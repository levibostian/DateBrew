package co.datebrew.datebrew.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import co.datebrew.datebrew.R;

public class DateFragment extends Fragment {

    private ImageView mDateImageView;
    private ImageView mBookItButton;
    private LinearLayout mBookItContainer;
    private LinearLayout mBrewedContainer;

    private static final int DATE_BACK = R.drawable.date_card_back;
    private static final int DATE_FRONT = R.drawable.date_card;
    private boolean mIsDateCardFront = true;

    public static DateFragment newInstance() {
        return new DateFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date, container, false);

        setHasOptionsMenu(true);

        mDateImageView = (ImageView) view.findViewById(R.id.date_imageview);
        mBookItButton = (ImageView) view.findViewById(R.id.book_it_button);
        mBookItContainer = (LinearLayout) view.findViewById(R.id.book_it_container);
        mBrewedContainer = (LinearLayout) view.findViewById(R.id.brewed_container);
        mDateImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDateDetails();
            }
        });
        mBookItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookDate();
            }
        });

        return view;
    }

    private void toggleDateDetails() {
        mDateImageView.setImageResource(mIsDateCardFront ? DATE_BACK : DATE_FRONT);
        mIsDateCardFront = !mIsDateCardFront;
    }

    private void bookDate() {
        mBookItContainer.setVisibility(View.GONE);
        mBrewedContainer.setVisibility(View.VISIBLE);
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
