package Api;
public class ServicesConnectionReader {
    private static ApiInterface apiInterface = null;

    private ServicesConnectionReader() {
    }

    public static ApiInterface GetService() {
        if (apiInterface == null) {
            apiInterface = ApiClientReader.getClient().create(ApiInterface.class);
        }
        return apiInterface;
    }
}
