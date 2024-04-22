<template>
  <div class="content">

    <el-card shadow="never">

      <el-col>
        <el-form ref="searchRef" :model="searchForm" size="small" inline>
          <el-form-item label="用例名称：" prop="name">
            <el-input v-model.trim="searchForm.conditions.sceneName" placeholder="请输入场景名称"/>
          </el-form-item>
          <el-form-item label="场景编码：" prop="code">
            <el-input v-model.trim="searchForm.conditions.sceneCode" placeholder="请输入场景编码"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="small" @click="handleSearch()">查询</el-button>
            <el-button icon="el-icon-refresh-right" size="small" @click="handleClear()">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col>
        <div class="opts">
          <el-button type="primary" icon="el-icon-circle-plus" size="small"
                     @click="changeView('/autotest/scene/addScene')"> 新增
          </el-button>
        </div>
      </el-col>

      <!-- 表格 -->
      <el-table ref="table" :data="tableData" stripe border>
        <el-table-column prop="id" label="id" width="50"/>
        <el-table-column prop="sceneName" label="场景名称" show-overflow-tooltip/>
        <el-table-column prop="sceneCode" label="场景编码" show-overflow-tooltip/>
        <el-table-column prop="desc" label="描述" show-overflow-tooltip/>
        <el-table-column prop="operator" label="操作人" show-overflow-tooltip/>
        <el-table-column prop="createTime" label="创建时间" show-overflow-tooltip/>
        <el-table-column label="操作" width="250">
          <template v-slot="row">
            <el-button type="success" size="small" @click="runScene(row.row.id)">运行
            </el-button>
            <el-button type="primary" size="small" @click="changeView('/autotest/scene/update',{id:row.row.id})"> 编排
            </el-button>
            <el-button type="danger" size="small" @click="deleteScene(row.row.id)"> 删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页 -->
      <el-pagination class="pagination" layout="->,total,sizes,prev,pager,next,jumper" :page-sizes="[10,20,30,40]"
                     :current-page="searchForm.currentPage" :page-size="searchForm.pageSize" :total="total"
                     @size-change="handleSizeChange" @current-change="handleCurrentPageChange"/>
      <Detail ref="service_detail"/>
    </el-card>
  </div>
</template>
<script>
import Detail from '../cases/Detail.vue'

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
          sceneName: '',
          sceneCode: ''
        }
      }
    }
  },
  created() {
    console.log('load this page')
    this.initPage()
  },
  methods: {
    async initPage() {
      const result = await this.$axios.post('/scene/list', this.searchForm)
      if (result.data.success) {
        this.tableData = result.data.data.data
        this.total = result.data.data.total
      } else {
        this.$message.error(result.data.message)
      }
    },
    handleSearch() {
      this.initPage()
    },
    handleClear() {
      this.searchForm.conditions.sceneCode = ''
      this.searchForm.conditions.sceneName = ''
      this.initPage()
    },
    changeView(path, queryParam) {
      this.$router.push({
        path: path,
        query: queryParam
      })
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
    deleteScene(sceneId) {
      this.$confirm('确认删除此条信息?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.post('/scene/del', {}, {params: {id: sceneId}}).then(res => {
          if (res.data.success) {
            this.$message.success('删除成功')
            this.initPage()
          } else {
            this.$message.error(res.data.message)
          }
        })
      })
    },
    async runScene(sceneId) {
      const result = await this.$axios.get('/scene/run', {params: {sceneId: sceneId}})
      if (result.data.success) {
        this.$message.success('正在执行，请稍后根据批次号：[' + result.data.data + ']至执行报告页面查询结果')
      } else {
        this.$message.error(result.data.message)
      }
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
