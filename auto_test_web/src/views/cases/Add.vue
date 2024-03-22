<template>
  <div class="content">
    <el-form ref="case_from" :model="caseModel" :rules="rules" label-width="150px">
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
          <el-form-item label="返回体报文格式：" prop="responseDataType">
            <el-input v-model="caseModel.responseConfig.responseDataType" disabled style="width: 30%"></el-input>
            <span
                style="font-size: 12px;color: #999a9a;margin-left: 10px">系统将按配置的报文协议将文本自动转换为对象</span>

          </el-form-item>
        </div>
        <el-form-item v-for="(header,index) in caseModel.responseConfig.responseParam" :key="index" style="width: 100%">
          <el-row :gutter="10" style="width: 100%">
            <el-col :span="6">
              <el-form-item :label="'结果:'" :prop="'responseConfig.responseParam.'+index+'.key'">
                <el-input v-model="header.key"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="映射为"/>
            </el-col>
            <el-col :span="6">
              <el-form-item :label="'变量:'" :prop="'responseConfig.responseParam.'+index+'.value'">
                <el-input v-model="header.value"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="2">
              <el-button type="info" size="small" @click.prevent="removeResult(header)">删除</el-button>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;" type="warning" icon="el-icon-plus" @click="addResult"/>
        </el-form-item>
      </el-card>
      <el-card class="box-card">
        <div slot="header">
          <span>校验点</span>
          <span style="font-size: 10px;color: #999a9a">（从上到下，顺序执行）</span>
        </div>
        <div class="template-content">
          <div v-for="(checkPoint,index) in caseModel.checkPoints" :key="'checkPoint'+index">
            <el-card class="box-card">
              <div class="heng">
                <el-form-item label="校验类型" :prop='"checkPoints." + index+".checkPointType"'>
                  <el-select v-model="checkPoint.checkPointType" placeholder="请选择校验类型"
                             filterable @change='changeCheckPoint(checkPoint)'>
                    <el-option
                        v-for="item in checkPointType"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="数据源" v-show="checkPoint.showScript"
                              :prop='"checkPoints." + index+".sourceCode"'>
                  <el-select v-model="checkPoint.sourceCode" placeholder="请选择数据源"
                             filterable>
                    <el-option
                        v-for="item in sourceList"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </div>
              <el-form-item label="查询脚本" :prop='"checkPoints." + index+".script"' v-show="checkPoint.showScript">
                <el-input v-model="checkPoint.script" type="textarea"></el-input>
              </el-form-item>
              <div v-for="(judge,idx) in checkPoint.judges" :key="'checkPoint'+'judges'+idx" class="judge">
                <el-form-item label="变量：" :prop="'checkPoints.'+index+'.judges.'+idx+'.param'">
                  <el-input v-model="judge.param"></el-input>
                </el-form-item>
                <el-form-item :prop="'checkPoints.'+index+'.judges.'+idx+'.logic'">
                  <el-select v-model="judge.logic" placeholder="请选择比较器">
                    <el-option
                        v-for="item in logicType"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="期望值：" :prop="'checkPoints.'+index+'.judges.'+idx+'.expect'">
                  <el-input v-model="judge.expect"></el-input>
                </el-form-item>
                <div>
                  <el-button type="primary" style="height: 40px;width: 60px;margin-left: 10px" size="small"
                             v-show="judge.ref" disabled>{{ judge.ref }}
                  </el-button>
                  <el-button type="info" style="height: 40px" size="small"
                             @click.prevent="removeJudge(checkPoint,judge)">删除
                  </el-button>
                </div>

              </div>
              <el-select placeholder="选择与或" style="height: 40px;width: 120px;"
                         @change='addJudge(checkPoint,$event)' v-model="lType">
                <el-option
                    v-for="item in refType"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-card>
            <el-button type="success" disabled size="small" v-if="checkPoint.ref">{{ checkPoint.ref }}</el-button>
          </div>
          <div class="check-opt">
            <el-select placeholder="选择与或" style="height: 40px;width: 120px;"
                       @change='addCheckPoint' v-model="lType2">
              <el-option
                  v-for="item in refType"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
            <el-button type="info" size="small" @click.prevent="removeCheckPoint" style="margin-left: 10px">删除
            </el-button>
          </div>
        </div>
        <el-card class="box-card">
          <div class="footer">
            <el-form-item>
              <el-button type="primary" @click="onSubmit('case_from')">保 存</el-button>
              <el-button @click="$router.back()">取 消</el-button>
            </el-form-item>
          </div>
        </el-card>
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
        checkPoints: [{judges: [{logic: '', expect: '', param: ''}], sourceCode: ''}],
        responseConfig: {responseParam: []}
      },
      lType: '',
      lType2: '',
      showScript: false,
      paramValue: [],
      serviceList: [],
      dataFormat: [{value: 'JSON', label: 'JSON'}, {value: 'XML', label: 'XML'}],
      sourceList: [{value: 'COMMON', label: '测试环境数据源'}],
      checkPointType: [
        {
          value: 'MYSQL',
          label: 'MYSQL'
        },
        {
          value: 'VALUE',
          label: '值校验'
        },
        {
          value: 'CACHE',
          label: '缓存校验'
        }],
      logicType: [
        {
          value: '1',
          label: '等于'
        }, {
          value: '2',
          label: '大于'
        }, {
          value: '3',
          label: '小于'
        }, {
          value: '4',
          label: '大于等于'
        }, {
          value: '5',
          label: '小于等于'
        }, {
          value: '6',
          label: '不等于'
        }
      ],
      refType: [{value: 'AND', label: 'AND'}, {value: 'OR', label: 'OR'}],
      rules: {
        name: [{
          required: true,
          message: '请输入用例名称',
          trigger: 'blur'
        }],
        serviceId: [{
          required: true,
          message: '请选择服务',
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
    this.addCheckPointRules()
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
          this.caseModel.responseConfig.responseDataType = ser.responseDataType
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
    addResult() {
      this.removeRulesForHeaders()
      this.caseModel.responseConfig.responseParam.push({key: '', value: ''})
      this.addRulesForHeaders()
      console.log(this.rules)
      console.log(this.caseModel)
    },
    removeResult(item) {
      this.removeRulesForHeaders()
      var index = this.caseModel.responseConfig.responseParam.indexOf(item)
      if (index !== -1) {
        this.caseModel.responseConfig.responseParam.splice(index, 1)
      }
      this.addRulesForHeaders()
    },
    removeRulesForHeaders() {
      for (let i = 0; i < this.caseModel.responseConfig.responseParam.length; i++) {
        this.$refs['case_from'].clearValidate(['responseConfig.responseParam.' + i + '.key'])
        this.$refs['case_from'].clearValidate(['responseConfig.responseParam.' + i + '.value'])
        this.$delete(this.rules, 'responseConfig.responseParam.' + i + '.value')
        this.$delete(this.rules, 'responseConfig.responseParam.' + i + '.key')
      }
    },
    addRulesForHeaders() {
      for (let i = 0; i < this.caseModel.responseConfig.responseParam.length; i++) {
        this.$set(this.rules, 'responseConfig.responseParam.' + i + '.key', [{
          required: true,
          message: '请输入key',
          trigger: blur
        }])
        this.$set(this.rules, 'responseConfig.responseParam.' + i + '.value', [{
          required: true,
          message: '请输入value',
          trigger: blur
        }])
      }
    },
    changeCheckPoint(checkPoint) {
      var i = this.caseModel.checkPoints.indexOf(checkPoint)
      if (checkPoint.checkPointType === 'MYSQL' || checkPoint.checkPointType === 'CACHE') {
        this.$set(this.rules, 'checkPoints.' + i + '.sourceCode', [{
          required: true,
          message: '选择数据源',
          trigger: blur
        }])
        this.$set(this.rules, 'checkPoints.' + i + '.script', [{
          required: true,
          message: '请输入查询脚本',
          trigger: blur
        }])
        checkPoint.showScript = true
      } else {
        this.$refs['case_from'].clearValidate(['checkPoints.' + i + '.sourceCode'])
        this.$delete(this.rules, 'checkPoints.' + i + '.sourceCode')
        this.$refs['case_from'].clearValidate(['checkPoints.' + i + '.script'])
        this.$delete(this.rules, 'checkPoints.' + i + '.script')
        checkPoint.showScript = false
      }
    },
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.buildRequest()
        } else {
          return false
        }
      })
    },
    buildRequest() {
      console.log(this.caseModel)
    },
    addJudge(checkPoint, value) {
      this.removeCheckPointRules()
      if (checkPoint.judges.length > 0) {
        checkPoint.judges[checkPoint.judges.length - 1].ref = value
      }
      checkPoint.judges.push({})
      this.addCheckPointRules()
    },
    addCheckPoint(value) {
      this.removeCheckPointRules()

      if (this.caseModel.checkPoints.length > 0) {
        this.caseModel.checkPoints[this.caseModel.checkPoints.length - 1].ref = value
      }
      this.caseModel.checkPoints.push({judges: [{logic: '', expect: '', param: ''}], sourceCode: ''})
      this.addCheckPointRules()
    },
    removeCheckPoint() {
      this.removeCheckPointRules()
      this.caseModel.checkPoints.pop()
      this.addCheckPointRules()
    },
    removeJudge(checkPoint, judge) {
      if (checkPoint.judges.length === 1) {
        this.$message.error('判断逻辑至少有一个')
        return
      }
      this.removeCheckPointRules()
      var index = checkPoint.judges.indexOf(judge)
      if (index !== -1) {
        checkPoint.judges.splice(index, 1)
      }
      this.addCheckPointRules()
    },
    addCheckPointRules() {
      for (let i = 0; i < this.caseModel.checkPoints.length; i++) {
        this.$set(this.rules, 'checkPoints.' + i + '.checkPointType', [{
          required: true,
          message: '请输入类型',
          trigger: blur
        }])
        if (this.caseModel.checkPoints[i].showScript) {
          this.$set(this.rules, 'checkPoints.' + i + '.sourceCode', [{
            required: true,
            message: '选择数据源',
            trigger: blur
          }])
          this.$set(this.rules, 'checkPoints.' + i + '.script', [{
            required: true,
            message: '请输入查询脚本',
            trigger: blur
          }])
        }
        if (this.caseModel.checkPoints[i].judges && this.caseModel.checkPoints[i].judges.length > 0) {
          for (let j = 0; j < this.caseModel.checkPoints[i].judges.length; j++) {
            this.$set(this.rules, 'checkPoints.' + i + '.judges.' + j + '.param', [{
              required: true,
              message: '请输入值',
              trigger: blur
            }])
            this.$set(this.rules, 'checkPoints.' + i + '.judges.' + j + '.logic', [{
              required: true,
              message: '请选择校验',
              trigger: blur
            }])
            this.$set(this.rules, 'checkPoints.' + i + '.judges.' + j + '.expect', [{
              required: true,
              message: '请输入值',
              trigger: blur
            }])
          }
        }
      }
    },
    removeCheckPointRules() {
      for (let i = 0; i < this.caseModel.checkPoints.length; i++) {
        this.$refs['case_from'].clearValidate(['checkPoints.' + i + '.checkPointType'])
        this.$delete(this.rules, 'checkPoints.' + i + '.checkPointType')
        if (this.caseModel.checkPoints[i].showScript) {
          this.$refs['case_from'].clearValidate(['checkPoints.' + i + '.sourceCode'])
          this.$delete(this.rules, 'checkPoints.' + i + '.sourceCode')
          this.$refs['case_from'].clearValidate(['checkPoints.' + i + '.script'])
          this.$delete(this.rules, 'checkPoints.' + i + '.script')
        }
        if (this.caseModel.checkPoints[i].judges && this.caseModel.checkPoints[i].judges.length > 0) {
          for (let j = 0; j < this.caseModel.checkPoints[i].judges.length; j++) {
            this.$refs['case_from'].clearValidate(['checkPoints.' + i + '.judges.' + j + '.param'])
            this.$delete(this.rules, 'checkPoints.' + i + '.judges.' + j + '.param')
            this.$refs['case_from'].clearValidate(['checkPoints.' + i + '.judges.' + j + '.logic'])
            this.$delete(this.rules, 'checkPoints.' + i + '.judges.' + j + '.logic')
            this.$refs['case_from'].clearValidate(['checkPoints.' + i + '.judges.' + j + '.expect'])
            this.$delete(this.rules, 'checkPoints.' + i + '.judges.' + j + '.expect')
          }
        }
      }
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

.judge {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;

}

.clearfix:after {
  clear: both
}

.check-opt {
  display: flex;
  justify-content: flex-end;
  margin-top: 10px;
}

.footer {
  display: flex;
  justify-content: flex-end;
}

.heng {
  display: flex;
}
</style>
