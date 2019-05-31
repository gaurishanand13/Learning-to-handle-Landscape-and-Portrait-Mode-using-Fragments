package com.example.fragment_part3;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
   //since we usually use a list view in our fragments , therefore androidStudio has provides us with a particlular
   //class names ListFragment which help us to include special functions to handle the list easily.
public class listFragment extends ListFragment {


    public listFragment() {
        // Required empty public constructor
    }


    //for this fragment to communicate with the other fragment we need to set up an interface which will make our link with the activity which is hosting this fragment which
    //will in turn communicate with the other fragment on our behalf.
    public interface itemSelected
    {
        //here the name of the interface is itemSelected. Thus we will pass an index from this fragment to the mainActivtiy which will
        // contact with the detailFragment to show the values corresponding to that index
        void onItemSelected(int index);
        //this is the function which will help us to communicate
    }
    //Now we will create an object of type itemSelected
    itemSelected activity;

    //rightclick -> generate -> override methods -> chose onAttach to get this function.
    //This function is called when the fragment is associated with the activity.
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (itemSelected) context;
        //Therefore writing the above statement we have linked our fragment with the actvitiy i.e now
        // we can easily pass the information from this fragment to the other fragment.
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //this function is executed after the onCreate function of the activity hosting this fragment is executed
        String arrayList[] = getResources().getStringArray(R.array.pieces); // Note though i have given the variable name as arrayList but arrayList is completely different from the string.

        //Now we will set up the arrayAdapter to set the listView
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrayList);
        setListAdapter(arrayAdapter);

        //since when the opens up in landscape mode we want that the text of first option should be displayed in the textView of detailFragment
        if(this.getActivity().findViewById(R.id.linearLayoutLandscape) != null)
        {
            activity.onItemSelected(0);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        activity.onItemSelected(position);
    }
}
