package com.cesecsh.surgegewumei.data.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by 上海中电
 * on 2016/10/14
 * 内容类
 */

public class Content implements Parcelable {

    public static final Creator<Content> CREATOR = new Creator<Content>() {
        @Override
        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        @Override
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };
    /**
     * id : 4028807b5828873f01582920edc5025e
     * attr : {}
     * siteName : 主站1
     * upCount : 0
     * files : null
     * title : 政府公告C
     * pictures : null
     * summary : 123456
     * typeImg : null
     * createDate : 1478158773000
     * hasTypeImage : false
     * commentCount : 0
     * collectCount : 0
     * user : {"id":"4028807b582e2d1701582e2ec71f0007","username":"ylx","photo":"res/hplus/img/a9.jpg","realname":"ylx","nickname":"ylx"}
     */

    private String id;
    private String siteName;
    private int upCount;
    private List<Media> files;
    private String title;
    private List<Media> pictures;
    private String summary;
    private String typeImg;
    private long createDate;
    private boolean hasTypeImage;
    private int commentCount;
    private int collectCount;
    private String channelName;
    private String txt;
    private String txtWithoutHTML;
    /**
     * id : 4028807b582e2d1701582e2ec71f0007
     * username : ylx
     * photo : res/hplus/img/a9.jpg
     * realname : ylx
     * nickname : ylx
     */

    private User user;
    private Attr attr;
    /**
     * typeName : 房屋装修专区
     * canUp : true
     * canCollect : true
     * typeImg : null
     * files : null
     */

    private String typeName;
    private boolean canUp;
    private boolean canCollect;
    /**
     * contentType : {"name":"图文","id":"2","description":null,"hasImg":true,"typeImg":"upload/content/cover/2/1481165153681_47651877.jpg","shortName":null,"background":null}
     * files : null
     */

    private ContentType contentType;
    protected Content(Parcel in) {
        id = in.readString();
        siteName = in.readString();
        upCount = in.readInt();
        files = in.createTypedArrayList(Media.CREATOR);
        title = in.readString();
        pictures = in.createTypedArrayList(Media.CREATOR);
        summary = in.readString();
        typeImg = in.readString();
        createDate = in.readLong();
        hasTypeImage = in.readByte() != 0;
        commentCount = in.readInt();
        collectCount = in.readInt();
        channelName = in.readString();
        txt = in.readString();
        txtWithoutHTML = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
        attr = in.readParcelable(Attr.class.getClassLoader());
        typeName = in.readString();
        canUp = in.readByte() != 0;
        canCollect = in.readByte() != 0;
        contentType = in.readParcelable(ContentType.class.getClassLoader());
    }

    public String getTxtWithoutHTML() {
        return txtWithoutHTML;
    }

    public void setTxtWithoutHTML(String txtWithoutHTML) {
        this.txtWithoutHTML = txtWithoutHTML;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getChannelName() {
        return channelName;
    }

    public Content setChannelName(String channelName) {
        this.channelName = channelName;
        return this;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getUpCount() {
        return upCount;
    }

    public void setUpCount(int upCount) {
        this.upCount = upCount;
    }

    public List<Media> getFiles() {
        return files;
    }

    public void setFiles(List<Media> files) {
        this.files = files;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Media> getPictures() {
        return pictures;
    }

    public void setPictures(List<Media> pictures) {
        this.pictures = pictures;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTypeImg() {
        return typeImg;
    }

    public void setTypeImg(String typeImg) {
        this.typeImg = typeImg;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public boolean isHasTypeImage() {
        return hasTypeImage;
    }

    public void setHasTypeImage(boolean hasTypeImage) {
        this.hasTypeImage = hasTypeImage;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isCanUp() {
        return canUp;
    }

    public void setCanUp(boolean canUp) {
        this.canUp = canUp;
    }

    public boolean isCanCollect() {
        return canCollect;
    }

    public void setCanCollect(boolean canCollect) {
        this.canCollect = canCollect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content content = (Content) o;

        return id != null ? id.equals(content.id) : content.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(siteName);
        dest.writeInt(upCount);
        dest.writeTypedList(files);
        dest.writeString(title);
        dest.writeTypedList(pictures);
        dest.writeString(summary);
        dest.writeString(typeImg);
        dest.writeLong(createDate);
        dest.writeByte((byte) (hasTypeImage ? 1 : 0));
        dest.writeInt(commentCount);
        dest.writeInt(collectCount);
        dest.writeString(channelName);
        dest.writeString(txt);
        dest.writeString(txtWithoutHTML);
        dest.writeParcelable(user, flags);
        dest.writeParcelable(attr, flags);
        dest.writeString(typeName);
        dest.writeByte((byte) (canUp ? 1 : 0));
        dest.writeByte((byte) (canCollect ? 1 : 0));
        dest.writeParcelable(contentType, flags);
    }
}
