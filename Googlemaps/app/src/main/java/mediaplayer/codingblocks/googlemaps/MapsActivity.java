package mediaplayer.codingblocks.googlemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        btn=(Button) findViewById(R.id.button_change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng delhiLoc=new LatLng(24,47);

        MarkerOptions delhiMarker=new MarkerOptions();
        delhiMarker.position(delhiLoc);
        delhiMarker.title("New delhi");
        mMap.addMarker(delhiMarker);

        CameraUpdate obj=CameraUpdateFactory.newLatLngZoom(delhiLoc,10);
        mMap.moveCamera(obj);

        LatLng myHome=new LatLng(100,100);
        LatLng codingBlocks=new LatLng(200,200);
        LatLng temp=new LatLng(300,300);
        Polyline polyLine=googleMap.addPolyline(new PolylineOptions().add(myHome,temp,codingBlocks)).setClickable(false);


        // Animation with motion
        // This integer is speed of marker
        // Mandatory Callbacks if speed justified
        /*
        mMap.animateCamera(obj, 10, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancel() {

            }
        });
        */
    }
}
