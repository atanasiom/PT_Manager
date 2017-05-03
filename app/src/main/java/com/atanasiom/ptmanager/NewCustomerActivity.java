package com.atanasiom.ptmanager;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewCustomerActivity extends AppCompatActivity {

	private static final int REQUEST_TAKE_PHOTO = 1;
	private EditText firstName;
	private EditText lastName;
	private ImageView custPhoto;
	private String mCurrentPhotoPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_customer);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);

		firstName = (EditText) findViewById(R.id.field_firstName);
		lastName = (EditText) findViewById(R.id.field_lastName);
		custPhoto = (ImageView) findViewById(R.id.image_new_customer);
	}


	private void dispatchTakePictureIntent() {
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			File photoFile = null;
			try {
				photoFile = createImageFile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (photoFile != null) {
				Uri photoURI = FileProvider.getUriForFile(this, "com.atanasiom.ptmanager.fileprovider", photoFile);
				takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
				startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
			}
		}
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		System.out.println(data);
		if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
			custPhoto.setImageBitmap(BitmapFactory.decodeFile(mCurrentPhotoPath));
		}
	}

	private File createImageFile() throws IOException {
		// Create an image file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String imageFileName = "JPEG_" + timeStamp + "_";
		File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
		File image = File.createTempFile(imageFileName,  /* prefix */
				".jpg",         /* suffix */
				storageDir      /* directory */);

		// Save a file: path for use with ACTION_VIEW intents
		mCurrentPhotoPath = image.getAbsolutePath();
		return image;
	}

	public void takePicture(View view) {
		dispatchTakePictureIntent();
	}

	public void createNewCustomer(View view) {
		ContentValues values = new ContentValues();
		values.put("LastName", lastName.getText().toString().trim());
		values.put("FirstName", firstName.getText().toString().trim());
		values.put("Picture", mCurrentPhotoPath);
		CustomerListActivity.customerDatabase.insert(CustomerListActivity.CUSTOMER_TABLE, null, values);
		Toast.makeText(this, "Customer created successfully!", Toast.LENGTH_SHORT).show();
		finish();
	}

	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_right);
	}
}