package org.cvpcs.android.cwiidconfig.widgets;

import org.cvpcs.android.cwiidconfig.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class HelpDialog extends Dialog {

	public HelpDialog(Context ctx, int helpImageResourceId) {
		super(ctx);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.help_dlg);

		setCancelable(true);
	
		final ImageView help_image = (ImageView)findViewById(R.id.help_dlg_image);
		final Button close_help = (Button)findViewById(R.id.help_dlg_close);
		
		help_image.setImageResource(helpImageResourceId);
		close_help.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dismiss();
			}
		});
	}
}
