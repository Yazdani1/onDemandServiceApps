package yazdaniscodelab.jobtoday.HireStuff;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

import yazdaniscodelab.jobtoday.HireStuffModel.HireStuffData;
import yazdaniscodelab.jobtoday.R;

public class HireStuffPostJobActivity extends AppCompatActivity {

    private Toolbar toolbar;

//    Edit Text..

    private EditText jobTitle;
    private EditText jobDescription;
    private EditText jobPosition;
    private EditText jobExperience;
    private EditText jobStart;
    private EditText jobAddress;
    private EditText jobSkills;
    private EditText jobContact;

    private Button applyJob;

//    Firebase.....

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private DatabaseReference mPublicdatabase;

//Progress Dialog

    private ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_stuff_post_job);
        toolbar=findViewById(R.id.hirestuff_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Job Post");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        mAuth=FirebaseAuth.getInstance();

        FirebaseUser mUser=mAuth.getCurrentUser();

        String uId=mUser.getUid();

        mDatabase= FirebaseDatabase.getInstance().getReference().child("HireStuffJobPost").child(uId);

        mPublicdatabase= FirebaseDatabase.getInstance().getReference().child("PublicDatabase");



//        Cast all edit text field;

        jobTitle=findViewById(R.id.job_title_xml);
        jobDescription=findViewById(R.id.job_description_xml);
        jobPosition=findViewById(R.id.job_position_xml);
        jobExperience=findViewById(R.id.job_experience_xml);
        jobStart=findViewById(R.id.job_start_xml);
        jobAddress=findViewById(R.id.job_address_xml);
        jobSkills=findViewById(R.id.job_skills_xml);
        jobContact=findViewById(R.id.job_contact_xml);
//        Apply Job Button
        applyJob=findViewById(R.id.btn_applyjob);

//        apply job button click..

        mDialog=new ProgressDialog(this);

        saveAllJobInformation();


    }


    private void saveAllJobInformation() {

        applyJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title=jobTitle.getText().toString().trim();
                String description=jobDescription.getText().toString().trim();
                String position=jobPosition.getText().toString().trim();
                String skills=jobSkills.getText().toString().trim();
                String start=jobStart.getText().toString().trim();
                String experience=jobExperience.getText().toString().trim();
                String address=jobAddress.getText().toString().trim();
                String phone=jobContact.getText().toString().trim();


                if (TextUtils.isEmpty(title))
                {
                    jobTitle.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(description))
                {
                    jobDescription.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(position))
                {
                    jobPosition.setError("Required Field..");
                    return;
                }

                if (TextUtils.isEmpty(skills))
                {
                    jobSkills.setError("Required Field..");
                    return;
                }

                if (TextUtils.isEmpty(start))
                {
                    jobStart.setError("Required Field..");
                    return;
                }

                if (TextUtils.isEmpty(experience))
                {
                    jobExperience.setError("Required Field..");
                    return;
                }

                if (TextUtils.isEmpty(address))
                {
                    jobAddress.setError("Required Field..");
                    return;
                }

                if (TextUtils.isEmpty(phone))
                {
                    jobContact.setError("Required Field..");
                    return;
                }


                String mdate= DateFormat.getDateInstance().format(new Date());
                String id=mDatabase.push().getKey();

                HireStuffData hireStuffData=new HireStuffData(
                        title,
                        description,
                        position,
                        experience,
                        start,
                        address,
                        skills,
                        phone,
                        id,
                        mdate
                );

                mDatabase.child(id).setValue(hireStuffData);

                mPublicdatabase.child(id).setValue(hireStuffData);

                startActivity(new Intent(getApplicationContext(),HomeHireStuffActivity.class));

                Toast.makeText(getApplicationContext(),"Jop posted Successfully..",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),HomeHireStuffActivity.class));

            }
        });
    }

}
