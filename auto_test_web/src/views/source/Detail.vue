<template>
  <div class="content">
    <el-drawer title="详情" :visible.sync="drawer" size="40%">
      <el-card class="box-card">
        <div class="card-content">
          <el-descriptions title="基本信息" :column="1">
            <el-descriptions-item label="数据源名称">{{ formData.name }}</el-descriptions-item>
            <el-descriptions-item label="数据源编码">{{ formData.code }}</el-descriptions-item>
            <el-descriptions-item label="数据源类型">{{ formData.sourceType }}</el-descriptions-item>
          </el-descriptions>
          <div v-if="formData.sourceType==='MYSQL'">
            <el-descriptions title="连接信息" :column="1">
              <el-descriptions-item label="地址">{{ formData.config.connectionInfo }}</el-descriptions-item>
              <el-descriptions-item label="端口">{{ formData.config.port }}</el-descriptions-item>
              <el-descriptions-item label="数据库">{{ formData.config.dataBaseName }}</el-descriptions-item>
              <el-descriptions-item label="用户名">{{ formData.config.userName }}</el-descriptions-item>
              <el-descriptions-item label="密码">{{ formData.config.password }}</el-descriptions-item>
            </el-descriptions>
          </div>
          <div v-if="formData.sourceType==='REDIS'">
            <el-descriptions title="连接信息" :column="1">
              <el-descriptions-item label="地址">{{ formData.config.connectionInfo }}</el-descriptions-item>
              <el-descriptions-item label="端口">{{ formData.config.port }}</el-descriptions-item>
              <el-descriptions-item label="数据库">{{ formData.config.dataBaseName }}</el-descriptions-item>
              <el-descriptions-item label="用户名">{{ formData.config.userName }}</el-descriptions-item>
              <el-descriptions-item label="密码">{{ formData.config.password }}</el-descriptions-item>
            </el-descriptions>
          </div>
        </div>
      </el-card>
    </el-drawer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      formData: {
        id: '',
        name: '',
        code: '',
        sourceType: '',
        config: {}
      },
      drawer: false
    }
  },
  methods: {
    async getSourceDetail() {
      console.log('id....' + this.formData.id)
      const result = await this.$axios.get('/sourceConfig/detail', {params: {id: this.formData.id}})
      console.log('id....' + this.formData.id)
      if (result.data.success) {
        let temp = result.data.data
        Object.assign(this.formData, temp)
        this.formData.config = JSON.parse(temp.config)
      } else {
        this.$message.error(result.data.message)
      }
    }
  }
}
</script>

<style>

</style>
