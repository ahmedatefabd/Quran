package model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ayah implements Parcelable {

    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("numberInSurah")
    @Expose
    private int numberInSurah;
    @SerializedName("juz")
    @Expose
    private int juz;
    @SerializedName("manzil")
    @Expose
    private int manzil;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("ruku")
    @Expose
    private int ruku;
    @SerializedName("hizbQuarter")
    @Expose
    private int hizbQuarter;
    @SerializedName("sajda")
    @Expose
    private boolean sajda;


    protected Ayah(Parcel in) {
        number = in.readInt();
        text = in.readString();
        numberInSurah = in.readInt();
        juz = in.readInt();
        manzil = in.readInt();
        page = in.readInt();
        ruku = in.readInt();
        hizbQuarter = in.readInt();
        sajda = in.readByte() != 0;
    }

    public static final Creator<Ayah> CREATOR = new Creator<Ayah>() {
        @Override
        public Ayah createFromParcel(Parcel in) {
            return new Ayah(in);
        }

        @Override
        public Ayah[] newArray(int size) {
            return new Ayah[size];
        }
    };

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumberInSurah() {
        return numberInSurah;
    }

    public void setNumberInSurah(int numberInSurah) {
        this.numberInSurah = numberInSurah;
    }

    public int getJuz() {
        return juz;
    }

    public void setJuz(int juz) {
        this.juz = juz;
    }

    public int getManzil() {
        return manzil;
    }

    public void setManzil(int manzil) {
        this.manzil = manzil;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRuku() {
        return ruku;
    }

    public void setRuku(int ruku) {
        this.ruku = ruku;
    }

    public int getHizbQuarter() {
        return hizbQuarter;
    }

    public void setHizbQuarter(int hizbQuarter) {
        this.hizbQuarter = hizbQuarter;
    }

    public boolean isSajda() {
        return sajda;
    }

    public void setSajda(boolean sajda) {
        this.sajda = sajda;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(text);
        dest.writeInt(numberInSurah);
        dest.writeInt(juz);
        dest.writeInt(manzil);
        dest.writeInt(page);
        dest.writeInt(ruku);
        dest.writeInt(hizbQuarter);
        dest.writeByte((byte) (sajda ? 1 : 0));
    }
}
