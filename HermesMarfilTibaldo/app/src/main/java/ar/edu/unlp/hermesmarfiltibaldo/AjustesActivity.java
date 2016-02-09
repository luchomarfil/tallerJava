package ar.edu.unlp.hermesmarfiltibaldo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;

/**
 * Created by Agustín on 2/8/2016.
 */
public class AjustesActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ajustes);


            /*textViewNuevoAlumno.setOnTouchListener(new AdapterView.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    crearAlumno();
                    return true;
                }
            });*/
            TextView textViewElimAlumno = (TextView) findViewById(R.id.elimAlumno);
    textViewElimAlumno.setOnTouchListener(new AdapterView.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            HermesCore.instancia().deleteAlumnoActual();
            return false;
        }
    });

        };

}