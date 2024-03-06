<template>
  <div class="content">
    <div class="main-info">
      <el-card class="info">
        <el-button type="primary" icon="el-icon-user-solid" circle/>
        <h2 class="num-info"> 100</h2>
        <p class="desc">服务总量</p>
      </el-card>
      <el-card class="info">
        <el-button type="warning" icon="el-icon-s-data" circle/>
        <h2 class="num-info"> 880 </h2>
        <p class="desc">用例总量</p>
      </el-card>
      <el-card class="info">
        <el-button type="success" icon="el-icon-check" circle/>
        <h2 class="num-info"> 90 </h2>
        <p class="desc">成功</p>
      </el-card>
      <el-card class="info">
        <el-button type="danger" icon="el-icon-loading" circle/>
        <h2 class="num-info"> 10 </h2>
        <p class="desc">失败</p>
      </el-card>
    </div>
    <div class="chart">
      <el-card class="e-chard" id="one-chart"></el-card>
      <el-card class="e-chard" id="two-chart"></el-card>
    </div>
  </div>

</template>

<script>
export default {
  data() {
    return {}
  },
  created() {
    this.initData()
  },
  methods: {
    async initData() {
      const result = await this.$axios.get('/data/board')
      if (result.data.success) {
        Object.assign(this.initData, result.data.data)
      } else {
        this.$message.error(result.data.message)
      }
    },
    oneEcharts() {
      var oneChart = this.$echarts.init(document.getElementById('one-chart'))
      var option = {
        tooltip: {},
        legend: {
          data: ['用例分布']
        },
        xAxis: {
          data: ['users', 'etc', 'pay']
        },
        yAxis: {},
        series: [
          {
            name: '用例分布',
            data: [30, 20, 10],
            type: 'bar'
          }
        ]
      }
      oneChart.setOption(option)
    },
    twoCharts() {
      var chartDom = document.getElementById('two-chart')
      var myChart = this.$echarts.init(chartDom)
      var option = {
        legend: {
          data: ['用例执行情况']
        },
        xAxis: {
          type: 'category',
          data: ['2-1', '2-2', '2-3', '2-4', '2-5']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '用例执行情况',
            data: [33, 25, 45, 119, 90],
            type: 'line'
          }
        ]
      }
      myChart.setOption(option)
    }
  },
  mounted() {
    this.oneEcharts()
    this.twoCharts()
  }
}

</script>

<style>
.content {
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  height: 100%;
}

.main-info {
  flex: 1;
  display: flex;
  justify-content: space-around;
  background: white;
  min-width: 800px;
  border-radius: 8px;
}

.info {
  background: white;
  width: 18%;
  height: 60%;
  align-self: center;
  text-align: center;
  box-sizing: border-box;
  display: flex;
  align-items: center;
  justify-content: center;
}

.info .num-info {
  margin: 10px 0;
}

.info .desc {
  font-size: 10px;
  color: gray;
}

.chart {
  flex: 1;
  margin-top: 10px;
  display: flex;
  justify-content: space-between;
  border-radius: 8px;
  width: 100%;
  height: 100%;
}

.e-chard {
  padding-top: 10px;
  width: 49%;
  height: auto;
  min-width: 500px;
}
</style>
