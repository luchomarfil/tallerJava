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
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return HermesCore.instancia().getAlumnoActual().getNombre();
        }
        return null;
    }
}
