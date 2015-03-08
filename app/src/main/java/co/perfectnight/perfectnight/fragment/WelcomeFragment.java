package co.perfectnight.perfectnight.fragment;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import co.perfectnight.perfectnight.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class WelcomeFragment extends Fragment {

    private ImageView mFacebookLoginButton;
    private ImageView mEmailLoginButton;

    public static WelcomeFragment newInstance() {
        return new WelcomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        hideStatusBar();

        mFacebookLoginButton = (ImageView) view.findViewById(R.id.facebook_login_button);
        mEmailLoginButton = (ImageView) view.findViewById(R.id.email_login_button);

        mFacebookLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Coming next Startup Weekend...", Toast.LENGTH_SHORT).show();
            }
        });

        mEmailLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getFragmentManager().beginTransaction().replace(R.id.fragment_container, LoginFragment.newInstance()).commit();
            }
        });

        return view;
    }

    private void hideStatusBar() {
        ((ActionBarActivity) getActivity()).getSupportActionBar().hide();
    }

}
