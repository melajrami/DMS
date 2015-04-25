package graduate.us.dms.Activities;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import graduate.us.dms.ConstantApp.AppLog;
import graduate.us.dms.ConstantApp.ConstantVariable;
import graduate.us.dms.Fragments.DashboardFragment;
import graduate.us.dms.Fragments.GlucoseFragment;
import graduate.us.dms.Fragments.SettingsFragment;
import graduate.us.dms.R;
import graduate.us.dms.view.event.IRemovableShadowToolBarShadow;


/**
 * Created by Tareq on 02/27/2015.
 */
public class BaseActivity   extends ActionBarActivity implements IRemovableShadowToolBarShadow {

    public Toolbar toolbar=null;
    public Drawer.Result result;
    public AccountHeader.Result headerResult;
    public View shadowView;
    public View toolbarContainer;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    public void SetupToolbarShadow(){
        //Shadow View
        shadowView=findViewById(R.id.shadow_main_activity);
        toolbarContainer=findViewById(R.id.activity_main_toolbar_container);
        // Solve Android bug in API < 21 by app custom shadow
        SetToolbarShadow();
    }

    public void SetToolbarShadow()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            shadowView.setVisibility(View.GONE);
            final float scale = getResources().getDisplayMetrics().density;
            toolbarContainer.setElevation(5f*scale);
        }else{
            shadowView.setVisibility(View.VISIBLE);
        }
    }
IProfile selectedProfile ;
    public void Drawable(String name , String email){
        // Create the AccountHeader
     //   String Name="";
     //   String Email="";
       selectedProfile =  new ProfileDrawerItem().withName(name).withEmail(email).withIcon(getResources().getDrawable(R.drawable.profile));

               headerResult = new AccountHeader()
                .withActivity(this)
                .withHeaderBackground(R.drawable.logo_main)
                .addProfiles(
                        selectedProfile,
                                    new ProfileDrawerItem().withName("BBBB").withEmail("HHH@hotmail.com").withIcon(getResources().getDrawable(R.drawable.profile))


        )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public void onProfileChanged(View view, IProfile profile) {

                        selectItem(ConstantVariable.Category.Profile.id);
                        selectedProfile=profile;

                    }
                })
                .build();


        result = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withHeader(R.layout.header)
                .addDrawerItems(


                        new PrimaryDrawerItem().withName(R.string.category_dashboard).withIdentifier(ConstantVariable.Category.Dashboard.id).withIcon(FontAwesome.Icon.faw_android),
                        new PrimaryDrawerItem().withName(R.string.category_glucose).withIdentifier(ConstantVariable.Category.Glucose.id).withIcon(FontAwesome.Icon.faw_android),
                        new PrimaryDrawerItem().withName(R.string.category_food).withIdentifier(ConstantVariable.Category.Food.id).withIcon(FontAwesome.Icon.faw_android),
                        // new SectionDrawerItem().withName("Sec"),
                        new PrimaryDrawerItem().withName(R.string.category_training).withIdentifier(ConstantVariable.Category.Training.id).withIcon(FontAwesome.Icon.faw_android),
                        new PrimaryDrawerItem().withName(R.string.category_medication).withIdentifier(ConstantVariable.Category.Medication.id).withIcon(FontAwesome.Icon.faw_android),
                        new PrimaryDrawerItem().withName(R.string.category_statistics).withIdentifier(ConstantVariable.Category.Statistics.id).withIcon(FontAwesome.Icon.faw_android),
                        new PrimaryDrawerItem().withName(R.string.category_Reminders).withIdentifier(ConstantVariable.Category.Reminders.id).withIcon(FontAwesome.Icon.faw_android),
                        new PrimaryDrawerItem().withName(R.string.category_setting).withIdentifier(ConstantVariable.Category.Settings.id).withIcon(FontAwesome.Icon.faw_android)

                        //,new PrimaryDrawerItem().withName(R.string.category_search).withIdentifier(ConstantVariable.Category.Search.id).withIcon(FontAwesome.Icon.faw_search),
                        //new PrimaryDrawerItem().withName(R.string.category_setting).withIdentifier(ConstantVariable.Category.Setting.id).withIcon(FontAwesome.Icon.faw_gear),
                        // For Test Only
                        // new PrimaryDrawerItem().withName(R.string.category_test).withIdentifier(ConstantVariable.Category.Test.id).withIcon(FontAwesome.Icon.faw_exchange)
                )
                .withSelectedItem(0)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            if (drawerItem instanceof Nameable) {
                                toolbar.setTitle(((Nameable) drawerItem).getNameRes());
                                //toolbar.setSubtitle(((Nameable) drawerItem).getNameRes());

                            }

                            selectItem(drawerItem.getIdentifier());

                        }
                    }
                })
                .build();


        //disable scrollbar :D it's ugly
        result.getListView().setVerticalScrollBarEnabled(false);
        selectItem(ConstantVariable.Category.Dashboard.id);
    }
    public  void  selectItem(int filter) {
        Fragment fragment = null;
        Bundle args = new Bundle();
        AppLog.i("position=> " + filter);


        if (filter == ConstantVariable.Category.Dashboard.id) {
            fragment = new DashboardFragment();
        }else  if (filter == ConstantVariable.Category.Glucose.id) {
            fragment = new GlucoseFragment();
          //  args.putString(TabFragment.FRAGMENT, GlucoseFragment.class.getName());
        }else if(filter == ConstantVariable.Category.Profile.id){
            fragment = new DashboardFragment();
        }else if(filter == ConstantVariable.Category.Settings.id){
            fragment = new SettingsFragment();

            args.putString("Profile", selectedProfile.getEmail());
        }


        fragment.setArguments(args);

        if (fragment != null) {
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_main, fragment)
                    .commit();
        }
        SetToolbarShadow();
    }

    @Override
    public void RemoveToolBarShadow() {
        shadowView.setVisibility(View.GONE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            toolbarContainer.setElevation(0);
    }
}
