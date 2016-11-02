package com.udacity.kssand.builditbigger.paid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.udacity.kssand.builditbigger.EndPointsAsyncTask;
import com.udacity.kssand.builditbigger.EndPointsPaidAsyncTask;
import com.udacity.kssand.builditbigger.R;


public class MainActivityFragment extends Fragment {
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        Button tellJokeButton = (Button) root.findViewById(R.id.jokeTeller);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndPointsAsyncTask(getActivity()).execute(getActivity());
            }
        });
        return root;
    }
}
