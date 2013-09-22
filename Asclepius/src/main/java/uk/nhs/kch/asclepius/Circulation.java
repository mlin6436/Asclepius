package uk.nhs.kch.asclepius;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class Circulation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.circulation, menu);
        return true;
    }

    public void onButtonClick_Next(View view){
        Intent intent = new Intent(this, Disability.class);
        startActivity(intent);
    }
}
