package edu.anu.retrogame2018s2_frogger.frogger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.anu.retrogame2018s2_frogger.GameActivity;
import edu.anu.retrogame2018s2_frogger.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void submit(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        TextView textView=(TextView)findViewById(R.id.name);
        String name=(String)textView.getText();
        intent.putExtra("name",name);
    }
    public void cancel(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}
