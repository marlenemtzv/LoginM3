package mx.edu.tesoem.loginm3;

import android.app.Application;
import com.google.android.material.color.DynamicColors;

public class LoginApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}