package networkingApi;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import java.util.List;
import callback.CB_OnDataLisener;
import model.Readers;

public class ApiModel {

    public void getReaders (final CB_OnDataLisener listener){

        AndroidNetworking.post("https://mostafagad9090.000webhostapp.com/QuranService/GetQuran.php")
                .addBodyParameter("reader_id", 1 + "")
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObjectList(Readers.class, new ParsedRequestListener<List<Readers>>() {
                    @Override
                    public void onResponse(List<Readers> response) {
                        listener.onSucess(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        listener.onError(anError.getErrorDetail());
                    }
                });
    }
}