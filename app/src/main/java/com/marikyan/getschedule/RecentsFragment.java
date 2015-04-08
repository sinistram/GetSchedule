package com.marikyan.getschedule;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Marikyan on 01-Mar-15.
 */
public class RecentsFragment extends Fragment {
    public static RecentsFragment newInstance() {
        RecentsFragment fragment = new RecentsFragment();
        return fragment;
    }

    private ListView myListView;

    private String[] listItems;

    public RecentsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recents, container, false);
        //Sets add button design
        rootView.findViewById(R.id.buttonFloat).setBackgroundColor(Color.argb(255, 244, 67, 54));

        myListView = (ListView)rootView.findViewById(R.id.myListView);
        listItems = getResources().getStringArray(R.array.my_data_list);
        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, listItems);
        myListView.setAdapter(objAdapter);
        return rootView;
        //TODO listview
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity)activity).onSectionAttached(1);
    }


}
