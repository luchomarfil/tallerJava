package ar.edu.unlp.hermesmarfiltibaldo.activityHelpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ar.edu.unlp.hermesmarfiltibaldo.AlumnoActivity;

/**
 * Created by luciano on 16/02/16.
 */
public abstract class SectionsPagerAdapterGeneric extends FragmentPagerAdapter {
    public SectionsPagerAdapterGeneric(FragmentManager fm) {
        super(fm);
    }

    abstract public int getCount();

    abstract public CharSequence getPageTitle(int position);

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        return AlumnoActivity.PlaceholderFragment.newInstance(position);
    }
}
