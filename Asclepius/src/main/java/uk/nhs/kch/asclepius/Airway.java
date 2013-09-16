package uk.nhs.kch.asclepius;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;

public class Airway extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airway);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.airway, menu);
        return true;
    }

    public void onCheckboxClick_Option1(View view){

    }

    public void onCheckboxClick_Option2(View view){

    }

    public void onCheckboxClick_Option3(View view){

    }

    public void onButtonClick_AirwayNext(View view){
        Intent intent = new Intent(this, Spine.class);
        startActivity(intent);
    }
}
