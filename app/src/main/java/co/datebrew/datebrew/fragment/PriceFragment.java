package co.datebrew.datebrew.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import co.datebrew.datebrew.R;

public class PriceFragment extends Fragment {

    private ImageView mLowestPriceButton;
    private ImageView mMediumPriceButton;
    private ImageView mExpensivePriceButton;

    public static PriceFragment newInstance() {
        return new PriceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_price, container, false);

        setHasOptionsMenu(true);
        showActionBar();

        mLowestPriceButton = (ImageView) view.findViewById(R.id.lowest_price_button);
        mMediumPriceButton = (ImageView) view.findViewById(R.id.medium_price_button);
        mExpensivePriceButton = (ImageView) view.findViewById(R.id.expensive_price_button);

        mLowestPriceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateFragment(DateFragment.newInstance());
            }
        });
        mMediumPriceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateFragment(DateFragment.newInstance());
            }
        });
        mExpensivePriceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateFragment(DateFragment.newInstance());
            }
        });

        return view;
    }

    private void showDateFragment(Fragment fragment) {
        getActivity().getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
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

    private void showActionBar() {
        ((ActionBarActivity) getActivity()).getSupportActionBar().show();
    }

}
