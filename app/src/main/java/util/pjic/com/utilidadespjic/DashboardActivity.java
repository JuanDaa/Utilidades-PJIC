package util.pjic.com.utilidadespjic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import util.pjic.com.utilidadespjic.R;
import util.pjic.com.utilidadespjic.ui.activities.CalculateNotesActivity;
import util.pjic.com.utilidadespjic.ui.activities.PoliMapActivity;

public class DashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        CardView cardCalculate = findViewById(R.id.cardCalculate);
        CardView cardPlaces = findViewById(R.id.cardPlaces);
        cardCalculate.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), CalculateNotesActivity.class)));
        cardPlaces.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), PoliMapActivity.class)));
    }
}
