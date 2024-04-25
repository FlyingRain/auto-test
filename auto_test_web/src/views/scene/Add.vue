<template>
  <div class="content">
    <el-form ref="scene_form" :model="sceneModel" :rules="rules" label-width="150px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>基础信息</span>
        </div>
        <div class="card-content">
          <el-form-item label="场景名称:" prop="sceneName">
            <el-input v-model="sceneModel.sceneName" placeholder="请输入场景名称"></el-input>
          </el-form-item>
          <el-form-item label="场景编码:" prop="sceneCode">
            <el-input v-model="sceneModel.sceneCode" placeholder="请输入场景编码" :disabled="isUpdate"></el-input>
          </el-form-item>
          <el-form-item label="操作人:" prop="operator" v-show="isUpdate">
            {{ sceneModel.operator }}
          </el-form-item>
        </div>
        <div>
          <el-form-item label="场景表述:" prop="desc">
            <el-input type="textarea" v-model="sceneModel.desc" placeholder="请输入场景描述"></el-input>
          </el-form-item>
        </div>
      </el-card>

      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>用例编排</span>
        </div>
        <div class="add_button">
          <el-button type="primary" size="small" @click="addCase"> 添加用例</el-button>
        </div>
        <div class="card-content">

          <el-table ref="table" :data="sceneModel.autoTestSceneCases" stripe border>
            <el-table-column type="index" label="行号" width="50"/>
            <el-table-column prop="autoTestCase.name" label="用例名称"/>
            <el-table-column prop="autoTestCase.code" label="用例编码"/>
            <el-table-column prop="autoTestCase.desc" label="描述"/>
            <el-table-column prop="executeOrder" label="执行顺序"/>
            <el-table-column label="操作" width="350">
              <template v-slot="row">
                <el-button type="success" size="small" @click="moveUp(row.$index)">上移</el-button>
                <el-button type="success" size="small" @click="moveDown(row.$index)">下移</el-button>
                <el-button type="danger" size="small" @click="removeCase(row.$index)">移除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-card>
      <el-card class="box-card">
        <div class="button_foot">
          <el-button type="primary" @click="submit"> 提交</el-button>
          <el-button type="info" @click="$router.back()"> 取消</el-button>
        </div>
      </el-card>
    </el-form>

    <el-dialog
        title="选取用例"
        ref="addDialog"
        :visible.sync="dialogVisible"
        width="60%"
        :close-on-click-modal=false
    >
      <el-form :model="chooseCaseForm">
        <div class="case_query">
          <el-form-item label="用例名称：" prop="name" label-width="120px">
            <el-input v-model.trim="chooseCaseForm.conditions.name" placeholder="请输入用例名称"
                      autocomplete="off"/>
          </el-form-item>
          <el-form-item label="用例编码：" prop="code" label-width="120px">
            <el-input v-model.trim="chooseCaseForm.conditions.code" placeholder="请输入用例编码"
                      autocomplete="off"/>
          </el-form-item>
          <el-form-item label="所属服务：" prop="serviceId" label-width="120px">
            <el-select v-model="chooseCaseForm.conditions.serviceId" filterable placeholder="请选择服务">
              <el-option
                  v-for="item in serviceList"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </div>
        <div class="button_foot">

          <el-form-item label-width="120px">
            <el-button type="primary" icon="el-icon-search" size="small" @click="searchCase">查询</el-button>
            <el-button icon="el-icon-refresh-right" size="small" @click="clearCase">重置</el-button>
          </el-form-item>
        </div>
      </el-form>
      <el-table ref="caseTable" :data="caseList" stripe border @selection-change="handleSelectionChange"
                :reserve-selection=true :row-key="getRowKey">
        <el-table-column
            type="selection"
            width="55" :reserve-selection=true>
        </el-table-column>
        <el-table-column prop="id" label="id" width="50"/>
        <el-table-column prop="name" label="用例名"/>
        <el-table-column prop="code" label="用例编码"/>
        <el-table-column prop="desc" label="描述"/>
        <el-table-column prop="serviceName" label="所属服务"/>
      </el-table>
      <el-pagination class="pagination" layout="->,total,sizes,prev,pager,next,jumper" :page-sizes="[5,10,15,20]"
                     :current-page="chooseCaseForm.currentPage" :page-size="chooseCaseForm.pageSize" :total="caseTotal"
                     @size-change="handleCaseSizeChange" @current-change="handleCaseCurrentPageChange"/>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addSceneCase">确 定</el-button>
    </span>

    </el-dialog>

  </div>
</template>

<script>
import {debounce} from 'lodash'

export default {
  data() {
    return {
      sceneModel: {
        id: '',
        sceneName: '',
        sceneCode: '',
        desc: '',
        operator: '',
        autoTestSceneCases: []
      },
      isUpdate: false,
      caseTotal: 0,
      rules: {
        sceneName: [{required: true, message: '请输入场景名称', trigger: 'blur'}],
        sceneCode: [{required: true, message: '请输入场景名称', trigger: 'blur'}]
      },
      dialogVisible: false,
      chooseCaseForm: {
        currentPage: 1,
        pageSize: 5,
        conditions: {serviceId: '', name: ''}
      },
      serviceList: [],
      caseList: [],
      multipleSelection: []
    }
  },
  created() {
    if (this.$route.query.id) {
      this.isUpdate = true
      this.querySceneDetail(this.$route.query.id)
    }
    this.initListData()
  },
  methods: {
    changeView(path, queryParam) {
      this.$router.push({
        path: path,
        query: queryParam
      })
    },
    addCase() {
      this.dialogVisible = true
      this.chooseCaseForm.currentPage = 1
      this.chooseCaseForm.pageSize = 5
      this.clearCase()
    },
    searchCase() {
      this.queryCaseList()
    },
    async initListData() {
      const result = await this.$axios.get('/service/all')
      if (result.data.success) {
        const temp = result.data.data
        for (let service of temp) {
          this.serviceList.push({label: service.serviceName, value: service.id})
        }
      } else {
        this.$message.error(result.data.message)
      }
      await this.queryCaseList()
    },
    async querySceneDetail(sceneId) {
      const result = await this.$axios.get('/scene/detail', {params: {id: sceneId}})
      if (result.data.success) {
        this.sceneModel = result.data.data
        if (!this.sceneModel.autoTestSceneCases) {
          this.sceneModel.autoTestSceneCases = []
        }
      } else {
        this.$message.error(result.data.message)
      }
    },
    async queryCaseList() {
      const result = await this.$axios.post('/case/queryList', this.chooseCaseForm)
      if (result.data.success) {
        this.caseList = result.data.data.data
        for (let caseData of this.caseList) {
          for (let service of this.serviceList) {
            if (caseData.serviceId === service.value) {
              caseData.serviceName = service.label
            }
          }
        }
        this.caseTotal = result.data.data.total
      } else {
        this.$message.error(result.data.message)
      }
    },
    handleCaseSizeChange(val) {
      this.chooseCaseForm.pageSize = val
      this.chooseCaseForm.currentPage = 1
      this.queryCaseList()
    },
    handleCaseCurrentPageChange(val) {
      this.chooseCaseForm.currentPage = val
      this.queryCaseList()
    },
    clearCase() {
      this.chooseCaseForm.conditions.name = ''
      this.chooseCaseForm.conditions.code = ''
      this.chooseCaseForm.conditions.serviceId = ''
      this.queryCaseList()
    },
    handleSelectionChange(val) {
      this.multipleSelection = val
    },
    getRowKey(row) {
      return row.id
    },
    addSceneCase: debounce(function () {
      for (let i = 0; i < this.multipleSelection.length; i++) {
        console.log('..................' + i)
        this.sceneModel.autoTestSceneCases.push({
          caseId: this.multipleSelection[i].id,
          executeOrder: this.sceneModel.autoTestSceneCases.length,
          sceneId: this.sceneModel.id ? this.sceneModel.id : null,
          autoTestCase:
              {
                id: this.multipleSelection[i].id,
                name:
                this.multipleSelection[i].name,
                code:
                this.multipleSelection[i].code,
                desc:
                this.multipleSelection[i].desc
              }
        })
      }
      console.log(JSON.stringify(this.sceneModel.autoTestSceneCases))
      this.dialogVisible = false
      this.$refs.caseTable.clearSelection()
    }, 300),
    submit: debounce(function () {
      this.$refs.scene_form.validate((valid) => {
        if (valid) {
          var url = this.sceneModel.id ? '/scene/update' : '/scene/add'
          this.$axios.post(url, this.sceneModel).then((result) => {
            if (result.data.success) {
              this.$message.success(this.sceneModel.id ? '修改成功' : '添加成功')
              this.$router.push('/autotest/scene')
            } else {
              this.$message.error(result.data.message)
            }
          })
        }
      })
    }, 300),
    moveUp(caseIndex) {
      if (caseIndex === 0) {
        this.$message.warning('已经是第一个了')
      } else {
        const temp = this.sceneModel.autoTestSceneCases[caseIndex]
        temp.executeOrder = temp.executeOrder - 1
        this.sceneModel.autoTestSceneCases[caseIndex - 1].executeOrder = this.sceneModel.autoTestSceneCases[caseIndex - 1].executeOrder + 1
        this.sceneModel.autoTestSceneCases.splice(caseIndex, 1, this.sceneModel.autoTestSceneCases[caseIndex - 1])
        this.sceneModel.autoTestSceneCases.splice(caseIndex - 1, 1, temp)
      }
    },
    moveDown(caseIndex) {
      if (caseIndex === this.sceneModel.autoTestSceneCases.length - 1) {
        this.$message.warning('已经是最后一个了')
      } else {
        const temp = this.sceneModel.autoTestSceneCases[caseIndex]
        temp.executeOrder = temp.executeOrder + 1
        this.sceneModel.autoTestSceneCases[caseIndex + 1].executeOrder = this.sceneModel.autoTestSceneCases[caseIndex + 1].executeOrder - 1
        this.sceneModel.autoTestSceneCases.splice(caseIndex, 1, this.sceneModel.autoTestSceneCases[caseIndex + 1])
        this.sceneModel.autoTestSceneCases.splice(caseIndex + 1, 1, temp)
      }
    },
    removeCase(caseIndex) {
      this.$confirm('确认移除该用例?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        for (let i = caseIndex; i < this.sceneModel.autoTestSceneCases.length; i++) {
          this.sceneModel.autoTestSceneCases[i].executeOrder = this.sceneModel.autoTestSceneCases[i].executeOrder - 1
        }
        this.sceneModel.autoTestSceneCases.splice(caseIndex, 1)
      })
    }
  }
}

</script>

<style>
.box-card {
  margin-top: 10px;
}

.case_query {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
}

.add_button {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 10px;
}

.card-content {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
}

.button_foot {
  display: flex;
  justify-content: flex-end;
}
</style>
