<template>
  <div class="content">
    <el-form ref="service_from" :model="service" :rules="rules" label-width="100px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>通用配置</span>
        </div>
        <div class="card-content">
          <el-form-item label="服务名称:" prop="serviceName">
            <el-input v-model="service.serviceName" placeholder="请输入服务名称"></el-input>
          </el-form-item>
          <el-form-item label="服务编码:" prop="serviceCode">
            <el-input v-model="service.serviceCode" placeholder="请输入服务编码"></el-input>
          </el-form-item>
          <el-form-item label="所属应用:" prop="appId">
            <el-cascader placeholder="请选择所属应用" v-model="service.appId" :options="appList"
                         @change="handleChange"></el-cascader>
          </el-form-item>
        </div>
      </el-card>

      <el-card class="box-card">
        <div slot="header">
          <span>协议配置</span>
        </div>
        <div class="card-content">
          <el-form-item label="请求路径:" prop="requestPath">
            <el-input v-model="service.requestPath" placeholder="请输入请求路径"></el-input>
          </el-form-item>
          <el-form-item label="请求协议:" prop="protocol">
            <el-cascader placeholder="请选择协议类型" v-model="service.protocol"
                         :options="protocolList"
                         @change="handleChange"></el-cascader>

          </el-form-item>
          <el-form-item label="返回报文格式:">
            <el-cascader placeholder="请选择返回报文格式" v-model="service.responseDataType"
                         :options="responseType"
                         @change="handleChange"></el-cascader>
          </el-form-item>

        </div>

      </el-card>
      <el-card class="box-card">
        <div slot="header">
          <span>报文配置</span>
        </div>
        <div class="template-content">
          <el-form-item label="报文头:"></el-form-item>
          <el-form-item v-for="(header,index) in service.headers" :key="index" style="width: 100%">
            <el-row :gutter="10" style="width: 100%">
              <el-col :span="6">
                <el-form-item :label="'key:'" :prop="'headers.'+index+'.key'">
                  <el-input v-model="header.key"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item :label="'value:'" :prop="'headers.'+index+'.value'">
                  <el-input v-model="header.value"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="2">
                <el-button type="info" size="small" @click.prevent="removeHeader(header)">删除</el-button>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item>
            <el-button style="width: 100%;" type="warning" icon="el-icon-plus" @click="addHeader"/>
          </el-form-item>
          <el-form-item label="请求体模板:" prop="requestModel">
            <el-input style="width: 100%" maxlength="1000" show-word-limit type="textarea"
                      v-model="service.requestModel" placeholder="请输入请求体模板"></el-input>
          </el-form-item>
        </div>
      </el-card>
      <el-card class="box-card">
        <div class="footer">
          <el-form-item>
            <el-button type="primary" @click="onSubmit('form')">保 存</el-button>
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
      service: {
        serviceName: '',
        serviceCode: '',
        requestType: '',
        appId: 1,
        requestPath: '',
        responseDataType: '',
        headers: [
          {key: 'Content-Type', value: 'application/json'}
        ],
        requestModel: ''

      },
      appList: [
        {
          value: 1,
          label: '通用'
        }
      ],
      responseType: [
        {
          value: 'JSON',
          label: 'JSON'
        },
        {
          value: 'XML',
          label: 'XML'
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
  },
  methods: {
    async getAppList() {
      const result = await this.$axios.get('/appList')
      if (result.data.success) {
        this.appList = result.data.data
      } else {
        this.$message.error(result.data.message)
      }
    },
    handleChange() {

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
    onSubmit() {

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
