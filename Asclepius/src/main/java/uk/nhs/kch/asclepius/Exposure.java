package uk.nhs.kch.asclepius;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Exposure extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exposure);

        Spinner exposure_site_spinner = (Spinner) findViewById(R.id.exposure_site_spinner);
        ArrayAdapter<CharSequence> exposure_site_adapter = ArrayAdapter.createFromResource(this,
                R.array.exposure_site, android.R.layout.simple_spinner_item);
        exposure_site_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        exposure_site_spinner.setAdapter(exposure_site_adapter);

        Spinner exposure_upperlimbpulses_spinner = (Spinner) findViewById(R.id.exposure_upperlimbpulses_spinner);
        ArrayAdapter<CharSequence> exposure_upperlimbpulses_adapter = ArrayAdapter.createFromResource(this,
                R.array.exposure_upperlimbpulses, android.R.layout.simple_spinner_item);
        exposure_upperlimbpulses_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        exposure_upperlimbpulses_spinner.setAdapter(exposure_upperlimbpulses_adapter);

        Spinner exposure_lowerlimbpulses_spinner = (Spinner) findViewById(R.id.exposure_lowerlimbpulses_spinner);
        ArrayAdapter<CharSequence> exposure_lowerlimbpulses_adapter = ArrayAdapter.createFromResource(this,
                R.array.exposure_lowerlimbpulses, android.R.layout.simple_spinner_item);
        exposure_lowerlimbpulses_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        exposure_lowerlimbpulses_spinner.setAdapter(exposure_lowerlimbpulses_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.exposure, menu);
        return true;
    }

    public void onButtonClick_Next(View view){
        Intent intent = new Intent(this, Bloods.class);
        startActivity(intent);
    }
    
}
