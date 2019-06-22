package com.kip.tichi.pisddetector;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class Test extends AppCompatActivity {
    ArrayList<Model> dataModels;
    private static CustomAdapter adapter;


    protected void onCreate(Bundle SavedInstance) {

        super.onCreate(SavedInstance);
        setContentView(R.layout.test_layout);
        ListView LV=(ListView)findViewById(R.id.lv);

        dataModels= new ArrayList<>();

        dataModels.add(new Model(getString(R.string.q1)));
        dataModels.add(new Model(getString(R.string.q2)));
        dataModels.add(new Model(getString(R.string.q3)));
        dataModels.add(new Model(getString(R.string.q4)));
        dataModels.add(new Model(getString(R.string.q5)));
        dataModels.add(new Model(getString(R.string.q6)));
        dataModels.add(new Model(getString(R.string.q7)));
        dataModels.add(new Model(getString(R.string.q8)));
        dataModels.add(new Model(getString(R.string.q9)));

        adapter= new CustomAdapter(dataModels,getApplicationContext());

        LV.setAdapter(adapter);
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Model dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getName()+"\n", Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
