package ar.edu.unlp.hermesmarfiltibaldo.activityHelpers;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapterModoAlumno extends SectionsPagerStrategy {


    @Override
    public int getCount() {
        // Show 1 total pages.
        return HermesCore.instancia().getAlumnoActual().getCategorias().size()+1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                if (this.getCount()>1)
                {return HermesCore.instancia().getAlumnoActual().getCategorias().get(0).getNombre();}
                else
                {return HermesCore.instancia().getAlumnoActual().getNombre();}
            case 1:
                if (this.getCount()>2)
                {return HermesCore.instancia().getAlumnoActual().getCategorias().get(1).getNombre();}
                else
                {return HermesCore.instancia().getAlumnoActual().getNombre();}
            case 2:
                if (this.getCount()>3)
                {return HermesCore.instancia().getAlumnoActual().getCategorias().get(2).getNombre();}
                else
                {return HermesCore.instancia().getAlumnoActual().getNombre();}
            case 3:
                if (this.getCount()>4)
                {return HermesCore.instancia().getAlumnoActual().getCategorias().get(3).getNombre();}
                else
                {return HermesCore.instancia().getAlumnoActual().getNombre();}
            case 4:
                return HermesCore.instancia().getAlumnoActual().getNombre();
        }
        return null;
    }
}
