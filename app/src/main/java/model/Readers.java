package model;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Readers implements Parcelable {

    @SerializedName("Sora")
    @Expose
    private String sora;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("Reader_Name")
    @Expose
    private String readerName;
    @SerializedName("pageNumber")
    @Expose
    private int pageNumber;
    @SerializedName("Sora_Type")
    @Expose
    private String soraType;
    @SerializedName("Sora_Number")
    @Expose
    private int soraNumber;
    @SerializedName("Ayats_number")
    @Expose
    private int ayatsNumber;

    protected Readers(Parcel in) {
        sora = in.readString();
        link = in.readString();
        readerName = in.readString();
        pageNumber = in.readInt();
        soraType = in.readString();
        soraNumber = in.readInt();
        ayatsNumber= in.readInt();
    }

    public static final Creator<Readers> CREATOR = new Creator<Readers>() {
        @Override
        public Readers createFromParcel(Parcel in) {
            return new Readers(in);
        }

        @Override
        public Readers[] newArray(int size) {
            return new Readers[size];
        }
    };

    public int getAyatsNumber() {
        return ayatsNumber;
    }

    public void setAyatsNumber(int ayatsNumber) {
        this.ayatsNumber = ayatsNumber;
    }

    public String getSora() {
        return sora;
    }

    public void setSora(String sora) {
        this.sora = sora;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSoraType() {
        return soraType;
    }

    public void setSoraType(String soraType) {
        this.soraType = soraType;
    }

    public int getSoraNumber() {
        return soraNumber;
    }

    public void setSoraNumber(int soraNumber) {
        this.soraNumber = soraNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sora);
        dest.writeString(link);
        dest.writeString(readerName);
        dest.writeInt(pageNumber);
        dest.writeString(soraType);
        dest.writeInt(soraNumber);
        dest.writeInt(ayatsNumber);
    }
}
