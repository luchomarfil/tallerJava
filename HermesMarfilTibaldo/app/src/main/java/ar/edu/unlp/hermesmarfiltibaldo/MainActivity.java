package ar.edu.unlp.hermesmarfiltibaldo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesConfiguration;
import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        HermesConfiguration.inicializar(this);

        setContentView(R.layout.activity_main);


        ListView lv = (ListView) findViewById(R.id.listView);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.


        ArrayAdapter<Alumno> arrayAdapter = new ArrayAdapter<Alumno>(
                this,
                R.layout.list_item_2,
                HermesCore.instancia().getAlumnos());

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickAlumno(position);
            }
        });
        TextView textViewNuevoAlumno = (TextView) findViewById(R.id.textView3);
        textViewNuevoAlumno.setOnTouchListener(new AdapterView.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                crearAlumno();
                return false;
            }
        });



    }

    /**
     * Cuando se selecciona el boton nuevo alumno, se crea el alumno y se va al
     * activity ajustes
     */

    protected void onResume(Bundle savedInstanceState) {
        ListView lv = (ListView) findViewById(R.id.listView);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.


        ArrayAdapter<Alumno> arrayAdapter = new ArrayAdapter<Alumno>(
                this,
                R.layout.list_item_2,
                HermesCore.instancia().getAlumnos());

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickAlumno(position);
            }
        });
    }

    private void crearAlumno(){
        HermesCore.instancia().setAlumnoActual(new Alumno());
        Intent i = new Intent(this, AjustesActivity.class);
        startActivity(i);
    }

    private void clickAlumno(int position) {
        HermesCore.instancia().setModoAlumno();
        ListView lv = (ListView) findViewById(R.id.listView);
        HermesCore.instancia().setAlumnoActual((Alumno) lv.getItemAtPosition(position));
        Intent i = new Intent(this, AlumnoActivity.class);
        startActivity(i);
    }
}
