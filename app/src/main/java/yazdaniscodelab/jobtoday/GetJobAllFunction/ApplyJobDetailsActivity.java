package yazdaniscodelab.jobtoday.GetJobAllFunction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import yazdaniscodelab.jobtoday.R;

public class ApplyJobDetailsActivity extends AppCompatActivity {

    private TextView jobTitle;
    private TextView jobDescription;
    private TextView jobPosition;
    private TextView jobExperience;
    private TextView jobStart;
    private TextView jobAddress;
    private TextView jobSkills;
    private TextView jobContact;

    private TextView jobPublisheddate;


    private Button btnapply;

    private boolean b=true;

//    Firebase..

    private DatabaseReference mDatabase;
    private DatabaseReference youJobDatabase;
    private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job_details);

        toolbar=findViewById(R.id.applydetails_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Job Details");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        jobTitle=findViewById(R.id.job_title_apply);
        jobDescription=findViewById(R.id.job_description_apply);
        jobPosition=findViewById(R.id.job_Position_apply);
        jobExperience=findViewById(R.id.job_Experience_apply);
        jobStart=findViewById(R.id.job_start_apply);
        jobAddress=findViewById(R.id.job_Address_apply);
        jobSkills=findViewById(R.id.job_Skills_apply);
        jobContact=findViewById(R.id.job_contact_apply);
        jobPublisheddate=findViewById(R.id.job_PublishedDate_apply);

        btnapply=findViewById(R.id.btn_applyjob_Apply);

        mDatabase= FirebaseDatabase.getInstance().getReference().child("PublicDatabase");
        youJobDatabase= FirebaseDatabase.getInstance().getReference().child("YourJob");


        final Intent intent=getIntent();

        String title=intent.getStringExtra("title");
        String description=intent.getStringExtra("description");
        String address=intent.getStringExtra("address");
        String date=intent.getStringExtra("date");

        String startdate=intent.getStringExtra("startdate");
        String skills=intent.getStringExtra("skills");

        final String contact=intent.getStringExtra("contact");
        String position=intent.getStringExtra("position");
        String experience=intent.getStringExtra("experience");

        final String post_key=intent.getStringExtra("post_key");

        jobTitle.setText(title);
        jobDescription.setText(description);
        jobPosition.setText(position);
        jobExperience.setText(experience);
        jobStart.setText(startdate);
        jobAddress.setText(address);
        jobSkills.setText(skills);
        jobPublisheddate.setText(date);
        jobContact.setText(contact);




        btnapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b==true){

                    btnapply.setBackgroundColor(Color.GREEN);

                    Toast.makeText(getApplicationContext(),"Job Applied"+post_key,Toast.LENGTH_SHORT).show();

                    String id=youJobDatabase.push().getKey();
                    youJobDatabase.child(id).setValue(post_key);



//                    Intent myintent=new Intent(getApplicationContext(),testActivity.class);
//
//                    intent.putExtra("key",post_key);
//                    startActivity(myintent);

                }



            }
        });


    }
}
