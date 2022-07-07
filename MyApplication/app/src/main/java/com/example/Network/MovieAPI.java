package com.example.Network;

import com.example.movie.movieData.mv_ResponseDTO;
import com.example.movie.movieData.mv_card_data;
import com.example.movie.movieData.mv_detail_data;
import com.example.movie.movieData.mv_search_data;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieAPI {

    @GET("movie") //전체 목록
    Call<mv_ResponseDTO<mv_card_data>> getMovieList();

    @GET("movie/actor/{actor}") // 배우 출연작 목록
    Call<mv_ResponseDTO<mv_card_data>> getActorList(@Path("actor") String actor);

    @GET("movie/genre/{genre}") // 장르 목록
    Call<mv_ResponseDTO<mv_card_data>> getGenreList(@Path("genre") String genre);

    @GET("movie/company/{company}") // 회사 목록
    Call<mv_ResponseDTO<mv_card_data>> getCompanyList(@Path("company") String company);

    @GET("movie/country/{country}") // 나라 목록
    Call<mv_ResponseDTO<mv_card_data>> getCountryList(@Path("country") String country);

    @GET("movie/year/{release_year}") // 개봉년도 목록
    Call<mv_ResponseDTO<mv_card_data>> getYearList(@Path("release_year") String release_year);


}
