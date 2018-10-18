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

import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;
import edu.anu.retrogame2018s2_frogger.frogger.player.DataProcess;
import edu.anu.retrogame2018s2_frogger.frogger.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class WelcomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
   DataProcess dataProcess=new DataProcess();
    String currentName;
    private Spinner spinner2;
    private Button btnSubmit;
    Player currentPlayer;
    boolean canLogIn;
    RankDatabaseHelper rankDatabaseHelper = new RankDatabaseHelper();
    List<String> list = rankDatabaseHelper.getPlayer();

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

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void submit(View view) {
        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();
        name=name.trim();//to reduce the meaningless thing
        RankDatabaseHelper rankDatabaseHelper = new RankDatabaseHelper();
        if (rankDatabaseHelper.playerExist(name)) {
            Toast.makeText(getApplicationContext(), "Already exits!Please change another one!", Toast.LENGTH_LONG).show();
        } else if (name.equals("")) {
            Toast.makeText(getApplicationContext(), "Can't sign up! Please change another one!", Toast.LENGTH_LONG).show();
        } else {

            //add to database
            rankDatabaseHelper.addData(new RecordInfo(name, -1, -1));//-1 means no record
            //give to player the current player name
            currentName = name;
            currentPlayer = new Player(currentName);
            list.add(0, currentName);
            addItemsOnSpinner2();
            editText.setText("");
            Toast.makeText(getApplicationContext(), "successful sign up!Log in please!", Toast.LENGTH_LONG).show();
        }

    }

    public void login(View view) {
        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();
        if (name.equals("")) {
            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
            currentPlayer = new Player(String.valueOf(spinner2.getSelectedItem()));
            dataProcess.save(currentPlayer.getName());
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "Please sign up!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
