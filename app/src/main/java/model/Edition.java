package model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Edition implements Parcelable {

    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("englishName")
    @Expose
    private String englishName;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("type")
    @Expose
    private String type;

    protected Edition(Parcel in) {
        identifier = in.readString();
        language = in.readString();
        name = in.readString();
        englishName = in.readString();
        format = in.readString();
        type = in.readString();
    }

    public static final Creator<Edition> CREATOR = new Creator<Edition>() {
        @Override
        public Edition createFromParcel(Parcel in) {
            return new Edition(in);
        }

        @Override
        public Edition[] newArray(int size) {
            return new Edition[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(identifier);
        dest.writeString(language);
        dest.writeString(name);
        dest.writeString(englishName);
        dest.writeString(format);
        dest.writeString(type);
    }
}
