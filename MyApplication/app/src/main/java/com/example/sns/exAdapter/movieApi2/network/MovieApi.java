package com.example.sns.exAdapter.movieApi2.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
//    https://openapi.naver.com/v1/
//    search/movie.json?
//    query=love&display=10&start=1&genre=1

//     headers.put("X-Naver-Client-Id","zPLJzJBVNOKp20sdrIix");
//     headers.put("X-Naver-Client-Secret","LLIDSy_UnJ");

    //movie.json
    @GET("search/{type}")
    Call<String> getMovieList(
            @Header("X-Naver-Client-Id") String ncid,
            @Header("X-Naver-Client-Secret") String ncpw,
            @Path("type") String type,
            @Query("query") String query,
            @Query("display") String display,
            @Query("start") String start,
            @Query("genre") String genre
    );
}
