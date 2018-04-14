package yazdaniscodelab.jobtoday.GetJobAllFunction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import yazdaniscodelab.jobtoday.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class YourJobFragment extends Fragment {

    private String mParam1;
    private TextView key;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview=inflater.inflate(R.layout.fragment_your_job, container, false);

        key=mview.findViewById(R.id.key_xml);



        return mview;

    }

}
