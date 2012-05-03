package com.afanou.dev.android;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements OnClickListener{

	private Intent i;
	private ImageView iv;
	private ImageButton ib;
	private Button b;
	private Bitmap bmp;
	private final static int cameraData = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initialize();
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
	}
	
	private void initialize()
	{
		iv = (ImageView)findViewById(R.id.ivReturnedPic);
		ib = (ImageButton)findViewById(R.id.ibTakePic);
		b = (Button)findViewById(R.id.btnSetWallpaper);
		iv.setOnClickListener(this);
		ib.setOnClickListener(this);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK)
		{
			Bundle extras = data.getExtras();
			bmp = (Bitmap)extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSetWallpaper:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case R.id.ibTakePic:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData );
			break;

		default:
			break;
		}
	}
}
