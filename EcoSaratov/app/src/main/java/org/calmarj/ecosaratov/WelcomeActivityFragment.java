package org.calmarj.ecosaratov;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class WelcomeActivityFragment extends Fragment {

    private Button mBeautifulPlacesButton;

    private Button mProblemPlacesButton;

    public WelcomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        mBeautifulPlacesButton = (Button) view.findViewById(R.id.beautiful_places_button);
        mProblemPlacesButton = (Button) view.findViewById(R.id.problem_places_button);

        mBeautifulPlacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                intent.putExtra("TYPE", "beautiful");
                startActivity(intent);
            }
        });

        mProblemPlacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                intent.putExtra("TYPE", "problem");
                startActivity(intent);
            }
        });


        return view;
    }


}
