package ar.edu.unlp.hermesmarfiltibaldo.activityHelpers;

/**
 * Created by luciano on 17/02/16.
 */
public abstract class SectionsPagerStrategy {

    SectionsPagerAdapterGeneric owner;

    public abstract int getCount();
    public abstract CharSequence getPageTitle(int position);


}
