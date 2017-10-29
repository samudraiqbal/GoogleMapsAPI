package id.sch.smktelkom_mlg.learn.samudraiqbal.googlemaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition INDONESIA = CameraPosition.builder()
            .target(new LatLng(-6.175392, 106.827178))
            .zoom(17)
            .bearing(295)
            .tilt(90)
            .build();
    static final CameraPosition US = CameraPosition.builder()
            .target(new LatLng(38.897678, -77.036477))
            .zoom(16)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition AUSTRALIA = CameraPosition.builder()
            .target(new LatLng(-33.856820, 151.215279))
            .zoom(16)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition FRANCE = CameraPosition.builder()
            .target(new LatLng(48.858270, 2.294509))
            .zoom(16)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAustralia = (Button) findViewById(R.id.btnAustralia);
        btnAustralia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(AUSTRALIA);
            }
        });

        Button btnFrance = (Button) findViewById(R.id.btnFrance);
        btnFrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(FRANCE);
            }
        });

        Button btnUnited = (Button) findViewById(R.id.btnUnited);
        btnUnited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(US);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(INDONESIA);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}