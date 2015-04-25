package graduate.us.dms.services.dailogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import graduate.us.dms.view.event.IDialogClick;

/**
 * Created by Tareq on 03/14/2015.
 */
public class AppDialog {

    public static void Delete(Context context, final IDialogClick cInterface){
        new AlertDialog.Builder(context)
                .setTitle(("Delete Confirm"))//R.string.delete_confirmation_title
                .setMessage(("Are you sure delete this!"))//R.string.delete_confirmation
                .setPositiveButton(("Yes"), new DialogInterface.OnClickListener() { //R.string.yes
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cInterface.onConfirm();
                    }
                })
                .setNegativeButton(("No"), null)//context.getString(R.string.no)
                .show();
    }
}
