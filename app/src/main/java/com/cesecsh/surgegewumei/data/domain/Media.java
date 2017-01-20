package com.cesecsh.surgegewumei.data.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by 上海中电
 * on 2016/11/8
 * 媒体文件
 */

public class Media implements Parcelable {
    private String location;
    private String id;
    private int type;
    private String path;
    private String extend;
    private String title;

    protected Media(Parcel in) {
        location = in.readString();
        id = in.readString();
        type = in.readInt();
        path = in.readString();
        extend = in.readString();
        title = in.readString();
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel in) {
            return new Media(in);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(location);
        dest.writeString(id);
        dest.writeInt(type);
        dest.writeString(path);
        dest.writeString(extend);
        dest.writeString(title);
    }
}
