package edu.unicauca.burnout;

import java.util.ArrayList;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import edu.unicauca.burnout.adapter.ListaMenuDesplegableAdapter;
import edu.unicauca.burnout.model.ItemMenuDesplegable;
import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MenuActivity extends ActionBarActivity {

	private DrawerLayout drawerLayout;
	private ListView listViewMenuDesplegable;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence tituloMenuDesplegable;
	private CharSequence tituloAplicacion;
	private String[] titulosMenuDesplegable;
	private TypedArray iconosMenuDesplegable;
	private ArrayList<ItemMenuDesplegable> itemsMenuDesplegable;
	private ListaMenuDesplegableAdapter adapter;

	@TargetApi(14)
	public void enableHomeButton() {
		if (android.os.Build.VERSION.SDK_INT >= 14)
			getActionBar().setHomeButtonEnabled(true);
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		tituloAplicacion = tituloMenuDesplegable = getTitle();
		titulosMenuDesplegable = getResources().getStringArray(
				R.array.titulos_menu_desplegable);
		iconosMenuDesplegable = getResources().obtainTypedArray(
				R.array.iconos_menu_desplegable);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_menu);
		listViewMenuDesplegable = (ListView) findViewById(R.id.list_menu_desplegable_menu);

		itemsMenuDesplegable = new ArrayList<ItemMenuDesplegable>();
		itemsMenuDesplegable.add(new ItemMenuDesplegable(
				titulosMenuDesplegable[0], iconosMenuDesplegable.getResourceId(
						0, -1)));
		itemsMenuDesplegable.add(new ItemMenuDesplegable(
				titulosMenuDesplegable[1], iconosMenuDesplegable.getResourceId(
						1, -1)));
		itemsMenuDesplegable.add(new ItemMenuDesplegable(
				titulosMenuDesplegable[2], iconosMenuDesplegable.getResourceId(
						2, -1)));
		itemsMenuDesplegable.add(new ItemMenuDesplegable(
				titulosMenuDesplegable[3], iconosMenuDesplegable.getResourceId(
						3, -1)));
		itemsMenuDesplegable.add(new ItemMenuDesplegable(
				titulosMenuDesplegable[4], iconosMenuDesplegable.getResourceId(
						4, -1)));
		itemsMenuDesplegable.add(new ItemMenuDesplegable(
				titulosMenuDesplegable[5], iconosMenuDesplegable.getResourceId(
						5, -1)));
		iconosMenuDesplegable.recycle();

		adapter = new ListaMenuDesplegableAdapter(getApplicationContext(),
				itemsMenuDesplegable);
		listViewMenuDesplegable.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		enableHomeButton();

		mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_menu_desplegable, R.string.app_name,
				R.string.app_name){
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(tituloAplicacion);
				invalidateOptionsMenu();
			}
			public void onDrawerOpened(View drawerView){
				getActionBar().setTitle(tituloMenuDesplegable);
				invalidateOptionsMenu();
			}
		};
		drawerLayout.setDrawerListener(mDrawerToggle);
		
		if (savedInstanceState == null) {
            // TODO Aca se debe indicar que se carga por defecto el home
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
        case R.id.action_settings:
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
	}
	
	/***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = drawerLayout.isDrawerOpen(listViewMenuDesplegable);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
    
    @Override
    public void setTitle(CharSequence title) {
        tituloAplicacion = title;
        getActionBar().setTitle(tituloAplicacion);
    }
    
    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
 
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
 
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
