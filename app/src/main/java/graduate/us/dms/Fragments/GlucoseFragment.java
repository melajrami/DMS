package graduate.us.dms.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import graduate.us.dms.Activities.OneFragmentActivity;
import graduate.us.dms.R;
import graduate.us.dms.services.AppAction;

/**
 * Created by MyLabtop on 4/22/2015.
 */
public class GlucoseFragment extends BaseFragment{


    private int position;
    private EditText et_date,et_time,et_glucose_time,et_glucose_breakfast,et_glucose_remainder,et_glucose_note,et_glucose_reading;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(POSITION, 0);
    }

    @Override
    public void onResume() {
        super.onResume();

    /*    OneFragmentActivity.temp=null;
        OneFragmentActivity.setCourseName(null);
        OneFragmentActivity.setNoteType(null);
        OneFragmentActivity.setFilePath(null);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                FillDate();
            }
        }, 500);
*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_glucose, container, false);




        FloatingActionButton fab=(FloatingActionButton) rootView.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(),"Marwan... We Fucked",Toast.LENGTH_LONG).show();
                AppAction.OpenActivityWithFRAGMENT(v.getContext(), OneFragmentActivity.class, GlucoseAddFragment.class.getName(), -1);

            }
        });

        return rootView;
    }
}
