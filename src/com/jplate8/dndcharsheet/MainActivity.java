package com.jplate8.dndcharsheet;

import android.os.Bundle;
//import android.app.Activity;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.support.v4.app.NavUtils;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        
        String[] dndChars = new String[] { "Character 1", "Character 2", "Character 3", "Character 4", "Character 5",
        		"Character 6", "Character 7", "Character 8", "Character 9", "Character 10",};
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dndChars));
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	String item = (String) getListAdapter().getItem(position);
    	Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
    	intent.putExtra("charIndex", Integer.toString(position));
    	startActivity(intent);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    */

    
}
