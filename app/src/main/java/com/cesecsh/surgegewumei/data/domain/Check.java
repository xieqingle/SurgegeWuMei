package com.cesecsh.surgegewumei.data.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 上海中电
 * on 2016/12/1
 */

public class Check implements Parcelable {
    private boolean isCheck;

    protected Check(Parcel in) {
        isCheck = in.readByte() != 0;
    }

    public static final Creator<Check> CREATOR = new Creator<Check>() {
        @Override
        public Check createFromParcel(Parcel in) {
            return new Check(in);
        }

        @Override
        public Check[] newArray(int size) {
            return new Check[size];
        }
    };

    public boolean isCheck() {
        return isCheck;
    }

    public Check setCheck(boolean check) {
        isCheck = check;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (isCheck ? 1 : 0));
    }
}
