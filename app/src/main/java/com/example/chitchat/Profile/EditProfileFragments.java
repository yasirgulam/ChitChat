package com.example.chitchat.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.chitchat.R;
import com.example.chitchat.utils.UniversalImageLoader;

public class EditProfileFragments extends Fragment {
    private static final String TAG = "EditProfileFragments";

    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        mProfilePhoto = view.findViewById(R.id.profile_photo);

        setProfileImage();


        //setup the backArrow for navigating back to profile activity
        ImageView backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Navigating back to profile acctivity");
                getActivity().finish();
            }
        });
        return view;
    }


    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: Setting profile image");
        String imgURL = "wonderfulengineering.com/wp-content/uploads/2016/02/iron-man-wallpaper-29-610x343.jpg";
        UniversalImageLoader.setImage(imgURL,mProfilePhoto,null,"https://");
        
    }
}
