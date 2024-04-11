
<template>
  <div class="content">
    <el-form ref="service_from" :model="sourceConfig" :rules="rules" label-width="100px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>数据源配置</span>
        </div>
        <div class="card-content">
          <el-form-item label="数据源名称:" prop="serviceName">
            <el-input v-model="sourceConfig.serviceName" placeholder="请输入服务名称"></el-input>
          </el-form-item>
          <el-form-item label="数据源编码:" prop="serviceCode">
            <el-input v-model="sourceConfig.serviceCode" placeholder="请输入服务编码"></el-input>
          </el-form-item>
          <el-form-item label="数据源类型:" prop="appId">
            <el-select v-model="sourceConfig.sourceType" filterable placeholder="请选择状态">
              <el-option
                  v-for="item in statusList"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
            <el-cascader placeholder="请选择数据源类型" v-model="service.appId" :options="appList"
                         @change="handleChange"></el-cascader>
          </el-form-item>
        </div>
      </el-card>
    </el-form>
  </div>
</template>

<script setup>

</script>

<style>

</style>
