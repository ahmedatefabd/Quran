package com.example.qurankarem.api;
public class ServicesConnection {
    public static final String BASE_URL = "https://api.alquran.cloud/v1/";
    private static ApiInterface apiInterface = null;
    private ServicesConnection() {
    }
    public static ApiInterface GetService() {
        if (apiInterface == null) {
            apiInterface = ApiClient.getClient().create(ApiInterface.class);
        }
        return apiInterface;
    }
}
