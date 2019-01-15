package util.pjic.com.utilidadespjic.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import util.pjic.com.utilidadespjic.MainActivity;
import util.pjic.com.utilidadespjic.R;
import util.pjic.com.utilidadespjic.utils.PrefManager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
       // final PrefManager prefManager = new PrefManager(WelcomeActivity.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               // if (prefManager.seMostraraIntro() == true && prefManager.seMostraraSesion() == true) {
                    startActivity(new Intent(WelcomeActivity.this, IntroductionActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
               // }else if (prefManager.seMostraraIntro() == false && prefManager.seMostraraSesion() == false) {
                  //  startActivity(new Intent(WelcomeActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
              //  }
            }
        }, 3000);
    }
}
