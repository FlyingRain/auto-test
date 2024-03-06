import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {path: '/', redirect: 'login'},
    {path: '/login', name: 'login', component: () => import('@/views/login.vue')},
    {
      path: '/home',
      meta: {title: '主页'},
      component: () => import('@/views/Home.vue'),
      redirect: '/index',
      children: [
        {
          path: '/index',
          meta: {
            title: '首页'
          },
          component: () => import('@/views/Welcome.vue')
        },
        {
          path: '/services',
          meta: {
            title: '服务管理'
          },
          component: () => import('@/views/services/Index.vue')
        },
        {
          path: '/cases',
          meta: {
            title: '用例编排'
          },
          component: () => import('@/views/cases/Index.vue')
        },
        {
          path: '/autotest',
          meta: {
            title: '自动化测试'
          },
          component: () => import('@/views/autotest/Index.vue')
        },
        {
          path: '/report',
          meta: {
            title: '执行报告'
          },
          component: () => import('@/views/reports/Index.vue')
        }]
    }
  ]
})

// 挂载路由导航守卫：to表示将要访问的路径，from表示从哪里来，next是下一个要做的操作
router.beforeEach((to, from, next) => {
  // 放行登录页面
  if (to.path === '/login') {
    return next()
  }
  // 获取token
  const tokenStr = sessionStorage.getItem('token')
  if (!tokenStr) {
    return next('/login')
  } else {
    next()
  }
})

export default router