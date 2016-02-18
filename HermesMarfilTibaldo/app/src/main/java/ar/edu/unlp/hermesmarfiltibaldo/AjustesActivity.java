package ar.edu.unlp.hermesmarfiltibaldo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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
import java.util.logging.Logger;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDao;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDaoDB;
import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;

/**
 * Created by Agustín on 2/8/2016.
 */
public class AjustesActivity extends AppCompatActivity {
        private EditText editTextIp;
        private EditText editTextPort;
        private EditText inputApellido;
        private EditText inputNombre;
        private Spinner  sItemsS;
        private Spinner  sItemsT;
        private List<Categoria> listC;

        private Logger logger = Logger.getLogger(AjustesActivity.class.getName());
    @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ajustes);



            TextView textViewElimAlumno = (TextView) findViewById(R.id.elimAlumno);
            textViewElimAlumno.setOnTouchListener(new AdapterView.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    HermesCore.instancia().deleteAlumnoActual();
                    return true;
                }
            });
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("HERMES                                     AJUSTES ");



            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            List<String> spinnerArraySexo =  new ArrayList<String>();
            spinnerArraySexo.add(Alumno.FEMENINO);
            spinnerArraySexo.add(Alumno.MASCULINO);


            ArrayAdapter<String> adapterSexo = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, spinnerArraySexo);

            adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sItemsS = (Spinner) findViewById(R.id.spinnerSexo);
            sItemsS.setAdapter(adapterSexo);

            List<String> spinnerArrayPictogramaTamanio =  new ArrayList<String>();
            spinnerArrayPictogramaTamanio.add(Alumno.GRANDE);
            spinnerArrayPictogramaTamanio.add(Alumno.NORMAL);

            ArrayAdapter<String> adapterPictoTamanio = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, spinnerArrayPictogramaTamanio);

            adapterPictoTamanio.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sItemsT = (Spinner) findViewById(R.id.spinnerPictograma);
            sItemsT.setAdapter(adapterPictoTamanio);

            editTextIp = (EditText)findViewById(R.id.inputIP);
            editTextPort = ((EditText)findViewById(R.id.inputPuerto));
            inputApellido = ((EditText) findViewById(R.id.inputApellido));
            inputNombre = ((EditText) findViewById(R.id.inputNombre));

            Alumno actual = HermesCore.instancia().getAlumnoActual();
            //si el alumno es un alumno ya existente completo los campos



            if ( actual.getId() != null) {

                inputApellido.setText(actual.getApellido());
                inputNombre.setText(actual.getNombre());
                sItemsS.setSelection(((actual.getSexo().equals(Alumno.MASCULINO)) ? 1 : 0));
                sItemsT.setSelection(((actual.getTamanioPictograma().equals(Alumno.GRANDE)) ? 0 : 1));

                listC = HermesCore.instancia().getCategorias(actual);

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

            editTextIp.setText(HermesCore.instancia().getIP());
            editTextPort.setText(HermesCore.instancia().getPortComunicadorJSON());
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            guardarInformacion();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        guardarInformacion();
    }

    private void guardarInformacion() {
        logger.info("Guardando la informacion del alumno");
        Boolean alumnoNuevo = HermesCore.instancia().getAlumnoActual().getId() == null;

        prepararAlumnoSegunInterface();
        //si es alumno ya creado, lo actualizo
        if(!alumnoNuevo){
            logger.info("Es un alumno ya existente, se actualiza");
            HermesCore.instancia().updateAlumno(HermesCore.instancia().getAlumnoActual());
        }
        //si es aluno nuevo, lo creo en la base de datos
        else{
            logger.info("Es un alumno nuevo, se crea");
            if(alumnoTieneNombreApellido()) {
                HermesCore.instancia().createNewAlumno(HermesCore.instancia().getAlumnoActual());
            }
            else{
                logger.warning("El alumno no tiene ni nombre ni apellido, no se guarda");
            }
        }
        logger.info("Guardando configuracion general");
        HermesCore.instancia().updateConfiguracion(editTextIp.getText().toString(), editTextPort.getText().toString());

    }

    /**
     * Este metodo actualiza el estado del alumno en base a lo seleccionado en la interface
     */
    private void prepararAlumnoSegunInterface() {
        Alumno a = HermesCore.instancia().getAlumnoActual();
        List<Categoria> categorias = preprarCategoriasSegunInterface();

        a.setSexo((String) sItemsS.getSelectedItem());
        a.setNombre(inputNombre.getText().toString());
        a.setApellido(inputApellido.getText().toString());
        a.setTamanioPictograma((String) sItemsT.getSelectedItem());
        a.setCategorias(categorias);
    }

    private List<Categoria> preprarCategoriasSegunInterface() {
        List<Categoria> cats = new ArrayList<>();

         Boolean emociones = ((CheckBox) findViewById(R.id.checkBoxEmociones)).isChecked();
         if(emociones) {
             cats.add(Categoria.getCategoriaEmociones());
         }
         Boolean establo = ((CheckBox) findViewById(R.id.checkBoxEstablo)).isChecked();
         if(establo){
             cats.add(Categoria.getCategoriaEstablo());
         }
         if(((CheckBox) findViewById(R.id.checkBoxNecesidades)).isChecked()){
             cats.add(Categoria.getCategoriaNecesidades());
         }
         if(((CheckBox) findViewById(R.id.checkBoxPista)).isChecked()){
             cats.add(Categoria.getCategoriaPista());
         }

        return cats;
    }

    private boolean alumnoTieneNombreApellido() {
        return inputApellido.getText() !=null && !inputApellido.getText().toString().trim().equals("")
                && inputNombre.getText() !=null && !inputNombre.getText().toString().trim().equals("");
    }
}