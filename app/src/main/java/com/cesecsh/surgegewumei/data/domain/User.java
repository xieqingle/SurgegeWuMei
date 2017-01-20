package com.cesecsh.surgegewumei.data.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by 上海中电
 * on 2017/1/18
 */

public class User implements Parcelable {
    public static final Creator<User> CREATOR = new Creator<User>() {
        /**
         * 供外部类反序列化本类数组使用
         */
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        /**
         * 从Parcel中读取数据
         */
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    private int _id;
    private String id;
    private String username;
    private String token;
    private String photo;
    private boolean recognised;
    private String nickname;
    private String realname;
    private List<Site> sites;
    private long createDate;

    /**
     * 这里的读的顺序必须与writeToParcel(Parcel dest, int flags)方法中
     * 写的顺序一致，否则数据会有差错，比如你的读取顺序如果是：
     * nickname = source.readString();
     * username=source.readString();
     * age = source.readInt();
     * 即调换了username和nickname的读取顺序，那么你会发现你拿到的username是nickname的数据，
     * 而你拿到的nickname是username的数据
     *
     * @param in
     */
    protected User(Parcel in) {
        _id = in.readInt();
        id = in.readString();
        username = in.readString();
        token = in.readString();
        photo = in.readString();
        recognised = in.readByte() != 0;
        nickname = in.readString();
        realname = in.readString();
        createDate = in.readLong();
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isRecognised() {
        return recognised;
    }

    public void setRecognised(boolean recognised) {
        this.recognised = recognised;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }


    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    /**
     * 内容接口描述，默认返回0就可以了
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 将我们的对象序列化一个Parcel对象，也就是将我们的对象存入Parcel中
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_id);
        parcel.writeString(id);
        parcel.writeString(username);
        parcel.writeString(token);
        parcel.writeString(photo);
        parcel.writeByte((byte) (recognised ? 1 : 0));
        parcel.writeString(nickname);
        parcel.writeString(realname);
        parcel.writeLong(createDate);
    }
}
