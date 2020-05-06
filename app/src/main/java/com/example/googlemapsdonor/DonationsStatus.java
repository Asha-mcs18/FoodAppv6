package com.example.googlemapsdonor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;

import static com.example.googlemapsdonor.utils.Notifications.CHANNEL_1_ID;

import android.widget.TextView;

import com.example.googlemapsdonor.controllers.DonationStatusController;
import com.example.googlemapsdonor.models.DataStatus;
import com.example.googlemapsdonor.models.DonationModel;
import com.example.googlemapsdonor.utils.Constants;

public class DonationsStatus extends AppCompatActivity {

    public static final int REQUEST_CODE_GETMESSAGE = 1014;
    private NotificationManagerCompat notificationManager;
    private TextView donationText;
    private String donationStatus= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donations_status);
        Log.i("Donation Status","status");
        notificationManager = NotificationManagerCompat.from(this);
        DonationStatusController statusController = new DonationStatusController();
        donationText= findViewById(R.id.donationKey);
        if(donationStatus==null||donationStatus.equals("")){
            donationText.setText("Please make a donation first");
        }
        statusController.donorStatus(new DataStatus() {
            @Override
            public void dataLoaded(String status) {
                super.dataLoaded(status);
                donationStatus=status;
                if(donationStatus==null||donationStatus.equals("")){
                    donationText.setText("Please make a donation first");
                }
                donationText.setText(donationStatus);
                Log.d("DonationStatusCOntrole", "Data Snapshot is " + status);
                if(donationStatus!=null&&donationStatus.equals(Constants.ACCEPTED)){
                    sendNotification();
                }
            }

            @Override
            public void errorOccured(String message) {

            }
        });
    }

    public void sendNotification() {
        String title = "Your Donation Accepted";
        String message = "Your donation is accepted by NGO";
        Log.i("onsend","onsend");

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_message_black)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
//        Intent intent = new Intent(getApplicationContext(),NgoActivity.class);
////        startActivity(intent);
//        DonationModel donationModel = (DonationModel) getIntent().getSerializableExtra("DonationModel");
//        donationText = findViewById(R.id.donationKey);
//        donationText.setText(donationModel.getKey());
//        Log.d("Donor Status Activity",donationModel.toString());
    }
}
