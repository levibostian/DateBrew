package co.perfectnight.perfectnight.application;

import android.app.Application;
import com.parse.Parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PerfectNightApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);

        try {
            InputStream stream = getAssets().open("parse-creds.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String id = reader.readLine();
            String key = reader.readLine();

            Parse.initialize(this, id, key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
