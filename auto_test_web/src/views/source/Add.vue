<template>
  <div class="content">
    <el-form ref="service_from" :model="sourceConfig" :rules="rules" label-width="100px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>基础信息配置</span>
        </div>
        <div class="card-content">
          <el-form-item label="数据源名称:" prop="name">
            <el-input v-model="sourceConfig.name" placeholder="请输入服务名称"></el-input>
          </el-form-item>
          <el-form-item label="数据源编码:" prop="code">
            <el-input v-model="sourceConfig.code" placeholder="请输入服务编码" :disabled="changeable"></el-input>
          </el-form-item>
          <el-form-item label="数据源类型:" prop="sourceType">
            <el-select v-model="sourceConfig.sourceType" filterable placeholder="请选择状态"
                       @change='changeSourceConfig' :disabled="changeable">
              <el-option
                  v-for="item in sourceTypes"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </div>
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>数据源配置</span>
        </div>
        <div class="source-content" v-if="showMysql">
          <el-form-item label="mysql连接:" prop="config.connectionInfo">
            <el-input v-model="sourceConfig.config.connectionInfo" placeholder="请输入服务名称"></el-input>
          </el-form-item>
          <el-form-item label="端口:" prop="config.port">
            <el-input v-model="sourceConfig.config.port" placeholder="请输入服务名称"></el-input>
          </el-form-item>
          <el-form-item label="数据库名称:" prop="config.dataBaseName">
            <el-input v-model="sourceConfig.config.dataBaseName" placeholder="请输入服务名称"></el-input>
          </el-form-item>
          <el-form-item label="用户名:" prop="config.userName">
            <el-input v-model="sourceConfig.config.userName" placeholder="请输入服务名称"></el-input>
          </el-form-item>
          <el-form-item label="密码:" prop="config.password">
            <el-input v-model="sourceConfig.config.password" placeholder="请输入服务名称"></el-input>
          </el-form-item>
        </div>
      </el-card>
      <el-card class="box-card">
        <div class="footer">
          <el-form-item>
            <el-button type="primary" @click="onSubmit('service_from')">保 存</el-button>
            <el-button @click="$router.back()">取 消</el-button>
          </el-form-item>
        </div>
      </el-card>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      sourceConfig: {
        id: '',
        name: '',
        code: '',
        sourceType: '',
        config: {connectionInfo: '', port: '', dataBaseName: '', userName: '', password: ''}
      },
      sourceTypes: [{value: 'MYSQL', label: 'MYSQL'}, {value: 'REDIS', label: 'REDIS'}],
      showMysql: false,
      rules: {
        name: [{required: true, message: '请输入名称', trigger: 'blur'}],
        code: [{required: true, message: '请输入编码', trigger: 'blur'}],
        sourceType: [{required: true, message: '请选择数据源类型', trigger: 'blur'}]
      },
      changeable: false

    }
  },
  methods: {
    changeSourceConfig(value) {
      if (value === 'MYSQL') {
        this.showMysql = true
        this.addMysqlRules()
      } else {
        this.showMysql = false
        this.removeMysqlRules()
      }
    },
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let url = this.sourceConfig.id ? '/sourceConfig/update' : '/sourceConfig/add'

          this.$axios.post(url, this.buildRequest()).then((res) => {
            if (res.data.success) {
              this.$message.success('保存成功')
              this.$router.push('/sourceConfig')
            } else {
              this.$message.error(res.data.message)
            }
          })
        } else {
          return false
        }
      })
    },
    addMysqlRules() {
      this.$set(this.rules, 'config.connectionInfo', [{required: true, message: '请输入连接', trigger: 'blur'}])
      this.$set(this.rules, 'config.port', [{required: true, message: '请输入端口', trigger: 'blur'}])
      this.$set(this.rules, 'config.dataBaseName', [{required: true, message: '请输入数据库名', trigger: 'blur'}])
      this.$set(this.rules, 'config.userName', [{required: true, message: '请输入用户名', trigger: 'blur'}])
    },
    removeMysqlRules() {
      this.$refs['service_from'].clearValidate(['config.connectionInfo', 'config.port', 'config.dataBaseName', 'config.userName'])
      this.$delete(this.rules, 'config.connectionInfo')
      this.$delete(this.rules, 'config.port')
      this.$delete(this.rules, 'config.dataBaseName')
      this.$delete(this.rules, 'config.userName')
    },
    buildRequest() {
      let config = JSON.stringify(this.sourceConfig.config)
      let request = {}
      Object.assign(request, this.sourceConfig)
      request.config = config
      return request
    },
    async getSourceDetail(id) {
      const result = await this.$axios.get('/sourceConfig/detail', {params: {id: id}})
      if (result.data.success) {
        let temp = result.data.data
        Object.assign(this.sourceConfig, temp)
        this.sourceConfig.config = JSON.parse(temp.config)
        if (temp.sourceType === 'MYSQL') {
          this.addMysqlRules()
          this.showMysql = true
        }
      }
    }
  },
  created() {
    if (this.$route.query.id) {
      this.changeable = true
      this.getSourceDetail(this.$route.query.id)
    }
  }
}

</script>

<style>
.card-content {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

.box-card {
  margin-top: 10px;
}

.footer {
  display: flex;
  justify-content: flex-end;
}
</style>
