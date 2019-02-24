package util.pjic.com.utilidadespjic.ui.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.List;
import java.util.Objects;

import util.pjic.com.utilidadespjic.R;

public class PoliMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poli_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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
        LatLng uPoliLocation = new LatLng(6.211476, -75.577522);
        LatLng centerPolyCamera = new LatLng(6.211776, -75.577037);
        mMap.addMarker(new MarkerOptions().position(uPoliLocation).title("Yo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(centerPolyCamera));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 18f ) );
        mMap.setMinZoomPreference(18f);
        mMap.setMinZoomPreference(18f);
        mMap.getUiSettings().setScrollGesturesEnabled(false);
        mMap.getUiSettings().setScrollGesturesEnabled(false);
        mMap.setInfoWindowAdapter(new CustomInfoWindowsAdapter(PoliMapActivity.this));


        Polygon polygonP31 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21266,-75.577),
                        new LatLng(6.21226,-75.57704),
                        new LatLng(6.21222,-75.57664),
                        new LatLng(6.21263,-75.5766)));
        polygonP31.setTag("'P31");

        Polygon polygonStudyZone1 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21266,-75.577),
                        new LatLng(6.21226,-75.57704),
                        new LatLng(6.21222,-75.57664),
                        new LatLng(6.21263,-75.5766)));
        polygonStudyZone1.setTag("'Zona de estudio los Naranjos");

        Polygon polygonStudyZone2 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21266,-75.577),
                        new LatLng(6.21226,-75.57704),
                        new LatLng(6.21222,-75.57664),
                        new LatLng(6.21263,-75.5766)));
        polygonStudyZone2.setTag("'Zona de estudio las palmeras");

        Polygon polygonStudyZone3 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21266,-75.577),
                        new LatLng(6.21226,-75.57704),
                        new LatLng(6.21222,-75.57664),
                        new LatLng(6.21263,-75.5766)));
        polygonStudyZone3.setTag("'Zona de estudio los almendros");

        Polygon polygonP17 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.211561, -75.577684),
                        new LatLng(6.211502, -75.577158),
                        new LatLng(6.211340, -75.577175),
                        new LatLng(6.211397, -75.577702)));
        polygonP17.setTag("P17");

        Polygon polygonPhotoCopy = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21131,-75.57737),
                        new LatLng(6.21131,-75.57731),
                        new LatLng(6.21125,-75.57731),
                        new LatLng(6.21126,-75.57737)));
        polygonPhotoCopy.setTag("Fotocopiadoras y cafeteria");

        Polygon polygonP19 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21116,-75.57772),
                        new LatLng(6.21114,-75.57743),
                        new LatLng(6.21106,-75.57744),
                        new LatLng(6.21104,-75.57721),
                        new LatLng(6.2109,-75.57722),
                        new LatLng(6.21092,-75.57746),
                        new LatLng(6.21071,-75.57748),
                        new LatLng(6.21072,-75.57762),
                        new LatLng(6.21093,-75.5776),
                        new LatLng(6.21094,-75.57774)

        ));
        polygonP19.setTag("'P19");

        Polygon polygonP13 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21204,-75.57711),
                        new LatLng(6.21222,-75.57709),
                        new LatLng(6.21226,-75.57755),
                        new LatLng(6.21209,-75.57757)));
        polygonP13.setTag("P13");

        mMap.setOnPolygonClickListener(polygon -> {
            double[] centerPolygon = centroid(polygon.getPoints());
            LatLng centerPosition = new LatLng(centerPolygon[0], centerPolygon[1]);
            Marker markerForInfoWindow;
            if (polygon.getId().equals(polygonP17.getId())) {
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition));
                markerForInfoWindow.showInfoWindow();
            } else if (polygon.getId().equals(polygonP13.getId())) {
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition));
                markerForInfoWindow.showInfoWindow();
            }
        });
    }

    @NonNull
    private MarkerOptions buildInfoWindowToPolygon(Polygon polygon, LatLng centerPosition) {
        return new MarkerOptions()
                .alpha(0.0f)
                .infoWindowAnchor(.6f, 1.0f)
                .position(centerPosition)
                .title(Objects.requireNonNull(polygon.getTag()).toString())
                .snippet("En este bloque hay\n eto");
    }

    private static double[] centroid(List<LatLng> points) {
        double[] centroid = { 0.0, 0.0 };
        for (LatLng point : points) {
            centroid[0] += point.latitude;
            centroid[1] += point.longitude;
        }

        int totalPoints = points.size();
        centroid[0] = centroid[0] / totalPoints;
        centroid[1] = centroid[1] / totalPoints;

        return centroid;
    }

    private class CustomInfoWindowsAdapter implements GoogleMap.InfoWindowAdapter {

        private final View mWindow;
        private Context mContext;

        CustomInfoWindowsAdapter(Context context) {
            this.mContext = context;
            this.mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
        }

        private void rendowWindowText(Marker marker, View view) {
            String title = marker.getTitle();
            TextView textTitle = view.findViewById(R.id.title);

            if (!title.equals("")) {
                textTitle.setText(title);
            }

            String snippet = marker.getSnippet();
            TextView textSnippet = view.findViewById(R.id.snippet);

            if (!snippet.equals("")) {
                textSnippet.setText(snippet);
            }
        }

        @Override
        public View getInfoWindow(Marker marker) {
            rendowWindowText(marker, mWindow);
            return mWindow;
        }

        @Override
        public View getInfoContents(Marker marker) {
            rendowWindowText(marker, mWindow);
            return mWindow;
        }
    }
}
