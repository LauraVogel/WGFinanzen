package com.laura.wgfinanzen;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class Compensation extends ActionBarActivity implements View.OnClickListener {

    EditText wert;
    RadioButton chris, sophia;
    Button safe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compensation);

        sophia = (RadioButton)findViewById(R.id.rb_PayOffSophia);
        chris = (RadioButton)findViewById(R.id.rB_PayOffChris);

        wert = (EditText)findViewById(R.id.eT_payOff);

        safe = (Button)findViewById(R.id.btn_safePayOff);
        safe.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_compensation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getInformation(){

    }

    @Override
    public void onClick(View v) {
        //speichern
    }

    private void resetValues(){
        wert.setText(0);

    }
}
