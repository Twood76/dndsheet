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

public class CombatFragment extends Fragment {
	public static final String PREFS_COMBAT = "CombatFile";
	public static final String FILE_BASE = "File";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
		return inflater.inflate(R.layout.combat, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Restore Combat Information
		int sheetIndex = ((InfoActivity)getActivity()).getSheetIndex();
		String file = FILE_BASE + sheetIndex;
		SharedPreferences infoFile = getActivity().getSharedPreferences(file, Context.MODE_PRIVATE);
		
		View rootView = getView();
		EditText view;
		String infoPiece;
		String defaultText = getString(R.string.not_set);
		
		infoPiece = infoFile.getString("infoCombat_hpNow", defaultText);
		view = (EditText) rootView.findViewById(R.id.combat_hp_now_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoCombat_hpMax", defaultText);
		view = (EditText) rootView.findViewById(R.id.combat_hp_max_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoCombat_acNow", defaultText);
		view = (EditText) rootView.findViewById(R.id.combat_ac_now_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoCombat_acBase", defaultText);
		view = (EditText) rootView.findViewById(R.id.combat_ac_base_val);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoCombat_bonusesAttr", defaultText);
		view = (EditText) rootView.findViewById(R.id.combat_bonuses_attr_list);
		view.setText(infoPiece);
		
		infoPiece = infoFile.getString("infoCombat_bonusesWep", defaultText);
		view = (EditText) rootView.findViewById(R.id.combat_bonuses_wep_list);
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
		
		view = (EditText) rootView.findViewById(R.id.combat_hp_now_val);
		editor.putString("infoCombat_hpNow", view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.combat_hp_max_val);
		editor.putString("infoCombat_hpMax",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.combat_ac_now_val);
		editor.putString("infoCombat_acNow",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.combat_ac_base_val);
		editor.putString("infoCombat_acBase",view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.combat_bonuses_attr_list);
		editor.putString("infoCombat_bonusesAttr", view.getText().toString());
		
		view = (EditText) rootView.findViewById(R.id.combat_bonuses_wep_list);
		editor.putString("infoCombat_bonusesWep", view.getText().toString());
		
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
