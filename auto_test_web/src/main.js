// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// 配置 font-awesome
import 'font-awesome/css/font-awesome.min.css'
// 全局引入 echarts
import * as echarts from 'echarts'
// 引入 axios
import axios from 'axios'

// 将 echarts 挂载到 Vue 上
Vue.prototype.$echarts = echarts
// 使用 ElementUI
Vue.use(ElementUI)

Vue.config.productionTip = false
// 将 axios 挂载到 Vue 上
Vue.prototype.$axios = axios
// 设置接口请求的前缀地址
axios.defaults.baseURL = 'http://localhost:8081/autotest'
// 全局设置token
axios.interceptors.request.use(function (config) {
  let token = sessionStorage.getItem('token')
  if (token) {
    config.headers['token'] = token
  }
  return config
})

// eslint-disable-next-line no-new
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
