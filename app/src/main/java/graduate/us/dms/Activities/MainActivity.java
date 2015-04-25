package graduate.us.dms.Activities;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import graduate.us.dms.ConstantApp.AppLog;
import graduate.us.dms.R;


public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = getIntent().getStringExtra("Name");
        String email = getIntent().getStringExtra("Email");

        int x = 10;
        toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        setSupportActionBar(toolbar);

        SetupToolbarShadow();

        Drawable(name,email);
        AppLog.i("jma " + x);
    }


}
