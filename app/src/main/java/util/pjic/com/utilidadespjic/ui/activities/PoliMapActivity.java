package util.pjic.com.utilidadespjic.ui.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class PoliMapActivity extends AppCompatActivity implements OnMapReadyCallback {

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
        LatLng centerPolyCamera = new LatLng(6.211096, -75.577191);
        mMap.addMarker(new MarkerOptions()
                .infoWindowAnchor(.6f, 1.0f)
                .position(uPoliLocation)
                .title("Tu posición")
                .snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(centerPolyCamera));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.5f ) );
        mMap.setMinZoomPreference(17.5f);
        mMap.setMinZoomPreference(17.5f);
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
        polygonP31.setTag("P31");

        Polygon polygonP36 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(new LatLng(6.21165, -75.57713),
                        new LatLng(6.2115, -75.57714),
                        new LatLng(6.21147, -75.57684),
                        new LatLng(6.21162, -75.57683)));
        polygonP36.setTag("P36");

        Polygon polygonP38 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21134,-75.57717),
                        new LatLng(6.2112,-75.57718),
                        new LatLng(6.21117,-75.57688),
                        new LatLng(6.21131,-75.57687)));
        polygonP38.setTag("P38");

        Polygon polygonP34 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21198,-75.5771),
                        new LatLng(6.21184,-75.57711),
                        new LatLng(6.21182,-75.57681),
                        new LatLng(6.21196,-75.5768)));
        polygonP34.setTag("P34");

        Polygon polygonP55 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21186, -75.57679),
                        new LatLng(6.21184, -75.5766),
                        new LatLng(6.21173, -75.57661),
                        new LatLng(6.21175, -75.5768)));
        polygonP55.setTag("P55");

        Polygon polygonP56 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21173, -75.57681),
                        new LatLng(6.21171, -75.57661),
                        new LatLng(6.21158, -75.57662),
                        new LatLng(6.2116, -75.57682)));
        polygonP56.setTag("P56");

        Polygon polygonP57 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21159, -75.57682),
                        new LatLng(6.21157, -75.57662),
                        new LatLng(6.21145, -75.57663),
                        new LatLng(6.21147, -75.57683)));
        polygonP57.setTag("P57");

        Polygon polygonP58 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21147, -75.57683),
                        new LatLng(6.21145, -75.57663),
                        new LatLng(6.21133, -75.57664),
                        new LatLng(6.21135, -75.57684)));
        polygonP58.setTag("P58");

        Polygon polygonP59 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21135, -75.57684),
                        new LatLng(6.21133, -75.57664),
                        new LatLng(6.21112, -75.57666),
                        new LatLng(6.21113, -75.57686)));
        polygonP59.setTag("P59");

        Polygon polygonP13 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21204,-75.57711),
                        new LatLng(6.21222,-75.57709),
                        new LatLng(6.21226,-75.57755),
                        new LatLng(6.21209,-75.57757)));
        polygonP13.setTag("P13");

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
        polygonP19.setTag("P19");

        Polygon polygonP40 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21073,-75.57727),
                        new LatLng(6.21063,-75.57728),
                        new LatLng(6.21063,-75.57727),
                        new LatLng(6.21053,-75.57728),
                        new LatLng(6.21053,-75.5773),
                        new LatLng(6.21044,-75.57731),
                        new LatLng(6.21038,-75.5768),
                        new LatLng(6.21046,-75.57679),
                        new LatLng(6.21046,-75.5768),
                        new LatLng(6.21058,-75.57679),
                        new LatLng(6.21057,-75.57675),
                        new LatLng(6.21068,-75.57674),
                        new LatLng(6.21069,-75.57683),
                        new LatLng(6.21068,-75.57684)

        ));
        polygonP40.setTag("P40");

        Polygon polygonP42 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(6.21186, -75.57679),
                        new LatLng(6.21184, -75.5766),
                        new LatLng(6.21173, -75.57661),
                        new LatLng(6.21175, -75.5768)));
        polygonP42.setTag("'P42");

        mMap.setOnPolygonClickListener(polygon -> {
            double[] centerPolygon = centroid(polygon.getPoints());
            LatLng centerPosition = new LatLng(centerPolygon[0], centerPolygon[1]);
            Marker markerForInfoWindow = null;
            String message;

            if (polygon.getId().equals(polygonP31.getId())) {
                message = "Bloque administrativo";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));
            } else if (polygon.getId().equals(polygonP36.getId())) {
                message = "Investigación y posgrados";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP38.getId())) {
                message = "Facultad de ciencias agrarias";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP34.getId())) {
                message = "Facultad de comunicación";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP55.getId())) {
                message = "CCNTROLES Automáticos";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP56.getId())) {
                message = "Servicios generales";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP57.getId())) {
                message = "Archivo y correspondencia";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP58.getId())) {
                message = "Fomento cultural";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            }  else if (polygon.getId().equals(polygonP59.getId())) {
                message = "Facultad de ciencias básicas";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP13.getId())) {
                message = "Facultad de administración";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP17.getId())) {
                message = "Facultad de ingenierias";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonPhotoCopy.getId())) {
                message = "";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP19.getId())) {
                message = "Bloque de profesores";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP40.getId())) {
                message = "BLOQUE CTIE (centro de tecnología, innovación y emprendimiento)";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            } else if (polygon.getId().equals(polygonP42.getId())) {
                message = "Facultad de educación fisica";
                markerForInfoWindow = mMap.addMarker(buildInfoWindowToPolygon(polygon, centerPosition, message));

            }
            markerForInfoWindow.showInfoWindow();
        });
    }

    @NonNull
    private MarkerOptions buildInfoWindowToPolygon(Polygon polygon, LatLng centerPosition, String message) {
        return new MarkerOptions()
                .alpha(0.0f)
                .infoWindowAnchor(.6f, 1.0f)
                .position(centerPosition)
                .title(Objects.requireNonNull(polygon.getTag()).toString())
                .snippet(message);
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
