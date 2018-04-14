package yazdaniscodelab.jobtoday.HireStuff;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import yazdaniscodelab.jobtoday.GetJobAllFunction.GetJobRegistrationActivity;
import yazdaniscodelab.jobtoday.GetJobAllFunction.HomeGetJobActivity;
import yazdaniscodelab.jobtoday.MainActivity;
import yazdaniscodelab.jobtoday.R;

public class HireStuffLoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText email;
    private EditText password;
    private TextView registration;
    private Button login;
    private TextView forgetpass;

    private ProgressDialog mDialog;

    //Firebase..

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_stuff_login);

        mAuth=FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }


        email=findViewById(R.id.edittext_email);
        password=findViewById(R.id.edittext_password);

        registration=findViewById(R.id.registraion_xml);
        login=findViewById(R.id.login_xml);
        forgetpass=findViewById(R.id.forgetpassword_xml);


        mDialog=new ProgressDialog(this);


        registration.setOnClickListener(this);
        login.setOnClickListener(this);
        forgetpass.setOnClickListener(this);


    }

    private void logindetails() {

        String mEmail=email.getText().toString().trim();
        String mPass= password.getText().toString().trim();


        if (TextUtils.isEmpty(mEmail)){
            email.setError("Email Required");
            return;
        }

        if (TextUtils.isEmpty(mPass)){
            password.setError("Password Required");
            return;
        }

        mDialog.setTitle("Login");
        mDialog.setMessage("Login is Processing..");
        mDialog.show();

        mAuth.signInWithEmailAndPassword(mEmail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    mDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),HomeHireStuffActivity.class));
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        if (view==login){

            logindetails();

        }

        if (view==registration){

            finish();
            startActivity(new Intent(getApplicationContext(),HireStuffRegActivity.class));

        }

        if (view==forgetpass){


        }

    }


}
