package graduate.us.dms.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import graduate.us.dms.R;
import graduate.us.dms.db.dal.ProfileDao;
import graduate.us.dms.services.AppAction;
import graduate.us.dms.services.BusinessRoleError;

/**
 * Created by MyLabtop on 4/24/2015.
 */
public class RegisterActivity extends ActionBarActivity {
    Activity activity;
    EditText et_fullName,et_email,et_password;
    Button btn_register;
    TextView btn_login;
    boolean isSuccess  =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        activity = this;
        initializeViews();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                            AddProfile();

                if(isSuccess) {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("Name",et_fullName.getText().toString().trim());
                    intent.putExtra("Email", et_email.getText().toString().trim());
                    startActivity(intent);
                    finish();
                }
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent intent = new Intent(RegisterActivity.this, Login_Activity.class);
                   startActivity(intent);
                finish();
            }
        });

    }
    public void AddProfile(){

        try {
          //  AppLog.i("ID== >>> " + ID);
            ProfileDao profile = new ProfileDao();

            if(et_fullName.getText().toString()==null || et_fullName.getText().toString().equals(""))
                throw new BusinessRoleError("Enter your Name");

                if(et_password.getText().toString()==null || et_password.getText().toString().equals(""))
                    throw new BusinessRoleError("Enter Password");
                    if(et_email.getText().toString()==null || et_email.getText().toString().equals(""))
                        throw new BusinessRoleError("Enter your Email");

        profile.Add(et_fullName.getText().toString().trim(),
                    et_password.getText().toString().trim(),
                    et_email.getText().toString().trim(),
                    0,
                    0,
                    "",
                    "",
                    "",
                    0,
                    0,
                    0,
                    0,
                     0);




            Toast.makeText(RegisterActivity.this,"successfully Registration", Toast.LENGTH_LONG).show();
            isSuccess = true;
        }catch (BusinessRoleError ex){
            AppAction.DiaplayError(RegisterActivity.this, ex.getMessage());
            isSuccess = false;
        }

    }
    private void initializeViews(){
       et_fullName = (EditText)findViewById(R.id.reg_fullname);
       et_email    = (EditText)findViewById(R.id.reg_email);
       et_password = (EditText)findViewById(R.id.reg_password);
       btn_register= (Button)findViewById(R.id.btnRegister);
       btn_login   = (TextView)findViewById(R.id.link_to_login);
    }


}
