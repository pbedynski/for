package org.forfoundation.activities;

import org.forfoundation.R;
import org.forfoundation.fragments.AboutCategoryListFragment;
import org.forfoundation.fragments.ProjectsCategoryListFragment;
import org.forfoundation.fragments.PublicationsCategoryListFragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;

public class HomeActivity extends Activity {

	private Resources res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		res = getResources();
		// Notice that setContentView() is not used, because we use the root
		// android.R.id.content as the container for each fragment

		setActionBar();

	}

	private void setActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setIcon(res.getDrawable(R.drawable.ic_launcher)); // TODO: change to better icon
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);

		Tab tab = actionBar
				.newTab()
				.setText(R.string.about)
				.setTabListener(new MainTabListener<AboutCategoryListFragment>(this,
								"about", AboutCategoryListFragment.class));
		actionBar.addTab(tab);

		tab = actionBar
				.newTab()
				.setText(R.string.publications)
				.setTabListener(new MainTabListener<PublicationsCategoryListFragment>(this, "publications",
								PublicationsCategoryListFragment.class));
		actionBar.addTab(tab);

		tab = actionBar
				.newTab()
				.setText(R.string.projects)
				.setTabListener(new MainTabListener<ProjectsCategoryListFragment>(this,
								"projects", ProjectsCategoryListFragment.class));
		actionBar.addTab(tab);

	}

	public static class MainTabListener<T extends Fragment> implements
			ActionBar.TabListener {
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;

		/**
		 * Constructor used each time a new tab is created.
		 * 
		 * @param activity
		 *            The host Activity, used to instantiate the fragment
		 * @param tag
		 *            The identifier tag for the fragment
		 * @param clz
		 *            The fragment's Class, used to instantiate the fragment
		 */
		public MainTabListener(Activity activity, String tag, Class<T> clz) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
		}

		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// Check if the fragment is already initialized
			if (mFragment == null) {
				// If not, instantiate and add it to the activity
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment, mTag);
			} else {
				// If it exists, simply attach it in order to show it
				ft.attach(mFragment);
			}
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (mFragment != null) {
				// Detach the fragment, because another one is being attached
				ft.detach(mFragment);
			}
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// User selected the already selected tab. Usually do nothing.
		}

	}

}
