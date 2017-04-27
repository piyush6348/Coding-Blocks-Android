package firebase.codingblocks.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by dell on 4/27/2017.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        //if(remoteMessage.)
        Log.e("onMessageReceived: ",remoteMessage.getMessageId()+" " );
        Log.e("onMessageReceived: ", remoteMessage.getData().toString() +" ");
        Log.e("onMessageReceived: ", remoteMessage.getNotification().getTitle()+" ");

        Notification.Builder notifybldr=new Notification.Builder(this);
        notifybldr.setContentTitle("ForeGround");
        notifybldr.setContentText("Body");
        notifybldr.setSmallIcon(R.mipmap.ic_launcher);

        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(111,notifybldr.build());
    }
}
