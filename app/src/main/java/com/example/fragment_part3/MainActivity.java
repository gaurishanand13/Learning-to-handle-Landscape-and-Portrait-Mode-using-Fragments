package com.example.fragment_part3;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements listFragment.itemSelected{

    String descriptionList[];
    //since the mainActivity host these fragments. Therefore the main activity can access its components like textView
    TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        descriptionList = getResources().getStringArray(R.array.descriptions);

        //the android studio has this aswesome feature to have 2 xml files -> one for landscape and the other for the portrait mode.
        //E.g -  when it is in portraitMode it will execute the activity_main.xml and the other i.e activity_main.xml(land) will be null .
        // Vice - verca is also true i.e if in landscape mode it will execute activity_main.xml(land)
        if(findViewById(R.id.linearLayoutLandscape)!=null)
        {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.detailFragment))
                    .show(fragmentManager.findFragmentById(R.id.listFragment))
                    .commit();
        }
        if(findViewById(R.id.linearLayoutPortrait)!=null)
        {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.detailFragment))
                    .show(fragmentManager.findFragmentById(R.id.listFragment))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        textView.setText(descriptionList[index]);

        if(findViewById(R.id.linearLayoutPortrait)!=null)
        {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.detailFragment))
                    .hide(fragmentManager.findFragmentById(R.id.listFragment))
                    .addToBackStack(null)
                    .commit();
        }

        //if we won't add this addToBackStack option then on clicking an option in the portrait mode. We will go to the detailFragment i.e hide the listFragment.
        // therefore on pressing back we will come out of the app not on the lis fragment as it is just hidden. Therefore to add this addToBackStack() is necessary
    }
}
