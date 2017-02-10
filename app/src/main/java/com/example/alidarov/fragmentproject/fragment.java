package com.example.alidarov.fragmentproject;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.example.alidarov.fragmentproject.MainActivity;
import com.example.alidarov.fragmentproject.R;

import java.util.ArrayList;


public class fragment extends Fragment implements View.OnClickListener{
    String text;
    int color;
    String loc;
    ArrayList<String> data;
    ListView lv;
    Button bRef;
    View view;
    ArrayAdapter<String> arrayAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_fragment, container, false);


        lv = (ListView)view.findViewById(R.id.listv);


        Bundle b = getArguments();
        text = b.getString("text");
        color = b.getInt("color");

        LinearLayout rl = (LinearLayout) view.findViewById(R.id.rl);

        rl.setBackgroundColor(color);
        loc = ((MainActivity)getActivity()).getLocation();

        switch (loc){
            case "a":
                data = ((MainActivity)getActivity()).getDataF();
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.listitem,data);
                lv.setAdapter(arrayAdapter);
                break;
            case "b":
                data = ((MainActivity)getActivity()).getDataS();
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.listitem,data);
                lv.setAdapter(arrayAdapter);
                break;
            case "c":
                data = ((MainActivity)getActivity()).getDataT();
                arrayAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.listitem,data);
                lv.setAdapter(arrayAdapter);
                break;
        }
        return view;
    }
    public void method(){
        switch (loc){
            case "a":
                data = ((MainActivity)getActivity()).getDataF();
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.listitem,data);
                lv.setAdapter(arrayAdapter);
                break;
            case "b":
                data = ((MainActivity)getActivity()).getDataS();
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.listitem,data);
                lv.setAdapter(arrayAdapter);
                break;
            case "c":
                data = ((MainActivity)getActivity()).getDataT();
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.listitem,data);
                lv.setAdapter(arrayAdapter);
                break;
        }}

    @Override
    public void onClick(View v) {
    }
}
