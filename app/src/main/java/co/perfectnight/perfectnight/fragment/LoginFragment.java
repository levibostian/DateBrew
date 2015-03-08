package co.perfectnight.perfectnight.fragment;

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
import co.perfectnight.perfectnight.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginFragment extends Fragment {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private ImageView mSignUpButton;
    private ImageView mLoginButton;
    private TextView mErrorText;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mEmailEditText = (EditText) view.findViewById(R.id.email_edittext);
        mPasswordEditText = (EditText) view.findViewById(R.id.password_edittext);
        mSignUpButton = (ImageView) view.findViewById(R.id.signup_button);
        mLoginButton = (ImageView) view.findViewById(R.id.login_button);
        mErrorText = (TextView) view.findViewById(R.id.error_text);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                signUp(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
                clearErrors();
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                login(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
            }
        });

        return view;
    }

    private void hideKeyboard() {
        ((InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mPasswordEditText.getWindowToken(), 0);
    }

    private void clearErrors() {
        mErrorText.setText("");
    }

    private void signUp(String email, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(email);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                getActivity().getFragmentManager().beginTransaction().replace(R.id.fragment_container, PriceFragment.newInstance()).commit();
            }
        });
    }

    private void login(String email, String password) {
        ParseUser.logInInBackground(email, password, new LogInCallback() {
            @Override
            public void done(final ParseUser parseUser, ParseException e) {
                if (parseUser != null) {
                    getActivity().getFragmentManager().beginTransaction().replace(R.id.fragment_container, PriceFragment.newInstance()).commit();
                } else {
                    setLoginError();
                }
            }
        });
    }

    private void setLoginError() {
        mErrorText.setText("Looks like you don't have an account. Try Sign up instead.");
    }
}
