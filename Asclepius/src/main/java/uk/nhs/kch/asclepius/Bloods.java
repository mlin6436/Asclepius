package uk.nhs.kch.asclepius;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Bloods extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloods);

        Spinner bloods_bloodgastype_spinner = (Spinner) findViewById(R.id.bloods_bloodgastype_spinner);
        ArrayAdapter<CharSequence> bloods_bloodgastype_adapter = ArrayAdapter.createFromResource(this,
                R.array.disbility_eye, android.R.layout.simple_spinner_item);
        bloods_bloodgastype_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        bloods_bloodgastype_spinner.setAdapter(bloods_bloodgastype_adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bloods, menu);
        return true;
    }

    public void onButtonClick_Next(View view){
        Intent intent = new Intent(this, FastScan.class);
        startActivity(intent);
    }
}
