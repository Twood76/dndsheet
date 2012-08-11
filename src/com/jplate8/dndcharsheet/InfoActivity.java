
package com.jplate8.dndcharsheet;

import android.os.Bundle;
//import android.content.Intent;
//import android.content.Context;
//import android.view.View;
//import android.widget.EditText;
import android.app.Activity;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
//import android.content.SharedPreferences;
//import android.view.LayoutInflater;
/*
import android.widget.TextView;
import android.util.Log;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
*/

public class InfoActivity extends Activity {
	public static final String FILE_BASE = "File";
	public int sheetIndex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		// setup action bar for tabs
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);
		
		// add Character section
		Tab tab = actionBar.newTab()
				.setText(R.string.title_section1)
				.setTabListener(new TabListener<CharacterFragment>(
						this, "character", CharacterFragment.class));
		actionBar.addTab(tab);
		
		// add Stats section
		tab = actionBar.newTab()
				.setText(R.string.title_section2)
				.setTabListener(new TabListener<StatsFragment>(
						this, "stats", StatsFragment.class));
		actionBar.addTab(tab);
		
		// add Combat section
		tab = actionBar.newTab()
				.setText(R.string.title_section3)
				.setTabListener(new TabListener<CombatFragment>(
						this, "combat", CombatFragment.class));
		actionBar.addTab(tab);
		
		// add Items section
		tab = actionBar.newTab()
				.setText(R.string.title_section4)
				.setTabListener(new TabListener<ItemsFragment>(
						this, "items", ItemsFragment.class));
		actionBar.addTab(tab);
		
		//get sheet index chosen on MainActivity
		Bundle extras = getIntent().getExtras();
		sheetIndex =  Integer.parseInt(extras.getString("charIndex"));
		System.out.println("sheetIndex = " + sheetIndex);
	}
	
	@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
        outState.putInt("sheetIndex", sheetIndex);
    }
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			getActionBar().setSelectedNavigationItem(savedInstanceState.getInt("tab", 0));
			sheetIndex = savedInstanceState.getInt("sheetIndex", 0);
			//System.out.println("sheetIndex is " + sheetIndex);
		}
	}
	
	public int getSheetIndex() {
		return sheetIndex;
	}
	
	/*
	@Override
	protected void onPause() {
		super.onPause();
		
		saveSheet();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		loadSheet();
	}
	*/
	
	/*
	private void loadSheet() {
		String file = FILE_BASE + sheetIndex;
		System.out.println("loading " + file);
		LayoutInflater inflater = getLayoutInflater();
		View rootView;
		
		// Restore Character Information
		SharedPreferences infoFile = getSharedPreferences(file, Context.MODE_PRIVATE);
		rootView = inflater.inflate(R.layout.character, null);
		EditText view;
		String infoPiece;
		String defaultText = getString(R.string.not_set);
		
		infoPiece = infoFile.getString("infoChar_name", defaultText);
		view = (EditText) rootView.findViewById(R.id.char_name_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoChar_class", defaultText);
		view = (EditText) rootView.findViewById(R.id.char_class_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoChar_race", defaultText);
		view = (EditText) rootView.findViewById(R.id.char_race_val);
		view.setText(infoPiece);
			
		infoPiece = infoFile.getString("infoChar_level", defaultText);
		view = (EditText) rootView.findViewById(R.id.char_level_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoChar_alignment", defaultText);
		view = (EditText) rootView.findViewById(R.id.char_alignment_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoChar_deity", defaultText);
		view = (EditText) rootView.findViewById(R.id.char_deity_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoChar_religion", defaultText);
		view = (EditText) rootView.findViewById(R.id.char_religion_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoChar_origin", defaultText);
		view = (EditText) rootView.findViewById(R.id.char_origin_val);
		view.setText(infoPiece);
	}
	
	private void saveSheet() {
		String file = FILE_BASE + sheetIndex;
		System.out.println("saving " + file);
		LayoutInflater inflater = getLayoutInflater();
		View rootView;
		
		SharedPreferences infoFile = getSharedPreferences(file, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = infoFile.edit();
		rootView = inflater.inflate(R.layout.character, null);
		EditText view;
		
		view = (EditText) rootView.findViewById(R.id.char_name_val);
		editor.putString("infoChar_name", view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.char_class_val);
		editor.putString("infoChar_class",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.char_race_val);
		editor.putString("infoChar_race",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.char_level_val);
		editor.putString("infoChar_level",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.char_alignment_val);
		editor.putString("infoChar_alignment",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.char_deity_val);
		editor.putString("infoChar_deity",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.char_religion_val);
		editor.putString("infoChar_religion",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.char_origin_val);
		editor.putString("infoChar_origin",view.getText().toString());
		
		editor.commit();
	}
	*/
}
/*
public class InfoActivity extends FragmentActivity implements ActionBar.TabListener {

    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // For each of the sections in the app, add a tab to the action bar.
        actionBar.addTab(actionBar.newTab().setText(R.string.title_section1).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.title_section2).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.title_section3).setTabListener(this));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
                getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_info, menu);
        return true;
    }

    

    //@Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    //@Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, show the tab contents in the container
        Fragment fragment = new DummySectionFragment();
        Bundle args = new Bundle();
        args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    //@Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
*/
    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
/*
    public static class DummySectionFragment extends Fragment {
        public DummySectionFragment() {
        }

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            Bundle args = getArguments();
            textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
            return textView;
        }
    }
}
*/