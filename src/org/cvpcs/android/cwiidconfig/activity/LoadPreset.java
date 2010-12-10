package org.cvpcs.android.cwiidconfig.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import org.cvpcs.android.cwiidconfig.R;

import org.cvpcs.android.cwiidconfig.config.ConfigManager;
import org.cvpcs.android.cwiidconfig.config.Preset;
import org.cvpcs.android.cwiidconfig.config.PresetManager;

public class LoadPreset extends ListActivity {
	private static final int OPTIONS_MENU_VIEW_CONFIG = Menu.FIRST + 1;
	private static final int OPTIONS_MENU_VIEW_HELP = Menu.FIRST + 2;

	private class PresetAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		private ArrayList<Preset> isExpanded;

		public PresetAdapter(Context c) {
			inflater = LayoutInflater.from(c);
			isExpanded = new ArrayList<Preset>();
		}

		public int getCount() {
			return PresetManager.getNumPresets();
		}

		public Object getItem(int position) {
			return PresetManager.getPreset(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			final View v;
			if(convertView == null) {
				v = inflater.inflate(R.layout.load_preset_item, null);
			} else {
				v = convertView;
			}

			final Preset preset = PresetManager.getPreset(position);

			final TextView title = (TextView)v.findViewById(R.id.load_preset_item_title);
			final TextView summary = (TextView)v.findViewById(R.id.load_preset_item_summary);
			final ImageButton load = (ImageButton)v.findViewById(R.id.load_preset_item_load_button);
			final ImageButton delete = (ImageButton)v.findViewById(R.id.load_preset_item_delete_button);
			final TextView delete_text = (TextView)v.findViewById(R.id.load_preset_item_delete_text);
			final TextView system_text = (TextView)v.findViewById(R.id.load_preset_item_system_text);
			final ImageView expand_icon = (ImageView)v.findViewById(R.id.load_preset_item_view_config_icon);
			final TextView expand_text = (TextView)v.findViewById(R.id.load_preset_item_view_config_text);
			final TextView config_text = (TextView)v.findViewById(R.id.load_preset_item_config_text);;
			
			load.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					CWiiDConfig.mAutoPreset.loadFromPreset(preset);
					finish();
				}
			});

			delete.setOnClickListener(new View.OnClickListener() {
				public void onClick(final View v) {
					AlertDialog.Builder adb = new AlertDialog.Builder(v.getContext());
					adb.setIcon(android.R.drawable.ic_dialog_alert);
					adb.setMessage("Are you sure you want to delete [" + preset.getName() + "]?");
					adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(!preset.delete()) {
								Toast.makeText(v.getContext(), "Error deleting preset", 5000).show();
							}
							
							// reload presets, since we deleted one (possibly)
							PresetManager.scanPresets();
							notifyDataSetChanged();
						}
					});
					adb.setNegativeButton("No", null);
					adb.show();
				}
			});

			title.setText(preset.getName());

			if(preset.getSummary() == null) {
				summary.setVisibility(View.GONE);
			} else {
				summary.setVisibility(View.VISIBLE);
				summary.setText(preset.getSummary());
			}

			// we don't bother to show deletion options if it's a system config, and therefore
			// they are not able to delete it anyway
			if(preset.isSystem()) {
				delete.setVisibility(View.GONE);
				delete_text.setVisibility(View.GONE);
				system_text.setVisibility(View.VISIBLE);
			} else {
				delete.setVisibility(View.VISIBLE);
				delete_text.setVisibility(View.VISIBLE);
				system_text.setVisibility(View.GONE);
			}
			
			expand_icon.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if(isExpanded.contains(preset)) {
						isExpanded.remove(preset);
					} else {
						isExpanded.add(preset);
					}
					
					if(isExpanded.contains(preset)) {
						expand_icon.setImageResource(R.drawable.expander_ic_maximized);
						expand_text.setText(R.string.hide_config);
						config_text.setText(ConfigManager.getHumanReadable(preset.getConfig()));
						config_text.setVisibility(View.VISIBLE);
					} else {
						expand_icon.setImageResource(R.drawable.expander_ic_minimized);
						expand_text.setText(R.string.view_config);
						config_text.setText("");
						config_text.setVisibility(View.GONE);
					}
				}
			});

			if(isExpanded.contains(preset)) {
				expand_icon.setImageResource(R.drawable.expander_ic_maximized);
				expand_text.setText(R.string.hide_config);
				config_text.setText(ConfigManager.getHumanReadable(preset.getConfig()));
				config_text.setVisibility(View.VISIBLE);
			} else {
				expand_icon.setImageResource(R.drawable.expander_ic_minimized);
				expand_text.setText(R.string.view_config);
				config_text.setText("");
				config_text.setVisibility(View.GONE);
			}

			return v;
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load_preset);

		PresetManager.scanPresets();

		getListView().setAdapter(new PresetAdapter(this));
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0, OPTIONS_MENU_VIEW_CONFIG, 0, "View Current Configuration")
    		.setIcon(R.drawable.ic_menu_compose);
    	menu.add(0, OPTIONS_MENU_VIEW_HELP, 0, "Help")
    		.setIcon(android.R.drawable.ic_menu_help);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {
    	case OPTIONS_MENU_VIEW_CONFIG:
    		Dialog dlgAbout = new Dialog(this);
    		dlgAbout.setTitle(R.string.view_config);
    		dlgAbout.setContentView(R.layout.view_config_dlg);
    		dlgAbout.setCancelable(true);
    		
    		final TextView config_text = (TextView)dlgAbout.findViewById(R.id.view_config_dlg_text);
    		config_text.setText(ConfigManager.getHumanReadable(CWiiDConfig.mAutoPreset.getConfig()));
    		
    		dlgAbout.show();
    		return true;
    	case OPTIONS_MENU_VIEW_HELP:
    		Dialog dlgHelp = new Dialog(this);
    		dlgHelp.setTitle(R.string.help);
    		dlgHelp.setContentView(R.layout.help_dlg);
    		dlgHelp.setCancelable(true);
    		
    		final ImageView help_image = (ImageView)dlgHelp.findViewById(R.id.help_dlg_image);
    		help_image.setImageResource(android.R.drawable.ic_menu_help);
    		
    		dlgHelp.show();
    		return true;
    	}
    	
    	return false;
    }
}
