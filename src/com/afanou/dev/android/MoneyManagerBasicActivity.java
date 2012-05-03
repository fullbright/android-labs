package com.afanou.dev.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoneyManagerBasicActivity extends Activity {
	/** Called when the activity is first created. */
	Button add, del;
	TextView display;
	int counter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		counter = 0;
		add = (Button) findViewById(R.id.btnAdd);
		del = (Button) findViewById(R.id.btnDel);
		display = (TextView) findViewById(R.id.txtResult);

		add.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				counter++;
				display.setText("Your total is : " + counter);
			}
		});

		del.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				counter--;
				display.setText("Your total is : " + counter);
			}
		});
	}
}