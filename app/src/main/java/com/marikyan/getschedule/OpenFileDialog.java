package com.marikyan.getschedule;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Marikyan on 02-Mar-15.
 */
public class OpenFileDialog extends AlertDialog.Builder {

    public OpenFileDialog(Context context) {
        super(context);
        setPositiveButton(android.R.string.ok, null)
                .setNegativeButton(android.R.string.cancel, null);
    }
}
