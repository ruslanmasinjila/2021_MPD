package com.example.fragmentcommunication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class FragmentB extends Fragment {



    private SharedViewModel viewModel;
    ////////////////////////////////////////////////////////////////////////////////////////////
    private TextView TextView_NAME;
    private String   TextView_NAME_VALUE = "AAA";

    private TextView TextView_AGE;
    private String   TextView_AGE_VALUE = "BBB";

    private TextView TextView_TELEPHONE;
    private String   TextView_TELEPHONE_VALUE= "CCC";

    private TextView TextView_EMAIL;
    private String   TextView_EMAIL_VALUE = "DDD";


    private TextView TextView_ADDRESS;
    private String   TextView_ADDRESS_VALUE = "EEE";
    ////////////////////////////////////////////////////////////////////////////////////////////

    public FragmentB ()
    {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_b, container, false);

        // Link the TextViews
        TextView_NAME = (TextView)view.findViewById(R.id.TextView_NAME);
        TextView_NAME.setText(TextView_NAME_VALUE);

        TextView_AGE = (TextView)view.findViewById(R.id.TextView_AGE);
        TextView_AGE.setText(TextView_AGE_VALUE);

        TextView_TELEPHONE = (TextView)view.findViewById(R.id.TextView_TELEPHONE);
        TextView_TELEPHONE.setText(TextView_TELEPHONE_VALUE);

        TextView_EMAIL = (TextView)view.findViewById(R.id.TextView_EMAIL);
        TextView_EMAIL.setText(TextView_EMAIL_VALUE);

        TextView_ADDRESS = (TextView)view.findViewById(R.id.TextView_ADDRESS);
        TextView_ADDRESS.setText(TextView_ADDRESS_VALUE);

        return view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState)  {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getSelectedPerson().observe(getViewLifecycleOwner(), new Observer<Person>() {
            @Override
            public void onChanged(@Nullable Person person) {
                TextView_NAME.setText(person.getName());
                TextView_AGE.setText(person.getAge());
                TextView_TELEPHONE.setText(person.getTelephone());
                TextView_EMAIL.setText(person.getEmail());
                TextView_ADDRESS.setText(person.getAddress());


            }
        });
    }


}
