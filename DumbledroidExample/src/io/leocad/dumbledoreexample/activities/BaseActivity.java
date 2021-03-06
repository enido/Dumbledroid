package io.leocad.dumbledoreexample.activities;

import io.leocad.dumbledoreexample.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivity extends Activity {

	protected void onConnectionError() {

		runOnUiThread( new Runnable() {

			@Override
			public void run() {

				new AlertDialog.Builder(BaseActivity.this)
				.setTitle("Error")
				.setMessage("Data connection unavailable!")
				.setNeutralButton("OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				})
				.create()
				.show();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.menu, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
			
		case R.id.menu_about:
			startActivity( new Intent(this, AboutActivity.class) );
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
