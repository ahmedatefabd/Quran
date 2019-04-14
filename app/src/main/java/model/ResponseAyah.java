package model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAyah implements Parcelable {
    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("englishName")
    @Expose
    private String englishName;
    @SerializedName("englishNameTranslation")
    @Expose
    private String englishNameTranslation;
    @SerializedName("revelationType")
    @Expose
    private String revelationType;
    @SerializedName("numberOfAyahs")
    @Expose
    private int numberOfAyahs;
    @SerializedName("ayahs")
    @Expose
    private List<Ayah> ayahs = null;
    @SerializedName("edition")
    @Expose
    private Edition edition;


    protected ResponseAyah(Parcel in) {
        number = in.readInt();
        name = in.readString();
        englishName = in.readString();
        englishNameTranslation = in.readString();
        revelationType = in.readString();
        numberOfAyahs = in.readInt();
        ayahs = in.createTypedArrayList(Ayah.CREATOR);
    }

    public static final Creator<ResponseAyah> CREATOR = new Creator<ResponseAyah>() {
        @Override
        public ResponseAyah createFromParcel(Parcel in) {
            return new ResponseAyah(in);
        }

        @Override
        public ResponseAyah[] newArray(int size) {
            return new ResponseAyah[size];
        }
    };

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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

    public String getRevelationType() {
        return revelationType;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }

    public int getNumberOfAyahs() {
        return numberOfAyahs;
    }

    public void setNumberOfAyahs(int numberOfAyahs) {
        this.numberOfAyahs = numberOfAyahs;
    }

    public List<Ayah> getAyahs() {
        return ayahs;
    }

    public void setAyahs(List<Ayah> ayahs) {
        this.ayahs = ayahs;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(name);
        dest.writeString(englishName);
        dest.writeString(englishNameTranslation);
        dest.writeString(revelationType);
        dest.writeInt(numberOfAyahs);
        dest.writeTypedList(ayahs);
    }
}
