package co.perfectnight.perfectnight.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import co.perfectnight.perfectnight.R;
import co.perfectnight.perfectnight.vo.User;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Push up simple object.
        ParseObject parseTestObject = new ParseObject("TestObject");
        parseTestObject.put("foo", "bar");
        parseTestObject.saveInBackground();

        // Nested object example.
        final ParseObject nestedObject = new ParseObject("OuterNest");
        ParseObject innerObject = new ParseObject("InnerObject");
        nestedObject.put("testOuter", true);
        innerObject.put("somethingInner", 10L);
        nestedObject.put("Inner", innerObject);

        final User user = new User();
        nestedObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                user.setParseObjectId(nestedObject.getObjectId());

                // Retrieve data.
                ParseQuery<ParseObject> query = ParseQuery.getQuery("OuterNest");
                query.getInBackground(user.getParseObjectId(), new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject parseObject, ParseException e) {
                        Log.d("perfectNight", parseObject.getParseObject("Inner") + "");
                    }
                });
            }
        });
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
