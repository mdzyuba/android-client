package com.mifos.mifosxdroid.online;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.mifos.mifosxdroid.SplashScreenActivity;
import com.mifos.objects.User;

/**
 * Logout activity.
 */
public class LogoutActivity extends ActionBarActivity {
    public final static String TAG = LogoutActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logout(this);
    }

    public void logout(Context context) {
        Log.d(TAG, "logout");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(User.AUTHENTICATION_KEY, "NA");
        editor.commit();
        editor.apply();
        startActivity(new Intent(LogoutActivity.this, SplashScreenActivity.class));
    }
}
