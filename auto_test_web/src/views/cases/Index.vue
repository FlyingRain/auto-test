<template>
  <div class="content">

    <el-card shadow="never">

      <el-col>
        <el-form ref="searchRef" :model="searchForm" size="small" inline>
          <el-form-item label="用例id：" prop="id">
            <el-input v-model.trim="searchForm.conditions.id" placeholder="请输入用例id"/>
          </el-form-item>
<!--          <el-form-item label="用例名称：" prop="name">-->
<!--            <el-input v-model.trim="searchForm.conditions.name" placeholder="请输入用例名称"/>-->
<!--          </el-form-item>-->
          <el-form-item label="用例编码：" prop="code">
            <el-input v-model.trim="searchForm.conditions.code" placeholder="请输入用例编码"/>
          </el-form-item>
          <el-form-item label="所属应用:" prop="serviceId">
            <el-select v-model.trim="searchForm.conditions.appId" placeholder="请选择应用" @change='appChange'
                       filterable>
              <el-option
                  v-for="item in appList"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="所属服务:" prop="serviceId">
            <template>
              <el-select v-model="searchForm.conditions.serviceId" filterable placeholder="请选择服务">
                <el-option
                    v-for="item in serviceList"
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
      <el-col>
        <div class="opts">
          <el-button type="primary" icon="el-icon-circle-plus" size="small" @click="changeView('/autotest/add')"> 新增
          </el-button>
        </div>
      </el-col>

      <!-- 表格 -->
      <el-table ref="table" :data="tableData" stripe border>
        <el-table-column prop="id" label="id" width="50"/>
        <el-table-column prop="name" label="用例名" show-overflow-tooltip/>
        <el-table-column prop="code" label="用例编码" show-overflow-tooltip/>
        <el-table-column prop="serviceName" label="所属服务" show-overflow-tooltip/>
        <el-table-column prop="desc" label="描述" show-overflow-tooltip/>
        <el-table-column prop="creator" label="创建人" show-overflow-tooltip/>
        <el-table-column prop="createTime" label="创建时间" show-overflow-tooltip/>
        <el-table-column label="操作" width="350">
          <template v-slot="row">
            <el-tooltip content="Run" placement="top">
              <el-button type="success" size="small" icon="el-icon-video-play"
                         @click="runCase(row.row.id)">运行
              </el-button>
              <!--              <i class="el-icon-video-play"></i>-->
            </el-tooltip>
            <el-button type="primary" size="small" @click="detail(row.row.id)"> 详情</el-button>
            <el-button type="warning" size="small" @click="changeView('/autotest/update',{id:row.row.id})"> 修改
            </el-button>
            <el-button type="danger" size="small" @click="deleteCase(row.row.id)"> 删除</el-button>
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
  name: 'caseManager',
  components: {Detail},
  data() {
    return {
      tableData: [],
      total: 0,
      searchForm: {
        currentPage: 1,
        pageSize: 10,
        conditions: {
          id: '',
          name: '',
          serviceId: '',
          code: '',
          creator: '',
          appId: ''
        }
      },
      serviceList: [],
      appList: []
    }
  },
  created() {
    console.log('load this page')
    this.initPage()
  },
  methods: {
    async getAppList() {
      const result = await this.$axios.get('app/all')
      if (result.data.success) {
        for (var appData of result.data.data) {
          this.appList.push({label: appData.appName, value: appData.id})
        }
      } else {
        this.$message.error(result.data.message)
      }
    },
    async getServiceList(appId) {
      const result = await this.$axios.get('service/query', {params: {appId: appId}})
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
    changeView(path, queryParam) {
      this.$router.push({
        path: path,
        query: queryParam
      })
    },
    async initPage() {
      await this.getPageList()
      await this.getAppList()
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
      this.searchForm.conditions.name = ''
      this.searchForm.conditions.serviceId = ''
      this.serviceList = []
      this.searchForm.conditions.appId = ''
      this.searchForm.conditions.creator = ''
      this.searchForm.conditions.id = ''
      this.getPageList()
    },
    async getPageList() {
      const result = await this.$axios.post('/case/queryList', this.searchForm)
      if (result.data.success) {
        this.tableData = result.data.data.data
        for (let item of this.tableData) {
          for (let s of this.serviceList) {
            if (item.serviceId === s.value) {
              item.serviceName = s.label
            }
          }
        }
        this.total = result.data.data.total
      } else {
        this.$message.error(result.data.message)
      }
    },
    detail(id) {
      this.$refs.case_detail.drawer = true
      this.$refs.case_detail.formData.id = id
      this.$refs.case_detail.getCaseDetail()
    },
    deleteCase(id) {
      this.$confirm('确认删除此条信息?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.post('/case/delete', {ids: [id]}).then((res) => {
          if (res.data.success) {
            this.$message.success('删除成功')
            this.getPageList()
          } else {
            this.$message.error(res.data.message)
          }
        })
      })
    },
    runCase(caseId) {
      this.$axios.get('/case/start', {params: {id: caseId}}).then((res) => {
        if (res.data.success) {
          this.$message.success('执行成功，请到执行报告页面查看结果，批次号：' + res.data.data)
        } else {
          this.$message.error('执行失败:' + res.data.message)
        }
      })
    },
    cleanChoose() {
      this.serviceList = []
      this.searchForm.conditions.serviceId = ''
    },
    appChange(appId) {
      this.cleanChoose()
      this.getServiceList(appId)
    }
  }
}

</script>
<style>
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
