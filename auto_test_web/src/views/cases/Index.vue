<template>
  <div class="content">

    <el-card shadow="never">

      <el-col>
        <el-form ref="searchRef" :model="searchForm" size="small" inline>
          <el-form-item label="用例名称：" prop="name">
            <el-input v-model.trim="searchForm.conditions.name" placeholder="请输入服务名称"/>
          </el-form-item>
          <el-form-item label="创建人：" prop="creator">
            <el-input v-model.trim="searchForm.conditions.creator" placeholder="请输入服务编码"/>
          </el-form-item>
          <el-form-item label="所属服务:" prop="serviceId">
            <template>
              <el-select v-model="searchForm.conditions.serviceId" filterable placeholder="请选择">
                <el-option
                    v-for="item in appList"
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
        <el-table-column prop="serviceName" label="服务名" show-overflow-tooltip/>
        <el-table-column prop="serviceCode" label="服务编码" show-overflow-tooltip/>
        <el-table-column prop="protocolType" label="协议类型" show-overflow-tooltip/>
        <el-table-column prop="requestPath" label="请求路径" show-overflow-tooltip/>
        <el-table-column prop="appName" label="归属应用" show-overflow-tooltip/>
        <el-table-column prop="creator" label="创建人" show-overflow-tooltip/>
        <el-table-column prop="createTime" label="创建时间" show-overflow-tooltip/>
        <el-table-column label="操作" width="250">
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
      <Detail ref="service_detail"/>
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
          name: '',
          serviceId: '',
          creator: ''
        }
      },
      appList: []
    }
  },
  created() {
    console.log('load this page')
  },
  methods: {
    changeView(path, queryParam) {
      this.$router.push({
        path: path,
        query: queryParam
      })
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
