package org.forfoundation.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

public class HomeActivity extends Activity{

	private Resources res;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		res = getResources();

	}
	
}
