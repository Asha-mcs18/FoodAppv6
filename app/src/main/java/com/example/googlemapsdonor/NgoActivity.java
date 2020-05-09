package com.example.googlemapsdonor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.googlemapsdonor.controllers.DonationListController;
import com.example.googlemapsdonor.models.DataStatus;
import com.example.googlemapsdonor.models.DonationListModel;
import com.example.googlemapsdonor.models.DonationModel;

import java.util.ArrayList;
import java.util.List;

public class NgoActivity extends AppCompatActivity {
    String donations[] = new String [] {"jin","suga","jhope","rm","jimin","V","jk"};
    private List<DonationListModel> mdonationList =null;
    private DonationListController donationListController = new DonationListController();

    @Override
    protected void onStart() {
        super.onStart();
        donationListController.getDonationList(new DataStatus() {
//            @Override
//            public void dataLoaded(List<Object> object) {
//                super.dataLoaded(object);
//                Log.d("Ngo Activity","Donation List Loaded successfully");
//                //mdonationList = (List<DonationListModel>)(List<?>)object;
//            }
            @Override
            public void dataLoaded(List<?> donations) {
                super.dataLoaded(donations);
                Log.d("NGO ACTIVITY", "ngo activity Donation List Item after food added");
                List<DonationListModel> donationList = (List<DonationListModel>)(List<?>) donations;
                mdonationList = donationList;
                for(DonationListModel d: donationList){
                    Log.d("NGO ACTIVITY", "ngo activity donation List item added  is" +d.toString());
                }
            }

            @Override
            public void dataLoaded(String object) {
                super.dataLoaded(object);

                Log.d("NGO ACTIVITY"," Ngo actitivity"+object);
            }

            @Override
            public void errorOccured(String message) {
                Log.d("Ngo Activity","Donation List Loaded falied"+message);
                Toast.makeText(NgoActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo);
        //test
        //test
        ListView donationList = (ListView) findViewById(R.id.donationsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,donations);
        donationList.setAdapter(adapter);
        Log.d("NGO ACTIVITY", "Donation List Items are : ");
        if(mdonationList!=null){
            for (DonationListModel donation:mdonationList){
                Log.d("Ngo Activity",donation.toString());
            }
        }

        donationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DonationDetails.class);
                intent.putExtra("memberName", donations[position]);
                startActivity(intent);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
