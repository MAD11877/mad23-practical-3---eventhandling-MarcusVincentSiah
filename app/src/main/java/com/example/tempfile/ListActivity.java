package com.example.tempfile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Alert Method/Function
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                Intent intent = new Intent(ListActivity.this, MainActivity2.class);
                intent.putExtra("New_Text", "MAD 1739039545");
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
}