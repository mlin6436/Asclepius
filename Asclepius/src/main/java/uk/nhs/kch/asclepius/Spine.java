package uk.nhs.kch.asclepius;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class Spine extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spine);
    }

    public void onRadioButtonClick_RadioButton1(View view){

    }

    public void onRadioButtonClick_RadioButton2(View view){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.spine, menu);
        return true;
    }
    
}