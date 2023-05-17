package com.example.tempfile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String name = generateNum();

        //Alert Method/Function
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent intent = new Intent(ListActivity.this, MainActivity2.class);
                intent.putExtra("New_Text", name);
                startActivity(intent); //changes to the destination activity
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){

            }
        });
        //End of Alert

        //When image is clicked, alert will be activated which calls the function above.
        ImageView myImageView = findViewById(R.id.imageView1);
        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }

    private String generateNum() {
        String name = "";

        Random random = new Random();

        long min1 = 100000000L;  // Minimum 9-digit number
        long max1 = 9999999999L; // Maximum 10-digit number
        long randomNumber1 = min1 + ((long) (random.nextDouble() * (max1 - min1)));
        name = "MAD " + randomNumber1;

        return name;
    }
}