package com.amysoftech.helpdesk;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class RestoreyourPassword extends AppCompatActivity {
EditText emailEditText;
ImageView nextbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restoreyour_password);
        emailEditText = findViewById(R.id.emailEditText);
        nextbutton = findViewById(R.id.nextbutton);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   sendOtpRequest();
                Intent in = new Intent(RestoreyourPassword.this, otpscreenactivity.class);
                in.putExtra("email", emailEditText.getText().toString());

                startActivity(in);
            }
        });

    }
    public void sendOtpRequest(){

      //  CustomProgress.showProgress(RestoreYourPasswo rd.this);
        ApiServices apiServices = RetrofitHelper.getRetrofitInstance().create(ApiServices.class);

        try {

            apiServices.sendforgetpasswordrequest(emailEditText.getText().toString(),
                            "SEND_OTP",

                            MyPrefrence.getInstance(RestoreyourPassword.this).GetAccessToken())
                    .enqueue(new Callback<forgetpassmodel>() {
                        @Override
                        public void onResponse(Call<forgetpassmodel> call, Response<forgetpassmodel> response) {
                            if (response.body().getStatus().equalsIgnoreCase ("1")){


                                Toast.makeText(RestoreyourPassword.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                Intent in = new Intent(RestoreyourPassword.this, otpscreenactivity.class);
                                in.putExtra("email",emailEditText.getText().toString());

                                startActivity(in);

                                finish();
                            }

                            else {

                                Toast.makeText(RestoreyourPassword.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<forgetpassmodel> call, Throwable t) {
                            Toast.makeText(RestoreyourPassword.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
        }catch (Exception e){ e.printStackTrace();

            //CustomProgress.hideProgress();
        }
    }


}