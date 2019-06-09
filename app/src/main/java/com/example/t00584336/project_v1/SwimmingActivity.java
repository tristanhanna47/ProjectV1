package com.example.t00584336.project_v1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SwimmingActivity extends Activity {

    Exercises[] swimmingex = { new Exercises("100m Freestyle ", 200)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swimming);

        ListView listView = (ListView) findViewById(R.id.swimminglist);

        ArrayAdapter<Exercises> adapter = new ArrayAdapter<Exercises>(this,android.R.layout.simple_list_item_1, swimmingex );
        listView.setAdapter(adapter);

        // Create a message handling object as an anonymous class.
        AdapterView.OnItemClickListener messageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click
                Toast.makeText(getApplicationContext(), "You added the " + swimmingex[position] + " exercise to the workout",Toast.LENGTH_LONG).show();
            }
        };

        listView.setOnItemClickListener(messageClickedHandler);
    };
}
