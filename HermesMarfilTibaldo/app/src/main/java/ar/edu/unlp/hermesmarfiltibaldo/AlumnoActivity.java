package ar.edu.unlp.hermesmarfiltibaldo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.GridView;
import android.widget.ImageButton;

import java.util.logging.Logger;

import ar.edu.unlp.hermesmarfiltibaldo.activityHelpers.SectionsPagerAdapterGeneric;
import ar.edu.unlp.hermesmarfiltibaldo.activityHelpers.SectionsPagerAdapterModoAlumno;
import ar.edu.unlp.hermesmarfiltibaldo.activityHelpers.SectionsPagerAdapterModoEdicion;
import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

public class AlumnoActivity extends AppCompatActivity {

    private static Logger logger = Logger.getLogger(AlumnoActivity.class.getName());
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapterGeneric mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        logger.info("Creando activity AlumnoActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("HERMES                                      " + HermesCore.instancia().getAlumnoActual().toString());

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recrearSolapas();

        ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        final Pictograma p = HermesCore.instancia().getPictogramaPorNombre("emociones/Si.png");
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HermesCore.instancia().playAudio(p, getApplicationContext());
                //HermesCore.instancia().comunicarNotificacion(p);
            }
        });

        ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
        final Pictograma p2 = HermesCore.instancia().getPictogramaPorNombre("emociones/No.png");
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HermesCore.instancia().playAudio(p2,getApplicationContext());
                //HermesCore.instancia().comunicarNotificacion(p2);
            }
        });
        logger.info("Informacion del alumno actual");
        logger.info("Alumno actual:"+HermesCore.instancia().getAlumnoActual().descripcion());
    }

    private void recrearSolapas() {
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapterGeneric(getSupportFragmentManager());
        crearEstrategiaSegunModo(mSectionsPagerAdapter);
        // Set up the ViewPager with the sections adapter.

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    private void crearEstrategiaSegunModo(SectionsPagerAdapterGeneric mSectionsPagerAdapter) {

        if(HermesCore.instancia().isModoAjuste()){
            mSectionsPagerAdapter.setStrategy(new SectionsPagerAdapterModoEdicion());
        }
        else{
            mSectionsPagerAdapter.setStrategy(new SectionsPagerAdapterModoAlumno());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alumno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Acá tenemos que configurar qué pasa cuando hacemos click en los botones del menue
        if (id == R.id.modo_edicion) {
            if (item.getTitle().equals("Modo Edición")) {
                HermesCore.instancia().setModoAjuste();
                item.setTitle("Modo Alumno");
                recrearSolapas();

            } else {
                HermesCore.instancia().setModoAlumno();
                item.setTitle("Modo Edición");
                recrearSolapas();

            }

        }

        if (id == R.id.ajustes) {
            Intent i = new Intent(this, AjustesActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        protected int number;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            fragment.number = sectionNumber;
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.fragment_alumno,container,false);
            GridView gridView = (GridView) view.findViewById(R.id.gridView);
            ImageAdapterGeneric im = new ImageAdapterGeneric(view.getContext(),number,crearEstrategiaSegunModo());
            gridView.setAdapter(im);
            return view;
        }

        @NonNull
        private ImageAdapterStrategy crearEstrategiaSegunModo() {
            if(HermesCore.instancia().isModoAjuste()){
                return new ImageAdapterModoEdicion();
            }
            else{
                return new ImageAdapterModoAlumno();
            }

        }
    }

}
