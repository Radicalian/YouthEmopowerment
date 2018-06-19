package com.yef.youthempower.youth;

/**
 * Created by Rajat Krishnan on 02-06-2018.
 */


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;



import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;


public class OnBoardActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences =  getSharedPreferences("my_preferences",
                MODE_PRIVATE);

        // Check if onboarding_complete is false
        if(preferences.getBoolean("onboarding_complete",false)) {
// Start the onboarding Activity
            Intent onboarding = new Intent(this,ProfileActivity.class);
            startActivity(onboarding);

// Close the main Activity
            finish();
            return;
        }

//slide1
        addFragment(new Step.Builder().setTitle("Welcome To Youth Empowerment Foundation!!")
                .setSummary("It seems like you are a New User!!\nWe welcome you to the official app of Youth Empowerment Foundation.We are happy to have you here!!")
                .setBackgroundColor(Color.parseColor("#FFFFD900")) // int background color
                .setDrawable(R.drawable.yef1) // int top drawable

                .build());
        final MediaPlayer mMediaPlayer=MediaPlayer.create(this,R.raw.ear);


        mMediaPlayer.start();
        CountDownTimer Timer = new CountDownTimer(37000,37000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                }
            }
        };
        Timer.start();



        //slide2
        addFragment(new Step.Builder().setTitle("Online Global Chat")
                .setSummary("This app gives you power to chat and get connected with the other user who uses this app as well as to get connected from the official of YEF community who are ready to help you out!!")
                .setBackgroundColor(Color.parseColor("#FF01CCFF")) // int background color
                .setDrawable(R.drawable.yef2) // int top drawable

                .build());

        //slide3
        addFragment(new Step.Builder().setTitle("Let's Get Started!!")
                .setSummary("Please Note before you start you must have an active internet connection and you need to Sign Up for the app so that we could serve you in a better manner!!")
                .setBackgroundColor(Color.parseColor("#FFA600")) // int background color
                .setDrawable(R.drawable.yef3) // int top drawable

                .build());
    }

    @Override
    public void finishTutorial() {

        SharedPreferences preferences =
                getSharedPreferences("my_preferences", MODE_PRIVATE);

        // Set onboarding_complete to true
        preferences.edit()
                .putBoolean("onboarding_complete",true).apply();

        // Launch the main Activity, called MainActivity
        Intent main = new Intent(this, ProfileActivity.class);
        startActivity(main);

        // Close the OnboardingActivity
        finish();


    }
}


