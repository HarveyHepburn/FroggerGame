package edu.anu.retrogame2018s2_frogger;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;

import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;
import edu.anu.retrogame2018s2_frogger.frogger.player.DataProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class WelcomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner1, spinner2;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_welcome);
        addItemsOnSpinner2();
    }

    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }



    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(WelcomeActivity.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }


//                DataProcess dataProcess = new DataProcess();
//
//
//
//
//                if (dataProcess.load().equals("")) {
//            setContentView(R.layout.activity_sign_up);
//        } else {
//            setContentView(R.layout.activity_welcome);
//            String res = dataProcess.load();
//            System.out.println(res);
//            TextView textView = (TextView) findViewById(R.id.toast);
//            textView.setText("Welcome " + res);
//        }
//    }


//    public void submit(View view) {
//        Intent intent = new Intent(this, WelcomeActivity.class);
//        startActivity(intent);
//        EditText editText = (EditText) findViewById(R.id.name);
//        String name = editText.getText().toString();
//        RankDatabaseHelper rankDatabaseHelper = new RankDatabaseHelper();
//       // System.out.println(rankDatabaseHelper.playerExist(name));
//        if (rankDatabaseHelper.playerExist(name)) {
//
//            Toast.makeText(getApplicationContext(), "Already exits!Please change another one!", Toast.LENGTH_LONG).show();
//        } else if (name == "") {
//            Toast.makeText(getApplicationContext(), "Can't sign up! Please change another one!", Toast.LENGTH_LONG).show();
//        } else {
//            //add to database
//            rankDatabaseHelper.addData(new RecordInfo(name, -1, -1));//-1 means no record
//            DataProcess dataProcess = new DataProcess();
//            dataProcess.save(name);
//        }
//
//    }
//
//    public void login(View view) {
//        Intent intent = new Intent(this, GameActivity.class);
//        startActivity(intent);
//        DataProcess dataProcess = new DataProcess();
//        String res = dataProcess.load();
//        TextView textView = (TextView) findViewById(R.id.toast);
//        textView.setText("Welcome " + res);
//
//    }
//
//    public void logout(View view) {
//        Intent intent = new Intent(this, SignUpActivity.class);
//        startActivity(intent);
//        DataProcess dataProcess = new DataProcess();
//        dataProcess.save("");
//    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);


//        if (hasFocus) {
//            hideSystemUI();
//        }
        });
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(parent.getContext(),
//                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
//                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        // TODO Auto-generated method stub
    }
}
