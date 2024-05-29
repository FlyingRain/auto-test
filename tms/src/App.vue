<template>
  <el-form :model="sendOrder">
    <div class="global-back">
      <div class="box-card" style="width: 74.5%;height: 80px">
        <div class="card-title"><span class="tip">基础信息 </span></div>
        <div class="element">
          <span class="tip">运单号：</span>
          <el-input size="small" style="width: 160px !important;" placeholder="运单号" v-model="sendOrder.orderNo"/>
          <span class="tip">客户单号：</span>
          <el-input size="small" style="width: 160px !important;" placeholder="客户单号"/>
          <span class="tip">寄件时间：</span>
          <el-input size="small" style="width: 160px !important;" disabled v-model="sendOrder.sendTime"/>
          <div style="height: 24px;display: flex;align-items: center;margin-left: 5px">
            <el-icon style="vertical-align: middle;color: blue">
              <RefreshRight/>
            </el-icon>
          </div>
          <span class="tip">开单人：</span>
          <el-input size="small" style="width: 160px !important;" placeholder="开单人"/>
          <span class="tip">服务方式：</span>
          <el-select size="small" style="width: 160px !important;" placeholder="自提/派送">
            <el-option key="1" label="自提"/>
            <el-option key="2" label="派送"/>
          </el-select>
          <span class="tip">收件员：</span>
          <el-select size="small" style="width: 150px !important;" allow-create
                     v-model="sendOrder.sendInfo.customerId"
                     filterable placeholder="选择业务员">
            <el-option
                v-for="item in customer_list"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </div>
      </div>
      <div style="display: flex;flex-wrap: nowrap">
        <div>
          <div style="display: flex;flex-wrap: nowrap">
            <div class="box-card">
              <div class="card-title"><span class="tip">寄方 </span></div>
              <div class="card-content">
                <div class="element">
                  <span class="tip">客户：</span>
                  <el-select size="small" style="width: 150px !important;" allow-create
                             v-model="sendOrder.sendInfo.customerId"
                             filterable placeholder="选择客户">
                    <el-option
                        v-for="item in customer_list"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                </div>


                <div class="element">
                  <span class="tip"><span class="star">*</span>寄件人：</span>
                  <el-input size="small" v-model="sendOrder.sendInfo.sendName" placeholder="寄件人"/>
                  <span class="tip">寄件公司：</span>
                  <el-input size="small" style="width: 160px !important;" placeholder="寄件公司"/>
                </div>
                <div class="element">
                  <span class="tip">寄件电话：</span>
                  <el-input size="small" style="width: 225px !important;" placeholder="输入联系方式"/>
                </div>
                <div class="element">
                  <span class="tip">寄方地址：</span>
                  <el-select size="small" v-model="sendOrder.sendInfo.address.province" filterable placeholder="省"
                             @change="queryCity($event,true,'1')">
                    <el-option
                        v-for="item in provinces"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                  <span style="display:flex; align-items:center;margin-left: 10px;margin-right: 10px">-</span>

                  <el-select size="small" v-model="sendOrder.sendInfo.address.city" filterable placeholder="市"
                             @change="queryCity($event,true,'2')">
                    <el-option
                        v-for="item in cities"
                        :key="item.key"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                  <span style="display:flex; align-items:center;margin-left: 10px;margin-right: 10px">-</span>
                  <el-select size="small" v-model="sendOrder.sendInfo.address.area" filterable placeholder="区/县"
                             @change="queryCity($event,true,'3')">
                    <el-option
                        v-for="item in areas"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                  <span style="display:flex; align-items:center;margin-left: 10px;margin-right: 10px">-</span>
                  <el-select size="small" v-model="sendOrder.sendInfo.address.county" filterable placeholder="乡镇">
                    <el-option
                        v-for="item in counties"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                </div>
                <div class="element">
                  <span class="tip">详细地址：</span>
                  <el-input size="small" style="width: 335px !important;" placeholder="详细地址"
                            v-model="sendOrder.sendInfo.detailArea"/>
                  <el-button style="margin-left: 10px" size="small" type="primary"> 解析</el-button>
                </div>
                <div class="element">
                  <span class="tip">证件类型：</span>
                  <el-select size="small" v-model="province" filterable placeholder="省">
                    <el-option
                        v-for="item in provinces"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                  <span class="tip">证件号：</span>
                  <el-input size="small" style="width: 250px !important;" placeholder="证件号"/>
                </div>
              </div>

            </div>
            <div class="box-card">
              <div class="card-title"><span class="tip">收方 </span></div>
              <div class="card-content">
                <div class="element">
                  <span class="tip">客户：</span>
                  <el-select size="small" style="width: 150px !important;" allow-create
                             v-model="sendOrder.receiverInfo.customerId"
                             filterable placeholder="选择客户">
                    <el-option
                        v-for="item in customer_list"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                  <span class="tip">收件公司：</span>
                  <el-input size="small" style="width: 160px !important;" placeholder="收件公司"/>
                </div>


                <div class="element">
                  <span class="tip"><span class="star">*</span>收件人：</span>
                  <el-input size="small" v-model="sendOrder.orderNo" placeholder="收件人"/>
                  <span class="tip">收件电话：</span>
                  <el-input size="small" style="width: 225px !important;" placeholder="输入联系方式"/>
                </div>

                <div class="element">
                  <span class="tip">收方地址：</span>
                  <el-select size="small" v-model="sendOrder.receiverInfo.address.province" filterable placeholder="省"
                             @change="queryCity($event,false,'1')">
                    <el-option
                        v-for="item in provinces"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                  <span style="display:flex; align-items:center;margin-left: 10px;margin-right: 10px">-</span>

                  <el-select size="small" v-model="sendOrder.receiverInfo.address.city" filterable placeholder="市"
                             @change="queryCity($event,false,'2')">
                    <el-option
                        v-for="item in rec_cities"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                  <span style="display:flex; align-items:center;margin-left: 10px;margin-right: 10px">-</span>
                  <el-select size="small" v-model="sendOrder.receiverInfo.address.area" filterable placeholder="区/县"
                             @change="queryCity($event,false,'3')">
                    <el-option
                        v-for="item in rec_areas"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                  <span style="display:flex; align-items:center;margin-left: 10px;margin-right: 10px">-</span>
                  <el-select size="small" v-model="sendOrder.receiverInfo.address.county" filterable placeholder="乡镇">
                    <el-option
                        v-for="item in rec_counties"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                </div>
                <div class="element">
                  <span class="tip">详细地址：</span>
                  <el-input size="small" style="width: 335px !important;" placeholder="详细地址"/>
                  <el-button style="margin-left: 10px" size="small" type="primary"> 解析</el-button>
                </div>

                <div class="element">
                  <span class="tip">派件说明：</span>
                  <el-input size="small" type="textarea" style="width: 395px !important;" rows="3"
                            placeholder="详细地址"/>

                </div>
              </div>
            </div>
          </div>
          <div class="box-card" style="width: 1015px;height: 80px">
            <div class="card-title"><span class="tip">货物信息 </span></div>
            <div class="card-content">
              <div class="element">
                <span class="tip">货物名称：</span>
                <el-input size="small" type="text" placeholder="货物名称"/>
                <span class="tip">包装类型：</span>
                <el-select size="small" v-model="sendOrder.goodsInfo.wrapType" filterable placeholder="包装">
                  <el-option
                      v-for="item in wrapTypeList"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                  </el-option>
                </el-select>
                <span class="tip">数量：</span>
                <el-input size="small" type="text" placeholder="数量"/>
                <span class="tip">重量(kg)：</span>
                <el-input size="small" type="text" placeholder="重量"/>
                <span class="tip">体积(M³)：</span>
                <el-input size="small" type="text" placeholder="货物名称"/>

                <el-button size="small" type="primary" style="margin-left: 10px">新增</el-button>
                <el-button size="small" type="danger" style="margin-left: 10px">删除</el-button>
              </div>
            </div>
          </div>
          <div class="box-card" style="width: 1015px;height: 80px">
            <div class="card-title"><span class="tip">承运商 </span></div>
            <div class="card-content">
              <div style="display: flex; width: 100%; justify-content: flex-end ">
                <el-button size="small" type="primary">一键比价</el-button>
              </div>
            </div>
          </div>
        </div>
        <div>
          <div class="box-card" style="width: 400px;height: 150px">
            <div class="card-title"><span class="tip">增值服务 </span></div>
            <div class="card-content">
              <div class="element">
                <span class="tip">是否回单：</span>
                <el-select size="small" v-model="sendOrder.addedValue.backOrderType" placeholder="回单">
                  <el-option key="0" label="无回单" value="0"/>
                  <el-option key="1" label="纸质回单" value="1"/>
                  <el-option key="2" label="电子回单" value="2"/>
                </el-select>
                <span class="tip">回单号：</span>
                <el-input size="small" type="text" style="width: 130px !important;" placeholder="回单号">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">上楼类型：</span>
                <el-select size="small" v-model="sendOrder.addedValue.backOrderType" placeholder="上楼">
                  <el-option key="0" label="不上楼" value="0"/>
                  <el-option key="1" label="电梯" value="1"/>
                  <el-option key="2" label="爬楼" value="2"/>
                </el-select>
                <span class="tip">楼层：</span>
                <el-input size="small" type="text" placeholder="楼层">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">结算方式：</span>
                <el-select size="small" v-model="sendOrder.addedValue.backOrderType" placeholder="结算方式">
                  <el-option key="1" label="到付" value="1"/>
                  <el-option key="2" label="寄付" value="2"/>
                </el-select>
                <span class="tip">保价额：</span>
                <el-input size="small" type="text" placeholder="保价">
                </el-input>
              </div>

            </div>
          </div>
          <div class="box-card" style="width: 400px;height: 155px">
            <div class="card-title"><span class="tip">成本</span></div>
            <div class="card-content">
              <div class="element">
                <span class="tip">总成本：</span>
                <el-input size="small" type="text" placeholder="总计">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">回单费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
                <span class="tip">保险费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
                <span class="tip">送货费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">上楼费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
                <span class="tip">装车费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
                <span class="tip">其他：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
              </div>

            </div>
          </div>

          <div class="box-card" style="width: 400px;height: 155px">
            <div class="card-title"><span class="tip">收入</span></div>
            <div class="card-content">
              <div class="element">
                <span class="tip">总收入：</span>
                <el-input size="small" type="text" placeholder="总计">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">运输费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
                <span class="tip">装车费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
                <span class="tip">卸货费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">操作费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="总计">
                </el-input>
                <span class="tip">其他费用：</span>
                <el-input size="small" style="width: 145px!important;" type="text" placeholder="总计">
                </el-input>

              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </el-form>
</template>

<script>

import {inject} from "vue";

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
          address: {
            province: '',
            city: '',
            area: '',
            county: ''
          },
          detailArea: ''
        },
        receiverInfo: {
          customerId: '',
          organization: '',
          receiverName: '',
          telNo: '',
          receiveList: [],
          address: {
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
      loading: false,
      searchQuery: '',
      customers: ['老王', '老李'],
      filteredResults: [],
      test: '',
      customer_list: [{key: '1', label: '老王', value: '1'}],
      val: '',
      provinces: [],
      cities: [],
      areas: [],
      counties: [],
      rec_cities: [],
      rec_areas: [],
      rec_counties: [],
      province: '',
      wrapTypeList: [{value: 1, label: '箱子'}]
    }
  },
  methods: {
    filterResults() {
      console.log('asdfasfd')
      this.filteredResults = this.customers.filter(result => {
        return result.toLowerCase().includes(this.searchQuery.toLowerCase())
      })
    },
    selectToggle(item) {
      this.test = item
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
    async queryCity(id, sender, type) {
      const result = await this.$axios.get('/getRelativeCity', {params: {relativeId: id}})
      if (result.data.success) {
        var city_data_list = result.data.data
        if (type === '0') {
          for (let c of city_data_list) {
            this.provinces.push({value: c.id, label: c.name, key: c.id})
          }
        }
        console.log(id + ' ,' + sender + ' ,' + type + ' ,' + city_data_list.length)
        if (sender) {
          if (type === '1') {
            this.cities = []
            this.areas = []
            this.counties = []
          } else if (type === '2') {
            this.areas = []
            this.counties = []
          } else if (type === '3') {
            this.counties = []
          }
          for (let c of city_data_list) {
            console.log(type === '1')
            if (type === '1') {
              this.cities.push({value: c.id, label: c.name, key: c.id})
            } else if (type === '2') {
              this.areas.push({value: c.id, label: c.name, key: c.id})
            } else if (type === '3') {
              this.counties.push({value: c.id, label: c.name, key: c.id})
            }
          }
        } else {
          if (type === '1') {
            this.rec_cities = []
            this.rec_areas = []
            this.rec_counties = []
          } else if (type === '2') {
            this.rec_areas = []
            this.rec_counties = []
          } else if (type === '3') {
            this.rec_counties = []
          }
          for (let c of city_data_list) {
            if (type === '1') {
              this.rec_cities.push({value: c.id, label: c.name, key: c.id})
            } else if (type === '2') {
              this.rec_areas.push({value: c.id, label: c.name, key: c.id})
            } else if (type === '3') {
              this.rec_counties.push({value: c.id, label: c.name, key: c.id})
            }
          }
        }
      }
    }
  },
  created() {
    this.sendOrder.sendTime = this.formatDate(new Date())
    this.queryCity(0, true, '0')
  }
}
</script>

<style>
body {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  height: 100%;
  width: 100%;
  background-color: #f2f2f2;
}

.vertical-line {
  border-left: 2px solid;
  height: 500px;
  position: relative;
  top: 50px
}
</style>
