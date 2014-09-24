package edu.unicauca.burnout.adapter;

import java.util.ArrayList;

import edu.unicauca.burnout.R;
import edu.unicauca.burnout.model.ItemMenuDesplegable;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaMenuDesplegableAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<ItemMenuDesplegable> itemsMenuDesplegable;
	
	public ListaMenuDesplegableAdapter(Context context,
			ArrayList<ItemMenuDesplegable> itemsMenuDesplegable) {
		this.context = context;
		this.itemsMenuDesplegable = itemsMenuDesplegable;
	}

	@Override
	public int getCount() {
		return itemsMenuDesplegable.size();
	}

	@Override
	public Object getItem(int position) {
		return itemsMenuDesplegable.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_menu_desplegable, null);
		}
		
		ImageView imgIcono = (ImageView)convertView.findViewById(R.id.icono_menu_desplegable);
		imgIcono.setImageResource(itemsMenuDesplegable.get(position).getIcono());
		
		TextView txtTitulo = (TextView)convertView.findViewById(R.id.titulo_menu_desplegable);
		txtTitulo.setText(itemsMenuDesplegable.get(position).getTitulo());
		
		return convertView;
	}
	
	

}
