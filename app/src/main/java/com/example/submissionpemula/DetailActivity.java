package com.example.submissionpemula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView detailTitle, detailInfo;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Items destinationItems = getIntent().getParcelableExtra("data");

        detailTitle = findViewById(R.id.detailTitle);
        String text_title = destinationItems.getTitle();
        detailTitle.setText(text_title);

        detailInfo = findViewById(R.id.detailInfo);
        String text_info = destinationItems.getInfo();
        detailInfo.setText(text_info);

        detailImage = findViewById(R.id.detailImage);
        int Image = destinationItems.getImage();
        detailImage.setImageResource(Image);

    }
}
