package co.perfectnight.perfectnight.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import co.perfectnight.perfectnight.R;
import co.perfectnight.perfectnight.fragment.WelcomeFragment;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction().add(R.id.fragment_container, WelcomeFragment.newInstance()).commit();
    }

}
