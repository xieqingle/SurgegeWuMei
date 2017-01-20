package com.cesecsh.surgegewumei.data.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by 上海中电
 * on 2016/11/8
 */

public class Attr implements Parcelable {
    private String serviceMoney;
    private String serviceDescription;
    private String serviceType;

    protected Attr(Parcel in) {
        serviceMoney = in.readString();
        serviceDescription = in.readString();
        serviceType = in.readString();
        endtime = in.readString();
        address = in.readString();
        noe = in.readString();
        begintime = in.readString();
        tel = in.readString();
        money = in.readString();
        key = in.readString();
        value = in.readString();
    }

    public static final Creator<Attr> CREATOR = new Creator<Attr>() {
        @Override
        public Attr createFromParcel(Parcel in) {
            return new Attr(in);
        }

        @Override
        public Attr[] newArray(int size) {
            return new Attr[size];
        }
    };

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceMoney() {
        return serviceMoney;
    }

    public void setServiceMoney(String serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    /**
     * endtime : 11月16日
     * address : 网易大楼
     * noe : 50
     * begintime : 11月11日
     * tel : 13456765897
     * money : 111
     */

    private String endtime;
    private String address;
    private String noe;
    private String begintime;
    private String tel;
    private String money;
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public Attr setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Attr setValue(String value) {
        this.value = value;
        return this;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoe() {
        return noe;
    }

    public void setNoe(String noe) {
        this.noe = noe;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(serviceMoney);
        dest.writeString(serviceDescription);
        dest.writeString(serviceType);
        dest.writeString(endtime);
        dest.writeString(address);
        dest.writeString(noe);
        dest.writeString(begintime);
        dest.writeString(tel);
        dest.writeString(money);
        dest.writeString(key);
        dest.writeString(value);
    }
}
