package com.example.tempfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        boolean[] variable = {false};
        User user = new User("Hello World!", "Lorem ipsum dolor sit amet, consecttur adipiscing elit, sed do eiusmod tempor incidiunt ut labore et dolore magna aliqua\"");
        EditText name = findViewById(R.id.editTextText);
        TextView description = findViewById(R.id.textView2);

        name.setText(user.getName());
        description.setText(user.getDescription());

        // name.setOnKeyListener(new);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.followed = !user.followed;
                btn.setText((user.followed)?"Follow":"Unfollow");

                if (user.followed == false){
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                else if (user.followed == true){
                    Toast.makeText(getApplicationContext(), "Unfollow", Toast.LENGTH_SHORT).show();
                }
//                if (variable[0] == false){
//                    btn.setText("Unfollow");
//                    variable[0] = true;
//                }
//                else if (variable[0] == true){
//                    btn.setText("Follow");
//                    variable[0] = false;
//                }

            }
        });

        //To edit the textView to a new message which was created in ListActivity
        Intent receivingEnd = getIntent();
        String message = receivingEnd.getStringExtra("New_Text");

        TextView textView = findViewById(R.id.editTextText);
        textView.setText(message);

        //event listener for message button
        Button myButton = findViewById(R.id.button2);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MessageGroup.class);
                startActivity(intent);
            }
        });

    }
}