<template>
  <div class="content">
    <el-card shadow="never" style="margin-top: 10px">
      <div class="title">
        <p style="font-size: large;color: #2661ef;font-weight: bold;text-align: center"> 测试报告 </p>
      </div>
      <div>
        <el-row type="flex" justify="center" class="no-gutter">
          <el-col :span="8">
            <el-card shadow="never" class="element">
              <el-button type="primary" class="card-button">测试人员</el-button>
              <span class="summary_content">{{ reportDetail.operator }}</span>
            </el-card>
          </el-col>
          <el-col :span="8">
            <el-card shadow="never" class="element">
              <el-button type="primary" class="card-button">用例总数</el-button>
              <span class="summary_content">{{ reportDetail.caseNumber }}</span>
            </el-card>
          </el-col>
        </el-row>
        <el-row type="flex" justify="center" style="margin-top: 0;margin-bottom: 0">
          <el-col :span="8">
            <el-card shadow="never" class="element">
              <el-button type="primary" class="card-button">执行时间</el-button>
              <span class="summary_content">{{ reportDetail.executeTime }}</span>
            </el-card>
          </el-col>
          <el-col :span="8">
            <el-card shadow="never" class="element">
              <el-button type="success" class="card-button">成功数量</el-button>
              <span class="summary_content">{{ reportDetail.successNumber }}</span>
            </el-card>
          </el-col>
        </el-row>
        <el-row type="flex" justify="center" style="margin-top: 0;margin-bottom: 0">
          <el-col :span="8">
            <el-card shadow="never" class="element">
              <el-button type="primary" class="card-button">执行耗时</el-button>
              <span class="summary_content">{{ reportDetail.consumeTime }}ms</span>
            </el-card>
          </el-col>
          <el-col :span="8">
            <el-card shadow="never" class="element">
              <el-button type="danger" class="card-button">失败数量</el-button>
              <span class="summary_content">{{ reportDetail.caseNumber - reportDetail.successNumber }}</span>
            </el-card>

          </el-col>
        </el-row>
        <el-row type="flex" justify="center" style="margin-top: 0;margin-bottom: 0">
          <el-col :span="8">
            <el-card shadow="never" class="element">
              <el-button type="primary" class="card-button">执行环境</el-button>
              <el-input v-model="reportDetail.env" class="card-input" style="width: 50%;"></el-input>
            </el-card>
          </el-col>
          <el-col :span="8">
            <el-card shadow="never" class="element">
              <el-button type="primary" class="card-button">最终结论</el-button>
              <span class="summary_content" style="color: red"
                    v-if="reportDetail.result==='FAIL'">不通过</span>
              <span class="summary_content" style="color: green"
                    v-if="reportDetail.result==='SUCCESS'">通过</span>
            </el-card>

          </el-col>
        </el-row>
        <el-row type="flex" justify="center" style="margin-top: 0;margin-bottom: 0">
          <el-col :span="16">
            <el-card shadow="never" class="element">
              <el-button type="primary" class="card-button">本次总结</el-button>
              <el-input v-model="reportDetail.desc" class="card-input"></el-input>
            </el-card>
          </el-col>
        </el-row>
      </div>
      <span style="font-weight: bold;color: seagreen;margin: 10px">执行流水</span>
      <div style="display: flex;justify-content: center">
        <el-table :data="tableData" style="width: 90%;margin: 10px " stripe border>
          <el-table-column prop="id" label="id" width="50"/>
          <el-table-column prop="batchNum" label="执行批次" show-overflow-tooltip/>
          <el-table-column prop="caseCode" label="用例编码" show-overflow-tooltip/>
          <el-table-column prop="runStatus" label="执行状态" show-overflow-tooltip>
            <template v-slot="row">
              <span v-if="row.row.runStatus==='SUCCESS'" style="color: green"> 成功</span>
              <span v-if="row.row.runStatus==='FAIL'" style="color:red;"> 失败</span>
            </template>
          </el-table-column>
          <el-table-column prop="spendTime" label="耗时（ms）" show-overflow-tooltip/>
          <el-table-column prop="runResult" label="运行结果" show-overflow-tooltip/>
          <el-table-column prop="message" label="校验结果" show-overflow-tooltip/>
          <el-table-column prop="executeTime" label="执行时间" show-overflow-tooltip/>
        </el-table>
      </div>
    </el-card>
    <el-card class="box-card">
      <div class="footer">
        <el-button type="primary" @click="onSubmit">保 存</el-button>
        <el-button @click="$router.back()">取 消</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      reportDetail: {}
    }
  },
  created() {
    this.initData(this.$route.query.id)
  },
  methods: {
    async initData(id) {
      const result = await this.$axios.get('/report/detail', {params: {id: id}})
      if (result.data.success) {
        this.reportDetail = result.data.data
        this.tableData = result.data.data.runLogs
      } else {
        this.$message.error(result.data.message)
      }
    },
    onSubmit() {
      this.$axios.post('/report/update', this.reportDetail).then(res => {
        if (res.data.success) {
          this.$message.success('更新成功！')
          this.$router.back()
        } else {
          this.$message.error(res.data.message)
        }
      })
    }
  }
}
</script>

<style>
.box-card {
  margin-top: 10px;
}

.no-gutter.el-col {
  padding: 0;
  margin-bottom: 0;
  margin-top: 0;
}

.element {
  width: 100%;
  height: 60px;
  padding: 0px;
  position: relative;
  margin: 0 !important;
}

.card-button {
  position: absolute;
  top: 10px;
  left: 15px;
}

.summary_content {
  font-size: 14px;
  position: absolute;
  top: 20px;
  left: 165px;
}

.card-input {
  position: absolute;
  top: 10px;
  left: 165px;
  width: 80%;
}

.footer {
  display: flex;
  justify-content: flex-end;
}
</style>
