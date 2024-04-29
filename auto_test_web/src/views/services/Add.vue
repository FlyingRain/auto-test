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
          <el-form-item label="请求协议:" prop="protocolType">
            <el-cascader placeholder="请选择协议类型" v-model="service.protocolType"
                         :options="protocolList"
                         @change="handleChange"></el-cascader>

          </el-form-item>
          <el-form-item label="请求类型:">
            <el-cascader placeholder="请选择返回报文格式" v-model="service.requestType"
                         :options="requestTypes"
                         @change="handleChange"></el-cascader>
          </el-form-item>
          <el-form-item label="返回报文格式:" prop="responseDataType">
            <el-cascader placeholder="请选择协议类型" v-model="service.responseDataType"
                         :options="dataFormat"
                         @change="handleChange"></el-cascader>

          </el-form-item>

        </div>

      </el-card>
      <el-card class="box-card">
        <div slot="header">
          <span>请求配置</span>
        </div>
        <div class="template-content">
          <el-form-item label="请求路径:" prop="requestPath">
            <el-input v-model="service.requestPath" placeholder="请输入请求路径"></el-input>
          </el-form-item>
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
          <el-form-item>
            <el-radio-group v-model="service.requestModel.requestBodyType" @change="requestBodyChange">
              <el-radio :label="1">form-data</el-radio>
              <el-radio :label="2">raw</el-radio>
            </el-radio-group>
          </el-form-item>
          <div v-show="service.requestModel.requestBodyType===2">
            <el-form-item label="请求体模板:" prop="requestModel">
              <el-input style="width: 100%" maxlength="1000" show-word-limit type="textarea"
                        v-model="service.requestModel.content" placeholder="请输入请求体模板" :autosize="{ minRows: 5}"
                        resize="both"></el-input>
            </el-form-item>
          </div>
          <div v-show="service.requestModel.requestBodyType===1" :key="bodyKey">
            <el-form-item label="Form表单:">
            </el-form-item>

            <el-form-item v-for="(entity,index) in service.requestModel.entities" :key="'entity'+index"
                          style="width: 100%">
              <el-row :gutter="10" style="width: 100%">
                <el-col :span="6">
                  <el-form-item :label="'key:'" :prop="'requestModel.entities.'+index+'.key'" label-width="120px">
                    <el-input v-model="entity.key"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item :label="'类型:'" :prop="'requestModel.entities.'+index+'.type'">
                    <el-select v-model="entity.type" filterable placeholder="请选参数类型" @change='entityTypeChange'>
                      <el-option
                          v-for="item in entityType"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item :label="'value:'" :prop="'requestModel.entities.'+index+'.value'">
                    <el-input v-model="entity.fileName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="2">
                  <el-upload
                      v-if="entity.type==='FILE'"
                      action="#"
                      :http-request="handleFileUpload"
                      :data="entity"
                      :on-change="handleChange"
                      :file-list="fileList">
                    <el-tooltip class="item" effect="dark" content="只能上传jpg/png文件，且不超过500kb"
                                placement="top-start">
                      <el-button size="small" type="primary">点击上传</el-button>
                    </el-tooltip>
                  </el-upload>
                </el-col>
                <el-col :span="2">
                  <el-button type="info" size="small" @click.prevent="removeEntity(entity)">删除</el-button>
                </el-col>
              </el-row>

            </el-form-item>
            <el-form-item>
              <el-button style="width: 100%;" type="warning" icon="el-icon-plus" @click="addEntity"/>
            </el-form-item>
          </div>
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
import {debounce} from 'lodash'

export default {
  data() {
    return {
      service: {
        id: '',
        serviceName: '',
        serviceCode: '',
        requestType: '',
        protocolType: '',
        appId: 0,
        requestPath: '',
        responseDataType: '',
        headers: [
          {key: 'Content-Type', value: 'application/json'}
        ],
        requestModel: {requestBodyType: 2, content: '', entities: [{key: '', value: '', type: '', fileName: ''}]}

      },
      bodyKey: 1,
      fileList: [],
      radio: 2,
      appList: [],
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
      entityType: [
        {
          value: 'TEXT',
          label: '文本'
        }, {
          value: 'FILE',
          label: '文件'
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
    this.addRulesForHeaders()
  },
  methods: {
    async getAppList() {
      const result = await this.$axios.get('app/all')
      if (result.data.success) {
        const appInfos = result.data.data
        for (const item of appInfos) {
          this.appList.push({value: item.id, label: item.appName})
        }
      } else {
        this.$message.error(result.data.message)
      }
    },
    handleChange() {

    },
    async getServiceDetail(id) {
      const result = await this.$axios.get('/service/detail', {params: {id: id}})
      if (result.data.success) {
        Object.assign(this.service, result.data.data)
        if (result.data.data.headers) {
          this.service.headers = JSON.parse(result.data.data.headers)
          var newModel = JSON.parse(result.data.data.requestModel)
          console.log(this.service.requestModel)
          if (newModel.requestBodyType) {
            this.service.requestModel = newModel
          } else {
            this.service.requestModel = {
              requestBodyType: 2,
              content: result.data.data.requestModel,
              entities: [{key: '', value: '', type: ''}]
            }
          }
        }
      }
    },
    addHeader() {
      this.removeRulesForHeaders()
      this.service.headers.push({
        key: '',
        value: ''
      })
      this.addRulesForHeaders()
    },
    removeHeader(item) {
      this.removeRulesForHeaders()
      var index = this.service.headers.indexOf(item)
      if (index !== -1) {
        this.service.headers.splice(index, 1)
      }
      this.addRulesForHeaders()
    },
    removeRulesForHeaders() {
      for (let i = 0; i < this.service.headers.length; i++) {
        this.$refs['service_from'].clearValidate(['headers.' + i + '.key'])
        this.$refs['service_from'].clearValidate(['headers.' + i + '.value'])
        this.$delete(this.rules, 'headers.' + i + '.value')
        this.$delete(this.rules, 'headers.' + i + '.key')
      }
    },
    addRulesForHeaders() {
      for (let i = 0; i < this.service.headers.length; i++) {
        this.$set(this.rules, 'headers.' + i + '.key', [{
          required: true,
          message: '请输入key',
          trigger: blur
        }])
        this.$set(this.rules, 'headers.' + i + '.value', [{
          required: true,
          message: '请输入value',
          trigger: blur
        }])
      }
    },
    onSubmit: debounce(function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let url = this.service.id ? '/service/update' : '/service/add'

          this.$axios.post(url, this.buildRequest()).then((res) => {
            if (res.data.success) {
              this.$message.success('保存成功')
              this.$router.push('/services')
            } else {
              this.$message.error(res.data.message)
            }
          })
        } else {
          return false
        }
      })
    }, 300),
    buildRequest() {
      const request = {}
      Object.assign(request, this.service)
      request.requestModel = ''
      if (this.service.headers) {
        request.headers = JSON.stringify(this.service.headers)
      }
      if (this.service.protocolType && Array.isArray(this.service.protocolType)) {
        request.protocolType = this.service.protocolType[0]
      }
      if (this.service.responseDataType && Array.isArray(this.service.responseDataType)) {
        request.responseDataType = this.service.responseDataType[0]
      }
      if (this.service.appId && Array.isArray(this.service.appId)) {
        request.appId = this.service.appId[0]
      }
      if (this.service.requestType && Array.isArray(this.service.requestType)) {
        request.requestType = this.service.requestType[0]
      }
      request.requestModel = JSON.stringify(this.service.requestModel)
      return request
    },
    requestBodyChange(value) {
      this.service.requestModel.requestBodyType = value
      console.log('ratio change ' + value)
      var haveType = false
      for (let headerConfig of this.service.headers) {
        if (headerConfig.key === 'Content-Type') {
          haveType = true
          if (value === 1) {
            headerConfig.value = 'multipart/form-data'
          } else if (value === 2) {
            headerConfig.value = 'application/json'
          }
        }
      }
      if (!haveType) {
        if (this.service.headers || this.service.headers.length === 0) {
          if (value === 1) {
            this.service.headers = [{key: 'Content-Type', value: 'multipart/form-data'}]
          } else if (value === 2) {
            this.service.headers = [{key: 'Content-Type', value: 'application/json'}]
          }
        } else {
          if (value === 1) {
            this.service.headers.push({key: 'Content-Type', value: 'multipart/form-data'})
          } else if (value === 2) {
            this.service.headers.push({key: 'Content-Type', value: 'application/json'})
          }
        }
      }
      if (value === 1) {
        if (!this.service.requestModel.entities) {
          this.service.requestModel.entities = [{key: '', value: '', type: ''}]
        }
      }
    },
    entityTypeChange() {
      this.bodyKey = this.bodyKey + 1
    },
    handleFileUpload(params) {
      let entity = params.data
      console.log(entity)
      let fileName = params.file.name
      let encodedFile = new File([params.file], encodeURI(encodeURI(fileName)))
      var formData = new FormData()
      formData.append('file', encodedFile)
      this.$axios.post('/file/upload', formData, {headers: {'Content-Type': 'multipart/form-data'}}).then(res => {
        if (res.data.success) {
          this.$message.success('上传成功!')
          entity.fileName = fileName
          entity.value = encodeURI(res.data.data)
          this.bodyKey = this.bodyKey + 1
        } else {
          this.$message.error(res.data.message)
        }
      })
    },
    removeEntity(entity) {
      var index = this.service.requestModel.entities.indexOf(entity)
      if (index !== -1) {
        this.service.requestModel.entities.splice(index, 1)
      }
    },
    addEntity() {
      this.service.requestModel.entities.push({key: '', value: '', type: ''})
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
