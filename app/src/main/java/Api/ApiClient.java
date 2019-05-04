package Api;
import android.content.Context;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient(String BASE_URL) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

//    public static ApiClient getInstance() {
//        if (apiClient == null) {
//            apiClient = new ApiClient();
//        }
//        return apiClient;
//    }
//
//    public Retrofit getClient() {
//        return getClient(null);
//    }
//
//    public Retrofit getClient2() {
//        return getClient2(null);
//    }
//
//    private Retrofit getClient(final Context context) {
//        retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(ScalarsConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        return retrofit;
//    }
//
//    private Retrofit getClient2(final Context context) {
//        retrofit2 = new Retrofit.Builder()
//                    .baseUrl(BASE_URL2)
//                    .addConverterFactory(ScalarsConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        return retrofit2;
//    }
}