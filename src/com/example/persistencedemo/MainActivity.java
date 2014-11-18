package com.example.persistencedemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	private EditText etValue;
	private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etValue = (EditText) findViewById(R.id.etValue);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        onLoad();
    }

    // Retrieve the value and put it into the edittext
    private void onLoad() {
		//String text = pref.getString("text", "");	
    	
//    	BufferedReader input = null;
//    	try {
//			input = new BufferedReader(
//			new InputStreamReader(openFileInput("myfile")));
//		
//    	String line;
//    	StringBuffer buffer = new StringBuffer();
//    	
//		while ((line = input.readLine()) != null) {
//		  buffer.append(line + "\n");
//		} 
//		
//		String text = buffer.toString();
//    	
//		etValue.setText(text);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	InputValue val = InputValue.queryMostRecent();
    	if(val != null) {
    		etValue.setText(val.text);
    	}
	}
    
    // Store the value from the edittext to disk (using different strategies)
	public void onPersist(View v) {
		//Editor edit = pref.edit();
		//edit.putString("text", etValue.getText().toString());
		//edit.remove("text");
		//edit.apply();
		
		// Use Activity method to create a file in the writeable directory
//		FileOutputStream fos = null;
//		try {
//			fos = openFileOutput("myfile", MODE_PRIVATE);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// Create buffered writer
//		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//		try {
//			writer.write(etValue.getText().toString());
//			writer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		InputValue val = new InputValue(etValue.getText().toString()); // construct object in memory
		val.save(); // INSERT INTO input_values
		
		
		
    	Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
