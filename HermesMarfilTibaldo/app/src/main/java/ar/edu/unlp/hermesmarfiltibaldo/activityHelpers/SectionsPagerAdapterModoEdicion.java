package ar.edu.unlp.hermesmarfiltibaldo.activityHelpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ar.edu.unlp.hermesmarfiltibaldo.AlumnoActivity;
import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapterModoEdicion extends SectionsPagerStrategy {


    @Override
    public int getCount() {
        // Show 1 total pages.
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Pista";
            case 1:
                return "Establo";
            case 2:
                return "Necesidad";
            case 3:
                return "Emociones";
            case 4:
                return HermesCore.instancia().getAlumnoActual().getNombre();
        }
        return null;
    }
}
