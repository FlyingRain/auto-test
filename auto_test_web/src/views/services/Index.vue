<template>
  <div class="content">

    <el-card shadow="never">

      <el-col>
        <el-form ref="searchRef" :model="searchForm" size="small" inline>
          <el-form-item label="服务名称：" prop="serviceName">
            <el-input v-model.trim="searchForm.conditions.serviceName" placeholder="请输入服务名称"/>
          </el-form-item>
          <el-form-item label="服务编码：" prop="serviceCode">
            <el-input v-model.trim="searchForm.conditions.serviceCode" placeholder="请输入服务编码"/>
          </el-form-item>
          <el-form-item label="所属应用:" prop="appId">
            <el-cascader placeholder="请选择所属应用" v-model="searchForm.conditions.appId" :options="appList"
                         @change="handleChange"></el-cascader>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="small" @click="handleSearch()">查询</el-button>
            <el-button icon="el-icon-refresh-right" size="small" @click="handleClear()">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col>
        <div class="opts">
          <el-button type="primary" icon="el-icon-circle-plus" size="small" @click="changeView('/service/add')"> 新增
          </el-button>
        </div>
      </el-col>

      <!-- 表格 -->
      <el-table ref="table" :data="tableData" border>
        <el-table-column prop="id" label="id" width="50"/>
        <el-table-column prop="serviceName" label="服务名" show-overflow-tooltip/>
        <el-table-column prop="serviceCode" label="服务编码" show-overflow-tooltip/>
        <el-table-column prop="protocolType" label="协议类型" show-overflow-tooltip/>
        <el-table-column prop="requestPath" label="请求路径" show-overflow-tooltip/>
        <el-table-column prop="appName" label="归属应用" show-overflow-tooltip/>
        <el-table-column prop="createTime" label="创建时间" show-overflow-tooltip/>
        <el-table-column label="操作" width="360">
          <template v-slot="{row}">
            <el-button type="success" size="small" @click="changeView('/service/update')">编辑</el-button>
            <el-button type="danger" size="small" @click="deletecourse(row.id)"> 删除</el-button>
            <el-button type="primary" size="small" @click="managercases(row.id)"> 管理用例</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <el-pagination class="pagination" layout="->,total,sizes,prev,pager,next,jumper" :page-sizes="[10,20,30,40]"
                     :current-page="searchForm.currentPage" :page-size="searchForm.pageSize" :total="total"
                     @size-change="handleSizeChange" @current-change="handleCurrentPageChange"/>
      <Detail ref="course_detail"/>
    </el-card>
  </div>
</template>

<script>
import Detail from '../services/Detail.vue'

export default {
  name: 'serviceManager',
  components: {Detail},
  data() {
    return {
      tableData: [],
      total: 0,
      searchForm: {
        currentPage: 1,
        pageSize: 10,
        conditions: {
          serviceName: '',
          serviceCode: '',
          appId: ''
        }
      },
      appList: []

    }
  },
  created() {
    this.getPageList()
    this.getAppList()
  },
  methods: {
    async getPageList() {
      const result = await this.$axios.post('/service/list', this.searchForm)
      if (result.data.success) {
        this.tableData = result.data.data.records
        this.total = result.data.data.total
      } else {
        this.$message.error(result.data.message)
      }
    },
    handleSizeChange(val) {
      this.searchForm.pageSize = val
      this.searchForm.currentPage = 1
      this.getPageList()
    },
    handleCurrentPageChange(val) {
      this.searchForm.currentPage = val
      this.getPageList()
    },
    handleSearch() {
      this.searchForm.currentPage = 1
      this.getPageList()
    },
    handleClear() {
      this.$refs['searchRef'].resetFields()
      this.getPageList()
    },
    changeView(url, queryParams) {
      this.$router.push({
        path: url,
        query: queryParams
      })
    },
    async getAppList() {
      const result = await this.$axios.get('/app/all')
      if (result.data.success) {
        const appInfos = result.data.data
        this.appList = appInfos.map(t => {
          return {value: t.id, label: t.appName}
        })
      } else {
        this.$message.error(result.data.message)
      }
    }
  }

}

</script>
<style scoped>
.opts {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 5px;
  margin-top: 5px;
}

.content {
  margin-top: 10px;
}
</style>
