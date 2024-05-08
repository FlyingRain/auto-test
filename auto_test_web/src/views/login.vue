<template>
  <div class="login">
    <!-- login card -->
    <el-card class="login_card">
      <el-image class="logo_image" :src="logo_url" fit="cover"></el-image>
      <p class="login_title">登 录</p>
      <p class="login_desc">欢迎登录飞羽自动化测试平台</p>
      <el-form ref="ruleForm" :model="form" :rules="rules">
        <el-form-item prop="userName">
          <el-input placeholder="请输入账号" v-model="form.userName" prefix-icon="el-icon-user"/>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="请输入密码" v-model="form.password" prefix-icon="el-icon-lock"/>
        </el-form-item>
        <el-form-item>
          <el-button :loading="loginLoading" style="background: #5b89fe;color: white" @click="submitForm('ruleForm')"
                     @keyup.enter="submitForm('ruleForm')">
            登录
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <p class="footer">Copyright @ flyingrain All Rights Reserved</p>
  </div>
</template>

<style scoped>
.login {
  width: 100%;
  height: 100%;
  background-image: url("../assets/imgs/background.jpg");
  position: absolute;
  left: 0;
  top: 0;
  background-size: 100% 100%;
}

.login_card {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  margin: auto;
  width: 20%;
  min-width: 300px;
  height: 450px;
  min-height: 400px;
  border-radius: 10px;
  text-align: center;
}

.logo_image {
  width: 50px;
  height: 50px;
  margin-top: 25px;
}

.login_title {
  font-size: 25px;
  font-weight: bold;
}

.login_desc {
  letter-spacing: 2px;
  color: #999a9a;
}

.el-button {
  width: 100%;
}

.footer {
  position: absolute;
  left: 0;
  right: 0;
  bottom: 20px;
  text-align: center;
  color: rgb(183, 181, 181);
}

</style>

<script>
export default {
  data() {
    return {
      logo_url: require('@/assets/imgs/logo.png'),
      form: {
        userName: '',
        password: ''
      },
      loginLoading: false,
      rules: {
        userName: [{required: true, message: '请输入账号', trigger: 'blur'}],
        password: [{required: true, message: '请输入密码', trigger: 'blur'}]
      }
    }
  },
  created() {
    document.onkeyup = e => {
      if ((e.code === 'Enter' || e.code === 'NumpadEnter') && e.target.baseURI.match(/login/)) {
        // 调用登录 验证方法
        this.submitForm('ruleForm')
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.loginLoading = true
          this.$axios.post('/user/login', this.form).then((res) => {
            if (res.data.success) {
              console.log('--------------' + JSON.stringify(res.data.data.user) + '--------------------')
              this.$cookies.set('user', JSON.stringify(res.data.data.user), {expires: 1})
              this.$cookies.set('token', res.data.data.token, {expires: 1})
              sessionStorage.setItem('user', JSON.stringify(res.data.data.user))
              sessionStorage.setItem('token', res.data.data.token)
              this.$router.push('/home')
            } else {
              this.$message.error(res.data.msg)
              this.loginLoading = false
            }
          }).catch((error) => {
            this.$message.error(error)
            this.loginLoading = false
          })
        } else {
          return false
        }
      })
    }
  }
}
</script>
