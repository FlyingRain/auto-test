<template>
  <div class="content">

    <el-drawer title="详情" :visible.sync="drawer" size="40%">
      <el-card class="box-card">
        <div class="card-content">
          <el-descriptions title="基本信息" :column=1>
            <el-descriptions-item label="用例编码">{{ formData.caseCode }}</el-descriptions-item>
            <el-descriptions-item label="批次号">{{ formData.batchNum }}</el-descriptions-item>
            <el-descriptions-item label="执行人">{{ formData.executor }}</el-descriptions-item>
          </el-descriptions>
          <el-descriptions title="执行详情" :column=1>
            <el-descriptions-item label="执行时间">{{ formData.executeTime }}</el-descriptions-item>
            <el-descriptions-item label="耗时">{{ formData.spendTime }} ms</el-descriptions-item>
            <el-descriptions-item label="执行结果">
              <span v-if="formData.runStatus === 'SUCCESS'" style="color: green">{{ formData.runStatus }}</span>
              <span v-if="formData.runStatus === 'FAIL'" style="color: red">{{ formData.runStatus }}</span>
            </el-descriptions-item>
          </el-descriptions>
          <el-descriptions title="执行结果" :column=1>
            <el-descriptions-item label="接口返回">{{ formData.runResult }}</el-descriptions-item>
            <el-descriptions-item label="校验结果">{{ formData.message }}</el-descriptions-item>
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
        caseCode: '',
        runStatus: '',
        batchNum: '',
        executor: '',
        runResult: '',
        executeTime: '',
        spendTime: '',
        message: ''
      }
    }
  },
  methods: {
    async getRunLogDetail() {
      console.log('sdsd + ' + this.formData.id)
      const result = await this.$axios.get('/runlog/detail', {params: {id: this.formData.id}})
      if (result.data.success) {
        Object.assign(this.formData, result.data.data)
      } else {
        this.$message.error(result.data.message)
      }
    }
  }
}
</script>
<style>

</style>
