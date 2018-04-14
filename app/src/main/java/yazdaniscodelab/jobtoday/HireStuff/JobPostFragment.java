package yazdaniscodelab.jobtoday.HireStuff;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import yazdaniscodelab.jobtoday.HireStuffModel.HireStuffData;
import yazdaniscodelab.jobtoday.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobPostFragment extends Fragment {

    private FloatingActionButton fb_btn;

    private RecyclerView mrecyclerview;

//    Firebase

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.fragment_job_post, container, false);

        mAuth=FirebaseAuth.getInstance();

        FirebaseUser mUser=mAuth.getCurrentUser();

        String uId=mUser.getUid();

        mDatabase=FirebaseDatabase.getInstance().getReference().child("HireStuffJobPost").child(uId);




        mrecyclerview=myview.findViewById(R.id.show_job_post);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        mrecyclerview.setHasFixedSize(true);
        mrecyclerview.setLayoutManager(layoutManager);



        fb_btn=myview.findViewById(R.id.fab_plus_xml);

        fb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),HireStuffPostJobActivity.class));
            }
        });

        return myview;
    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<HireStuffData,MyViewHolder>recyclerAdapter=new FirebaseRecyclerAdapter<HireStuffData, MyViewHolder>
                (
                        HireStuffData.class,
                        R.layout.itemdata,
                        JobPostFragment.MyViewHolder.class,
                        mDatabase
                ) {
            @Override
            protected void populateViewHolder(MyViewHolder viewHolder, HireStuffData model, int position) {

                viewHolder.setTitle(model.getJobTitle());
                viewHolder.setDescription(model.getJobDescription());
                viewHolder.setAddress(model.getJobAddress());
                viewHolder.setDate(model.getDate());

            }
        };

        mrecyclerview.setAdapter(recyclerAdapter);

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        View myview;

        public MyViewHolder(View itemView) {
            super(itemView);
            myview=itemView;
        }


        public void setTitle(String title){

            TextView jobtitle=myview.findViewById(R.id.job_title_show);
            jobtitle.setText(title);
        }


        public void setDate(String date){

            TextView jobdate=myview.findViewById(R.id.date_show);
            jobdate.setText(date);


        }

        public void setDescription(String description){

            TextView jobdescription=myview.findViewById(R.id.job_description_show);
            jobdescription.setText(description);

        }

        public void setAddress(String address){

            TextView jobaddress=myview.findViewById(R.id.job_address_show);
            jobaddress.setText(address);

        }





    }


}
