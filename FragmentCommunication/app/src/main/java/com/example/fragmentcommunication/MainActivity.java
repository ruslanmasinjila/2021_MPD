package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    // Create Components which are inside the MainActivity
    ///////////////////////////////////////////////////////////////////////////////////////////////
    private FrameLayout FrameLayout_CONTAINER;
    private LinearLayout layout_ab;

    // Create FragmentA and FragmentB
    private Fragment FragmentA=new FragmentA();
    private Fragment FragmentB=new FragmentB();
    ///////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///////////////////////////////////////////////////////////////////////////////////////////////
        // REFERENCING

        // 1. Reference the FrameLayout inside the MainActivity.
        //    This Layout will contain layout_ab, and, optionally, FragmentC (for google maps)
        FrameLayout_CONTAINER = findViewById(R.id.FrameLayout_CONTAINER);

        // 2. Create a Layout Inflater that will be used to inflate the layout_ab
        LayoutInflater inflater = (LayoutInflater)getSystemService(this.LAYOUT_INFLATER_SERVICE);
        layout_ab = (LinearLayout) inflater.inflate(R.layout.layout_ab, null);

        // Add the newly inflated layout_ab into the FrameLayout_CONTAINER
        FrameLayout_CONTAINER.addView(layout_ab);


        // 3. Remember that layout_ab is a LinearLayout which inturn contains two FrameLayouts
        //    One of the FrameLayouts (fragment_a) will contain the FragmentA
        //    The other FrameLayout   (fragment_b) will contain FragmentB
        //    Therefore, use the Fragment Manager to add FragmentA and commit into layout_ab


        // Create FragmentManager and FragmentTransaction
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        // Add (replace) FragmentA within FrameLayout fragment_a
        transaction.add(layout_ab.findViewById(R.id.fragment_a).getId(),FragmentA);

        // Add (replace) FragmentB within FrameLayout fragment_b
        transaction.add(layout_ab.findViewById(R.id.fragment_b).getId(),FragmentB);

        // Commit the changes
        transaction.commit();









    }

}
