package com.azharfaunsyah.project_uas_android.services

import com.azharfaunsyah.project_uas_android.models.Complain
import com.azharfaunsyah.project_uas_android.models.News
import com.azharfaunsyah.project_uas_android.models.User
import com.azharfaunsyah.project_uas_android.networks.BaseListResponse
import com.azharfaunsyah.project_uas_android.networks.BaseResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @GET("api/news")
    fun all() : Call<BaseListResponse<News>>

    @FormUrlEncoded
    @POST("api/user/login")
    fun login(@Field("email") email : String, @Field("password") password : String) : Call<BaseResponse<User>>

    @FormUrlEncoded
    @POST("api/user/register")
    fun register(@Field("name") n : String, @Field("email") e : String,@Field("password") p : String) : Call<BaseResponse<User>>

    @GET("api/user/complaint")
    fun allComplain(@Header("Authorization") api_token : String) : Call<BaseListResponse<Complain>>

    @FormUrlEncoded
    @POST("api/user/complaint")
    fun new(@Header("Authorization") api_token: String, @Field("title") title : String, @Field("message") message : String, @Field("input1") input1 : String, @Field("input2") input2 : String) : Call<BaseResponse<Complain>>


    @FormUrlEncoded
    @PUT("api/user/complaint/{id}")
    fun update(@Header("Authorization") api_token: String, @Path("id") id : String, @Field("title") title : String, @Field("message") message : String, @Field("input1") input1 : String, @Field("input2") input2 : String) : Call<BaseResponse<Complain>>

    @DELETE("api/user/complaint/{id}")
    fun delete(@Header("Authorization") api_token : String, @Path("id") id : String) : Call<BaseResponse<Complain>>



}