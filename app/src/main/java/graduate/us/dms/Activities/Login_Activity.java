package graduate.us.dms.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;

import graduate.us.dms.R;
//import graduate.us.dms.services.auths.AppFacebookAuth;
//import graduate.us.dms.services.auths.AppGoogleAuth;

public class Login_Activity extends ActionBarActivity {
    TextView tv_title, tv_loading;
    EditText et_username, et_pass;
    ImageView img_logo;
    LinearLayout ll_loginForm;
    RelativeLayout ll_logoLoading;
    FloatingActionButton btn_fb, btn_google, btn_next;
    Display display;
    int screenHeight, screenWidth;
    float text_size;
  //  AppGoogleAuth googleAuth;
    Activity activity;
    final int SPLASH_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        NotificationDao n = new NotificationDao();
//        List<Notification> notifications = n.getAll(2);
//        Toast.makeText(getBaseContext(), notifications.size() + " Notification", Toast.LENGTH_LONG).show();
//        for (Notification notification : notifications) {
//            Calendar c = Calendar.getInstance();
//            Toast.makeText(getBaseContext(), notification.Course.Name + " ON: " + notification.CalenderDateTime.toGMTString()
//                    +" IsHoliday: "+notification.IsHoliday, Toast.LENGTH_LONG).show();
//        }


       // Intent intent = new Intent(Login_Activity.this, MainActivity.class);
      //  startActivity(intent);
      //  finish();

        setContentView(R.layout.activity_login);

        activity = this;
        // initialize Google Auth, Facebook does not need to initialize, it makes login directly
      //  googleAuth = new AppGoogleAuth(activity);

   //     initializeResponsiveScreenParameters();
        initializeViews();
    //    ResizeViews();
   //     hideLoginForm();



        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }





    private void initializeViews() {
    //    img_logo = (ImageView) findViewById(R.id.img_login_logo);
        tv_title = (TextView) findViewById(R.id.tv_login_title);
       // tv_loading = (TextView) findViewById(R.id.tv_login_loading);
        et_username = (EditText) findViewById(R.id.et_login_username);
        et_pass = (EditText) findViewById(R.id.et_login_pass);
      //  btn_fb = (FloatingActionButton) findViewById(R.id.fab_login_facebook);
      //  btn_google = (FloatingActionButton) findViewById(R.id.fab_login_google);
        btn_next = (FloatingActionButton) findViewById(R.id.fab_login_next);
     //   ll_loginForm = (LinearLayout) findViewById(R.id.ll_login_form);
      //  ll_logoLoading = (RelativeLayout) findViewById(R.id.rl_login_logoLoading);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
     //   googleAuth.mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
   //     if (googleAuth.mGoogleApiClient.isConnected()) {
     //       googleAuth.mGoogleApiClient.disconnect();
        }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


    }
}
