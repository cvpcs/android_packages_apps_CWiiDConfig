package org.cvpcs.android.cwiidconfig.activity;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.cvpcs.android.cwiidconfig.R;

import org.cvpcs.android.cwiidconfig.config.Preset;
import org.cvpcs.android.cwiidconfig.config.PresetManager;

public class LoadPreset extends ListActivity {

	private class PresetAdapter extends BaseAdapter {
		private LayoutInflater inflater;

		public PresetAdapter(Context c) {
			inflater = LayoutInflater.from(c);
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
			View v = convertView;
			if(v == null) {
				v = inflater.inflate(R.layout.load_preset_item, null);
			}

			final Preset preset = PresetManager.getPreset(position);

			final TextView title = (TextView)v.findViewById(R.id.load_preset_item_title);
			final TextView summary = (TextView)v.findViewById(R.id.load_preset_item_summary);
			final ImageButton load = (ImageButton)v.findViewById(R.id.load_preset_item_load_button);
			final ImageButton delete = (ImageButton)v.findViewById(R.id.load_preset_item_delete_button);
			final TextView delete_text = (TextView)v.findViewById(R.id.load_preset_item_delete_text);

			load.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
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
				summary.setText(preset.getSummary());
			}

			// we don't bother to show deletion options if it's a system config, and therefore
			// they are not able to delete it anyway
			if(!preset.canDelete()) {
				delete.setVisibility(View.GONE);
				delete_text.setVisibility(View.GONE);

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
}
