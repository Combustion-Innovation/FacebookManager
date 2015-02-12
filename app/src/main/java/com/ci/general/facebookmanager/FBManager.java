package com.ci.general.facebookmanager;

/**
 * Created by Alex on 12/3/14.
 * FBManager is a login utility class that makes it easy to reuse Facebook code.
 */
public class FBManager {
    private static final String TAG = "FBManager";

    /**
     * Before using this API: https://github.com/Combustion-Innovation/general-classes/wiki/Facebook-Login-Requirements
     * API info: https://github.com/Combustion-Innovation/general-classes/wiki/Facebook-Login-API
     * 
     * @return
     */
    public static FBFragment getFBLogin(int id) {
        FBFragment fbFragment = new FBFragment();
        fbFragment.setViewId(id);
        return fbFragment;
    }
}
