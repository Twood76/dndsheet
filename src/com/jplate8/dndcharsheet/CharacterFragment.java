package com.jplate8.dndcharsheet;

import android.app.Fragment;
//import android.util.Log;
//import android.app.FragmentTransaction;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.SharedPreferences;
//import android.widget.TextView;
import android.widget.EditText;

public class CharacterFragment extends Fragment {
	public static final String PREFS_CHARACTER = "CharacterFile";
	public static final String FILE_BASE = "File";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
		//return inflater.inflate(R.layout.character, container, false);
		return inflater.inflate(R.layout.character, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Restore Character Information
		int sheetIndex = ((InfoActivity)getActivity()).getSheetIndex();
		String file = FILE_BASE + sheetIndex;
		SharedPreferences infoFile = getActivity().getSharedPreferences(file, Context.MODE_PRIVATE);
		
		View rootView = getView();
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
		//Log.e("can we reach view from fragment?", view.getText().toString()); //yes, if we use getView() for .findViewById since onCreateView returned view's layout
		//System.out.println(view.getText().toString());
		//Log.e("HELP", "can you hear me?");
		 
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
		
		//Log.e("does onPause when tab switch?", "goodbye character tab!");
	}
	
	/*
	@Override
	public void onResume() {
		super.onResume();
		Log.e("does onResume when tab switch back?", "hello again character tab!");
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
