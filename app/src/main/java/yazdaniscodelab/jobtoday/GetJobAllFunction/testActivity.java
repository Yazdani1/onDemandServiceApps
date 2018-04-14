package yazdaniscodelab.jobtoday.GetJobAllFunction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import yazdaniscodelab.jobtoday.R;

public class testActivity extends AppCompatActivity {

    private TextView mykey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mykey=findViewById(R.id.test_key);

        Intent intent=getIntent();

        String keyvalue=intent.getStringExtra("key");

        mykey.setText(keyvalue);



    }
}
