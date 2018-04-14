package yazdaniscodelab.jobtoday.GetJobAllFunction;


import android.content.Intent;
import android.os.Bundle;
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

import yazdaniscodelab.jobtoday.HireStuff.JobPostFragment;
import yazdaniscodelab.jobtoday.HireStuffModel.HireStuffData;
import yazdaniscodelab.jobtoday.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllJobPostFragment extends Fragment {


    private RecyclerView mrecyclerview;

//    Firebase

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myview=inflater.inflate(R.layout.fragment_all_job_post, container, false);

        mAuth=FirebaseAuth.getInstance();
        FirebaseUser mUser=mAuth.getCurrentUser();
        String uId=mUser.getUid();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("PublicDatabase");
        mrecyclerview=myview.findViewById(R.id.recycler_all_post);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        mrecyclerview.setHasFixedSize(true);
        mrecyclerview.setLayoutManager(layoutManager);

        return myview;
    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<HireStuffData,AllJobPostFragment.MyViewHolder> recyclerAdapter=new FirebaseRecyclerAdapter<HireStuffData, AllJobPostFragment.MyViewHolder>
                (
                        HireStuffData.class,
                        R.layout.itemdata,
                        AllJobPostFragment.MyViewHolder.class,
                        mDatabase
                ) {
            @Override
            protected void populateViewHolder(AllJobPostFragment.MyViewHolder viewHolder, final HireStuffData model, int position) {


                final String post_key=getRef(position).getKey();

                viewHolder.setTitle(model.getJobTitle());
                viewHolder.setDescription(model.getJobDescription());
                viewHolder.setAddress(model.getJobAddress());
                viewHolder.setDate(model.getDate());
                viewHolder.setStartDate(model.getJobStart());
                viewHolder.setSkills(model.getJobSkills());

                viewHolder.setContact(model.getJobContact());
                viewHolder.setPosition(model.getJobPosition());
                viewHolder.setExperience(model.getJobExperience());

                viewHolder.myview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Toast.makeText(getActivity(),post_key,Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(getActivity(),ApplyJobDetailsActivity.class);

                        intent.putExtra("post_key",post_key);
                        intent.putExtra("title",model.getJobTitle());
                        intent.putExtra("description",model.getJobDescription());
                        intent.putExtra("address",model.getJobAddress());
                        intent.putExtra("date",model.getDate());

                        intent.putExtra("startdate",model.getJobStart());
                        intent.putExtra("skills",model.getJobSkills());

                        intent.putExtra("contact",model.getJobContact());
                        intent.putExtra("position",model.getJobPosition());
                        intent.putExtra("experience",model.getJobExperience());

                        startActivity(intent);

                    }
                });


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


        public void setStartDate(String startDate){

        }

        public void setSkills(String skills){

        }

        public void setContact(String contact){

        }

        public void setPosition(String position){

        }

        public void setExperience(String experience){

        }

    }


}
