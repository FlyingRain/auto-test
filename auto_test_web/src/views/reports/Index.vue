<template>
  <div class="content">
    <el-card shadow="never">
      <el-col>
        <el-form ref="searchForm" :model="reportModel" size="small" inline>
          <el-form-item label="批次号">
            <el-input v-model.trim="reportModel.conditions.batchNum" placeholder="请输入批次号"></el-input>
          </el-form-item>
          <el-form-item label="状态:" prop="serviceId">
            <template>
              <el-select v-model="reportModel.conditions.result" filterable placeholder="请选择状态">
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

      <el-table ref="table" :data="tableData" stripe border>
        <el-table-column prop="id" label="id" width="50"/>
        <el-table-column prop="batchNum" label="批次号" show-overflow-tooltip/>
        <el-table-column prop="result" label="结论" show-overflow-tooltip>
          <template v-slot="row">
            <span v-if="row.row.result==='SUCCESS'" style="color: green"> 通过</span>
            <span v-if="row.row.result==='FAIL'" style="color:red;"> 不通过</span>
            <span v-if="row.row.result==='EXECUTING'" style="color:blue;"> 执行中</span>
          </template>
        </el-table-column>
        <el-table-column prop="caseNumber" label="执行用例数" show-overflow-tooltip/>
        <el-table-column prop="runNumber" label="实际执行数" show-overflow-tooltip/>
        <el-table-column prop="successNumber" label="成功数" show-overflow-tooltip/>
        <el-table-column prop="executeTime" label="执行时间" width="250" show-overflow-tooltip>
          <template v-slot="row">
            {{ formatDate(row.row.executeTime) }}
          </template>
        </el-table-column>
        <el-table-column label="操作" width="250">
          <template v-slot="row">
            <el-button type="success" size="small" @click="detail(row.row.id)"> 预览</el-button>
            <el-button type="primary" size="small" @click="download(row.row.id)"> 下载</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页 -->
      <el-pagination class="pagination" layout="->,total,sizes,prev,pager,next,jumper" :page-sizes="[10,20,30,40]"
                     :current-page="reportModel.currentPage" :page-size="reportModel.pageSize" :total="total"
                     @size-change="handleSizeChange" @current-change="handleCurrentPageChange"/>

    </el-card>

  </div>
</template>
<script>
export default {
  data() {
    return {
      reportModel: {
        currentPage: 1,
        pageSize: 10,
        conditions: {
          batchNum: '',
          result: ''
        }
      },
      total: 0,
      tableData: [],
      statusList: [{label: '成功', value: 'SUCCESS'}, {label: '失败', value: 'FAIL'}]
    }
  },
  created() {
    this.initPage()
  },
  methods: {
    handleSearch() {
      this.reportModel.currentPage = 1
      this.initPage()
    },
    async initPage() {
      const result = await this.$axios.post('/report/list', this.reportModel)
      if (result.data.success) {
        this.tableData = result.data.data.data
        this.total = result.data.data.total
      } else {
        this.$message.error(result.data.message)
      }
    },
    handleClear() {
      this.reportModel.conditions.batchNum = ''
      this.reportModel.conditions.result = ''
      this.handleSearch()
    },
    handleSizeChange(val) {
      this.reportModel.pageSize = val
      this.reportModel.currentPage = 1
      this.initPage()
    },
    handleCurrentPageChange(val) {
      this.reportModel.currentPage = val
      this.initPage()
    },
    formatDate(date) {
      return date
    },
    download(id) {
      this.$axios.get('/report/download', {params: {id: id}, responseType: 'blob'}).then(response => {
        const url = window.URL.createObjectURL(new Blob([response.data]))
        const link = document.createElement('a')
        link.href = url
        link.setAttribute('download', 'test111.pdf')
        document.body.appendChild(link)
        link.click()
      }).catch(error => {
        this.$message.error(error)
      })
    }
  }
}
</script>

<style>

</style>
