package co.perfectnight.perfectnight.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import co.perfectnight.perfectnight.R;

public class PriceFragment extends Fragment {

    private Button mLowestPriceButton;
    private Button mMediumPriceButton;
    private Button mExpensivePriceButton;

    public static PriceFragment newInstance() {
        return new PriceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_price, container, false);

        setHasOptionsMenu(true);

        mLowestPriceButton = (Button) view.findViewById(R.id.lowest_price_button);
        mMediumPriceButton = (Button) view.findViewById(R.id.medium_price_button);
        mExpensivePriceButton = (Button) view.findViewById(R.id.expensive_price_button);

        mLowestPriceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show lowest price option
            }
        });
        mMediumPriceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show medium price option
            }
        });
        mExpensivePriceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show expensive price option
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            getActivity().getFragmentManager().beginTransaction().replace(R.id.fragment_container, WelcomeFragment.newInstance()).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
