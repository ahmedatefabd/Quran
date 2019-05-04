package callback;
import java.util.List;
import model.Readers;

public interface CB_OnDataLisener {
    void onSucess(List<Readers> readersList);
    void onError(String errorMsg);
}
