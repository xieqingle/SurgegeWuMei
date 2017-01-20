package com.cesecsh.surgegewumei.data.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by 上海中电
 * on 2016/11/7
 */

public class ContentType implements Parcelable {

    /**
     * name : 租房专区
     * id : gc005
     * description : 出租、求租、问邻居更靠谱
     * hasImg : false
     */

    private String name;
    private String id;
    private String description;
    private boolean hasImg;
    private boolean isCheck;

    private String typeImg;
    private String shortName;
    private String background;

    protected ContentType(Parcel in) {
        name = in.readString();
        id = in.readString();
        description = in.readString();
        hasImg = in.readByte() != 0;
        isCheck = in.readByte() != 0;
        typeImg = in.readString();
        shortName = in.readString();
        background = in.readString();
    }

    public static final Creator<ContentType> CREATOR = new Creator<ContentType>() {
        @Override
        public ContentType createFromParcel(Parcel in) {
            return new ContentType(in);
        }

        @Override
        public ContentType[] newArray(int size) {
            return new ContentType[size];
        }
    };

    public String getTypeImg() {
        return typeImg;
    }

    public ContentType setTypeImg(String typeImg) {
        this.typeImg = typeImg;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public ContentType setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getBackground() {
        return background;
    }

    public ContentType setBackground(String background) {
        this.background = background;
        return this;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public ContentType setCheck(boolean check) {
        isCheck = check;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasImg() {
        return hasImg;
    }

    public void setHasImg(boolean hasImg) {
        this.hasImg = hasImg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(description);
        dest.writeByte((byte) (hasImg ? 1 : 0));
        dest.writeByte((byte) (isCheck ? 1 : 0));
        dest.writeString(typeImg);
        dest.writeString(shortName);
        dest.writeString(background);
    }
}
