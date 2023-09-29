package com.amysoftech.helpdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
EditText emailEditText,passwordEdittext;
TextView forgetpassword;
String device_token="";
ImageView nextbutton;

String org="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText=findViewById(R.id.emailEditText);
        passwordEdittext=findViewById(R.id.passwordEdittext);
        forgetpassword=findViewById(R.id.forgetpassword);
        nextbutton=findViewById(R.id.nextbutton);
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,RestoreyourPassword.class);
                startActivity(i);
            }
        });
     nextbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
             String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";
             if (validation()) {
                 if (emailEditText.getText().toString().matches(emailPattern) || passwordEdittext.getText().toString().matches(emailPattern2)) {

                     sendLoginRequest();


                 } else {
                     Toast.makeText(LoginActivity.this,
                             "please enter valid email", Toast.LENGTH_SHORT).show();

                 }

             }
         }
});
    }
    //Validation for SignIn
    public boolean validation(){

        if(emailEditText.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(LoginActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return false;
        }else if
        (passwordEdittext.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(LoginActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    //Login API Method
    public void sendLoginRequest(){  ApiServices apiServices =
            RetrofitHelper.getRetrofitInstance().create(ApiServices.class);

        try {

            apiServices.sendLogindRequest(emailEditText.getText().toString(),passwordEdittext.getText().toString(),device_token)
                    .enqueue(new Callback<LoginModule>() {
                        @Override
                        public void onResponse(Call<LoginModule> call, Response<LoginModule> response) {
                            if (response.body().getStatus().equalsIgnoreCase("1")) {

                                Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                                MyPrefrence.getInstance(LoginActivity.this).SetLoginStatus("true");

                                MyPrefrence.getInstance(LoginActivity.this).SetUser_ID(response.body().getId());

                                MyPrefrence.getInstance(LoginActivity.this).SetAcessToken(
                                        "Bearer " + response.body().getAccesstoken());

                                MyPrefrence.getInstance(LoginActivity.this).SetEMP_ROLE(response.body().getType());

                                MyPrefrence.getInstance(LoginActivity.this).SetOrganization(response.body().getOrganizationName());
                                   Intent in = new
                                 Intent(LoginActivity.this, MainActivity.class);
                              //  Toast.makeText(LoginActivity.this, "It works", Toast.LENGTH_SHORT).show();
                                 startActivity(in); finish();
                            } else {
                                ';po0Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginModule> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                   // enqueue(new Callback<LoginModule>()

        }catch (Exception e){ e.printStackTrace();
            //CustomProgress.hideProgress();
        }
    }



}