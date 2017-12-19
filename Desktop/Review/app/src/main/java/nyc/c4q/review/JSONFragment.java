package nyc.c4q.review;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
//the support helps us to be
// "backwards compatible": this means that you don't have to mess around with APIs
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class JSONFragment extends Fragment {

    //we need to set the textview here
    private TextView textView;
    private Bundle bundle;
    private String bundleString;

    public JSONFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_json, container, false);
        textView = view.findViewById(R.id.fragment_textview);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //no views are here. only data. this data does not come from your layouts. Databases and network connections
        bundle = getArguments();
        bundleString = bundle.getString("string");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView.setText(bundleString);

    }



    //control o helps you look for your methods for lifecycle!!!!!!!!!!!
}















