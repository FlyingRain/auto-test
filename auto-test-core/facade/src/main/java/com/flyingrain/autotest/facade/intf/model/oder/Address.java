package com.flyingrain.autotest.facade.intf.model.oder;

public class Address {

    private String province;

    private String city;

    private String area;

    private String county = "";

    private String detailAddr;


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }


    public String contactDetail() {
        return province + city + area + detailAddr;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", county='" + county + '\'' +
                ", detailAddr='" + detailAddr + '\'' +
                '}';
    }
}
