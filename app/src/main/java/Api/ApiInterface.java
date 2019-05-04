package Api;
import java.util.List;

import model.Data;
import model.Readers;
import model.ResponseSurah;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("surah")
    Call<ResponseSurah> getResponseSurah();

    @GET("surah/{number}/{language}")
    Call<Data> getResponseAyah(@Path("number") Integer number, @Path("language") String language);

    @FormUrlEncoded
    @POST("GetQuran.php")
//    Call<List<Readers>> getAllReaders(@Body int body);
    Call<List<Readers>> getAllReaders(@Field("reader_id") int body);
}
