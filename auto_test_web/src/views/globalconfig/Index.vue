<template>
  <div class="content">
    <el-card shadow="never" style="margin-top: 10px">
      <el-col>

        <el-form ref="searchForm" :model="globalConfig" size="small" inline>
          <el-form-item label="参数名称">
            <el-input v-model.trim="globalConfig.conditions.paramName" placeholder="请输入参数名称"></el-input>
          </el-form-item>
          <el-form-item label="参数key">
            <el-input v-model.trim="globalConfig.conditions.paramKey" placeholder="请输入参数key"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="small" @click="handleSearch()">查询</el-button>
            <el-button icon="el-icon-refresh-right" size="small" @click="handleClear()">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-card>
    <el-card shadow="never" style="margin-top: 5px">
      <div class="opts">
        <el-button type="primary" icon="el-icon-circle-plus" size="small" @click="dialogVisible = true"> 新增
        </el-button>
      </div>
      <el-form ref="configForm" :model="list" size="small" :key="formKey" inline>

        <el-row :gutter="10" style="width: 60%">
          <el-col style="width: 20%">
            <span class="title">参数key</span>
          </el-col>
          <el-col style="width: 20%">
            <span class="title">参数值</span>
          </el-col>
          <el-col style="width: 30%">
            <span class="title">参数名称</span>
          </el-col>
          <el-col style="width: 30%">
            <span class="title">操作</span>
          </el-col>
        </el-row>
        <div v-for="(config,index) in list.globalConfigs" :key="index"
             style="width: 100%;display: flex">
          <el-row :gutter="10" style="width: 60%">
            <el-col style="width: 20%;margin-top: 7px">
              <el-form-item :prop="'globalConfigs.'+index+'.paramKey'">
                <el-input v-model="config.paramKey" :disabled="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col style="width: 20%;margin-top: 7px">
              <el-form-item :prop="'globalConfigs.'+index+'.paramValue'">
                <el-input v-model="config.paramValue" :disabled="config.canEdit"></el-input>
              </el-form-item>
            </el-col>
            <el-col style="width: 30%;margin-top: 7px">
              <el-form-item :prop="'globalConfigs.'+index+'.paramName'">
                <el-input v-model="config.paramName" :disabled="config.canEdit"></el-input>
              </el-form-item>
            </el-col>
            <el-col style="width: 30%;margin-top: 7px">
              <el-button size="small" type="primary" v-if="config.canEdit" @click="changeEdit(config)"> 编辑</el-button>
              <el-button size="small" type="danger" v-if="config.canEdit" @click="deleteConfig(config)"> 删除
              </el-button>
              <el-button size="small" type="success" v-if="!config.canEdit" @click="saveUpdate(config)"> 确定
              </el-button>
              <el-button size="small" type="info" v-if="!config.canEdit" @click="changeEdit(config)"> 取消</el-button>
            </el-col>
          </el-row>
        </div>
      </el-form>
      <el-dialog
          title="新增变量"
          ref="addDialog"
          :visible.sync="dialogVisible"
          width="30%"
          :close-on-click-modal=false
      >
        <el-form :model="globalConfigForm" ref="configForm" size="small" :rules="addRules">
          <el-form-item label="参数key：" prop="paramKey" label-width="120px">
            <span>global_</span>
            <el-input v-model.trim="globalConfigForm.paramKey" placeholder="请输入参数Key" style="width: 70%"/>
          </el-form-item>
          <el-form-item label="参数值：" prop="paramValue" label-width="120px">
            <el-input v-model.trim="globalConfigForm.paramValue" placeholder="请输入参数值" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="参数名称：" prop="paramName" label-width="120px">
            <el-input v-model.trim="globalConfigForm.paramName" placeholder="请输入参数名称" style="width: 80%"/>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addGlobalConfig">确 定</el-button>
    </span>
      </el-dialog>
    </el-card>

  </div>

</template>

<script>
import {debounce} from 'lodash'

export default {
  data() {
    return {
      globalConfig: {
        currentPage: 1,
        pageSize: 10,
        conditions: {
          paramName: '',
          paramKey: ''
        }
      },
      formKey: 0,
      list: {globalConfigs: [{paramKey: 'asdf', paramValue: 'asfd', paramName: 'fasd', canEdit: true}]},
      dialogVisible: false,
      globalConfigForm: {
        paramKey: '',
        paramValue: '',
        paramName: ''
      },
      addRules: {
        paramKey: [{required: true, message: '请输入参数key', trigger: 'blur'}],
        paramValue: [{required: true, message: '请输入参数值', trigger: 'blur'}]
      }
    }
  },
  created() {
    this.initData()
  },
  methods: {
    changeEdit(opt) {
      var idx = this.list.globalConfigs.indexOf(opt)
      this.list.globalConfigs[idx].canEdit = !this.list.globalConfigs[idx].canEdit
      this.formKey = this.formKey + 1
    },
    saveUpdate(config) {
      this.$axios.post('/globalConfig/update', config).then(res => {
        if (res.data.success) {
          config.canEdit = true
          this.formKey = this.formKey + 1
          this.$message.success('更新成功')
        } else {
          this.$message.error(res.data.message)
        }
      })
    },
    deleteConfig(config) {
      this.$confirm('确认删除此全局变量?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.post('/globalConfig/batchDel', {ids: [config.id]}).then(res => {
          if (res.data.success) {
            this.$message.success('删除成功')
            this.initData()
          } else {
            this.$message.error(res.data.message)
          }
        })
      })
    },
    async initData() {
      const result = await this.$axios.get('/globalConfig/queryAll')
      if (result.data.success) {
        this.list.globalConfigs = result.data.data
        for (let c of this.list.globalConfigs) {
          c.canEdit = true
        }
      } else {
        this.$message.error(result.data.message)
      }
    },
    addGlobalConfig: debounce(function () {
      this.$refs.configForm.validate((valid) => {
        if (valid) {
          var gConfig = {}
          console.log(this.globalConfigForm)
          Object.assign(gConfig, this.globalConfigForm)
          gConfig.paramKey = 'global_' + this.globalConfigForm.paramKey
          this.$axios.post('/globalConfig/insert', gConfig).then(res => {
            if (res.data.success) {
              this.initData()
              this.dialogVisible = false
            } else {
              this.$message.error(res.data.message)
            }
          })
        } else {
          return false
        }
      })
    }, 300),
    handleSearch() {
      this.$axios.post('/globalConfig/queryByPage', this.globalConfig).then((res) => {
        if (res.data.success) {
          this.list.globalConfigs = res.data.data.data
          for (let c of this.list.globalConfigs) {
            c.canEdit = true
          }
        } else {
          this.$message.error(res.data.message)
        }
      })
    },
    handleClear() {
      this.globalConfig.conditions.paramKey = ''
      this.globalConfig.conditions.paramName = ''
      this.initData()
    }
  }

}
</script>

<style>
.title {
  font-size: 14px;
}

.opts {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 10px;
  margin-top: 5px;
}
</style>
