package com.atanasiom.ptmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private EditText usernameText;
	private EditText passwordText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		usernameText = (EditText) findViewById(R.id.field_username);
		passwordText = (EditText) findViewById(R.id.field_password);

		String[] permissions = {"android.permission.CAMERA"};
		ActivityCompat.requestPermissions(this, permissions, 1);
	}

	public void login(View view) {
		System.out.println(passwordText.getText());
		String username = usernameText.getText().toString();
		String password = passwordText.getText().toString();
		if (getResources().getString(R.string.username).equals(username) && getResources().getString(R.string
				.password).equals(password)) {
			Toast.makeText(this, "Logged in successfully as " + username, Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, CustomerListActivity.class);
			startActivity(intent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.option_log_off:
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}