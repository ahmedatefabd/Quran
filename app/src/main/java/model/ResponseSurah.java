package model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSurah implements Parcelable {

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private List<Surah> surahList = null;

    protected ResponseSurah(Parcel in) {
        if (in.readByte() == 0) {
            code = null;
        } else {
            code = in.readInt();
        }
        status = in.readString();
        surahList = in.createTypedArrayList(Surah.CREATOR);
    }

    public static final Creator<ResponseSurah> CREATOR = new Creator<ResponseSurah>() {
        @Override
        public ResponseSurah createFromParcel(Parcel in) {
            return new ResponseSurah(in);
        }

        @Override
        public ResponseSurah[] newArray(int size) {
            return new ResponseSurah[size];
        }
    };

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Surah> getSurahList() {
        return surahList;
    }

    public void setSurahList(List<Surah> surahList) {
        this.surahList = surahList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (code == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(code);
        }
        dest.writeString(status);
        dest.writeTypedList(surahList);
    }
}
