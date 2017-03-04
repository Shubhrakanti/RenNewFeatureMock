package com.example.giddu.rennewfeaturemock;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.support.v7.appcompat.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recList;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private String pictureImagePath ="";
    private ArrayList<PicturePost> picturePosts;
    private PicturePostAdapter picturePostAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        picturePosts = new ArrayList<>();
        picturePosts.add(new PicturePost("Obama","5 m",R.drawable.prof_pic_1,BitmapFactory.decodeResource(getResources(), R.drawable.woody_selfie), 15, 5));

        picturePostAdapter = new PicturePostAdapter(picturePosts);

        recList.setAdapter(picturePostAdapter);

    }

    public void openBackCamera(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            picturePosts.add(new PicturePost("Obama","5 m",R.drawable.prof_pic_1,imageBitmap, 15, 5));
            picturePostAdapter.updateDataSet(picturePosts);
        }
    }
}
