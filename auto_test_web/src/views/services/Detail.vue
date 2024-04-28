<template>
  <div class="content">
    <el-drawer title="详情" :visible.sync="drawer"  size="40%">

      <el-card class="box-card">
        <div class="card-content">
          <el-descriptions title="基本信息">
            <el-descriptions-item label="服务名">{{ formData.serviceName }}</el-descriptions-item>
            <el-descriptions-item label="服务编码">{{ formData.serviceCode }}</el-descriptions-item>
            <el-descriptions-item label="所属应用">{{ formData.appName }}</el-descriptions-item>
          </el-descriptions>
          <el-descriptions title="协议信息"  direction="vertical" :column=1>
            <el-descriptions-item label="请求地址">{{ formData.requestPath }}</el-descriptions-item>
            <el-descriptions-item label="请求协议">{{ formData.protocolType }}</el-descriptions-item>
            <el-descriptions-item label="请求类型">{{ formData.requestType }}</el-descriptions-item>
            <el-descriptions-item label="返回报文格式">{{ formData.responseDataType }}</el-descriptions-item>
          </el-descriptions>
          <el-descriptions title="报文信息" direction="vertical" :column=1>
            <el-descriptions-item label="请求头">
              <el-table :data="formData.headers" style="width: 50%">
                <el-table-column prop="key" label="key"></el-table-column>
                <el-table-column prop="value" label="value"></el-table-column>
              </el-table>
            </el-descriptions-item>
            <el-descriptions-item label="请求报文模板">{{ formData.requestModel }}</el-descriptions-item>
          </el-descriptions>
          <el-descriptions title="动态参数列表" direction="vertical" :column=1>
            <el-descriptions-item label="参数：">
              <el-table :data="formData.autoTestServiceParams" style="width: 50%">
                <el-table-column prop="id" label="id"></el-table-column>
                <el-table-column prop="name" label="参数名称"></el-table-column>
              </el-table>
            </el-descriptions-item>
          </el-descriptions>

        </div>
      </el-card>
    </el-drawer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      drawer: false,
      formData: {
        id: '',
        serviceName: '',
        serviceCode: '',
        appName: '',
        autoTestServiceParams: []
      }
    }
  },
  methods: {
    async getServiceDetail() {
      const result = await this.$axios.get('/service/detail', {params: {id: this.formData.id}})
      if (result.data.success) {
        Object.assign(this.formData, result.data.data)
        if (this.formData.headers) {
          this.formData.headers = JSON.parse(this.formData.headers)
        }
      } else {
        this.$message.error(result.data.message)
      }
    },
    handleClose() {
      this.drawer = false
    }
  }

}
</script>
<style>

</style>
