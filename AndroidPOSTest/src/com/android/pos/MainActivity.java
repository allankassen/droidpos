package com.android.pos;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
        
      
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	MenuInflater inflater = this.getMenuInflater();
    	inflater.inflate(R.menu.mainmenu, menu);
    	
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {    	    
    	
    	switch(item.getItemId()) {
    	    	
    		case R.id.quit_application:
    			
    			Toast.makeText(MainActivity.this, "Closing the application...", Toast.LENGTH_SHORT).show();
    			//Closing the application			
    			finish();    			
    			return true;    
    			
    		default:
    			return super.onOptionsItemSelected(item);
    	
    	}
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)  {
    	
    	super.onCreateContextMenu(menu, v, menuInfo);
    	
    	MenuInflater inflater = this.getMenuInflater();
    	inflater.inflate(R.menu.product_contextmenu, menu); 
    	
    	menu.setHeaderTitle("Products");
    }
}