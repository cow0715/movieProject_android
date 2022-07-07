package com.example.sns.network;

import com.example.sns.data.ResponseDTO;
import com.example.sns.data.SnsData;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface SnsV1API {

    @GET("sns") //전체 목록
    Call<ResponseDTO<SnsData>> getSnsList();

    @GET("sns/v2") //전체 목록
    Call<ResponseDTO<SnsData>> getSnsListV2();

    @POST("sns") //등록
    Call<ResponseDTO<SnsData>> addSns(@Body SnsData post);


    @GET("sns/{sid}")
    Call<ResponseDTO<SnsData>> getSns(@Path("sid") int sid);

    @GET("sns/m/{sid}")
    Call<ResponseDTO<SnsData>> getSnsV2(@Path("sid") int sid);

    @PATCH("sns/{sid}")
    Call<ResponseDTO<SnsData>> updateSns(@Path("sid") int sid, @Body SnsData sns);

    @DELETE("sns/{sid}")
    Call<ResponseDTO<SnsData>> deleteSns(@Path("sid") int sid);



    @Multipart
    @POST("sns/m/upload")
    Call<Void> uploadImg( @Part MultipartBody.Part files);

    @Multipart
    @POST("sns/m/upload2")
    Call<Void> uploadImages( @Part ArrayList<MultipartBody.Part> files);

}
