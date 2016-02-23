package ar.edu.unlp.hermesmarfiltibaldo.activityHelpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import ar.edu.unlp.hermesmarfiltibaldo.AlumnoActivity;

/**
 * Created by luciano on 16/02/16.
 */
public class SectionsPagerAdapterGeneric extends FragmentStatePagerAdapter{
    public SectionsPagerAdapterGeneric(FragmentManager fm) {
        super(fm);
    }

    public SectionsPagerStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SectionsPagerStrategy strategy) {
        this.strategy = strategy;
    }

    protected SectionsPagerStrategy strategy;

    public int getCount(){
        return this.strategy.getCount();
    }

    public CharSequence getPageTitle(int position){
        return this.strategy.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return AlumnoActivity.PlaceholderFragment.newInstance(position);
    }
}
