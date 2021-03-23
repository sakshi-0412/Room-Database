package app.sakshi.userdeomo.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferenceManager {

    SharedPreferences moSharedPreferences;

    public SharedPreferenceManager(Context foContext) {
        moSharedPreferences = android.preference.PreferenceManager
                .getDefaultSharedPreferences(foContext.getApplicationContext());
    }

    public String getStatus() {
        if (moSharedPreferences != null) {
            return moSharedPreferences.getString("status", "");
        }
        return null;
    }

    public void setStatus(String status) {
        if (moSharedPreferences != null) {
            SharedPreferences.Editor loEditor = moSharedPreferences.edit();
            loEditor.putString("status", status);
            loEditor.commit();
        }
    }



}
