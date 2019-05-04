package ModelDB;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import model.Surah;

@Entity(tableName = "Suras")
public class SuraDB {
    private static SuraDB instance;

    @PrimaryKey
    private Integer number;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "englishName")
    private String englishName;

    @ColumnInfo(name = "englishNameTranslation")
    private String englishNameTranslation;

    @ColumnInfo(name = "numberOfAyahs")
    private Integer numberOfAyahs;

    @ColumnInfo(name = "revelationType")
    private String revelationType;

    public SuraDB(Integer number, String name, String englishName, String englishNameTranslation, Integer numberOfAyahs, String revelationType) {
        this.number = number;
        this.name = name;
        this.englishName = englishName;
        this.englishNameTranslation = englishNameTranslation;
        this.numberOfAyahs = numberOfAyahs;
        this.revelationType = revelationType;
    }

    public static SuraDB getInstance(Integer number, String name, String englishName, String englishNameTranslation, Integer numberOfAyahs, String revelationType) {
        if (instance == null) {
            synchronized (Surah.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new SuraDB(number, name, englishName, englishNameTranslation, numberOfAyahs, revelationType);
                }
            }
        }
        return instance;
    }

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
}
