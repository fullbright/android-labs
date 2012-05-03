package com.afanou.dev.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class Email extends Activity implements OnClickListener{

	
	private View btnSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		btnSend = findViewById(R.id.btnEmailSend);
		btnSend.setOnClickListener(this);
	}

	public void onClick(View v) {
		String emailAddresses[] = { ((EditText)findViewById(R.id.txtEmailTo)).getText().toString() };
		
		String message = ((EditText)findViewById(R.id.txtEmailMessage)).getText().toString();
		String emailSubject = ((EditText)findViewById(R.id.txtEmailSubject)).getText().toString();
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddresses);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, emailSubject);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
	
	
}
