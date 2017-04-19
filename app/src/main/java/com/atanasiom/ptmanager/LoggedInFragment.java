package com.atanasiom.ptmanager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoggedInFragment extends Fragment {

	private TextView loggedInView;

	public LoggedInFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_logged_in, container, false);

		loggedInView = (TextView) root.findViewById(R.id.logged_in_view);
		loggedInView.setText("Logged in as " + getResources().getString(R.string.username));

		return root;
	}

}