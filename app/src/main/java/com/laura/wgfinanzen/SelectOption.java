package com.laura.wgfinanzen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SelectOption extends ActionBarActivity implements View.OnClickListener{

    String username;
    Button goToFinance, goToCostOverview;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option);

        username = (String)getIntent().getSerializableExtra("User");
        user = (TextView)findViewById(R.id.tV_User);
        user.setText(username);

        goToCostOverview = (Button)findViewById(R.id.btn_GoToCostOverview);
        goToCostOverview.setOnClickListener(this);

        goToFinance = (Button)findViewById(R.id.btn_goToFinance);
        goToFinance.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_option, menu);
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
        switch (v.getId())
        {
            case R.id.btn_GoToCostOverview:
                switchPage(CostsMonth.class);
                break;
            case R.id.btn_goToFinance:
                //switchPage();
                break;
            default:break;
        }
    }

    private void switchPage(Class c){
        Intent i = new Intent(SelectOption.this,c);
        i.putExtra("User", username);
        startActivity(i);

    }
}
