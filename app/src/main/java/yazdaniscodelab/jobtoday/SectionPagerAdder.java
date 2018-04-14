package yazdaniscodelab.jobtoday;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Yazdani on 3/31/2018.
 */

public class SectionPagerAdder extends FragmentPagerAdapter {
    public SectionPagerAdder(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
//                JobPostFragment requestFragment=new JobPostFragment();
//                return requestFragment;

            case 1:

//                JobPostFragment mrequestFragment=new JobPostFragment();
//                return mrequestFragment;

            case 2:

//                JobPostFragment krequestFragment=new JobPostFragment();
//                return krequestFragment;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){

        switch (position){

            case 0:
                return "Your Job";

            case 1:
                return "Chat";


            case 2:
                return "Profile";


            default:
                return null;

        }

    }

}
