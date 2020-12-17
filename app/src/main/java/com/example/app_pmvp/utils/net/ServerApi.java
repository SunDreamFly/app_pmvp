package com.example.app_pmvp.utils.net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ServerApi {
    @GET
    Observable<ResponseBody> get(@Url String url);
}
