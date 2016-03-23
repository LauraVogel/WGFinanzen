package com.laura.wgfinanzen;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class CostsMonth extends AppCompatActivity implements View.OnClickListener {
    Button goToNewPosition, costOverview, filterView;
    String username;
    TextView eins, zwei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costs_month);

        goToNewPosition = (Button) findViewById(R.id.btn_generateNewPosition);
        goToNewPosition.setOnClickListener(this);

        costOverview = (Button) findViewById(R.id.btn_financeOverview);
        costOverview.setOnClickListener(this);

        filterView = (Button) findViewById(R.id.btn_filterOverview);
        filterView.setOnClickListener(this);

        eins = (TextView) findViewById(R.id.tV_Test1);
        zwei = (TextView) findViewById(R.id.tV_Test2);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_costs_month, menu);
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
        switch (v.getId()) {
            case R.id.btn_generateNewPosition:
                switchPage(AddNewPosition.class);
                break;
            case R.id.btn_filterOverview:

                break;
            case R.id.btn_financeOverview:
                showPosition();
                break;
        }

    }

    private void showPosition() {
        MySQLiteHelper helper = new MySQLiteHelper(this);
        List<Position> p = helper.getPositions();

        eins.setText(p.get(0).getName());
        zwei.setText(p.get(1).getName());
    }

    private void switchPage(Class c) {
        Intent i = new Intent(CostsMonth.this, c);
        i.putExtra("User", username);
        startActivity(i);
    }
}
