package com.jplate8.dndcharsheet;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
//import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.TextView;
import android.widget.EditText;

public class ItemsFragment extends Fragment {
	public static final String PREFS_ITEMS = "ItemsFile";
	public static final String FILE_BASE = "File";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
		return inflater.inflate(R.layout.items, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Restore Items Information
		int sheetIndex = ((InfoActivity)getActivity()).getSheetIndex();
		String file = FILE_BASE + sheetIndex;
		SharedPreferences infoFile = getActivity().getSharedPreferences(file, Context.MODE_PRIVATE);
		
		View rootView = getView();
		EditText view;
		String infoPiece;
		String defaultText = getString(R.string.not_set);
		
		infoPiece = infoFile.getString("infoItems_items", defaultText);
		view = (EditText) rootView.findViewById(R.id.items_list);
		view.setText(infoPiece);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		
		// Save Character Information
		int sheetIndex = ((InfoActivity)getActivity()).getSheetIndex();
		String file = FILE_BASE + sheetIndex;
		SharedPreferences infoFile = getActivity().getSharedPreferences(file, Context.MODE_PRIVATE);
		
		SharedPreferences.Editor editor = infoFile.edit();
		View rootView = getView();
		EditText view;
		
		view = (EditText) rootView.findViewById(R.id.items_list);
		editor.putString("infoItems_items", view.getText().toString());
		
		editor.commit();
	}
	/*
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	*/
	/*
	@Override
	public void onPause() {
		super.onPause();
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.detach(this);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.attach(this);
	}
	*/
}
