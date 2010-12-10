package org.cvpcs.android.cwiidconfig.widgets;

import org.cvpcs.android.cwiidconfig.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.cvpcs.android.cwiidconfig.activity.CWiiDConfig;
import org.cvpcs.android.cwiidconfig.config.ConfigManager;

public class ViewConfigDialog extends Dialog {

	public ViewConfigDialog(Context ctx) {
		super(ctx);
		setContentView(R.layout.view_config_dlg);
		
		setTitle(R.string.view_config);
		setCancelable(true);
	
		final TextView config_text = (TextView)findViewById(R.id.view_config_dlg_text);
		final Button close_view = (Button)findViewById(R.id.view_config_dlg_close);
		
		config_text.setText(ConfigManager.getHumanReadable(CWiiDConfig.mAutoPreset.getConfig()));
		close_view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dismiss();
			}
		});
	
	}
}
