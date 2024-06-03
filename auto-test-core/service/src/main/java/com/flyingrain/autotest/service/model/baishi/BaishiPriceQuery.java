
package com.flyingrain.autotest.service.model.baishi;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.flyingrain.autotest.common.util.HttpUtil;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.facade.intf.model.oder.SendOrder;
import com.flyingrain.autotest.facade.intf.model.oder.UserContactInfo;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class BaishiPriceQuery {

    private Integer doubleRatio;
    private Integer sendSiteId;
    private String sendSiteName;
    private String sendSiteCode;
    private String sendDate;
    private Object id;
    private String customerName;
    private String sendAddress;
    private Integer courierId;
    private String courierName;
    private Integer basicServiceId;
    private String basicServiceName;
    private String acceptPerson;
    private String acceptAddress;
    private String acceptPhone;
    private String acceptCanton;
    private String acceptAddressDetail;
    private String acceptParseType;
    private Integer dispSiteId;
    private String dispSiteName;
    private Object substituteDispSiteId;
    private Object substituteDispSiteCode;
    private Object substituteDispSiteName;
    private Integer townId;
    private String townName;
    private String treePath;
    private Boolean detailAddressHasCanton;
    private Boolean selectDisabled;
    private Integer dispParentId;
    private String dispParentName;
    private Integer sendParentId;
    private String sendParentName;
    private Integer amount;
    private Double weight;
    private Double upstairsWeight;
    private Double actualWeight;
    private Double cubic;
    private Integer paymentTypeId;
    private Integer insuranceTypeId;
    private Integer insureAmount;
    private Integer productId;
    private Object bfrZz001;
    private Object bfrZz002;
    private Object bfrZz003;
    private Object bfrZz004;
    private Object bfrZzDelayDispatch;
    private Object bfrZz005;
    private Object bfrZzCod;
    private Object bfrZzPickup;
    private Object bfrZzHome;
    private String name;
    private String sendPhone;
    private String sendPerson;
    private String courier;
    private String acceptPersonDetail;
    private Double grossWeight;
    private Double standardFeeWeight;
    private String cargo;
    private List<Object> recordCodes = new ArrayList<Object>();
    private Object addedServiceSubCodeList;
    private Object cubicRemark;
    private Object recordCode;
    private Object releaseGoodsRecordCode;
    private Object promotionRecordCode;
    private Object podInfo;
    private Integer productSnapshotId;
    private Object specialItemVos;
    private CodInfo codInfo;
    private Object pickupSiteId;
    private Object pickupSiteCode;
    private Object pickupSiteName;
    private String pickupMode;
    private Object pickupReMark;
    private Object pickupAddress;

    @JSONField(serialize = false)
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public static BaishiPriceQuery fromSendOrder(SendOrder sendOrder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BaishiPriceQuery baishiPriceQuery = new BaishiPriceQuery();
        baishiPriceQuery.setDoubleRatio(0);
        baishiPriceQuery.setSendSiteId(9600130);
        baishiPriceQuery.setSendSiteName("湖州织里镇ZX");
        baishiPriceQuery.setSendSiteCode("3131060");
        baishiPriceQuery.setSendDate(simpleDateFormat.format(new Date()));
        baishiPriceQuery.setSendPhone(sendOrder.getSendInfo().getTelNo());

        UserContactInfo userContactInfo = sendOrder.getSendInfo();
        baishiPriceQuery.setCustomerName(userContactInfo.getSendName());
        baishiPriceQuery.setSendAddress(userContactInfo.getAddress().getDetailAddr());
        baishiPriceQuery.setBasicServiceId(1);
        baishiPriceQuery.setBasicServiceName("派送");

        UserContactInfo receiveInfo = sendOrder.getReceiverInfo();
        baishiPriceQuery.setAcceptPerson(receiveInfo.getSendName());
        baishiPriceQuery.setAcceptAddress(receiveInfo.getAddress().contactDetail());
        baishiPriceQuery.setAcceptPhone(receiveInfo.getTelNo());
        baishiPriceQuery.setAcceptAddressDetail(receiveInfo.getAddress().getDetailAddr());
        baishiPriceQuery.setAcceptParseType("CP_ONLY_AS___CP");


        String addrQueryUrl = "https://v5.800best.com/ltlv5-war/web/site/parseSiteByAddressIntegrationNew?address=江苏省南京市鼓楼区&basicServiceId=1&sendSiteId=9600130";
        String cookie = RunTimeContext.globalGet("baishi");
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", cookie);
        String result = HttpUtil.get(addrQueryUrl, headers);
        BaishiAddressInfo baishiAddressInfo = JSONObject.parseObject(result, BaishiAddressInfo.class);
        ParseTownVo parseTownVo = baishiAddressInfo.getParseTownVo();

        baishiPriceQuery.setAcceptCanton(parseTownVo.getNamePath());
        baishiPriceQuery.setTreePath(parseTownVo.getTreePath());

        baishiPriceQuery.setDispSiteId(baishiAddressInfo.getCbSiteRouteVo().getDispSiteId());
        baishiPriceQuery.setDispSiteName(baishiAddressInfo.getCbSiteRouteVo().getDispSiteName());
        baishiPriceQuery.setDispParentId(baishiAddressInfo.getCbSiteRouteVo().getOutletCenterId());
        baishiPriceQuery.setDetailAddressHasCanton(false);
        baishiPriceQuery.setDispParentName(baishiAddressInfo.getCbSiteRouteVo().getOutletCenterName());
        baishiPriceQuery.setSelectDisabled(true);
        baishiPriceQuery.setSendParentId(baishiAddressInfo.getCbSiteRouteVo().getInletCenterId());
        baishiPriceQuery.setSendParentName(baishiAddressInfo.getCbSiteRouteVo().getInletCenterName());


        String baishiWeightQueryUrl = "https://v5.800best.com/ltlv5-war/web/cubicWeightRatio/calcFeeWeightAndProductDistinguishCountry";
        Map<String, String> params = new HashMap<>();
        params.put("cubic", sendOrder.getGoodsInfo().getVolume() + "");
        params.put("actualWeight", sendOrder.getGoodsInfo().getWeight() + "");
        params.put("sendSiteId", "9600130");

        String reuslt = HttpUtil.postFormUrlEncoded(baishiWeightQueryUrl, headers, params);
        BaishiWeightResult baishiWeightResult = JSONObject.parseObject(result, BaishiWeightResult.class);
        baishiPriceQuery.setAmount(sendOrder.getGoodsInfo().getCount());
        baishiPriceQuery.setWeight(baishiWeightResult.getVo().getSiteFeeWeight());
        baishiPriceQuery.setGrossWeight(baishiWeightResult.getVo().getGrossWeight());
        baishiPriceQuery.setUpstairsWeight(baishiWeightResult.getVo().getUpstairsWeight());
        baishiPriceQuery.setActualWeight(sendOrder.getGoodsInfo().getWeight());
        baishiPriceQuery.setCubic(sendOrder.getGoodsInfo().getVolume());
        baishiPriceQuery.setStandardFeeWeight(baishiWeightResult.getVo().getStandardFeeWeight());
        baishiPriceQuery.setCargo(sendOrder.getGoodsInfo().getGoodName());

        baishiPriceQuery.setPaymentTypeId(30);
        baishiPriceQuery.setInsuranceTypeId(648);
        baishiPriceQuery.setProductId(1);
        baishiPriceQuery.setProductSnapshotId(1);
        baishiPriceQuery.setProductId(1);
        baishiPriceQuery.setName(sendOrder.getSendInfo().getSendName());
        baishiPriceQuery.setAcceptPersonDetail(sendOrder.getReceiverInfo().getSendName());
        baishiPriceQuery.setPickupMode("pickupMode");
        return baishiPriceQuery;
    }

    public Integer getDoubleRatio() {
        return doubleRatio;
    }

    public void setDoubleRatio(Integer doubleRatio) {
        this.doubleRatio = doubleRatio;
    }

    public Integer getSendSiteId() {
        return sendSiteId;
    }

    public void setSendSiteId(Integer sendSiteId) {
        this.sendSiteId = sendSiteId;
    }

    public String getSendSiteName() {
        return sendSiteName;
    }

    public void setSendSiteName(String sendSiteName) {
        this.sendSiteName = sendSiteName;
    }

    public String getSendSiteCode() {
        return sendSiteCode;
    }

    public void setSendSiteCode(String sendSiteCode) {
        this.sendSiteCode = sendSiteCode;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public Integer getBasicServiceId() {
        return basicServiceId;
    }

    public void setBasicServiceId(Integer basicServiceId) {
        this.basicServiceId = basicServiceId;
    }

    public String getBasicServiceName() {
        return basicServiceName;
    }

    public void setBasicServiceName(String basicServiceName) {
        this.basicServiceName = basicServiceName;
    }

    public String getAcceptPerson() {
        return acceptPerson;
    }

    public void setAcceptPerson(String acceptPerson) {
        this.acceptPerson = acceptPerson;
    }

    public String getAcceptAddress() {
        return acceptAddress;
    }

    public void setAcceptAddress(String acceptAddress) {
        this.acceptAddress = acceptAddress;
    }

    public String getAcceptPhone() {
        return acceptPhone;
    }

    public void setAcceptPhone(String acceptPhone) {
        this.acceptPhone = acceptPhone;
    }

    public String getAcceptCanton() {
        return acceptCanton;
    }

    public void setAcceptCanton(String acceptCanton) {
        this.acceptCanton = acceptCanton;
    }

    public String getAcceptAddressDetail() {
        return acceptAddressDetail;
    }

    public void setAcceptAddressDetail(String acceptAddressDetail) {
        this.acceptAddressDetail = acceptAddressDetail;
    }

    public String getAcceptParseType() {
        return acceptParseType;
    }

    public void setAcceptParseType(String acceptParseType) {
        this.acceptParseType = acceptParseType;
    }

    public Integer getDispSiteId() {
        return dispSiteId;
    }

    public void setDispSiteId(Integer dispSiteId) {
        this.dispSiteId = dispSiteId;
    }

    public String getDispSiteName() {
        return dispSiteName;
    }

    public void setDispSiteName(String dispSiteName) {
        this.dispSiteName = dispSiteName;
    }

    public Object getSubstituteDispSiteId() {
        return substituteDispSiteId;
    }

    public void setSubstituteDispSiteId(Object substituteDispSiteId) {
        this.substituteDispSiteId = substituteDispSiteId;
    }

    public Object getSubstituteDispSiteCode() {
        return substituteDispSiteCode;
    }

    public void setSubstituteDispSiteCode(Object substituteDispSiteCode) {
        this.substituteDispSiteCode = substituteDispSiteCode;
    }

    public Object getSubstituteDispSiteName() {
        return substituteDispSiteName;
    }

    public void setSubstituteDispSiteName(Object substituteDispSiteName) {
        this.substituteDispSiteName = substituteDispSiteName;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    public Boolean getDetailAddressHasCanton() {
        return detailAddressHasCanton;
    }

    public void setDetailAddressHasCanton(Boolean detailAddressHasCanton) {
        this.detailAddressHasCanton = detailAddressHasCanton;
    }

    public Boolean getSelectDisabled() {
        return selectDisabled;
    }

    public void setSelectDisabled(Boolean selectDisabled) {
        this.selectDisabled = selectDisabled;
    }

    public Integer getDispParentId() {
        return dispParentId;
    }

    public void setDispParentId(Integer dispParentId) {
        this.dispParentId = dispParentId;
    }

    public String getDispParentName() {
        return dispParentName;
    }

    public void setDispParentName(String dispParentName) {
        this.dispParentName = dispParentName;
    }

    public Integer getSendParentId() {
        return sendParentId;
    }

    public void setSendParentId(Integer sendParentId) {
        this.sendParentId = sendParentId;
    }

    public String getSendParentName() {
        return sendParentName;
    }

    public void setSendParentName(String sendParentName) {
        this.sendParentName = sendParentName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getUpstairsWeight() {
        return upstairsWeight;
    }

    public void setUpstairsWeight(Double upstairsWeight) {
        this.upstairsWeight = upstairsWeight;
    }

    public Double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Double actualWeight) {
        this.actualWeight = actualWeight;
    }

    public Double getCubic() {
        return cubic;
    }

    public void setCubic(Double cubic) {
        this.cubic = cubic;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public Integer getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(Integer insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }

    public Integer getInsureAmount() {
        return insureAmount;
    }

    public void setInsureAmount(Integer insureAmount) {
        this.insureAmount = insureAmount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Object getBfrZz001() {
        return bfrZz001;
    }

    public void setBfrZz001(Object bfrZz001) {
        this.bfrZz001 = bfrZz001;
    }

    public Object getBfrZz002() {
        return bfrZz002;
    }

    public void setBfrZz002(Object bfrZz002) {
        this.bfrZz002 = bfrZz002;
    }

    public Object getBfrZz003() {
        return bfrZz003;
    }

    public void setBfrZz003(Object bfrZz003) {
        this.bfrZz003 = bfrZz003;
    }

    public Object getBfrZz004() {
        return bfrZz004;
    }

    public void setBfrZz004(Object bfrZz004) {
        this.bfrZz004 = bfrZz004;
    }

    public Object getBfrZzDelayDispatch() {
        return bfrZzDelayDispatch;
    }

    public void setBfrZzDelayDispatch(Object bfrZzDelayDispatch) {
        this.bfrZzDelayDispatch = bfrZzDelayDispatch;
    }

    public Object getBfrZz005() {
        return bfrZz005;
    }

    public void setBfrZz005(Object bfrZz005) {
        this.bfrZz005 = bfrZz005;
    }

    public Object getBfrZzCod() {
        return bfrZzCod;
    }

    public void setBfrZzCod(Object bfrZzCod) {
        this.bfrZzCod = bfrZzCod;
    }

    public Object getBfrZzPickup() {
        return bfrZzPickup;
    }

    public void setBfrZzPickup(Object bfrZzPickup) {
        this.bfrZzPickup = bfrZzPickup;
    }

    public Object getBfrZzHome() {
        return bfrZzHome;
    }

    public void setBfrZzHome(Object bfrZzHome) {
        this.bfrZzHome = bfrZzHome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public String getSendPerson() {
        return sendPerson;
    }

    public void setSendPerson(String sendPerson) {
        this.sendPerson = sendPerson;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getAcceptPersonDetail() {
        return acceptPersonDetail;
    }

    public void setAcceptPersonDetail(String acceptPersonDetail) {
        this.acceptPersonDetail = acceptPersonDetail;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getStandardFeeWeight() {
        return standardFeeWeight;
    }

    public void setStandardFeeWeight(Double standardFeeWeight) {
        this.standardFeeWeight = standardFeeWeight;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Object> getRecordCodes() {
        return recordCodes;
    }

    public void setRecordCodes(List<Object> recordCodes) {
        this.recordCodes = recordCodes;
    }

    public Object getAddedServiceSubCodeList() {
        return addedServiceSubCodeList;
    }

    public void setAddedServiceSubCodeList(Object addedServiceSubCodeList) {
        this.addedServiceSubCodeList = addedServiceSubCodeList;
    }

    public Object getCubicRemark() {
        return cubicRemark;
    }

    public void setCubicRemark(Object cubicRemark) {
        this.cubicRemark = cubicRemark;
    }

    public Object getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(Object recordCode) {
        this.recordCode = recordCode;
    }

    public Object getReleaseGoodsRecordCode() {
        return releaseGoodsRecordCode;
    }

    public void setReleaseGoodsRecordCode(Object releaseGoodsRecordCode) {
        this.releaseGoodsRecordCode = releaseGoodsRecordCode;
    }

    public Object getPromotionRecordCode() {
        return promotionRecordCode;
    }

    public void setPromotionRecordCode(Object promotionRecordCode) {
        this.promotionRecordCode = promotionRecordCode;
    }

    public Object getPodInfo() {
        return podInfo;
    }

    public void setPodInfo(Object podInfo) {
        this.podInfo = podInfo;
    }

    public Integer getProductSnapshotId() {
        return productSnapshotId;
    }

    public void setProductSnapshotId(Integer productSnapshotId) {
        this.productSnapshotId = productSnapshotId;
    }

    public Object getSpecialItemVos() {
        return specialItemVos;
    }

    public void setSpecialItemVos(Object specialItemVos) {
        this.specialItemVos = specialItemVos;
    }

    public CodInfo getCodInfo() {
        return codInfo;
    }

    public void setCodInfo(CodInfo codInfo) {
        this.codInfo = codInfo;
    }

    public Object getPickupSiteId() {
        return pickupSiteId;
    }

    public void setPickupSiteId(Object pickupSiteId) {
        this.pickupSiteId = pickupSiteId;
    }

    public Object getPickupSiteCode() {
        return pickupSiteCode;
    }

    public void setPickupSiteCode(Object pickupSiteCode) {
        this.pickupSiteCode = pickupSiteCode;
    }

    public Object getPickupSiteName() {
        return pickupSiteName;
    }

    public void setPickupSiteName(Object pickupSiteName) {
        this.pickupSiteName = pickupSiteName;
    }

    public String getPickupMode() {
        return pickupMode;
    }

    public void setPickupMode(String pickupMode) {
        this.pickupMode = pickupMode;
    }

    public Object getPickupReMark() {
        return pickupReMark;
    }

    public void setPickupReMark(Object pickupReMark) {
        this.pickupReMark = pickupReMark;
    }

    public Object getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(Object pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BaishiPriceQuery.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("doubleRatio");
        sb.append('=');
        sb.append(((this.doubleRatio == null) ? "<null>" : this.doubleRatio));
        sb.append(',');
        sb.append("sendSiteId");
        sb.append('=');
        sb.append(((this.sendSiteId == null) ? "<null>" : this.sendSiteId));
        sb.append(',');
        sb.append("sendSiteName");
        sb.append('=');
        sb.append(((this.sendSiteName == null) ? "<null>" : this.sendSiteName));
        sb.append(',');
        sb.append("sendSiteCode");
        sb.append('=');
        sb.append(((this.sendSiteCode == null) ? "<null>" : this.sendSiteCode));
        sb.append(',');
        sb.append("sendDate");
        sb.append('=');
        sb.append(((this.sendDate == null) ? "<null>" : this.sendDate));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("customerName");
        sb.append('=');
        sb.append(((this.customerName == null) ? "<null>" : this.customerName));
        sb.append(',');
        sb.append("sendAddress");
        sb.append('=');
        sb.append(((this.sendAddress == null) ? "<null>" : this.sendAddress));
        sb.append(',');
        sb.append("courierId");
        sb.append('=');
        sb.append(((this.courierId == null) ? "<null>" : this.courierId));
        sb.append(',');
        sb.append("courierName");
        sb.append('=');
        sb.append(((this.courierName == null) ? "<null>" : this.courierName));
        sb.append(',');
        sb.append("basicServiceId");
        sb.append('=');
        sb.append(((this.basicServiceId == null) ? "<null>" : this.basicServiceId));
        sb.append(',');
        sb.append("basicServiceName");
        sb.append('=');
        sb.append(((this.basicServiceName == null) ? "<null>" : this.basicServiceName));
        sb.append(',');
        sb.append("acceptPerson");
        sb.append('=');
        sb.append(((this.acceptPerson == null) ? "<null>" : this.acceptPerson));
        sb.append(',');
        sb.append("acceptAddress");
        sb.append('=');
        sb.append(((this.acceptAddress == null) ? "<null>" : this.acceptAddress));
        sb.append(',');
        sb.append("acceptPhone");
        sb.append('=');
        sb.append(((this.acceptPhone == null) ? "<null>" : this.acceptPhone));
        sb.append(',');
        sb.append("acceptCanton");
        sb.append('=');
        sb.append(((this.acceptCanton == null) ? "<null>" : this.acceptCanton));
        sb.append(',');
        sb.append("acceptAddressDetail");
        sb.append('=');
        sb.append(((this.acceptAddressDetail == null) ? "<null>" : this.acceptAddressDetail));
        sb.append(',');
        sb.append("acceptParseType");
        sb.append('=');
        sb.append(((this.acceptParseType == null) ? "<null>" : this.acceptParseType));
        sb.append(',');
        sb.append("dispSiteId");
        sb.append('=');
        sb.append(((this.dispSiteId == null) ? "<null>" : this.dispSiteId));
        sb.append(',');
        sb.append("dispSiteName");
        sb.append('=');
        sb.append(((this.dispSiteName == null) ? "<null>" : this.dispSiteName));
        sb.append(',');
        sb.append("substituteDispSiteId");
        sb.append('=');
        sb.append(((this.substituteDispSiteId == null) ? "<null>" : this.substituteDispSiteId));
        sb.append(',');
        sb.append("substituteDispSiteCode");
        sb.append('=');
        sb.append(((this.substituteDispSiteCode == null) ? "<null>" : this.substituteDispSiteCode));
        sb.append(',');
        sb.append("substituteDispSiteName");
        sb.append('=');
        sb.append(((this.substituteDispSiteName == null) ? "<null>" : this.substituteDispSiteName));
        sb.append(',');
        sb.append("townId");
        sb.append('=');
        sb.append(((this.townId == null) ? "<null>" : this.townId));
        sb.append(',');
        sb.append("townName");
        sb.append('=');
        sb.append(((this.townName == null) ? "<null>" : this.townName));
        sb.append(',');
        sb.append("treePath");
        sb.append('=');
        sb.append(((this.treePath == null) ? "<null>" : this.treePath));
        sb.append(',');
        sb.append("detailAddressHasCanton");
        sb.append('=');
        sb.append(((this.detailAddressHasCanton == null) ? "<null>" : this.detailAddressHasCanton));
        sb.append(',');
        sb.append("selectDisabled");
        sb.append('=');
        sb.append(((this.selectDisabled == null) ? "<null>" : this.selectDisabled));
        sb.append(',');
        sb.append("dispParentId");
        sb.append('=');
        sb.append(((this.dispParentId == null) ? "<null>" : this.dispParentId));
        sb.append(',');
        sb.append("dispParentName");
        sb.append('=');
        sb.append(((this.dispParentName == null) ? "<null>" : this.dispParentName));
        sb.append(',');
        sb.append("sendParentId");
        sb.append('=');
        sb.append(((this.sendParentId == null) ? "<null>" : this.sendParentId));
        sb.append(',');
        sb.append("sendParentName");
        sb.append('=');
        sb.append(((this.sendParentName == null) ? "<null>" : this.sendParentName));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null) ? "<null>" : this.amount));
        sb.append(',');
        sb.append("weight");
        sb.append('=');
        sb.append(((this.weight == null) ? "<null>" : this.weight));
        sb.append(',');
        sb.append("upstairsWeight");
        sb.append('=');
        sb.append(((this.upstairsWeight == null) ? "<null>" : this.upstairsWeight));
        sb.append(',');
        sb.append("actualWeight");
        sb.append('=');
        sb.append(((this.actualWeight == null) ? "<null>" : this.actualWeight));
        sb.append(',');
        sb.append("cubic");
        sb.append('=');
        sb.append(((this.cubic == null) ? "<null>" : this.cubic));
        sb.append(',');
        sb.append("paymentTypeId");
        sb.append('=');
        sb.append(((this.paymentTypeId == null) ? "<null>" : this.paymentTypeId));
        sb.append(',');
        sb.append("insuranceTypeId");
        sb.append('=');
        sb.append(((this.insuranceTypeId == null) ? "<null>" : this.insuranceTypeId));
        sb.append(',');
        sb.append("insureAmount");
        sb.append('=');
        sb.append(((this.insureAmount == null) ? "<null>" : this.insureAmount));
        sb.append(',');
        sb.append("productId");
        sb.append('=');
        sb.append(((this.productId == null) ? "<null>" : this.productId));
        sb.append(',');
        sb.append("bfrZz001");
        sb.append('=');
        sb.append(((this.bfrZz001 == null) ? "<null>" : this.bfrZz001));
        sb.append(',');
        sb.append("bfrZz002");
        sb.append('=');
        sb.append(((this.bfrZz002 == null) ? "<null>" : this.bfrZz002));
        sb.append(',');
        sb.append("bfrZz003");
        sb.append('=');
        sb.append(((this.bfrZz003 == null) ? "<null>" : this.bfrZz003));
        sb.append(',');
        sb.append("bfrZz004");
        sb.append('=');
        sb.append(((this.bfrZz004 == null) ? "<null>" : this.bfrZz004));
        sb.append(',');
        sb.append("bfrZzDelayDispatch");
        sb.append('=');
        sb.append(((this.bfrZzDelayDispatch == null) ? "<null>" : this.bfrZzDelayDispatch));
        sb.append(',');
        sb.append("bfrZz005");
        sb.append('=');
        sb.append(((this.bfrZz005 == null) ? "<null>" : this.bfrZz005));
        sb.append(',');
        sb.append("bfrZzCod");
        sb.append('=');
        sb.append(((this.bfrZzCod == null) ? "<null>" : this.bfrZzCod));
        sb.append(',');
        sb.append("bfrZzPickup");
        sb.append('=');
        sb.append(((this.bfrZzPickup == null) ? "<null>" : this.bfrZzPickup));
        sb.append(',');
        sb.append("bfrZzHome");
        sb.append('=');
        sb.append(((this.bfrZzHome == null) ? "<null>" : this.bfrZzHome));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("sendPhone");
        sb.append('=');
        sb.append(((this.sendPhone == null) ? "<null>" : this.sendPhone));
        sb.append(',');
        sb.append("sendPerson");
        sb.append('=');
        sb.append(((this.sendPerson == null) ? "<null>" : this.sendPerson));
        sb.append(',');
        sb.append("courier");
        sb.append('=');
        sb.append(((this.courier == null) ? "<null>" : this.courier));
        sb.append(',');
        sb.append("acceptPersonDetail");
        sb.append('=');
        sb.append(((this.acceptPersonDetail == null) ? "<null>" : this.acceptPersonDetail));
        sb.append(',');
        sb.append("grossWeight");
        sb.append('=');
        sb.append(((this.grossWeight == null) ? "<null>" : this.grossWeight));
        sb.append(',');
        sb.append("standardFeeWeight");
        sb.append('=');
        sb.append(((this.standardFeeWeight == null) ? "<null>" : this.standardFeeWeight));
        sb.append(',');
        sb.append("cargo");
        sb.append('=');
        sb.append(((this.cargo == null) ? "<null>" : this.cargo));
        sb.append(',');
        sb.append("recordCodes");
        sb.append('=');
        sb.append(((this.recordCodes == null) ? "<null>" : this.recordCodes));
        sb.append(',');
        sb.append("addedServiceSubCodeList");
        sb.append('=');
        sb.append(((this.addedServiceSubCodeList == null) ? "<null>" : this.addedServiceSubCodeList));
        sb.append(',');
        sb.append("cubicRemark");
        sb.append('=');
        sb.append(((this.cubicRemark == null) ? "<null>" : this.cubicRemark));
        sb.append(',');
        sb.append("recordCode");
        sb.append('=');
        sb.append(((this.recordCode == null) ? "<null>" : this.recordCode));
        sb.append(',');
        sb.append("releaseGoodsRecordCode");
        sb.append('=');
        sb.append(((this.releaseGoodsRecordCode == null) ? "<null>" : this.releaseGoodsRecordCode));
        sb.append(',');
        sb.append("promotionRecordCode");
        sb.append('=');
        sb.append(((this.promotionRecordCode == null) ? "<null>" : this.promotionRecordCode));
        sb.append(',');
        sb.append("podInfo");
        sb.append('=');
        sb.append(((this.podInfo == null) ? "<null>" : this.podInfo));
        sb.append(',');
        sb.append("productSnapshotId");
        sb.append('=');
        sb.append(((this.productSnapshotId == null) ? "<null>" : this.productSnapshotId));
        sb.append(',');
        sb.append("specialItemVos");
        sb.append('=');
        sb.append(((this.specialItemVos == null) ? "<null>" : this.specialItemVos));
        sb.append(',');
        sb.append("codInfo");
        sb.append('=');
        sb.append(((this.codInfo == null) ? "<null>" : this.codInfo));
        sb.append(',');
        sb.append("pickupSiteId");
        sb.append('=');
        sb.append(((this.pickupSiteId == null) ? "<null>" : this.pickupSiteId));
        sb.append(',');
        sb.append("pickupSiteCode");
        sb.append('=');
        sb.append(((this.pickupSiteCode == null) ? "<null>" : this.pickupSiteCode));
        sb.append(',');
        sb.append("pickupSiteName");
        sb.append('=');
        sb.append(((this.pickupSiteName == null) ? "<null>" : this.pickupSiteName));
        sb.append(',');
        sb.append("pickupMode");
        sb.append('=');
        sb.append(((this.pickupMode == null) ? "<null>" : this.pickupMode));
        sb.append(',');
        sb.append("pickupReMark");
        sb.append('=');
        sb.append(((this.pickupReMark == null) ? "<null>" : this.pickupReMark));
        sb.append(',');
        sb.append("pickupAddress");
        sb.append('=');
        sb.append(((this.pickupAddress == null) ? "<null>" : this.pickupAddress));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.dispSiteName == null) ? 0 : this.dispSiteName.hashCode()));
        result = ((result * 31) + ((this.sendDate == null) ? 0 : this.sendDate.hashCode()));
        result = ((result * 31) + ((this.townId == null) ? 0 : this.townId.hashCode()));
        result = ((result * 31) + ((this.sendPerson == null) ? 0 : this.sendPerson.hashCode()));
        result = ((result * 31) + ((this.bfrZzPickup == null) ? 0 : this.bfrZzPickup.hashCode()));
        result = ((result * 31) + ((this.upstairsWeight == null) ? 0 : this.upstairsWeight.hashCode()));
        result = ((result * 31) + ((this.insureAmount == null) ? 0 : this.insureAmount.hashCode()));
        result = ((result * 31) + ((this.standardFeeWeight == null) ? 0 : this.standardFeeWeight.hashCode()));
        result = ((result * 31) + ((this.pickupSiteId == null) ? 0 : this.pickupSiteId.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.recordCode == null) ? 0 : this.recordCode.hashCode()));
        result = ((result * 31) + ((this.cargo == null) ? 0 : this.cargo.hashCode()));
        result = ((result * 31) + ((this.substituteDispSiteCode == null) ? 0 : this.substituteDispSiteCode.hashCode()));
        result = ((result * 31) + ((this.sendSiteCode == null) ? 0 : this.sendSiteCode.hashCode()));
        result = ((result * 31) + ((this.bfrZzDelayDispatch == null) ? 0 : this.bfrZzDelayDispatch.hashCode()));
        result = ((result * 31) + ((this.dispParentId == null) ? 0 : this.dispParentId.hashCode()));
        result = ((result * 31) + ((this.townName == null) ? 0 : this.townName.hashCode()));
        result = ((result * 31) + ((this.cubicRemark == null) ? 0 : this.cubicRemark.hashCode()));
        result = ((result * 31) + ((this.sendSiteId == null) ? 0 : this.sendSiteId.hashCode()));
        result = ((result * 31) + ((this.productId == null) ? 0 : this.productId.hashCode()));
        result = ((result * 31) + ((this.weight == null) ? 0 : this.weight.hashCode()));
        result = ((result * 31) + ((this.pickupSiteName == null) ? 0 : this.pickupSiteName.hashCode()));
        result = ((result * 31) + ((this.recordCodes == null) ? 0 : this.recordCodes.hashCode()));
        result = ((result * 31) + ((this.specialItemVos == null) ? 0 : this.specialItemVos.hashCode()));
        result = ((result * 31) + ((this.customerName == null) ? 0 : this.customerName.hashCode()));
        result = ((result * 31) + ((this.bfrZzCod == null) ? 0 : this.bfrZzCod.hashCode()));
        result = ((result * 31) + ((this.sendAddress == null) ? 0 : this.sendAddress.hashCode()));
        result = ((result * 31) + ((this.courier == null) ? 0 : this.courier.hashCode()));
        result = ((result * 31) + ((this.pickupAddress == null) ? 0 : this.pickupAddress.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.sendParentId == null) ? 0 : this.sendParentId.hashCode()));
        result = ((result * 31) + ((this.acceptPerson == null) ? 0 : this.acceptPerson.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.substituteDispSiteName == null) ? 0 : this.substituteDispSiteName.hashCode()));
        result = ((result * 31) + ((this.acceptAddress == null) ? 0 : this.acceptAddress.hashCode()));
        result = ((result * 31) + ((this.bfrZz001 == null) ? 0 : this.bfrZz001.hashCode()));
        result = ((result * 31) + ((this.substituteDispSiteId == null) ? 0 : this.substituteDispSiteId.hashCode()));
        result = ((result * 31) + ((this.bfrZz005 == null) ? 0 : this.bfrZz005.hashCode()));
        result = ((result * 31) + ((this.bfrZz004 == null) ? 0 : this.bfrZz004.hashCode()));
        result = ((result * 31) + ((this.dispSiteId == null) ? 0 : this.dispSiteId.hashCode()));
        result = ((result * 31) + ((this.bfrZz003 == null) ? 0 : this.bfrZz003.hashCode()));
        result = ((result * 31) + ((this.bfrZz002 == null) ? 0 : this.bfrZz002.hashCode()));
        result = ((result * 31) + ((this.pickupMode == null) ? 0 : this.pickupMode.hashCode()));
        result = ((result * 31) + ((this.acceptPersonDetail == null) ? 0 : this.acceptPersonDetail.hashCode()));
        result = ((result * 31) + ((this.acceptParseType == null) ? 0 : this.acceptParseType.hashCode()));
        result = ((result * 31) + ((this.sendParentName == null) ? 0 : this.sendParentName.hashCode()));
        result = ((result * 31) + ((this.basicServiceId == null) ? 0 : this.basicServiceId.hashCode()));
        result = ((result * 31) + ((this.basicServiceName == null) ? 0 : this.basicServiceName.hashCode()));
        result = ((result * 31) + ((this.codInfo == null) ? 0 : this.codInfo.hashCode()));
        result = ((result * 31) + ((this.courierName == null) ? 0 : this.courierName.hashCode()));
        result = ((result * 31) + ((this.actualWeight == null) ? 0 : this.actualWeight.hashCode()));
        result = ((result * 31) + ((this.pickupSiteCode == null) ? 0 : this.pickupSiteCode.hashCode()));
        result = ((result * 31) + ((this.paymentTypeId == null) ? 0 : this.paymentTypeId.hashCode()));
        result = ((result * 31) + ((this.bfrZzHome == null) ? 0 : this.bfrZzHome.hashCode()));
        result = ((result * 31) + ((this.podInfo == null) ? 0 : this.podInfo.hashCode()));
        result = ((result * 31) + ((this.releaseGoodsRecordCode == null) ? 0 : this.releaseGoodsRecordCode.hashCode()));
        result = ((result * 31) + ((this.dispParentName == null) ? 0 : this.dispParentName.hashCode()));
        result = ((result * 31) + ((this.amount == null) ? 0 : this.amount.hashCode()));
        result = ((result * 31) + ((this.cubic == null) ? 0 : this.cubic.hashCode()));
        result = ((result * 31) + ((this.addedServiceSubCodeList == null) ? 0 : this.addedServiceSubCodeList.hashCode()));
        result = ((result * 31) + ((this.acceptPhone == null) ? 0 : this.acceptPhone.hashCode()));
        result = ((result * 31) + ((this.insuranceTypeId == null) ? 0 : this.insuranceTypeId.hashCode()));
        result = ((result * 31) + ((this.promotionRecordCode == null) ? 0 : this.promotionRecordCode.hashCode()));
        result = ((result * 31) + ((this.doubleRatio == null) ? 0 : this.doubleRatio.hashCode()));
        result = ((result * 31) + ((this.selectDisabled == null) ? 0 : this.selectDisabled.hashCode()));
        result = ((result * 31) + ((this.grossWeight == null) ? 0 : this.grossWeight.hashCode()));
        result = ((result * 31) + ((this.acceptCanton == null) ? 0 : this.acceptCanton.hashCode()));
        result = ((result * 31) + ((this.acceptAddressDetail == null) ? 0 : this.acceptAddressDetail.hashCode()));
        result = ((result * 31) + ((this.pickupReMark == null) ? 0 : this.pickupReMark.hashCode()));
        result = ((result * 31) + ((this.sendPhone == null) ? 0 : this.sendPhone.hashCode()));
        result = ((result * 31) + ((this.courierId == null) ? 0 : this.courierId.hashCode()));
        result = ((result * 31) + ((this.detailAddressHasCanton == null) ? 0 : this.detailAddressHasCanton.hashCode()));
        result = ((result * 31) + ((this.sendSiteName == null) ? 0 : this.sendSiteName.hashCode()));
        result = ((result * 31) + ((this.treePath == null) ? 0 : this.treePath.hashCode()));
        result = ((result * 31) + ((this.productSnapshotId == null) ? 0 : this.productSnapshotId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BaishiPriceQuery) == false) {
            return false;
        }
        BaishiPriceQuery rhs = ((BaishiPriceQuery) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.dispSiteName == rhs.dispSiteName) || ((this.dispSiteName != null) && this.dispSiteName.equals(rhs.dispSiteName))) && ((this.sendDate == rhs.sendDate) || ((this.sendDate != null) && this.sendDate.equals(rhs.sendDate)))) && ((this.townId == rhs.townId) || ((this.townId != null) && this.townId.equals(rhs.townId)))) && ((this.sendPerson == rhs.sendPerson) || ((this.sendPerson != null) && this.sendPerson.equals(rhs.sendPerson)))) && ((this.bfrZzPickup == rhs.bfrZzPickup) || ((this.bfrZzPickup != null) && this.bfrZzPickup.equals(rhs.bfrZzPickup)))) && ((this.upstairsWeight == rhs.upstairsWeight) || ((this.upstairsWeight != null) && this.upstairsWeight.equals(rhs.upstairsWeight)))) && ((this.insureAmount == rhs.insureAmount) || ((this.insureAmount != null) && this.insureAmount.equals(rhs.insureAmount)))) && ((this.standardFeeWeight == rhs.standardFeeWeight) || ((this.standardFeeWeight != null) && this.standardFeeWeight.equals(rhs.standardFeeWeight)))) && ((this.pickupSiteId == rhs.pickupSiteId) || ((this.pickupSiteId != null) && this.pickupSiteId.equals(rhs.pickupSiteId)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.recordCode == rhs.recordCode) || ((this.recordCode != null) && this.recordCode.equals(rhs.recordCode)))) && ((this.cargo == rhs.cargo) || ((this.cargo != null) && this.cargo.equals(rhs.cargo)))) && ((this.substituteDispSiteCode == rhs.substituteDispSiteCode) || ((this.substituteDispSiteCode != null) && this.substituteDispSiteCode.equals(rhs.substituteDispSiteCode)))) && ((this.sendSiteCode == rhs.sendSiteCode) || ((this.sendSiteCode != null) && this.sendSiteCode.equals(rhs.sendSiteCode)))) && ((this.bfrZzDelayDispatch == rhs.bfrZzDelayDispatch) || ((this.bfrZzDelayDispatch != null) && this.bfrZzDelayDispatch.equals(rhs.bfrZzDelayDispatch)))) && ((this.dispParentId == rhs.dispParentId) || ((this.dispParentId != null) && this.dispParentId.equals(rhs.dispParentId)))) && ((this.townName == rhs.townName) || ((this.townName != null) && this.townName.equals(rhs.townName)))) && ((this.cubicRemark == rhs.cubicRemark) || ((this.cubicRemark != null) && this.cubicRemark.equals(rhs.cubicRemark)))) && ((this.sendSiteId == rhs.sendSiteId) || ((this.sendSiteId != null) && this.sendSiteId.equals(rhs.sendSiteId)))) && ((this.productId == rhs.productId) || ((this.productId != null) && this.productId.equals(rhs.productId)))) && ((this.weight == rhs.weight) || ((this.weight != null) && this.weight.equals(rhs.weight)))) && ((this.pickupSiteName == rhs.pickupSiteName) || ((this.pickupSiteName != null) && this.pickupSiteName.equals(rhs.pickupSiteName)))) && ((this.recordCodes == rhs.recordCodes) || ((this.recordCodes != null) && this.recordCodes.equals(rhs.recordCodes)))) && ((this.specialItemVos == rhs.specialItemVos) || ((this.specialItemVos != null) && this.specialItemVos.equals(rhs.specialItemVos)))) && ((this.customerName == rhs.customerName) || ((this.customerName != null) && this.customerName.equals(rhs.customerName)))) && ((this.bfrZzCod == rhs.bfrZzCod) || ((this.bfrZzCod != null) && this.bfrZzCod.equals(rhs.bfrZzCod)))) && ((this.sendAddress == rhs.sendAddress) || ((this.sendAddress != null) && this.sendAddress.equals(rhs.sendAddress)))) && ((this.courier == rhs.courier) || ((this.courier != null) && this.courier.equals(rhs.courier)))) && ((this.pickupAddress == rhs.pickupAddress) || ((this.pickupAddress != null) && this.pickupAddress.equals(rhs.pickupAddress)))) && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))) && ((this.sendParentId == rhs.sendParentId) || ((this.sendParentId != null) && this.sendParentId.equals(rhs.sendParentId)))) && ((this.acceptPerson == rhs.acceptPerson) || ((this.acceptPerson != null) && this.acceptPerson.equals(rhs.acceptPerson)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.substituteDispSiteName == rhs.substituteDispSiteName) || ((this.substituteDispSiteName != null) && this.substituteDispSiteName.equals(rhs.substituteDispSiteName)))) && ((this.acceptAddress == rhs.acceptAddress) || ((this.acceptAddress != null) && this.acceptAddress.equals(rhs.acceptAddress)))) && ((this.bfrZz001 == rhs.bfrZz001) || ((this.bfrZz001 != null) && this.bfrZz001.equals(rhs.bfrZz001)))) && ((this.substituteDispSiteId == rhs.substituteDispSiteId) || ((this.substituteDispSiteId != null) && this.substituteDispSiteId.equals(rhs.substituteDispSiteId)))) && ((this.bfrZz005 == rhs.bfrZz005) || ((this.bfrZz005 != null) && this.bfrZz005.equals(rhs.bfrZz005)))) && ((this.bfrZz004 == rhs.bfrZz004) || ((this.bfrZz004 != null) && this.bfrZz004.equals(rhs.bfrZz004)))) && ((this.dispSiteId == rhs.dispSiteId) || ((this.dispSiteId != null) && this.dispSiteId.equals(rhs.dispSiteId)))) && ((this.bfrZz003 == rhs.bfrZz003) || ((this.bfrZz003 != null) && this.bfrZz003.equals(rhs.bfrZz003)))) && ((this.bfrZz002 == rhs.bfrZz002) || ((this.bfrZz002 != null) && this.bfrZz002.equals(rhs.bfrZz002)))) && ((this.pickupMode == rhs.pickupMode) || ((this.pickupMode != null) && this.pickupMode.equals(rhs.pickupMode)))) && ((this.acceptPersonDetail == rhs.acceptPersonDetail) || ((this.acceptPersonDetail != null) && this.acceptPersonDetail.equals(rhs.acceptPersonDetail)))) && ((this.acceptParseType == rhs.acceptParseType) || ((this.acceptParseType != null) && this.acceptParseType.equals(rhs.acceptParseType)))) && ((this.sendParentName == rhs.sendParentName) || ((this.sendParentName != null) && this.sendParentName.equals(rhs.sendParentName)))) && ((this.basicServiceId == rhs.basicServiceId) || ((this.basicServiceId != null) && this.basicServiceId.equals(rhs.basicServiceId)))) && ((this.basicServiceName == rhs.basicServiceName) || ((this.basicServiceName != null) && this.basicServiceName.equals(rhs.basicServiceName)))) && ((this.codInfo == rhs.codInfo) || ((this.codInfo != null) && this.codInfo.equals(rhs.codInfo)))) && ((this.courierName == rhs.courierName) || ((this.courierName != null) && this.courierName.equals(rhs.courierName)))) && ((this.actualWeight == rhs.actualWeight) || ((this.actualWeight != null) && this.actualWeight.equals(rhs.actualWeight)))) && ((this.pickupSiteCode == rhs.pickupSiteCode) || ((this.pickupSiteCode != null) && this.pickupSiteCode.equals(rhs.pickupSiteCode)))) && ((this.paymentTypeId == rhs.paymentTypeId) || ((this.paymentTypeId != null) && this.paymentTypeId.equals(rhs.paymentTypeId)))) && ((this.bfrZzHome == rhs.bfrZzHome) || ((this.bfrZzHome != null) && this.bfrZzHome.equals(rhs.bfrZzHome)))) && ((this.podInfo == rhs.podInfo) || ((this.podInfo != null) && this.podInfo.equals(rhs.podInfo)))) && ((this.releaseGoodsRecordCode == rhs.releaseGoodsRecordCode) || ((this.releaseGoodsRecordCode != null) && this.releaseGoodsRecordCode.equals(rhs.releaseGoodsRecordCode)))) && ((this.dispParentName == rhs.dispParentName) || ((this.dispParentName != null) && this.dispParentName.equals(rhs.dispParentName)))) && ((this.amount == rhs.amount) || ((this.amount != null) && this.amount.equals(rhs.amount)))) && ((this.cubic == rhs.cubic) || ((this.cubic != null) && this.cubic.equals(rhs.cubic)))) && ((this.addedServiceSubCodeList == rhs.addedServiceSubCodeList) || ((this.addedServiceSubCodeList != null) && this.addedServiceSubCodeList.equals(rhs.addedServiceSubCodeList)))) && ((this.acceptPhone == rhs.acceptPhone) || ((this.acceptPhone != null) && this.acceptPhone.equals(rhs.acceptPhone)))) && ((this.insuranceTypeId == rhs.insuranceTypeId) || ((this.insuranceTypeId != null) && this.insuranceTypeId.equals(rhs.insuranceTypeId)))) && ((this.promotionRecordCode == rhs.promotionRecordCode) || ((this.promotionRecordCode != null) && this.promotionRecordCode.equals(rhs.promotionRecordCode)))) && ((this.doubleRatio == rhs.doubleRatio) || ((this.doubleRatio != null) && this.doubleRatio.equals(rhs.doubleRatio)))) && ((this.selectDisabled == rhs.selectDisabled) || ((this.selectDisabled != null) && this.selectDisabled.equals(rhs.selectDisabled)))) && ((this.grossWeight == rhs.grossWeight) || ((this.grossWeight != null) && this.grossWeight.equals(rhs.grossWeight)))) && ((this.acceptCanton == rhs.acceptCanton) || ((this.acceptCanton != null) && this.acceptCanton.equals(rhs.acceptCanton)))) && ((this.acceptAddressDetail == rhs.acceptAddressDetail) || ((this.acceptAddressDetail != null) && this.acceptAddressDetail.equals(rhs.acceptAddressDetail)))) && ((this.pickupReMark == rhs.pickupReMark) || ((this.pickupReMark != null) && this.pickupReMark.equals(rhs.pickupReMark)))) && ((this.sendPhone == rhs.sendPhone) || ((this.sendPhone != null) && this.sendPhone.equals(rhs.sendPhone)))) && ((this.courierId == rhs.courierId) || ((this.courierId != null) && this.courierId.equals(rhs.courierId)))) && ((this.detailAddressHasCanton == rhs.detailAddressHasCanton) || ((this.detailAddressHasCanton != null) && this.detailAddressHasCanton.equals(rhs.detailAddressHasCanton)))) && ((this.sendSiteName == rhs.sendSiteName) || ((this.sendSiteName != null) && this.sendSiteName.equals(rhs.sendSiteName)))) && ((this.treePath == rhs.treePath) || ((this.treePath != null) && this.treePath.equals(rhs.treePath)))) && ((this.productSnapshotId == rhs.productSnapshotId) || ((this.productSnapshotId != null) && this.productSnapshotId.equals(rhs.productSnapshotId))));
    }

}
