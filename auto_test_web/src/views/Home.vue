<template>
  <div>
    <el-container class="home-container">
      <!-- 头部信息 -->
      <el-header>
        <el-row>
          <el-col :span="4">
            <p class="system-name"> 自动化测试管理后台 </p>
          </el-col>
          <el-col :offset="12" :span="8" style="min-height: 150px">
            <el-dropdown style="float:right;margin: 20px 10px">
              <span class="el-dropdown-link" style="color: #fff;cursor: pointer">
                {{ user.userName ? user.userName : "飞羽" }}
                <i class="fa fa-caret-down fa-1x"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item @click.native="editPasswordDialog=true"> 修改密码</el-dropdown-item>
                <el-dropdown-item @click.native="logout()">退出系统</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <el-avatar shape="square" :src="avatar" style="margin: 10px;float: right">
            </el-avatar>
          </el-col>
        </el-row>
        <!-- 修改密码 -->
        <el-dialog title="修改密码" :visible.sync="editPasswordDialog" width="30%" :before-close="closeEditPassword"
                   :close-on-click-modal="false">
          <el-form ref="editPasswordForm" :rules="editPasswordRule" class="demo-form-inline" :model="editPasswordForm"
                   label-width="90px">
            <el-form-item label="原密码:" prop="oldPassword">
              <el-input v-model="editPasswordForm.oldPassword" placeholder="请输入原始密码"/>
            </el-form-item>
            <el-form-item label="新密码:" prop="newPassword">
              <el-input v-model="editPasswordForm.newPassword" placeholder="请输入新密码"/>
            </el-form-item>
            <el-form-item label="确认密码:" prop="confirmPassword">
              <el-input v-model="editPasswordForm.confirmPassword" placeholder="请确认密码"/>
            </el-form-item>
            <el-form-item>
              <el-button size="small" @click="closeEditPassword()"> 取 消</el-button>
              <el-button size="small" type="primary" @click="editPassword()"> 保 存</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>
      </el-header>
      <!-- 主体部分 -->
      <el-container>
        <!-- 侧边栏 -->
        <el-aside>
          <div class="toggle-button" @click="isCollapse = !isCollapse">
            <i v-if="isCollapse" class="el-icon-s-unfold"></i>
            <i v-if="!isCollapse" class="el-icon-s-fold"></i>
          </div>
          <el-menu router :default-active="activePath" class="el-menu-vertical-demo" :collapse="isCollapse">
            <el-menu-item index="/index" @click="saveActiveNav('/index')">
              <i class="el-icon-house"></i>
              <span slot="title"> 首页</span>
            </el-menu-item>
            <el-menu-item index="/app" @click="saveActiveNav('/app')">
              <i class="el-icon-menu"></i>
              <span slot="title">应用管理</span>
            </el-menu-item>
            <el-menu-item index="/services" @click="saveActiveNav('/services')">
              <i class="el-icon-s-management"></i>
              <span slot="title">服务管理</span>
            </el-menu-item>
            <el-submenu index="/autotest">
              <template slot="title">
                <i class="el-icon-hot-water"></i>
                <span>自动化测试</span>
              </template>
              <el-menu-item index="/autotest/scene" @click="saveActiveNav('/autotest/scene')"> 场景管理</el-menu-item>
              <el-menu-item index="/autotest/cases" @click="saveActiveNav('/autotest/cases')"> 用例管理</el-menu-item>
              <el-menu-item index="/autotest/report" @click="saveActiveNav('/autotest/report')"> 执行报告</el-menu-item>
              <el-menu-item index="/autotest/runlog" @click="saveActiveNav('/autotest/runlog')"> 执行流水</el-menu-item>
            </el-submenu>
            <el-menu-item index="/sourceConfig" @click="saveActiveNav('/sourceConfig')">
              <i class="el-icon-s-data"></i>
              <span slot="title">数据源配置</span>
            </el-menu-item>
            <el-menu-item index="/globalConfig" @click="saveActiveNav('/globalConfig')">
              <i class="el-icon-s-tools"></i>
              <span slot="title">全局变量</span>
            </el-menu-item>

          </el-menu>
        </el-aside>
        <!-- 主体部分 -->
        <el-container>
          <el-main>
            <Breadcrumb/>
            <router-view></router-view>
          </el-main>
          <el-footer>Copyright © 2024 飞羽技术</el-footer>

        </el-container>
      </el-container>

    </el-container>
  </div>
</template>

<style>
.home-container {
  position: absolute;
  height: 100%;
  top: 0;
  left: 0;
  width: 100%;
  background: #f2f3f5;

}

.el-header {
  background: #2661ef;
  padding: 0 10px;
  overflow: hidden;
}

.system-name {
  color: #fff;
  font-size: 18px;
}

.el-aside {
  background: white;
  width: auto !important;
}

.toggle-button {
  background-color: #d9e0e7;
  font-size: 18px;
  line-height: 24px;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;
  color: black;
}

.el-footer {
  color: #cccccc;
  text-align: center;
  line-height: 60px;
}

.el-footer:hover {
  color: #2661ef;
}
</style>
<script>
import Breadcrumb from '../components/Breadcrumb.vue'

export default {
  components: {Breadcrumb},
  data() {
    return {
      avatar: require('@/assets/imgs/avator.jpg'),
      isCollapse: false,
      activePath: '',
      editPasswordDialog: false,
      user: {},
      editPasswordForm: {
        oldPassword: '',
        newPassword: '',
        confirmPassword: ''
      },
      editPasswordRule: {
        oldPassword: [{require: true, message: '请输入原始密码', trigger: 'blur'}],
        newPassword: [{require: true, message: '请输入新密码', trigger: 'blur'}],
        confirmPassword: [{require: true, message: '请确认新密码', trigger: 'blur'}]

      }
    }
  },
  created() {
    this.activePath = sessionStorage.getItem('activePath') ? sessionStorage.getItem('activePath') : '/index'
    let cuser = this.$cookies.get('user')
    console.log('cuser:' + cuser)
    this.user = JSON.parse(cuser)
  },
  methods: {
    saveActiveNav(activePath) {
      sessionStorage.setItem('activePath', activePath)
      this.activePath = activePath
    },
    // 修改密码
    editPassword() {
      this.$refs.editPasswordForm.validate(async (valid) => {
        if (!valid) return
        if (this.editPasswordForm.newPassword !== this.editPasswordForm.confirmPassword) {
          return this.$message.error('两次密码不一致，请重新输入！')
        }
        const {data: res} = await this.$axios.post('/user/updatePassword', this.editPasswordForm)
        if (res.success) {
          this.$message.success('密码修改成功，跳转到登陆页面')
          sessionStorage.clear()
          await this.$router.push('/login')
        } else {
          return this.$message.error(res.msg)
        }
      })
    },
    // 取消关闭
    closeEditPassword() {
      this.editPasswordDialog = false
      this.$refs.editPasswordForm.resetFields()
    },
    // 退出系统
    logout() {
      this.$confirm('确定退出？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        sessionStorage.clear()
        this.$router.push('/login')
      }).catch(() => {
        return false
      })
    }
  }

}
</script>
