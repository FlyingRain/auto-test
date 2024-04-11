<template>
  <div class="content">
    <el-card shadow="never">
      <el-col>
        <el-form ref="reportSearch" :model="searchForm" size="small" inline>
          <el-form-item label="数据源名称：">
            <el-input v-model.trim="searchForm.conditions.name" placeholder="请输入批次号"></el-input>
          </el-form-item>
          <el-form-item label="数据源编码：">
            <el-input v-model.trim="searchForm.conditions.code" placeholder="请输入用例id"></el-input>
          </el-form-item>
          <el-form-item label="数据源类型:" prop="sourceType">
            <template>
              <el-select v-model="searchForm.conditions.sourceType" filterable placeholder="请选择状态">
                <el-option
                    v-for="item in sourceTypes"
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
        <el-table-column prop="name" label="名称" show-overflow-tooltip/>
        <el-table-column prop="code" label="编码" show-overflow-tooltip/>
        <el-table-column prop="sourceType" label="类型" show-overflow-tooltip />
        <el-table-column prop="createTime" label="创建时间" show-overflow-tooltip/>
        <el-table-column label="操作" width="350">
          <template v-slot="row">
            <el-button type="success" size="small" @click="changeView('/service/update',{id:row.row.id})">编辑
            </el-button>
            <el-button type="primary" size="small" @click="detail(row.row.id)"> 详情</el-button>
            <el-button type="danger" size="small" @click="deleteService(row.row.id)"> 删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <el-pagination class="pagination" layout="->,total,sizes,prev,pager,next,jumper" :page-sizes="[10,20,30,40]"
                     :current-page="searchForm.currentPage" :page-size="searchForm.pageSize" :total="total"
                     @size-change="handleSizeChange" @current-change="handleCurrentPageChange"/>
      <Detail ref="runLog_detail"/>
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
          name: '',
          code: '',
          sourceType: ''
        }
      },
      sourceTypes: [
        {value: 'MYSQL', label: 'MYSQL'},
        {value: 'REDIS', label: 'REDIS'}
      ]
    }
  },
  created() {
    this.initPage()
  },
  methods: {
    async initPage() {
      const result = await this.$axios.post('/sourceConfig/list', this.searchForm)
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
    },
    detail(id) {
      console.log('id is ------- ' + id)
      this.$refs.runLog_detail.drawer = true
      this.$refs.runLog_detail.formData.id = id
      this.$refs.runLog_detail.getRunLogDetail()
    }
  }

}
</script>
<style>
.content {
  margin-top: 10px;
}
</style>
