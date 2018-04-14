package yazdaniscodelab.jobtoday.GetJobAllFunction;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import yazdaniscodelab.jobtoday.HireStuff.HireStuffProfileFragment;
import yazdaniscodelab.jobtoday.HireStuff.HomeHireStuffActivity;
import yazdaniscodelab.jobtoday.HireStuff.JobPostFragment;
import yazdaniscodelab.jobtoday.MainActivity;
import yazdaniscodelab.jobtoday.R;

public class HomeGetJobActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_get_job);

        toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        viewPager=findViewById(R.id.viewpager_xml);
        setUpViewPager(viewPager);

        tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }


    private void setUpViewPager(ViewPager viewPager){

        HomeGetJobActivity.ViewpagerAdapter adapter=new HomeGetJobActivity.ViewpagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new AllJobPostFragment(),"Job Post");
        adapter.addFragment(new ProfileFragment(),"Profile");
        adapter.addFragment(new YourJobFragment(),"Your Job");
//        adapter.addFragment(new JobPostFragment(),"Profile");
        viewPager.setAdapter(adapter);

    }


    class ViewpagerAdapter extends FragmentPagerAdapter

    {

        private final List<Fragment> mFragment=new ArrayList<>();

        private final List<String> mFragmentTitle=new ArrayList<>();


        public ViewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        public void addFragment(Fragment fragment,String title){

            mFragment.add(fragment);
            mFragmentTitle.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitle.get(position);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }


}
