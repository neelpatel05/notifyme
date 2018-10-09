package com.neelpatel.notifyme;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.neelpatel.notifyme.R.mipmap.app_icon;

public class MainActivity extends AppCompatActivity {

    String channel_id="Notification Id";
    String channel_name="Notify Me";
    NotificationManager manager;
    Button notifyme;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifyme=(Button)findViewById(R.id.notifyme);
        text=(EditText)findViewById(R.id.notifytext);



        notifyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text1=text.getText().toString();
                Notification.Builder builder= new Notification.Builder(getApplicationContext(),channel_id)
                        .setContentText(text1)
                        .setSmallIcon(R.drawable.ic_stat_name)
                        .setColor(Color.GREEN)
                        .setAutoCancel(false);


                NotificationChannel mychannel = new NotificationChannel(channel_id,channel_name, NotificationManager.IMPORTANCE_HIGH);
                mychannel.enableLights(true);
                mychannel.enableVibration(true);
                mychannel.setLightColor(Color.GREEN);

                mychannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
                if(manager==null)
                    manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                manager.createNotificationChannel(mychannel);

                manager.notify(new Random().nextInt(),builder.build());

            }
        });

    }
}
