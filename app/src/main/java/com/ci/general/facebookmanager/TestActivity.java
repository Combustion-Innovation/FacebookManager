package com.ci.general.facebookmanager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.facebook.Response;
import com.facebook.model.GraphUser;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 2/7/15.
 */
public class TestActivity extends FragmentActivity {
    public final static String TAG = "TestActivity";

    private FBFragment fbFragment;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_test);

        fbFragment = FBManager.getFBLogin(R.id.fb_login_button);
        if (savedInstance == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fb_container, fbFragment)
                    .commit();
        } else {
            // Or set the fragment from restored state info
            fbFragment = (FBFragment) getSupportFragmentManager()
                    .findFragmentById(android.R.id.content);
        }

        List permissions = Arrays.asList("email", "user_friends");
        Log.d(TAG, permissions.toString());
        fbFragment.setPermissions(permissions);
        fbFragment.setCallback(new GenericCallback<Void, Void, Object>() {
            @Override
            public void onStart(Void o) {

            }

            @Override
            public void onProgress(Void o) {

            }

            @Override
            public void onEnd(Object... o) {
                GraphUser user = (GraphUser) o[0];
                Response response = (Response) o[1];

                Log.d(TAG, user.getName());
                logout();
            }
        });
    }

    private void logout() {
        fbFragment.logout(getApplicationContext());
    }
}
