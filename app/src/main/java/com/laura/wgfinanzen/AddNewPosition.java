package com.laura.wgfinanzen;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;


public class AddNewPosition extends ActionBarActivity implements View.OnClickListener{

    Button safeNewPosition;
    EditText name, description, value;
    DatePicker picker;
    Date date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_position);

        safeNewPosition = (Button)findViewById(R.id.btn_SafeNewPosition);
        safeNewPosition.setOnClickListener(this);

        name = (EditText)findViewById(R.id.eT_newPositionName);
        description = (EditText)findViewById(R.id.eT_newPositionDescription);
        value = (EditText)findViewById(R.id.eT_newPositionValue);

        picker = (DatePicker)findViewById(R.id.datePicker);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_position, menu);
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

    //Toast toast = Toast.makeText(context, text, duration);


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_SafeNewPosition:
                if(mandatoryFieldsFilles()){
                    Toast toast = Toast.makeText(getApplicationContext(),safeInformation(getInformation()),Toast.LENGTH_SHORT);
                    toast.show();
                    switchPage(CostsMonth.class);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Pflichtfelder nicht ausgefüllt",Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            default:;
        }

    }

    private Position getInformation(){
        //double valueShopping = Double.parseDouble(value.getText().toString());
        return new Position(name.getText().toString(), description.getText().toString(), Person.login, getDate(), Double.parseDouble(value.getText().toString()));
    }

    private String safeInformation(Position p){
        try{
            MySQLiteHelper helper = new MySQLiteHelper(this);
            helper.safePosition(p);
            return "Ausgabe gespeichert";
        }
        catch(Exception e){
            return "Speichern der Ausgabe fehlgeschlafen";
        }
    }

    private Date getDate(){
        date = new Date();
        date.setYear(picker.getYear());
        date.setMonth(picker.getMonth()+1);
        date.setDate(picker.getDayOfMonth());

        return date;
    }

    private void switchPage(Class c){
       // Intent i = new Intent(AddNewPosition.this,c);
        //i.putExtra("User", username);
        startActivity( new Intent(AddNewPosition.this,c));
    }

    private Boolean mandatoryFieldsFilles(){
        if(name.getText().toString() == "" || name.getText().toString().equals("") || value.getText().toString().equals("") || value.getText().toString() == "")
            return false;
        else
            return true;
    }
}
