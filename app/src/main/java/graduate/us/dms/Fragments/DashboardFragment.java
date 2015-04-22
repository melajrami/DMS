package graduate.us.dms.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import graduate.us.dms.Activities.BaseActivity;
import graduate.us.dms.R;

//import graduate.us.dms.Lib.SlidingTabs.SlidingTabLayout;


/**
 * Created by Tareq on 02/28/2015.
 */
public class DashboardFragment extends BaseFragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ((BaseActivity) getActivity()).RemoveToolBarShadow();

        FloatingActionButton fab=(FloatingActionButton) rootView.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Marwan... We Fucked", Toast.LENGTH_LONG).show();
                //    AppAction.OpenActivityWithFRAGMENT(v.getContext(), OneFragmentActivity.class, NoteFragmentAddEdit.class.getName(),-1);

            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

    }




}
