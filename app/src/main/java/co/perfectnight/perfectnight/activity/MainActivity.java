package co.perfectnight.perfectnight.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import co.perfectnight.perfectnight.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class MainActivity extends ActionBarActivity {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mSignUpButton;
    private Button mLoginButton;
    private TextView mErrorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        mEmailEditText = (EditText) findViewById(R.id.email_edittext);
        mPasswordEditText = (EditText) findViewById(R.id.password_edittext);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mErrorText = (TextView) findViewById(R.id.error_text);

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
                // go to first page of app.
            }
        });
    }

    private void login(String email, String password) {
        ParseUser.logInInBackground(email, password, new LogInCallback() {
            @Override
            public void done(final ParseUser parseUser, ParseException e) {
                if (parseUser != null) {
                    // go to first page of app.
                } else {
                    setLoginError();
                }
            }
        });
    }

    private void setLoginError() {
        mErrorText.setText("Looks like you don't have an account. Try Sign up instead.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
