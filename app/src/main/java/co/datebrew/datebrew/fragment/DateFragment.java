package co.datebrew.datebrew.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import co.datebrew.datebrew.R;

public class DateFragment extends Fragment {

    private ImageView mDateImageView;
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

        mDateImageView = (ImageView) view.findViewById(R.id.date_imageview);
        mDateImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDateDetails();
            }
        });

        return view;
    }

    private void toggleDateDetails() {
        mDateImageView.setImageResource(mIsDateCardFront ? DATE_BACK : DATE_FRONT);
        mIsDateCardFront = !mIsDateCardFront;
    }

}
