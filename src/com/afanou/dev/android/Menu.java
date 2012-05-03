package com.afanou.dev.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity
{
	String classes[] = {
			"MoneyManagerBasicActivity",
			"TextPlay",
			"Email",
			"Camera",
			"example4",
			"example5",
			"example6"
	};
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try {
			String selectedClass = classes[position];
			Class activityClass = Class.forName("com.afanou.dev.android." + selectedClass);
			Intent activityIntent = new Intent(Menu.this, activityClass);
			startActivity(activityIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
}
