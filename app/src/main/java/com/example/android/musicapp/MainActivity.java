package com.example.android.musicapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // What to do when the user clicks the button of play music at activity main
        Button playMusicNow = (Button) findViewById(R.id.button1MA);

        playMusicNow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(MainActivity.this, ChoosePlaystyle.class);

                // Start the new activity
                startActivity(nowPlayingIntent);
            }
        });

        // What to do when the user clicks the button of live search at activity main
        // At first we will open soundhound application. If it does not exist a toast message will be pooped
        Button liveSearch = (Button) findViewById(R.id.button2MA);

        liveSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PackageManager pm = getPackageManager();
                String targetPackage = "com.melodis.midomiMusicIdentifier.freemium";

                if (isPackageExisted(targetPackage)) {
                    Intent intent = pm.getLaunchIntentForPackage(targetPackage);
                    startActivity(intent);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Download Soundhound";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }

        });


        // What to do when the user clicks the button of play music at activity main
        Button donate = (Button) findViewById(R.id.button3MA);

        donate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(MainActivity.this, Payment.class);

                // Start the new activity
                startActivity(nowPlayingIntent);
            }
        });

    }

    // here it is checked if the package of soundhound exists
    public boolean isPackageExisted(String targetPackage) {
        PackageManager pm = getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }

}
