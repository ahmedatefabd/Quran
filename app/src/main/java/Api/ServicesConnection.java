package Api;
public class ServicesConnection {
    private static ApiInterface apiInterface = null;

    private ServicesConnection() {
    }

    public static ApiInterface GetService(String BASE_URL) {
        if (apiInterface == null) {
            apiInterface = ApiClient.getClient(BASE_URL).create(ApiInterface.class);
        }
        return apiInterface;
    }
}
