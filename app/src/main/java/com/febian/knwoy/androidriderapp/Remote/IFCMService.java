package com.febian.knwoy.androidriderapp.Remote;

import com.febian.knwoy.androidriderapp.Model.FCMResponse;
import com.febian.knwoy.androidriderapp.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAEy-FKRc:APA91bFB8h3xkcZqsZT-ZdHrxk9rms8gyvD1Ue3f332th-k4jBO6gWBqLWxNFTg1Mg38Z9y63-TSwuth_Uv2eV8d3eRNnorTGN24XRhf_DpKU-fs5BI4bKgdqxZF0CkwSCvqqnC9InVX"
    })
    @POST("fcm/send")
    Call<FCMResponse> sendMessage(@Body Sender body);
}
