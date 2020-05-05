package com.example.googlemapsdonor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.googlemapsdonor.controllers.DonationStatusController;
import com.example.googlemapsdonor.models.DataStatus;

public class MainActivity extends AppCompatActivity {
    //test
    private DonationStatusController donationStatusController= new DonationStatusController();
    //test

    public void toDonorActivity(View view){
        Intent intent = new Intent(getApplicationContext(),DonorActivity.class);
     startActivity(intent);

    }
    public void toLoginActivity(View view){
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);

    }
    public void toRegisterActivity(View view){
        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);
    }
    public void toNGOActivity(View view){
        Intent intent = new Intent(getApplicationContext(),NgoActivity.class);
        startActivity(intent);
    }

    public void toAboutActivity(View view){
        Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
        startActivity(intent);
    }
    public void toHomeActivity(View view){
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        donationStatusController.donorStatus(new DataStatus() {
//            @Override
//            public void dataLoaded(String status) {
//                super.dataLoaded(status);
//                Log.d("Donor status","status is "+status);
//            }
//
//            @Override
//            public void errorOccured(String message) {
//
//            }
//        });
    }
}
