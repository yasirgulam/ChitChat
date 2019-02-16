package com.example.chitchat.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.chitchat.Home.HomeActivity;
import com.example.chitchat.Likes.LikesActivity;
import com.example.chitchat.Profile.ProfileActivity;
import com.example.chitchat.R;
import com.example.chitchat.Search.SearchActivity;
import com.example.chitchat.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {
    private static final String TAG = "bottomNavigationViewHel";

    public static void setupBottomnavigationView(BottomNavigationViewEx bottomNavigationViewEx){

        Log.d(TAG, "setupBottomnavigationView: setting up bottom navigation view");

        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

    }


    public static void enableNavigation(final Context context,BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, HomeActivity.class);//ACTIVITY_NUM = 0;
                        context.startActivities(new Intent[]{intent1});
                        break;
                    case R.id.ic_search:
                        Intent intent2= new Intent(context, SearchActivity.class);//ACTIVITY_NUM = 1;
                        context.startActivities(new Intent[]{intent2});
                         break;
                    case R.id.ic_add:
                        Intent intent3= new Intent(context, ShareActivity.class);//ACTIVITY_NUM = 2;
                        context.startActivities(new Intent[]{intent3});
                        break;
                    case R.id.ic_like:
                        Intent intent4= new Intent(context, LikesActivity.class);//ACTIVITY_NUM = 3;
                        context.startActivities(new Intent[]{intent4});
                        break;
                    case R.id.ic_profile:
                        Intent intent5= new Intent(context, ProfileActivity.class);//ACTIVITY_NUM = 4;
                        context.startActivities(new Intent[]{intent5});
                        break;

                }
                return false;
            }
        });
    }

}
