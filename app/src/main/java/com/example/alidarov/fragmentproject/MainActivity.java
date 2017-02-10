package com.example.alidarov.fragmentproject;



import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity implements OnClickListener {

    fragment a;
    fragment b;
    fragment c;
    fragment frag;
    EditText et,calendar;
    Button b1,b2,b3,add;
    ArrayList<String> data1,data2,data3;
    FragmentTransaction transaction;
    String words;
    String location;
    Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        data1= new ArrayList();
        data2 = new ArrayList();
        data3 = new ArrayList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et = (EditText)findViewById(R.id.edit);
        calendar = (EditText)findViewById(R.id.data);
        calendar.setOnClickListener(this);


        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        add = (Button)findViewById(R.id.add);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        add.setOnClickListener(this);

        Bundle bundle = new Bundle();
        bundle.putString("text", "Fragment A");
        bundle.putInt("color", Color.RED);
        a = new fragment();
        a.setArguments(bundle);

        bundle = new Bundle();
        bundle.putString("text", "Fragment B");
        bundle.putInt("color", Color.GREEN);
        b = new fragment();
        b.setArguments(bundle);

        bundle = new Bundle();
        bundle.putString("text", "Fragment C");
        bundle.putInt("color", Color.YELLOW);
        c = new fragment();
        c.setArguments(bundle);



    }


    public ArrayList<String> getDataF() {return data1;}
    public ArrayList<String> getDataS(){
        return data2;
    }
    public ArrayList<String> getDataT(){
        return data3;
    }
    public String getLocation(){
        return location;
    }


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        calendar.setText(sdf.format(myCalendar.getTime()));
    }



    @Override
    public void onClick(View v) {
        transaction = getFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.b1:
                transaction.replace(R.id.container, a);
                location = "a";
                break;
            case R.id.b2:
                transaction.replace(R.id.container, b);
                location = "b";
                break;
            case R.id.b3:
                transaction.replace(R.id.container, c);
                location =  "c";
                break;
            case R.id.add:
                if(location!=null && et.getText().toString().trim().length() != 0
                        && calendar.getText().toString().trim().length() != 0){
                    switch (location){
                        case "a":
                            words = et.getText().toString() + "->" + calendar.getText().toString();
                            data1.add(words);
                            frag = (fragment) getFragmentManager().findFragmentById(R.id.container);
                            frag.method();
                            break;
                        case "b":
                            words = et.getText().toString() + "->" + calendar.getText().toString();
                            data2.add(words);
                            frag = (fragment) getFragmentManager().findFragmentById(R.id.container);
                            frag.method();
                            break;
                        case "c":
                            words = et.getText().toString() + "->" + calendar.getText().toString();
                            data3.add(words);
                            frag = (fragment) getFragmentManager().findFragmentById(R.id.container);
                            frag.method();
                            break;

                    }
                    et.setText("");
                    calendar.setText("");

                }
                break;
            case R.id.data:
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
        transaction.commit();
    }
}
