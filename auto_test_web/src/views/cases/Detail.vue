<template>
  <div class="content">
    <el-drawer title="详情" :visible.sync="drawer" size="40%">
      <el-card class="box-card">
        <div class="card-content">
          <el-descriptions title="基本信息" :column=1>
            <el-descriptions-item label="用例名">{{ formData.name }}</el-descriptions-item>
            <el-descriptions-item label="用例编码">{{ formData.code }}</el-descriptions-item>
            <el-descriptions-item label="服务名称">{{ formData.service.serviceName }}</el-descriptions-item>
            <el-descriptions-item label="描述">{{ formData.desc }}</el-descriptions-item>
          </el-descriptions>
          <el-descriptions title="请求预览" direction="vertical" :column=1>
            <el-descriptions-item label="请求协议" v-if="formData.service.protocolType==='HTTP'">{{
                formData.service.protocolType
              }}
            </el-descriptions-item>
            <el-descriptions-item label="请求类型" v-if="formData.service.protocolType==='HTTP'">{{
                formData.service.requestType
              }}
            </el-descriptions-item>
            <el-descriptions-item label="请求路径">{{ formData.service.requestPath }}</el-descriptions-item>
            <el-descriptions-item label="请求头" v-if="formData.service.protocolType==='HTTP'">
              <el-table :data="formData.service.headers" style="width: 50%">
                <el-table-column prop="key" label="key"></el-table-column>
                <el-table-column prop="value" label="value"></el-table-column>
              </el-table>
            </el-descriptions-item>
            <el-descriptions-item label="请求体">
              {{ formData.service.requestModel }}
            </el-descriptions-item>
          </el-descriptions>
          <el-descriptions title="返回变量提取" direction="vertical" :column="1">
            <el-descriptions-item label="提取值">
              <el-table :data="formData.responseConfigData" style="width: 50%">
                <el-table-column prop="key" label="提取变量"></el-table-column>
                <el-table-column prop="value" label="映射变量"></el-table-column>
              </el-table>
            </el-descriptions-item>
          </el-descriptions>
          <el-descriptions title="校验点" direction="vertical" :column="1">
            <el-descriptions-item :label="'校验规则'+index" v-for="(checkpoint,index) in formData.checkpoints"
                                  :key="'checkPoint'+index">
              <el-row :gutter="10" style="width: 100%">
                <el-col :span="6">
                  <label class="check_label">校验类型:</label>
                  <span>{{ calculateType(checkpoint.checkPointType) }}</span><br/>
                  <label class="check_label" v-if="checkpoint.showScript"> 数据源：</label>
                  <span v-if="checkpoint.showScript">{{ checkpoint.sourceCode }}</span>
                </el-col>
                <el-col v-if="checkpoint.showScript">
                  <label class="check_label">脚本:</label>
                  <span>{{ checkpoint.script }}</span>
                </el-col>
                <el-col v-for="judge in checkpoint.judges" v-bind:key="judge.id">
                  <label class="check_label">变量：</label>
                  <span>{{ judge.param }}</span>
                  <span>{{ calculateJudge(judge.logic) }}</span>
                  <label class="check_label">值：</label>
                  <span>{{ judge.expect }}</span>
                </el-col>
                <el-col :span="6">
                  <span v-if="checkpoint.ref === 'AND'" style="color: darkgreen">{{ checkpoint.ref }}</span>
                  <span v-if="checkpoint.ref === 'OR'" style="color: red">{{ checkpoint.ref }}</span>
                </el-col>
              </el-row>
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
        name: '',
        service: {serviceName: '', protocolType: ''},
        checkpoints: []
      },
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
      ]
    }
  },
  methods: {
    async getCaseDetail() {
      const result = await this.$axios.get('/case/detail', {params: {id: this.formData.id}})
      if (result.data.success) {
        Object.assign(this.formData, result.data.data)
        this.formData.service = result.data.data.autoTestService
        this.formData.checkpoints = JSON.parse(result.data.data.checkPoints)
        this.formData.responseConfigData = JSON.parse(result.data.data.responseConfig).responseParam
        console.log('++++++++++++++++++++++++++++++++' + JSON.stringify(this.formData.checkpoints))

        this.formData.service.headers = JSON.parse(result.data.data.autoTestService.headers)
        this.formData.service.serviceName = result.data.data.autoTestService.serviceName
      } else {
        this.$message.error(result.data.message)
      }
    }
  },
  computed: {
    calculateJudge() {
      return (value) => {
        return this.logicType[parseInt(value) - 1].label
      }
    },
    calculateType() {
      return (value) => {
        for (let item of this.checkPointType) {
          if (item.value === value) {
            return item.label
          }
        }
        return value
      }
    }
  }
}

</script>
<style>
.check_label {
  margin-left: 10px;
  margin-right: 5px;
}
</style>
