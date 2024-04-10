<template>
  <div class="content">
    <el-card shadow="never">
      <el-col>
        <el-form ref="reportSearch" :model="searchForm" size="small" inline>
          <el-form-item label="批次号：">
            <el-input v-model.trim="searchForm.conditions.batchNum" placeholder="请输入批次号"></el-input>
          </el-form-item>
          <el-form-item label="用例id：">
            <el-input v-model.trim="searchForm.conditions.caseId" placeholder="请输入用例id"></el-input>
          </el-form-item>
          <el-form-item label="状态:" prop="serviceId">
            <template>
              <el-select v-model="searchForm.conditions.runStatus" filterable placeholder="请选择状态">
                <el-option
                    v-for="item in statusList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </template>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="small" @click="handleSearch()">查询</el-button>
            <el-button icon="el-icon-refresh-right" size="small" @click="handleClear()">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>

      <!-- 表格 -->
      <el-table ref="table" :data="tableData" stripe border>
        <el-table-column prop="id" label="id" width="50"/>
        <el-table-column prop="batchNum" label="执行批次" show-overflow-tooltip/>
        <el-table-column prop="caseId" label="用例id" show-overflow-tooltip/>
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
        <el-table-column label="操作" width="150">
          <template v-slot="row">
            <el-button type="primary" size="small" @click="detail(row.row.id)"> 详情</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <el-pagination class="pagination" layout="->,total,sizes,prev,pager,next,jumper" :page-sizes="[10,20,30,40]"
                     :current-page="searchForm.currentPage" :page-size="searchForm.pageSize" :total="total"
                     @size-change="handleSizeChange" @current-change="handleCurrentPageChange"/>
      <Detail ref="case_detail"/>
    </el-card>

  </div>
</template>

<script>

import Detail from './Detail.vue'

export default {
  name: 'reportManager',
  components: {Detail},
  data() {
    return {
      tableData: [],
      total: 0,
      searchForm: {
        currentPage: 1,
        pageSize: 10,
        conditions: {
          batchNum: '',
          caseId: '',
          runStatus: ''
        }
      },
      statusList: [
        {value: 'SUCCESS', label: '成功'},
        {value: 'FAIL', label: '失败'},
        {value: 'EXECUTING', label: '执行中'}
      ]
    }
  },
  created() {
    this.initPage()
  },
  methods: {
    async initPage() {
      const result = await this.$axios.post('/runlog/list', this.searchForm)
      if (result.data.success) {
        this.tableData = result.data.data.data
        this.total = result.data.data.total
      } else {
        this.$message.error(result.data.message)
      }
    },
    handleSizeChange(val) {
      this.searchForm.pageSize = val
      this.searchForm.currentPage = 1
      this.initPage()
    },
    handleCurrentPageChange(val) {
      this.searchForm.currentPage = val
      this.initPage()
    },
    handleSearch() {
      this.searchForm.currentPage = 1
      this.initPage()
    },
    handleClear() {
      this.searchForm.conditions.batchNum = ''
      this.searchForm.conditions.caseId = ''
      this.searchForm.conditions.runStatus = ''
      this.initPage()
    }
  }

}
</script>
<style>
.content {
  margin-top: 10px;
}
</style>
