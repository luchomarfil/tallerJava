package ar.edu.unlp.hermesmarfiltibaldo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDao;
import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;

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
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("HERMES                                     AJUSTES ");


            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            List<String> spinnerArraySexo =  new ArrayList<String>();
            spinnerArraySexo.add("Femenino");
            spinnerArraySexo.add("Masculino");


            ArrayAdapter<String> adapterSexo = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, spinnerArraySexo);

            adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner sItemsS = (Spinner) findViewById(R.id.spinnerSexo);
            sItemsS.setAdapter(adapterSexo);

            List<String> spinnerArrayPictogramaTamanio =  new ArrayList<String>();
            spinnerArrayPictogramaTamanio.add("Grande");
            spinnerArrayPictogramaTamanio.add("Normal");

            ArrayAdapter<String> adapterPictoTamanio = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, spinnerArrayPictogramaTamanio);

            adapterPictoTamanio.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner sItemsT = (Spinner) findViewById(R.id.spinnerPictograma);
            sItemsT.setAdapter(adapterPictoTamanio);

            Alumno actual;
            if ((actual = HermesCore.instancia().getAlumnoActual()) != null) {

                ((EditText) findViewById(R.id.inputApellido)).setText(actual.getApellido());
                ((EditText) findViewById(R.id.inputNombre)).setText(actual.getNombre());
                sItemsS.setSelection(((actual.getSexo() == Alumno.MASCULINO) ? 1 : 0));
                sItemsT.setSelection(((actual.getTamanioPictograma() == Alumno.GRANDE) ? 0 : 1));

                List<Categoria> listC = HermesDao.instancia().getCategorias(actual);
                if (listC.contains(Categoria.getCategoriaEmociones())) {
                    ((CheckBox) findViewById(R.id.checkBoxEmociones)).setChecked(true);
                }
                if (listC.contains(Categoria.getCategoriaEstablo())) {
                    ((CheckBox) findViewById(R.id.checkBoxEstablo)).setChecked(true);
                }
                if (listC.contains(Categoria.getCategoriaNecesidades())) {
                    ((CheckBox) findViewById(R.id.checkBoxNecesidades)).setChecked(true);
                }
                if (listC.contains(Categoria.getCategoriaPista())) {
                    ((CheckBox) findViewById(R.id.checkBoxPista)).setChecked(true);
                }
            }
            ((EditText)findViewById(R.id.inputIP)).setText(HermesDao.instancia().getIP());
            ((EditText)findViewById(R.id.inputPuerto)).setText(HermesDao.instancia().getPortComunicadorJSON().toString());
        };


}