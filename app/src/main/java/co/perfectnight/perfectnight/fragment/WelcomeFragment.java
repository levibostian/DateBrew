package co.perfectnight.perfectnight.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import co.perfectnight.perfectnight.R;

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
                getActivity().getFragmentManager().beginTransaction().setCustomAnimations(R.animator.slide_in_left,
                                                                                          R.animator.slide_out_right,
                                                                                          0,0).replace(R.id.fragment_container, LoginFragment.newInstance()).commit();
            }
        });

        return view;
    }

    private void hideStatusBar() {
        ((ActionBarActivity) getActivity()).getSupportActionBar().hide();
    }

}
