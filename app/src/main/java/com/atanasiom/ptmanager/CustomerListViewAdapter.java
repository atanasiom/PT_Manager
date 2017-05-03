package com.atanasiom.ptmanager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomerListViewAdapter extends ArrayAdapter<Customer> {

	private int layoutResourceId;

	public CustomerListViewAdapter(Context context, int layoutResourceId) {
		super(context, layoutResourceId);
		this.layoutResourceId = layoutResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
		convertView = inflater.inflate(layoutResourceId, parent, false);

		ImageView customerImage = (ImageView) convertView.findViewById(R.id.list_cust_image);
		TextView customerName = (TextView) convertView.findViewById(R.id.list_cust_name);

		Bitmap bm = BitmapFactory.decodeFile(this.getItem(position).getCustomerImagePath());
		System.out.println(this.getItem(position).getCustomerImagePath());

		if (bm == null)
			customerImage.setImageResource(this.getItem(position).getCustomerImage());
		else
			customerImage.setImageBitmap(bm);
		customerName.setText(this.getItem(position).getName());

		return convertView;
	}
}