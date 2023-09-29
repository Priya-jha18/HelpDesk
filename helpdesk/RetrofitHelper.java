package com.amysoftech.helpdesk;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static final String BASE_URL = "https://uathelpdesk.amysoftech.com/";
   // private static final String BASE_URL = "http://10.10.10.252/hrm/";
  //  private static final String BASE_URL = "http://10.10.10.174/customer_support/MDDAPI/";
    private static Retrofit retrofit = null;
    private static OkHttpClient client = new OkHttpClient();

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            client = new OkHttpClient.Builder().
                    readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}