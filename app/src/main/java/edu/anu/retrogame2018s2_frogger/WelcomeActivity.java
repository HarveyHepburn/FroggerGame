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

import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;
import edu.anu.retrogame2018s2_frogger.frogger.player.PlayerStore;

import java.util.List;

public class WelcomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String currentName;
    private Spinner spinner2;
    private Button btnSubmit;
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
        RankDatabaseHelper rankDatabaseHelper = new RankDatabaseHelper();
        if (rankDatabaseHelper.playerExist(name)) {
            Toast.makeText(getApplicationContext(), "Player Name already exits!Please change another name!", Toast.LENGTH_LONG).show();
        } else if (name.equals("")) {
            Toast.makeText(getApplicationContext(), "You haven't type your account name to sign up", Toast.LENGTH_LONG).show();
        } else {

            //add to database
            rankDatabaseHelper.addData(new RecordInfo(name, -1, -1));//-1 means no record
            //give to player the current player name
            currentName = name;
            list.add(0, currentName);


            addItemsOnSpinner2();

            Toast.makeText(getApplicationContext(), "Successfully signed up, you are ready to login", Toast.LENGTH_LONG).show();
        }

    }

    public void login(View view) {
        String name = "";
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        if (spinner2.getSelectedItem() != null) name = spinner2.getSelectedItem().toString();
        if (name.equals("")) {
            Toast.makeText(getApplicationContext(), "Please sign up or choose an account to login", Toast.LENGTH_LONG).show();
            return;
        }
        currentName = name;
        Toast.makeText(getApplicationContext(), "Welcome back, " + name, Toast.LENGTH_LONG).show();

        PlayerStore.save(name);
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        startActivity(intent);
//        String res = playerStore.load();
//        TextView textView = (TextView) findViewById(R.id.toast);
//        textView.setText("Welcome " + res);

    }

    // get the selected dropdown list value
    public void addListenerOnButton() {
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.login);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = String.valueOf(spinner2.getSelectedItem());
                currentName = name;
                Toast.makeText(WelcomeActivity.this,
                        "OnClickListener : " +
                                "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

//
//    public void logout(View view) {
//        Intent intent = new Intent(this, SignUpActivity.class);
//        startActivity(intent);
//        PlayerStore dataProcess = new PlayerStore();
//        dataProcess.save("");
//    }
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

    }
}
