package Api;
import model.Data;
import model.ResponseSurah;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("surah")
    Call<ResponseSurah> getResponseSurah();

    @GET("surah/{number}/{language}")
    Call<Data> getResponseAyah(@Path("number") Integer number, @Path("language") String language);
}
