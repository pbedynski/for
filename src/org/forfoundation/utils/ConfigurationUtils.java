package org.forfoundation.utils;

import android.content.res.Configuration;
import android.content.res.Resources;

public class ConfigurationUtils {

	/**
	 * 
	 * @return true if screen is large (multipanel layouts)
	 */
	public static boolean isLargeScreen(Resources res){
		return (res.getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == 
			        Configuration.SCREENLAYOUT_SIZE_LARGE;
		
	}
}
