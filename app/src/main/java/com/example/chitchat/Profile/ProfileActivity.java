package com.example.chitchat.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.chitchat.R;
import com.example.chitchat.utils.BottomNavigationViewHelper;
import com.example.chitchat.utils.GridImageAdapter;
import com.example.chitchat.utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;
    private static final String TAG = "ProfileActivity";
    private Context mContext = ProfileActivity.this;


    private ProgressBar mProgressBar;
    private ImageView profilePhoto;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started");

        initImageLoader();
        setupBottomNavigattionView();
        setupToolBar();
        setupActivityWidgets();
        setProfileImage();
        tempGridSetup();
    }

    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("http://hdqwalls.com/wallpapers/iron-man-simple-1-image.jpg ");
        imgURLs.add("http://hdqwalls.com/wallpapers/captain-america-original-poster.jpg");
        imgURLs.add("http://hdqwalls.com/wallpapers/spiderman-captain-america-civil-war-pic.jpg");
        imgURLs.add("http://hdqwalls.com/wallpapers/iron-man-civil-war-art-wf.jpg");
        imgURLs.add("http://hdqwalls.com/wallpapers/iron-man-pop-head-minimalism-pn.jpg");
        imgURLs.add("http://hdqwalls.com/wallpapers/avengers-infinity-war-captain-america-iron-man-thanos-0x.jpg");
        imgURLs.add("http://hdqwalls.com/wallpapers/avengers-assemble-artwork-fq.jpg");
        imgURLs.add("http://hdqwalls.com/wallpapers/black-widow-in-avengers-age-of-ultron.jpg");
        imgURLs.add("http://hdqwalls.com/wallpapers/iron-man-and-batman-5k-bs.jpg");
        imgURLs.add("http://hdqwalls.com/wallpapers/iron-man-minimalism-4k-2018-26.jpg");
        imgURLs.add("http://hdqwalls.com/thor-ragnarok-4k-new-wallpaper");
        imgURLs.add("http://hdqwalls.com/wallpapers/iron-man-and-captain-america-g8.jpg");

        setupImageGrid(imgURLs);
    }

    private void setupImageGrid(ArrayList<String> imgURLs) {
        GridView gridView = findViewById(R.id.gridView);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, imgURLs, "");
        gridView.setAdapter(adapter);
    }


    private void setupActivityWidgets(){
        mProgressBar = findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = findViewById(R.id.profile_photo);
    }

    private void setProfileImage(){
      Log.d(TAG, "setProfileImage: setting profile photo");
      String imgURL = "wonderfulengineering.com/wp-content/uploads/2016/02/iron-man-wallpaper-29-610x343.jpg";
      UniversalImageLoader.setImage(imgURL, profilePhoto, null, "https://" );
    }
    /**
     * Responsible for setting up profile toolbar
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupToolBar() {
        Toolbar toolbar = findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to account settings");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });

    }
    private void initImageLoader(){

        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    /**
     * bottom navigation view settup
     */
    public void setupBottomNavigattionView(){
        Log.d(TAG, "setupBottomNavigattionView: setting up bottom anavigation view");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomnavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
