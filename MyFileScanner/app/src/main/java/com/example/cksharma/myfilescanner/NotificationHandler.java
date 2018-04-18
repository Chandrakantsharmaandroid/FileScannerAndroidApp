package com.example.cksharma.myfilescanner;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.RemoteViews;


import java.util.HashMap;
import java.util.Map;

public class NotificationHandler {

    private static NotificationHandler sNotificationHandler = new NotificationHandler();

    public static NotificationHandler getInstance(){return sNotificationHandler;}

    private Map<Integer,String> notifications;

    private NotificationHandler(){
        notifications = new HashMap<>();
    }

    public void initialize(int id,String message,Context context){
        notifications.put(id, message);

        Intent intent = new Intent(context,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP); //No need to create back stack since there is only 1 activity running at all times.
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        Notification notification = mBuilder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.file_scane)
                .setAutoCancel(false)
                .build();

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.progress_notification);
        remoteViews.setTextViewText(R.id.message, message);
        remoteViews.setProgressBar(R.id.progressBar,0,0,true);
        notification.contentView = remoteViews;




        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id,notification);

    }

    public void updateMessage(int id,String message,Context context){
        notifications.put(id,message);
        initialize(id,message,context);


    }

    public void remove(int id){
        notifications.remove(id);
    }


}
