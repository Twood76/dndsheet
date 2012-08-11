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

public class StatsFragment extends Fragment {
	public static final String PREFS_STATS = "StatsFile";
	public static final String FILE_BASE = "File";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
		return inflater.inflate(R.layout.stats, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Restore Stats Information
		int sheetIndex = ((InfoActivity)getActivity()).getSheetIndex();
		String file = FILE_BASE + sheetIndex;
		SharedPreferences infoFile = getActivity().getSharedPreferences(file, Context.MODE_PRIVATE);
		
		View rootView = getView();
		EditText view;
		String infoPiece;
		String defaultText = getString(R.string.not_set);
		
		infoPiece = infoFile.getString("infoStats_str", defaultText);
		view = (EditText) rootView.findViewById(R.id.stats_str_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoStats_int", defaultText);
		view = (EditText) rootView.findViewById(R.id.stats_int_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoStats_wis", defaultText);
		view = (EditText) rootView.findViewById(R.id.stats_wis_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoStats_dex", defaultText);
		view = (EditText) rootView.findViewById(R.id.stats_dex_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoStats_con", defaultText);
		view = (EditText) rootView.findViewById(R.id.stats_con_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoStats_cha", defaultText);
		view = (EditText) rootView.findViewById(R.id.stats_cha_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoStats_spells", defaultText);
		view = (EditText) rootView.findViewById(R.id.stats_spells_list);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoStats_abil", defaultText);
		view = (EditText) rootView.findViewById(R.id.stats_abil_list);
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
		
		view = (EditText) rootView.findViewById(R.id.stats_str_val);
		editor.putString("infoStats_str", view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.stats_int_val);
		editor.putString("infoStats_int", view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.stats_wis_val);
		editor.putString("infoStats_wis", view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.stats_dex_val);
		editor.putString("infoStats_dex", view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.stats_con_val);
		editor.putString("infoStats_con", view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.stats_cha_val);
		editor.putString("infoStats_cha", view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.stats_spells_list);
		editor.putString("infoStats_spells",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.stats_abil_list);
		editor.putString("infoStats_abil",view.getText().toString());
		
		editor.commit();
	}
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
