package com.example.video4u;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        Video Video = (Video) b.getSerializable("Video");

        ImageView avatar = findViewById(R.id.avatar);
        TextView fullname = findViewById(R.id.fullname);
        TextView console = findViewById(R.id.console);
        TextView gamename = findViewById(R.id.gamename);
        TextView year = findViewById(R.id.year);
        TextView price = findViewById(R.id.price);

        if(Video.getUri() == null)
            avatar.setImageResource(Video.getPhoto());
        else
            avatar.setImageURI(Uri.parse(Video.getUri()));

        fullname.setText(Video.getFullName());
        console.setText(Video.getConsole());
        gamename.setText(Video.getGameName());
        year.setText(Video.getYear());
        price.setText(Video.getPrice());

    }
}
