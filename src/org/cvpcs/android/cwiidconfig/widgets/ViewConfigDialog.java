package org.cvpcs.android.cwiidconfig.widgets;

import org.cvpcs.android.cwiidconfig.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.cvpcs.android.cwiidconfig.activity.CWiiDConfig;
import org.cvpcs.android.cwiidconfig.config.ConfigManager;

public class ViewConfigDialog extends Dialog {

	public ViewConfigDialog(Context ctx) {
		super(ctx);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.view_config_dlg);
		
		setCancelable(true);
	
		final TextView config_text = (TextView)findViewById(R.id.view_config_dlg_text);
		final Button close_view = (Button)findViewById(R.id.view_config_dlg_close);
		
		String configText = ConfigManager.getHumanReadable(CWiiDConfig.mAutoPreset.getConfig());
		
		if(configText.equals("")) {
			// if we have no config text we load a string that notifies the user of that info
			config_text.setText(R.string.config_empty);
		} else {
			config_text.setText(configText);	
		}
		
		close_view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dismiss();
			}
		});
	
	}
}
