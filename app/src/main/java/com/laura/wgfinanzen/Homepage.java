package com.laura.wgfinanzen;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class Homepage extends ActionBarActivity implements View.OnClickListener {
    Button goOn;
    RadioButton chris, sophia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        goOn = (Button)findViewById(R.id.btn_goToFinance);
        goOn.setOnClickListener(this);

        chris = (RadioButton)findViewById(R.id.rB_Chris);
        sophia = (RadioButton)findViewById(R.id.rB_Sophia);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homepage, menu);
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

    @Override
    public void onClick(View v) {
        //Intent i = new Intent(Homepage.this, SelectOption.class);
       // i.putExtra("User", getUSer());
        setPerson();
        startActivity(new Intent(Homepage.this, CostsMonth.class));
    }


    private void setPerson(){
        Person christian = new Person("Christian");
        Person sophia = new Person("Sophia");
        Person.residents.put(christian.getName(), christian);
        Person.residents.put(sophia.getName(),sophia);

        if(chris.isChecked())
            Person.login = christian;
        else
            Person.login = sophia;
    }
}
