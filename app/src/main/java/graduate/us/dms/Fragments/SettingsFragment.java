package graduate.us.dms.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import graduate.us.dms.R;

/**
 * Created by MyLabtop on 4/22/2015.
 */
public class SettingsFragment extends BaseFragment{

    private int position;
    private TextView tv_help,tv_profile,tv_notification;
    TextView tv_email;
    String email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

        email = getArguments().getString("Profile");


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

        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        tv_help = (TextView)rootView.findViewById(R.id.tv_help);
        tv_profile = (TextView)rootView.findViewById(R.id.tv_profile);
        tv_notification = (TextView)rootView.findViewById(R.id.tv_notification);

        tv_profile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                Toast.makeText(getActivity(),"Heloo",Toast.LENGTH_LONG).show();

                return false;
            }
        });





        return rootView;
    }
}
