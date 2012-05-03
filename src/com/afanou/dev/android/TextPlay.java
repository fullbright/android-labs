package com.afanou.dev.android;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		Button btnSubmit = (Button) findViewById(R.id.btnCommand);
		final ToggleButton tbToggle  = (ToggleButton) findViewById(R.id.btnToggle);
		final EditText editText = (EditText)findViewById(R.id.etCommand);
		final TextView txtResult = (TextView)findViewById(R.id.txtResult);
		
		tbToggle.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(tbToggle.isChecked())
				{
					editText.setInputType(InputType.TYPE_CLASS_TEXT);
				}
				else
				{
					editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
				
			}
		});
		
		btnSubmit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(editText.getText().toString().contentEquals("left"))
				{
					txtResult.setGravity(Gravity.LEFT);
				}
				else if(editText.getText().toString().contentEquals("right"))
				{
					txtResult.setGravity(Gravity.RIGHT);
				}
				else if(editText.getText().toString().contentEquals("center"))
				{
					txtResult.setGravity(Gravity.CENTER);
				}
			}
		});
		
	}
}
