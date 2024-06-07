<template xmlns="http://www.w3.org/1999/html">
  <el-dialog
      title="承运商详情"
      ref="businessDialog"
      v-model="dialogVisible"
      width="30%"
      :close-on-click-modal=false
  >
    <el-descriptions :column=1>
      <el-descriptions-item label="承运商名称:">{{ dialogData.channelName }}</el-descriptions-item>
      <el-descriptions-item label="承运商报价:">{{ dialogData.channelPrice.total }}</el-descriptions-item>
      <el-descriptions-item label="承运商报价明细:">{{ dialogData.channelPrice.otherDetail }}</el-descriptions-item>
      <el-descriptions-item label="网点信息:">{{ dialogData.siteAddress }}</el-descriptions-item>
      <el-descriptions-item label="目的地距离:">{{ dialogData.distance }}</el-descriptions-item>
      <el-descriptions-item label="网点负责人:">{{ dialogData.siteManagerName }}</el-descriptions-item>
      <el-descriptions-item label="网点描述:">{{ dialogData.siteDes }}</el-descriptions-item>
      <el-descriptions-item label="查件电话:">{{ dialogData.queryGoodPhone }}</el-descriptions-item>
      <el-descriptions-item label="网点负责人电话:">{{ dialogData.sitePhone }}</el-descriptions-item>
      <el-descriptions-item label="派送及区域详情:">{{ dialogData.specialInfo }}</el-descriptions-item>
    </el-descriptions>
    <span slot="footer" class="dialog-footer" style="display: flex;justify-content: end">
         <el-button @click="dialogVisible = false">关闭</el-button>
        </span>
  </el-dialog>
  <el-form :model="sendOrder">
    <div class="global-back">
      <div class="box-card" style="width: 1408px;height: 25px;padding: 10px">
        <el-button size="small" type="primary">新增</el-button>
        <el-button size="small" type="primary">保存</el-button>
        <el-button size="small" type="primary">打印</el-button>
        <el-button size="small" type="primary"  @click="comparePrice">一键比价</el-button>
      </div>
      <div class="box-card" style="width: 1428px;height: 80px">
        <div class="card-title"><span class="tip">基础信息 </span></div>
        <div class="element">
          <span class="tip">运单号：</span>
          <el-input size="small" style="width: 80px !important;" placeholder="运单号" v-model="sendOrder.orderNo"/>
          <span class="tip">客户单号：</span>
          <el-input size="small" style="width: 80px !important;" placeholder="运单号" v-model="sendOrder.customerNo"/>


          <span class="tip">开单人：</span>
          <el-input size="small" style="width: 160px !important;" placeholder="开单人"
                    v-model="sendOrder.receiveAccNo"/>
          <span class="tip">服务方式：</span>
          <el-select size="small" style="width: 160px !important;" placeholder="自提/派送"
                     v-model="sendOrder.serviceType">
            <el-option key="1" label="自提" value="1"/>
            <el-option key="2" label="派送" value="2"/>
          </el-select>
          <span class="tip">业务员：</span>
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
          <span class="tip">业务类型：</span>
          <el-select size="small" style="width: 160px !important;" placeholder="零担/拼车/整车"
                     v-model="sendOrder.businessType">
            <el-option key="1" value="1" label="零担"/>
            <el-option key="2" value="2" label="专线"/>
            <el-option key="3" value="3" label="整车"/>
            <el-option key="4" value="4" label="拼车"/>
          </el-select>
          <span class="tip">寄件时间：</span>
          <el-input size="small" style="width: 160px !important;" disabled v-model="sendOrder.sendTime"/>
          <div style="height: 24px;display: flex;align-items: center;margin-left: 5px">
            <el-icon style="vertical-align: middle;color: blue">
              <RefreshRight/>
            </el-icon>
          </div>
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
                  <el-input size="small" style="width: 225px !important;" placeholder="输入联系方式"
                            v-model="sendOrder.sendInfo.telNo"/>
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
                  <el-input size="small" style="width: 335px !important;"
                            placeholder="例:小明17626111111广东省广州市荔湾区方式东漖街道花地大道中22号首层"
                            v-model="sendOrder.sendInfo.address.detailAddr"/>
                  <el-button style="margin-left: 10px" size="small" type="primary" @click="analysisAddr('1')"> 解析
                  </el-button>
                </div>
                <div class="element">
                  <span class="tip">证件类型：</span>
                  <el-select size="small" v-model="sendOrder.sendInfo.certificateType" filterable placeholder="证件类型">
                    <el-option
                        v-for="item in certificateType"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                    </el-option>
                  </el-select>
                  <span class="tip">证件号：</span>
                  <el-input size="small" style="width: 250px !important;" placeholder="证件号" v-model="sendOrder.sendInfo.certificateValue"/>
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
                  <el-input size="small" v-model="sendOrder.receiverInfo.receiverName" placeholder="收件人"/>
                  <span class="tip">收件电话：</span>
                  <el-input size="small" style="width: 225px !important;" placeholder="输入联系方式"
                            v-model="sendOrder.receiverInfo.telNo"/>
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
                  <el-input size="small" style="width: 335px !important;"
                            placeholder="例:小明17626111111广东省广州市荔湾区方式东漖街道花地大道中22号首层"
                            v-model="sendOrder.receiverInfo.address.detailAddr"/>
                  <el-button style="margin-left: 10px" size="small" type="primary" @click="analysisAddr('2')"> 解析
                  </el-button>
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
                <el-input size="small" type="text" placeholder="货物名称" v-model="sendOrder.goodsInfo.goodName"/>
                <span class="tip">包装类型：</span>
                <el-select size="small" v-model="sendOrder.goodsInfo.wrapType" filterable placeholder="包装">
                  <el-option
                      v-for="item in wrapTypeList"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                  </el-option>
                </el-select>
                <span class="tip">总件数：</span>
                <el-input size="small" type="text" placeholder="件数" v-model="sendOrder.goodsInfo.count"/>
                <span class="tip" style="width: 75px">实际重量(kg)：</span>
                <el-input size="small" type="text" placeholder="重量" v-model="sendOrder.goodsInfo.weight"/>
                <span class="tip" style="width: 75px">计费重量(kg)：</span>
                <el-input size="small" type="text" placeholder="重量" v-model="sendOrder.goodsInfo.weight"/>
                <span class="tip">体积(M³)：</span>
                <el-input size="small" type="text" placeholder="体积" v-model="sendOrder.goodsInfo.volume"/>
              </div>
            </div>
          </div>
          <div class="box-card" style="width: 1015px;height: 85px">
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
                <span class="tip">上楼类型：</span>
                <el-select size="small" v-model="sendOrder.addedValue.backOrderType" placeholder="上楼">
                  <el-option key="0" label="不上楼" value="0"/>
                  <el-option key="1" label="普通上楼" value="1"/>
                  <el-option key="2" label="大件上楼" value="2"/>
                </el-select>
                <span class="tip">楼层：</span>
                <el-input size="small" type="text" placeholder="楼层">
                </el-input>
                <span class="tip">结算方式：</span>
                <el-select size="small" v-model="sendOrder.addedValue.backOrderType" placeholder="结算方式">
                  <el-option key="1" label="到付" value="1"/>
                  <el-option key="2" label="寄付" value="2"/>
                  <el-option key="3" label="月结" value="3"/>
                </el-select>
                <span class="tip">保价额：</span>
                <el-input size="small" type="text" placeholder="保价" v-model="sendOrder.addedValue.insureAmount"
                          @input="checkValue">
                </el-input>
              </div>

            </div>
          </div>
        </div>

        <div>
          <div class="box-card" style="width: 400px;height: 215px">
            <div class="card-title"><span class="tip">收入</span></div>
            <div class="card-content">
              <div class="element">
                <span class="tip" style="width: 70px">预估总收入：</span>
                <el-input size="small" type="text" placeholder="总计">
                </el-input>
                <span class="tip" style="width: 80px">特殊区域加收：</span>
                <el-input size="small" type="text" placeholder="费用">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">运费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
                <span class="tip">保价费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
                <span class="tip">上楼费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">大件服务：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
                <span class="tip">回单费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
                <span class="tip">其他：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>

              </div>
              <div class="element" style="margin-top: 5px">
                <span class="tip" style="width: 80px;">其他费用明细：</span>

              </div>
              <div class="element" style="margin-top: 0">
                <el-input size="small" type="textarea" style="width: 345px!important;margin-left: 10px" rows="2"
                          placeholder="其他费用明细">
                </el-input>
              </div>
            </div>
          </div>
          <div class="box-card" style="width: 400px;height: 215px">
            <div class="card-title"><span class="tip">成本</span></div>
            <div class="card-content">
              <div class="element">
                <span class="tip" style="width: 70px">预估总成本：</span>
                <el-input size="small" type="text" placeholder="总计">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">平台运费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
                <span class="tip">派费：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
                <span class="tip">客户返点：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
              </div>
              <div class="element">
                <span class="tip">赔款理赔：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
                <span class="tip">奖罚：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
                <span class="tip">其他：</span>
                <el-input size="small" style="width: 45px!important;" type="text" placeholder="费用">
                </el-input>
              </div>
              <div class="element" style="margin-top: 5px">
                <span class="tip" style="width: 80px;">其他费用明细：</span>

              </div>
              <div class="element" style="margin-top: 0">
                <el-input size="small" type="textarea" style="width: 345px!important;margin-left: 10px" rows="2"
                          placeholder="其他费用明细">
                </el-input>
              </div>

            </div>
          </div>

        </div>

      </div>
      <div class="box-card" style="width: 1428px;height: auto">
        <div class="card-title"><span class="tip">承运商 </span></div>
        <div class="card-content">
          <span>承运商选择:</span><el-input size="small" style="margin-left: 10px" v-model="sendOrder.thirdBusiness"></el-input>
          <el-table ref="table" :data="tableData" style="font-size: 11px;margin-top: 10px" v-loading="loading"
                    element-loading-text="Loading..." stripe border>
            <el-table-column prop="channelName" label="渠道名称" width="100" show-overflow-tooltip/>
            <el-table-column prop="channelPrice.total" label="总成本" width="80" show-overflow-tooltip/>
            <el-table-column prop="channelPrice.total" label="平台报价" width="80" show-overflow-tooltip/>
            <el-table-column prop="siteAddress" label="匹配网点" show-overflow-tooltip/>
            <el-table-column prop="channelPrice.otherDetail" label="价格明细" show-overflow-tooltip/>
            <el-table-column prop="specialInfo" label="派送区域详情" show-overflow-tooltip/>
            <el-table-column prop="siteManagerName" label="站点联系人" show-overflow-tooltip/>
            <el-table-column prop="name" label="操作" show-overflow-tooltip>
              <template v-slot="row">
                <el-button type="primary" size="small" @click="detail(row.row)"> 详情</el-button>
                <el-button type="success" size="small" @click="choose(row.row)"> 选择</el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="display: flex; margin-top: 10px;margin-bottom: 10px; width: 100%; justify-content: flex-end ">
<!--            <el-button size="small" type="primary" @click="comparePrice">一键比价</el-button>-->
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
        businessType: '1',
        serviceType: '',
        orderNo: '',
        customerNo: '',
        sendTime: '',
        receiveAccNo: '',
        sendInfo: {
          telNo: '',
          customerId: '',
          sendName: '',
          sendCompany: '',
          certificateType:'',
          certificateValue:'',
          sendAreaList: '',
          address: {
            province: '',
            city: '',
            area: '',
            county: '',
            detailAddr: ''
          }
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
            county: '',
            detailAddr: ''
          }
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
          insureAmount: '',
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
        cost: {},
        thirdBusiness:''
      },
      dialogVisible: false,
      tableData: [],
      loading: false,
      searchQuery: '',
      customers: ['老王', '老李'],
      filteredResults: [],
      test: '',
      customer_list: [{key: '1', label: '老王', value: '1'}],
      val: '',
      provinces: [],
      certificateType:[
        {value: 1, label: '身份证'},
        {value: 2, label: '驾驶证'},
      ],
      cities: [],
      areas: [],
      counties: [],
      rec_cities: [],
      rec_areas: [],
      rec_counties: [],
      province: '',
      wrapTypeList: [
        {value: 1, label: '纸箱'},
        {value: 2, label: '托盘'},
        {value: 3, label: '塑料桶'},
        {value: 4, label: '纸筒'},
        {value: 5, label: '木箱'},
        {value: 6, label: '泡沫箱'},
        {value: 7, label: '铁桶'},
        {value: 8, label: '编织袋'},
      ],
      dialogData: {
        channelName: '',
        siteAddress: '',
        sitePhone: '',
        siteManagerName: '',
        specialInfo: '',
        targetSite: '',
        channelPrice: {total: '', otherDetail: ''}
      }
    }
  },
  methods: {
    detail(row) {
      console.log(row)
      this.dialogData = row
      this.dialogVisible = true
    },
    choose(row){
      this.sendOrder.thirdBusiness = row.channelName
    },
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
    checkValue(value) {
      if (!this.$myGlobal.onlyNumber(value)) {
        this.sendOrder.addedValue.insureAmount = ''
      }

    },
    async queryCity(name, sender, type) {
      console.log('start to update ' + name)
      var id
      if (type === '0') {
        id = 0
      } else {
        if (sender) {
          if (type === '1') {
            for (let province of this.provinces) {
              if (province.value.includes(name)) {
                id = province.key
              }
            }
            this.cities = []
            this.areas = []
            this.counties = []
          } else if (type === '2') {
            for (let city of this.cities) {
              if (city.value.includes(name)) {
                id = city.key
              }
            }
            this.areas = []
            this.counties = []
          } else if (type === '3') {
            for (let area of this.areas) {
              if (area.value.includes(name)) {
                id = area.key
              }
            }
            this.counties = []
          }
        } else {
          if (type === '1') {
            for (let province of this.provinces) {
              if (province.value.includes(name)) {
                id = province.key
              }
            }
            this.rec_cities = []
            this.rec_areas = []
            this.rec_counties = []
          } else if (type === '2') {
            for (let city of this.rec_cities) {
              if (city.value.includes(name)) {
                id = city.key
              }
            }
            this.rec_areas = []
            this.rec_counties = []
          } else if (type === '3') {
            for (let area of this.rec_areas) {
              if (area.value.includes(name)) {
                id = area.key
              }
            }
            this.rec_counties = []
          }
        }
      }
      console.log('end id ' + id)


      const result = await this.$axios.get('/getRelativeCity', {params: {relativeId: id}})
      if (result.data.success) {
        var city_data_list = result.data.data
        if (type === '0') {
          for (let c of city_data_list) {
            this.provinces.push({value: c.name, label: c.name, key: c.id})
          }
          return
        }
        console.log(id + ' ,' + sender + ' ,' + type + ' ,' + city_data_list.length)
        if (sender) {
          for (let c of city_data_list) {
            console.log(type === '1')
            if (type === '1') {
              this.cities.push({value: c.name, label: c.name, key: c.id})
            } else if (type === '2') {
              this.areas.push({value: c.name, label: c.name, key: c.id})
            } else if (type === '3') {
              this.counties.push({value: c.name, label: c.name, key: c.id})
            }
          }
        } else {

          for (let c of city_data_list) {
            if (type === '1') {
              this.rec_cities.push({value: c.name, label: c.name, key: c.id})
            } else if (type === '2') {
              this.rec_areas.push({value: c.name, label: c.name, key: c.id})
            } else if (type === '3') {
              this.rec_counties.push({value: c.name, label: c.name, key: c.id})
            }
          }
        }
      }

    },
    async comparePrice() {
      this.loading = true
      const result = await this.$axios.post('/compare', this.sendOrder)
      if (result.data.success) {
        this.tableData = result.data.data
      } else {
        this.$message.error(result.data.message)
      }
      this.loading = false
    },
    addGood() {
      this.dialogVisible = true
    },
    async analysisAddr(type) {
      var addr
      if (type === '1') {
        addr = this.sendOrder.sendInfo.address.detailAddr
      } else if (type === '2') {
        addr = this.sendOrder.receiverInfo.address.detailAddr
      }
      const res = await this.$axios.get('/analysis/addr', {params: {addr: addr}})
      if (res.data.success) {
        if (type === '1') {
          await this.queryCity(res.data.data.address.province, true, "1")
          this.sendOrder.sendInfo.address.province = res.data.data.address.province


          var send_cityName
          if (this.$myGlobal.isDirectCity(res.data.data.address.city)) {
            send_cityName = '市辖区'
          } else {
            send_cityName = res.data.data.address.city
          }
          await this.queryCity(send_cityName, true, "2")
          this.sendOrder.sendInfo.address.city = send_cityName


          await this.queryCity(res.data.data.address.area, true, "3")
          this.sendOrder.sendInfo.address.area = res.data.data.address.area

          this.sendOrder.sendInfo.address.detailAddr = res.data.data.address.detailAddr
          this.sendOrder.sendInfo.telNo = res.data.data.telNo
          this.sendOrder.sendInfo.sendName = res.data.data.sendName
        } else if (type === '2') {

          await this.queryCity(res.data.data.address.province, false, "1")
          this.sendOrder.receiverInfo.address.province = res.data.data.address.province
          var cityName
          if (this.$myGlobal.isDirectCity(res.data.data.address.city)) {
            cityName = '市辖区'
          } else {
            cityName = res.data.data.address.city
          }
          await this.queryCity(cityName, false, "2")
          this.sendOrder.receiverInfo.address.city = cityName


          await this.queryCity(res.data.data.address.area, false, "3")
          this.sendOrder.receiverInfo.address.area = res.data.data.address.area
          this.sendOrder.receiverInfo.address.detailAddr = res.data.data.address.detailAddr
          this.sendOrder.receiverInfo.telNo = res.data.data.telNo
          this.sendOrder.receiverInfo.receiverName = res.data.data.sendName
        }
      } else {
        this.$message.error(res.data.message)
      }

    }
  },
  created() {
    this.sendOrder.orderNo = new Date().getTime();
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
