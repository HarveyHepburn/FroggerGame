//package edu.anu.retrogame2018s2_frogger;
//
//import android.content.Intent;
//import android.content.pm.ActivityInfo;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.EditText;
//
//import edu.anu.retrogame2018s2_frogger.frogger.player.PlayerStore;
//
//public class SignUpActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        // Hide the Title bar of this activity screen
//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        setContentView(R.layout.activity_sign_up);
//    }
//    public void submit(View view) {
//        Intent intent = new Intent(this, GameActivity.class);
//        startActivity(intent);
//        EditText editText=(EditText) findViewById(R.id.name);
//        String name=editText.getText().toString();
//        PlayerStore playerStore =new PlayerStore();
//        playerStore.save(name);
//
//    }
//    public void cancel(View view) {
//        Intent intent = new Intent(this, WelcomeActivity.class);
//        startActivity(intent);
//    }
//
//}
