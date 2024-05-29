<template>
  <div class="content">
    <el-form ref="order_form" :model="sendOrder" :rules="rules">
      <div class="order-info">
        <!--        <p style="display: flex;justify-content: center;font-size: 22px">创建订单</p>-->
        <el-card class="box-card" shadow="hover">
          <div>基本信息</div>
          <div class="order-head">
            <el-form-item label="运单号:" prop="orderNo" label-width="120px">
              <el-input v-model="sendOrder.orderNo">
              </el-input>
            </el-form-item>
            <el-form-item label="客户单号:" prop="customerNo" label-width="120px">
              <el-input v-model="sendOrder.customerNo">
              </el-input>
            </el-form-item>
            <el-form-item label="收件员工:" prop="receiveAccNo" label-width="120px">
              <el-select v-model="sendOrder.receiveAccNo">
                <el-option v-for="item in acctList" :key="item.key" :value="item.value" :label="item.label">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="寄件日期:" prop="sendTime" label-width="120px">
              <el-input v-model="sendOrder.sendTime" disabled>
              </el-input>
            </el-form-item>
            <i class="el-icon-refresh-right" style="margin-left: 10px;margin-top: 10px;color: #2661ef"
               @click="refreshTime"></i>

          </div>
        </el-card>
      </div>
      <div class="order-send-receive">
        <el-card class="box-card subCard right" shadow="hover">
          <div>寄件人信息</div>
          <div class="customer">
            <el-form-item label="电话:" prop="sendInfo.telNo" label-width="90px">
              <el-input v-model="sendOrder.sendInfo.telNo" style="width: 250px">
              </el-input>
            </el-form-item>
            <el-form-item label="客户:" prop="sendInfo.customerId" label-width="90px">
              <el-select v-model="sendOrder.sendInfo.customerId" style="width: 250px">
                <el-option v-for="item in customerList" :key="item.key" :value="item.value" :label="item.label">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="寄件人:" prop="sendInfo.sendName" label-width="90px">
              <el-input v-model="sendOrder.sendInfo.sendName" style="width: 250px">
              </el-input>
            </el-form-item>
            <el-form-item label="寄件公司:" prop="sendInfo.sendCompany" label-width="90px">
              <el-input v-model="sendOrder.sendInfo.sendCompany" style="width: 250px">
              </el-input>
            </el-form-item>
            <el-form-item label="地区:" prop="sendInfo.sendAreaList" label-width="90px">
              <el-cascader v-model="sendOrder.sendInfo.sendAreaList" :options="areaOptions"
                           @change="handleSendAreaChange" style="width: 590px;">
              </el-cascader>
            </el-form-item>
            <el-form-item label="详细地址:" prop="sendInfo.detailArea" label-width="90px">
              <el-input v-model="sendOrder.sendInfo.detailArea" style="width: 590px">
              </el-input>
            </el-form-item>
          </div>
        </el-card>
        <el-card class="box-card subCard left" shadow="hover">
          <div>收件信息</div>
          <div class="customer">
            <el-form-item label="电话:" prop="sendInfo.telNo" label-width="90px">
              <el-input v-model="sendOrder.sendInfo.telNo" style="width: 250px">
              </el-input>
            </el-form-item>
            <el-form-item label="客户:" prop="sendInfo.customerId" label-width="90px">
              <el-select v-model="sendOrder.sendInfo.customerId" style="width: 250px">
                <el-option v-for="item in customerList" :key="item.key" :value="item.value" :label="item.label">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="收件人:" prop="sendInfo.sendName" label-width="90px">
              <el-input v-model="sendOrder.sendInfo.sendName" style="width: 250px">
              </el-input>
            </el-form-item>
            <el-form-item label="收件公司:" prop="sendInfo.sendCompany" label-width="90px">
              <el-input v-model="sendOrder.sendInfo.sendCompany" style="width: 250px">
              </el-input>
            </el-form-item>
            <el-form-item label="地区:" prop="sendInfo.receiveList" label-width="90px">
              <el-cascader v-model="sendOrder.sendInfo.receiveList" :options="areaOptions"
                           @change="handleSendAreaChange" style="width: 590px">
              </el-cascader>
            </el-form-item>
            <el-form-item label="详细地址:" prop="sendInfo.detailArea" label-width="90px">
              <el-input v-model="sendOrder.sendInfo.detailArea" style="width: 590px">
              </el-input>
            </el-form-item>
          </div>
        </el-card>
      </div>
      <div class="sub-order-info">
        <el-card class="card-content">
          <div>货物信息</div>
          <div class="customer">
            <el-form-item label="货物名称:" prop="goodsInfo.goodName" label-width="90px">
              <el-input v-model="sendOrder.goodsInfo.goodName">
              </el-input>
            </el-form-item>
            <el-form-item label="包装:" prop="goodsInfo.wrapType" label-width="90px">
              <el-select v-model="sendOrder.goodsInfo.wrapType">
                <el-option v-for="item in wrapTypeList" :key="item.key" :value="item.value" :label="item.label">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="数量:" prop="goodsInfo.count" label-width="90px">
              <el-input v-model="sendOrder.goodsInfo.count">
              </el-input>
            </el-form-item>
            <el-form-item label="体积(m³):" prop="goodsInfo.goodName" label-width="90px">
              <el-input v-model="sendOrder.goodsInfo.goodName">
              </el-input>
            </el-form-item>
            <el-form-item label="重量(kg):" prop="goodsInfo.goodName" label-width="90px">
              <el-input v-model="sendOrder.goodsInfo.goodName">
              </el-input>
            </el-form-item>
          </div>
        </el-card>
      </div>
      <div class="value-added">
        <el-card class="card-content">
          <div>增值服务</div>
          <div class="customer">
            <el-form-item label="回单要求:" prop="addedValue.backOrderType" label-width="90px">
              <el-select v-model="sendOrder.addedValue.backOrderType">
                <el-option key="1" value="1" label="电子回单"/>
                <el-option key="2" value="2" label="纸质回单"/>
                <el-option key="3" value="4" label="电子加纸质回单"/>
              </el-select>
            </el-form-item>
            <el-form-item label="回单号:" prop="addedValue.backOrderNo" label-width="90px">
              <el-input v-model="sendOrder.addedValue.backOrderNo"
                        :disabled="sendOrder.addedValue.backOrderType === ''">
              </el-input>
            </el-form-item>
            <el-form-item label="结算方式:" prop="addedValue.settleType" label-width="90px">
              <el-select v-model="sendOrder.addedValue.settleType">
                <el-option key="1" value="1" label="现付"/>
                <el-option key="2" value="2" label="到付"/>
                <el-option key="3" value="4" label="月结"/>
                <el-option key="3" value="5" label="回单付"/>
              </el-select>
            </el-form-item>
            <el-form-item label="到付款:" prop="addedValue.arrivePayAmount" label-width="90px">
              <el-input v-model="sendOrder.addedValue.arrivePayAmount"
                        :disabled="sendOrder.addedValue.settleType !== '2'">
              </el-input>
            </el-form-item>
            <el-form-item label="送货方式:" prop="addedValue.upstairs" label-width="90px">
              <el-select v-model="sendOrder.addedValue.upstairs">
                <el-option key="1" value="1" label="自提"/>
                <el-option key="2" value="2" label="人工上楼"/>
                <el-option key="3" value="3" label="电梯上楼"/>
              </el-select>
            </el-form-item>
            <el-form-item label="楼层:" prop="addedValue.upstairsLayer" label-width="90px">
              <el-input v-model="sendOrder.addedValue.upstairsLayer"
                        :disabled="sendOrder.addedValue.upstairs !== '2'">
              </el-input>
            </el-form-item>
            <el-form-item label="备注:" prop="addedValue.upstairsLayer" label-width="90px">
              <el-input type="textarea" v-model="sendOrder.addedValue.remark">
              </el-input>
            </el-form-item>
          </div>
        </el-card>
      </div>
      <div class="value-added">
        <el-card class="card-content">
          <div>承运单位</div>
          <div style="margin-top: 10px">
            <el-button type="primary">一键比价</el-button>

          </div>
        </el-card>
      </div>
      <div class="value-added">
        <el-card class="card-content">
          <div>收入   总计：<el-input  style="width: 30px" size="small" disabled/> <span style="margin-left: 5px"> 元</span></div>
          <div class="customer">
            <el-form-item label="运费:" prop="income.transportFee" label-width="90px">
              <el-input v-model="sendOrder.income.transportFee">
              </el-input>
            </el-form-item>
            <el-form-item label="回单费:" prop="income.backOrderFee" label-width="90px">
              <el-input v-model="sendOrder.income.backOrderFee">
              </el-input>
            </el-form-item>
            <el-form-item label="保险费:" prop="income.insuranceFee" label-width="90px">
              <el-input v-model="sendOrder.income.insuranceFee">
              </el-input>
            </el-form-item>
            <el-form-item label="送货费:" prop="income.deliverFee" label-width="90px">
              <el-input v-model="sendOrder.income.deliverFee">
              </el-input>
            </el-form-item>
            <el-form-item label="其他费:" prop="income.otherFee" label-width="90px">
              <el-input v-model="sendOrder.income.otherFee">
              </el-input>
            </el-form-item>

          </div>
        </el-card>
      </div>
      <div class="value-added">
        <el-card class="card-content">
          <div>成本   总计：<el-input  style="width: 30px" size="small" disabled/> <span style="margin-left: 5px"> 元</span></div>
          <div class="customer">
            <el-form-item label="运费:" prop="income.transportFee" label-width="90px">
              <el-input v-model="sendOrder.income.transportFee">
              </el-input>
            </el-form-item>
            <el-form-item label="回单费:" prop="income.backOrderFee" label-width="90px">
              <el-input v-model="sendOrder.income.backOrderFee">
              </el-input>
            </el-form-item>
            <el-form-item label="保险费:" prop="income.insuranceFee" label-width="90px">
              <el-input v-model="sendOrder.income.insuranceFee">
              </el-input>
            </el-form-item>
            <el-form-item label="送货费:" prop="income.deliverFee" label-width="90px">
              <el-input v-model="sendOrder.income.deliverFee">
              </el-input>
            </el-form-item>
            <el-form-item label="其他费:" prop="income.otherFee" label-width="90px">
              <el-input v-model="sendOrder.income.otherFee">
              </el-input>
            </el-form-item>

          </div>
        </el-card>
      </div>
      <div class="footer-card" >
        <div class="footer">
          <el-button type="primary">提交</el-button>
        </div>

      </div>
    </el-form>
  </div>
</template>
<script>
import {regionData, codeToText} from 'element-china-area-data'

export default {
  data() {
    return {
      sendOrder: {
        orderNo: '',
        customerNo: '',
        sendTime: '',
        receiveAccNo: '',
        sendInfo: {
          telNo: '',
          customerId: '',
          sendName: '',
          sendCompany: '',
          sendAreaList: '',
          sendArea: {
            province: '',
            city: '',
            area: '',
            county: ''
          },
          detailArea: ''
        },
        receiverInfo: {
          organization: '',
          receiverName: '',
          telNo: '',
          receiveList: [],
          receiveArea: {
            province: '',
            city: '',
            area: '',
            county: ''
          },
          detailArea: ''
        },
        goodsInfo: {
          goodName: '',
          count: '',
          wrapType: '',
          weight: '',
          volume: ''
        },
        addedValue: {
          backOrderType: '',
          backOrderNo: '',
          upstairs: '',
          upstairsLayer: '',
          settleType: '',
          arrivePayAmount: '',
          remark: ''
        },
        income: {
          transportFee: '',
          backOrderFee: '',
          insuranceFee: '',
          deliverFee: '',
          loadVehicleFee: '',
          otherFee: ''
        },
        cost: {}
      },
      areaOptions: regionData,
      rules: [],
      acctList: [{
        key: '123412',
        value: '123412',
        label: '张三'
      }],
      customerList: [
        {
          key: '213412',
          value: '1123',
          label: '老王'
        }
      ],
      wrapTypeList: [
        {
          key: '1',
          value: '1',
          label: '木箱'
        },
        {
          key: '2',
          value: '2',
          label: '纸箱'
        },
        {
          key: '3',
          value: '3',
          label: '编织袋'
        },
        {
          key: '4',
          value: '4',
          label: '托盘'
        }
      ]
    }
  },
  created() {
    var date = new Date()
    this.sendOrder.sendTime = this.formatDate(date)
  },
  methods: {
    handleSendAreaChange(text) {
      console.log(this.codeToText(text))
    },
    codeToText(code) {
      return codeToText[code[0]] + '-' + codeToText[code[1]] + '-' + codeToText[code[2]]
    },
    formatDate(date) {
      const year = date.getFullYear()
      const month = this.padZero(date.getMonth() + 1)
      const day = this.padZero(date.getDate())
      const hours = this.padZero(date.getHours())
      const minutes = this.padZero(date.getMinutes())
      const seconds = this.padZero(date.getSeconds())
      return year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds
    },
    padZero(num) {
      return num < 10 ? '0' + num : num
    },
    refreshTime() {
      this.sendOrder.sendTime = this.formatDate(new Date())
    }
  }
}

</script>

<style>
.order-head {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
}

.order-send-receive {
  margin-top: 10px;
  display: flex;
  justify-content: center;
}

.sub-order-info {
  margin-top: 10px;
}

.value-added {
  margin-top: 10px;
}

.subCard {
  width: 50%;
}

.right {
  margin-right: 5px;
}

.left {
  margin-left: 5px;
}

.customer {
  margin-top: 10px;
  display: flex;
  justify-content: start;
  flex-wrap: wrap;
}
.footer{
  padding: 5px;
  display: flex;
  justify-content: end;
}
.footer-card{
  height: 50px;
  background-color: ghostwhite;
  margin-right:10px;
  width: 92%;
  position: fixed;
  bottom: 0px; /* 距离底部10像素 */
  right: 10px; /* 距离右侧10像素 */
}
</style>
