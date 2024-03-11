<template>
  <div class="content">

    <el-card shadow="never">

      <el-col>
        <el-form ref="searchRef" :model="searchForm" size="small" inline>
          <el-form-item label="应用名称：" prop="appName">
            <el-input v-model.trim="searchForm.conditions.appName" placeholder="请输入应用名称"/>
          </el-form-item>
          <el-form-item label="应用编码：" prop="appCode">
            <el-input v-model.trim="searchForm.conditions.appCode" placeholder="应用编码"/>
          </el-form-item>
          <el-form-item label="负责人：" prop="owner">
            <el-input v-model.trim="searchForm.conditions.owner" placeholder="请输入应用负责人"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="small" @click="handleSearch()">查询</el-button>
            <el-button icon="el-icon-refresh-right" size="small" @click="handleClear()">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col>
        <div class="opts">
          <el-button type="primary" icon="el-icon-circle-plus" size="small" @click="dialogVisible = true"> 新增
          </el-button>
        </div>
      </el-col>

      <el-dialog
          title="新增应用"
          ref="addDialog"
          :visible.sync="dialogVisible"
          width="30%"
          :before-close="handleClose">
        <el-form :model="addAppForm" size="small" :rules="addRules">
          <el-form-item label="应用编码：" prop="appCode">
            <el-input v-model.trim="addAppForm.appCode" placeholder="请输入应用编码"/>
          </el-form-item>
          <el-form-item label="应用名称：" prop="appName">
            <el-input v-model.trim="addAppForm.appName" placeholder="请输入应用名称"/>
          </el-form-item>
          <el-form-item label="负责人：" prop="owner">
            <el-input v-model.trim="addAppForm.owner" placeholder="请输入负责人"/>
          </el-form-item>
          <el-form-item label="描述：" prop="desc">
            <el-input v-model.trim="addAppForm.desc" placeholder="描述" type="textarea"/>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addApp">确 定</el-button>
    </span>
      </el-dialog>
      <!-- 表格 -->
      <el-table ref="table" :data="tableData" border>
        <el-table-column prop="id" label="id" width="50"/>
        <el-table-column prop="appName" label="应用名" show-overflow-tooltip/>
        <el-table-column prop="appCode" label="应用编码" show-overflow-tooltip/>
        <el-table-column prop="owner" label="负责人" show-overflow-tooltip/>
        <el-table-column prop="desc" label="描述" show-overflow-tooltip/>
        <el-table-column prop="createTime" label="创建时间" show-overflow-tooltip/>
        <el-table-column label="操作" width="180">
          <template v-slot="{row}">
            <el-button type="success" size="small" @click="changeView('/service/update')">编辑</el-button>
            <el-button type="danger" size="small" @click="deletecourse(row.id)"> 删除</el-button>
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
      dialogVisible: false,
      tableData: [],
      total: 0,
      searchForm: {
        currentPage: 1,
        pageSize: 10,
        conditions: {
          appName: '',
          appCode: '',
          owner: ''
        }
      },
      addAppForm: {
        appCode: '',
        appName: '',
        desc: '',
        owner: ''
      },
      addRules: {
        appCode: [{
          required: true,
          message: '请输入应用编码',
          trigger: 'blur'
        }],
        appName: [{
          required: true,
          message: '请输入应用名称',
          trigger: 'blur'
        }]
      }

    }
  },
  created() {
    this.getPageList()
  },
  methods: {
    async getPageList() {
      const result = await this.$axios.post('/app/list', this.searchForm)
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
    async addApp() {
      console.log(JSON.stringify(this.addAppForm))
      const result = await this.$axios.post('/app/add', this.addAppForm)
      if (result.data.success) {
        this.dialogVisible = false
        location.reload()
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
