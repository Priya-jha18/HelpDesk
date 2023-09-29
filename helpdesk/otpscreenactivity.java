package com.amysoftech.helpdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class otpscreenactivity extends AppCompatActivity {
EditText newpass,confirmpass;
ImageView nextbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpscreenactivity);
        newpass=findViewById(R.id.newpassedit);
        confirmpass=findViewById(R.id.confirmpassedit);
        nextbutton=findViewById(R.id.nextbutton);





    }
}