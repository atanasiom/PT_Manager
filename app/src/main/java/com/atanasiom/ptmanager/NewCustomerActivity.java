package com.atanasiom.ptmanager;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewCustomerActivity extends AppCompatActivity {

	private EditText firstName;
	private EditText lastName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_customer);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);

		firstName = (EditText) findViewById(R.id.field_firstName);
		lastName = (EditText) findViewById(R.id.field_lastName);
	}

	public void createNewCustomer(View view) {
		ContentValues values = new ContentValues();
		values.put("LastName", lastName.getText().toString().trim());
		values.put("FirstName", firstName.getText().toString().trim());
		values.put("Picture", Integer.toString(R.drawable.john_cena));
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