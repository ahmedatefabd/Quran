package model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Surah_Aya implements Parcelable {

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("englishName")
    @Expose
    private String englishName;
    @SerializedName("englishNameTranslation")
    @Expose
    private String englishNameTranslation;
    @SerializedName("numberOfAyahs")
    @Expose
    private Integer numberOfAyahs;
    @SerializedName("revelationType")
    @Expose
    private String revelationType;

    protected Surah_Aya(Parcel in) {
        if (in.readByte() == 0) {
            number = null;
        } else {
            number = in.readInt();
        }
        name = in.readString();
        englishName = in.readString();
        englishNameTranslation = in.readString();
        if (in.readByte() == 0) {
            numberOfAyahs = null;
        } else {
            numberOfAyahs = in.readInt();
        }
        revelationType = in.readString();
    }

    public static final Creator<Surah_Aya> CREATOR = new Creator<Surah_Aya>() {
        @Override
        public Surah_Aya createFromParcel(Parcel in) {
            return new Surah_Aya(in);
        }

        @Override
        public Surah_Aya[] newArray(int size) {
            return new Surah_Aya[size];
        }
    };

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEnglishNameTranslation() {
        return englishNameTranslation;
    }

    public void setEnglishNameTranslation(String englishNameTranslation) {
        this.englishNameTranslation = englishNameTranslation;
    }

    public Integer getNumberOfAyahs() {
        return numberOfAyahs;
    }

    public void setNumberOfAyahs(Integer numberOfAyahs) {
        this.numberOfAyahs = numberOfAyahs;
    }

    public String getRevelationType() {
        return revelationType;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (number == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(number);
        }
        dest.writeString(name);
        dest.writeString(englishName);
        dest.writeString(englishNameTranslation);
        if (numberOfAyahs == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numberOfAyahs);
        }
        dest.writeString(revelationType);
    }
}
