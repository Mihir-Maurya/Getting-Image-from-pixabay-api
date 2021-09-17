package com.example.volleylibraryexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.volleylibraryexample.MainActivity.EXTRA_CREATOR;
import static com.example.volleylibraryexample.MainActivity.EXTRA_LIKES;
import static com.example.volleylibraryexample.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES,0);
        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView creatorView = findViewById(R.id.creator_name_detail);
        TextView likesView = findViewById(R.id.likes_detail);
        Picasso.get().load(imageUrl).centerInside().fit().into(imageView);
        creatorView.setText(creatorName);
        likesView.setText("Likes: " + likeCount);
    }
}