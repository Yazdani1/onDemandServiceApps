package yazdaniscodelab.jobtoday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import yazdaniscodelab.jobtoday.GetJobAllFunction.GetJobLoginActivity;
import yazdaniscodelab.jobtoday.GetJobAllFunction.HomeGetJobActivity;
import yazdaniscodelab.jobtoday.HireStuff.HireStuffLoginActivity;
import yazdaniscodelab.jobtoday.HireStuff.HomeHireStuffActivity;

public class MainActivity extends AppCompatActivity {

    private Button get_job;
    private Button hire_stuff;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();


        get_job=findViewById(R.id.get_job);
        hire_stuff=findViewById(R.id.hire_job);


        // Get Job Onclick

        get_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomeGetJobActivity.class));
            }
        });


        //Hire stuff Onclick..

        hire_stuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomeHireStuffActivity.class));

            }
        });

    }


}
