<template>
  <div class="content">
    <el-form ref="service_from" :model="caseModel" :rules="rules" label-width="150px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>通用配置</span>
        </div>
        <div class="card-content">
          <el-form-item label="用例名称:" prop="name">
            <el-input v-model="caseModel.name" placeholder="请输入用例名称"></el-input>
          </el-form-item>
          <el-form-item label="所属服务:" prop="serviceId">
            <el-cascader placeholder="请选择所属服务" v-model="caseModel.serviceId" :options="serviceList"
                         @change="serviceChange"></el-cascader>
          </el-form-item>
        </div>
      </el-card>

      <el-card class="box-card">
        <div slot="header">
          <span>参数配置</span>
        </div>
        <div class="card-content">
          <el-table :data="paramValue" style="width: 50%">
            <el-table-column prop="name" label="动态变量名"></el-table-column>
            <el-table-column prop="value" label="值">
              <el-input v-model="paramValue.value" placeholder="请输入参数值"></el-input>
            </el-table-column>
          </el-table>

        </div>

      </el-card>
      <el-card class="box-card">
        <div slot="header">
          <span>返回值提取</span>
        </div>
        <div class="template-content">
          <el-form-item label="返回体报文格式：" prop="responseDataType"><el-input v-model="responseConfig.responseDataType" disabled style="width: 30%"></el-input></el-form-item>
        </div>
      </el-card>
      <el-card class="box-card">
        <div slot="header">
          <span>校验点</span>
        </div>
        <div class="template-content">
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
      caseModel: {
        id: '',
        name: '',
        serviceId: '',
        requestType: '',
        protocolType: '',
        appId: 0,
        requestPath: '',
        responseDataType: '',
        headers: [
          {key: 'Content-Type', value: 'application/json'}
        ],
        requestModel: ''

      },
      paramValue: [],
      serviceList: [],
      responseConfig: {},
      dataFormat: [{value: 'JSON', label: 'JSON'}, {value: 'XML', label: 'XML'}],
      requestTypes: [
        {
          value: 'POST',
          label: 'POST'
        },
        {
          value: 'GET',
          label: 'GET'
        },
        {
          value: 'PUT',
          label: 'PUT'
        },
        {
          value: 'DELETE',
          label: 'DELETE'
        }],
      protocolList: [
        {
          value: 'HTTP',
          label: 'HTTP'
        }, {
          value: 'DUBBO',
          label: 'DUBBO'
        }
      ],
      rules: {
        serviceName: [{
          required: true,
          message: '请输入服务名称',
          trigger: 'blur'
        }],
        serviceCode: [{
          required: true,
          message: '请输入服务编码',
          trigger: 'blur'
        }],
        appId: [{
          required: true,
          message: '请输入所属应用',
          trigger: 'blur'
        }],
        requestPath: [{
          required: true,
          message: '请输入请求路径',
          trigger: 'blur'
        }]
      }

    }
  },
  created() {
    this.getAppList()
    if (this.$route.query.id) {
      this.getServiceDetail(this.$route.query.id)
    }
  },
  methods: {
    async getAppList() {
      const result = await this.$axios.get('service/all')
      if (result.data.success) {
        const appInfos = result.data.data
        for (const item of appInfos) {
          this.serviceList.push({
            value: item.id,
            label: item.serviceName,
            params: item.autoTestServiceParams,
            responseDataType: item.responseDataType
          })
        }
      } else {
        this.$message.error(result.data.message)
      }
    },
    serviceChange(value) {
      for (let ser of this.serviceList) {
        if (ser.value === value[0]) {
          console.log(ser.responseDataType)
          this.paramValue = ser.params
          this.responseConfig.responseDataType = ser.responseDataType
        }
      }
    },
    async getServiceDetail(id) {
      const result = await this.$axios.get('/service/detail', {params: {id: id}})
      if (result.data.success) {
        console.log(JSON.parse(result.data.data.headers))
        Object.assign(this.service, result.data.data)
        if (result.data.data.headers) {
          this.service.headers = JSON.parse(result.data.data.headers)
        }
      }
    },
    addHeader() {
      this.service.headers.push({
        key: '',
        value: ''
      })
    },
    removeHeader(item) {
      var index = this.service.headers.indexOf(item)
      if (index !== -1) {
        this.service.headers.splice(index, 1)
      }
    },
    onSubmit(formName) {
    },
    buildRequest() {
    }
  }

}

</script>

<style>
.box-card {
  margin-top: 10px;
}

.card-content {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

.el-input {
  width: 100%;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.footer {
  display: flex;
  justify-content: flex-end;
}
</style>
