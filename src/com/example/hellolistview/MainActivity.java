package com.example.hellolistview;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	Button myButton;
	EditText myEditText;
	ListView myListView;

	ArrayAdapter<String> myAdapter;
	ArrayList<String> myListItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// init views
		myButton = (Button) findViewById(R.id.button1);
		myEditText = (EditText) findViewById(R.id.editText1);
		myListView = (ListView) findViewById(R.id.listView1);

		// add Listeners
		myButton.setOnClickListener(this);
		myListView.setOnItemClickListener(this);

		// init list items
		myListItems = new ArrayList<String>();
		myListItems.add("element 1");
		myListItems.add("element 2");

		// init adapter
		myAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				myListItems);

		myListView.setAdapter(myAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		String editTextContent = myEditText.getText().toString();
		myListItems.add(editTextContent);
		myAdapter.notifyDataSetChanged();

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		Toast.makeText(this, myListItems.get(arg2) + " deleted !",
				Toast.LENGTH_SHORT).show();
		myListItems.remove(arg2);
		myAdapter.notifyDataSetChanged();

	}

}
