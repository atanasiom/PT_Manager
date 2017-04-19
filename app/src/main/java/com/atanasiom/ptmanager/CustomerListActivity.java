package com.atanasiom.ptmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {

	private ArrayList<Customer> customerArrayList = new ArrayList<Customer>();

	private ListView customerList;
	private CustomerListViewAdapter adapter;
	private OnItemClickListener customerClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
			Intent intent = new Intent(CustomerListActivity.this, CustomerViewActivity.class);
			startActivity(intent);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_list);

		customerArrayList.add(new Customer("John Cena", R.drawable.john_cena));
		adapter = new CustomerListViewAdapter(this, R.layout.layout_customer_list);
		adapter.addAll(customerArrayList);

		customerList = (ListView) findViewById(R.id.listview_customers);
		customerList.setAdapter(adapter);
		customerList.setOnItemClickListener(customerClickListener);
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
				Toast.makeText(this, "Logging You Off", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(this, MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(intent);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}