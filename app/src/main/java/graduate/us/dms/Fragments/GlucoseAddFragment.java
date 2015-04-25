package graduate.us.dms.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import graduate.us.dms.R;
import graduate.us.dms.view.event.IRemovableShadowToolBarShadow;

//   import graduate.us.dms.db.dal.HolidayDao;

/**
 * Created by Tareq on 03/05/2015.
 */
public class GlucoseAddFragment extends BaseFragment {

    private EditText et_glucose_date,et_glucose_time,et_glucose_breakfast,et_glucose_remainder,et_glucose_note,et_glucose_reading;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

        ((IRemovableShadowToolBarShadow) getActivity()).RemoveToolBarShadow();

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setSubTitle("Add");
    }





    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_save, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ic_menu_save_menu:
                Add();
                break;
            default:
                break;
        }
        return true;
    }

    public void Add(){
        getActivity().finish();
        Toast.makeText(getActivity(), "Successful Adding", Toast.LENGTH_LONG).show();
     /*   try {
            AppLog.i("ID== >>> " + ID);
            HolidayDao holiday = new HolidayDao();

            // BR BR_AUH_005
            if (holidayName.getText().toString().trim().equals(""))
                throw new BusinessRoleError(R.string.BR_HLD_005);
            // BR BR_AUH_004
            if (startDate.getText().toString().trim().equals("") || endDate.getText().toString().trim().equals(""))
                throw new BusinessRoleError(R.string.BR_HLD_004);

            long startDateMil = (long) startDate.getTag();
            long endDateMil = (long) endDate.getTag();

            if(ID!=null && ID!=0)
                holiday.Edit(ID, holidayName.getText().toString().trim(), startDateMil, endDateMil);
            else
                holiday.Add(holidayName.getText().toString().trim(), startDateMil, endDateMil);

            getActivity().finish();
            Toast.makeText(getActivity(), R.string.holiday_add_successfully, Toast.LENGTH_LONG).show();
        }catch (BusinessRoleError ex){
            AppAction.DiaplayError(getActivity(), ex.getMessage());
        }
        */
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    private  void fillDate(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.glucose_add_fragment, container, false);
        removeShadowForNewApi21(rootView);

        et_glucose_date = (EditText)rootView.findViewById(R.id.et_glucose_date);
        SetDateControl_New(et_glucose_date);
        et_glucose_time = (EditText)rootView.findViewById(R.id.et_glucose_time);
        SetTimeControl_New(et_glucose_time);
        et_glucose_breakfast = (EditText)rootView.findViewById(R.id.et_glucose_breakfast);
        et_glucose_remainder=(EditText)rootView.findViewById(R.id.et_glucose_remainder);
        et_glucose_note=(EditText)rootView.findViewById(R.id.et_glucose_note);
        et_glucose_reading=(EditText)rootView.findViewById(R.id.et_glucose_reading);




        fillDate();

        return rootView;
    }



}
