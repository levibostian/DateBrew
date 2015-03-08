package co.perfectnight.perfectnight.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import co.perfectnight.perfectnight.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginFragment extends Fragment {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mSignUpButton;
    private Button mLoginButton;
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
        mSignUpButton = (Button) view.findViewById(R.id.sign_up_button);
        mLoginButton = (Button) view.findViewById(R.id.login_button);
        mErrorText = (TextView) view.findViewById(R.id.error_text);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
                clearErrors();
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
            }
        });

        return view;
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