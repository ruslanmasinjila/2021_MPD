package com.example.fragmentcommunication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.LinkedList;


// This Fragment holds a list of persons, but only displays the names of the persons
// in the ListView
public class FragmentA extends Fragment {


    ////////////////////////////////////////////////////////////////////////////////////////////////
    private SharedViewModel viewModel;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private ListView ListView_NAMES;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private ArrayAdapter<String> arrayAdapter;
    LinkedList<Person> personLinkedList = new LinkedList<Person>();
    LinkedList<String> personName = new LinkedList<String>();

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public FragmentA()
    {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        ////////////////////////////////////////////////////////////////////////////////////////////////
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_a, container, false);

        // Find ListView_NAMES its by ID in the root
        ListView_NAMES = (ListView)view.findViewById(R.id.ListView_NAMES);


        // Create two people and add them to LinkedList
        Person ruslan = new Person("Ruslan","50","+1234567890","abc@gmail.com","Pemba");
        Person doctor =  new Person("Dr. Who","900","+0987654321","zyx@gmail.com","Gallifrey");
        Person cyberman =  new Person("Cyberman","12000","+9192631770","upgrade@cybermail.com","Everywhere");

        personLinkedList.add(ruslan);
        personName.add(ruslan.getName());

        personLinkedList.add(doctor);
        personName.add(doctor.getName());

        personLinkedList.add(cyberman);
        personName.add(cyberman.getName());

        // Create Array Adapter for the list
        arrayAdapter =  new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, personName);

        ListView_NAMES.setAdapter(arrayAdapter);
        ////////////////////////////////////////////////////////////////////////////////////////////////
        ListView_NAMES.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the selected name
                String selectedName = (String)parent.getItemAtPosition(position);

                // Look for Person with the selected name, once found
                // Set the selectedPerson in SharedView model to this person
                for(int i = 0; i < personLinkedList.size();i++)
                {
                    if(selectedName.equals(personLinkedList.get(i).getName()))
                    {
                        viewModel.setSelectedPerson(personLinkedList.get(i));
                        break;
                    }
                }


            }
        });


        return view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState)  {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    }


}
