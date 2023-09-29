package com.amysoftech.helpdesk;

import com.amysoftech.helpdesk.dashboard.dashboard_model.DashboardModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("MDDAPI/Mobapp_API?action=EMPLOGIN")
    Call<LoginModule> sendLogindRequest(@Field("u_username") String user_email,
                                        @Field("u_password") String user_pass,
                                        @Field("u_device_token") String device_id); @FormUrlEncoded
    @POST("MDDAPI/Mobapp_API.php?action=CREATE_TICKET")
    Call<CreateTicketModel> sendCreateTicket(@Field("subject") String subject,
                                        @Field("organization") String organization,
                                        @Field("project") String project,
                                        @Field("process") String process,
                                        @Field("description") String description,
                                        @Field("customer_id") String customer_id,
                                        @Field("priority") String priority,
                                        @Field("ticket_type") String ticket_type,
                                        @Field("type") String type,
                                        @Header("Authorization")String auth);
    @FormUrlEncoded
    @POST("MDDAPI/Mobapp_API.php?action=GET_PROCESS_DATA")
    Call<processmodel> sendProcessData(@Field("id") String id,
                                        @Field("type") String type,
                                   @Header("Authorization")String auth);
 @FormUrlEncoded
    @POST("MDDAPI/Mobapp_API.php?action=GET_PROJECT_DATA")
    Call<projectmodel> sendProjectData(@Field("id") String id,
                                        @Field("type") String type,
                                   @Header("Authorization")String auth);
@FormUrlEncoded
    @POST("MDDAPI/Mobapp_API.php?action=GET_PROJECT_DATA")
    Call<updateTicketModel> sendEditTicketRequest(@Field("id") String id,
                                        @Field("status") String status,
                                   @Header("Authorization")String auth);

    @FormUrlEncoded
    @POST("/MDDAPI/Mobapp_API.php?action=DASHBOARD")
    Call<DashboardModel> getDashboard(@Field("id") String id,
                                      @Field("type") String type,
                                      @Header("Authentication") String auth);

    @FormUrlEncoded
    @POST("/MDDAPI/Mobapp_API.php?action=ALL_TICKETS")
    Call<AllTicketModel> getTicketList(@Field("id") String id,
                                       @Field("type") String type,
                                       @Field("ticket_type") String ticket_type,
                                       @Header("Authentication") String auth);


 @FormUrlEncoded
    @POST("/Mobapp_API.php?action=FORGOT_PASSWORD")
    Call<forgetpassmodel> sendforgetpasswordrequest(@Field("email") String id,
                                       @Field("type") String type,
                                       @Header("Authentication") String auth);


 @FormUrlEncoded
    @POST("/Mobapp_API.php?action=FORGOT_PASSWORD")
    Call<chatmodel> sendChatRequest(@Field("email") String id,
                                       @Field("type") String type,
                                       @Header("Authentication") String auth);


}
