package nyc.c4q.review;


import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.review.controller.MyAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.androidRV);

        //Q. What does the LinearLayoutManager do?
        //A. LLM tells the RV how they're going to layout the views (is it going to be staggered? vertical? grid?)
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        List<String> names = new ArrayList<>();
        names.add("joanne");
        names.add("jose");
        names.add("yoke");
        names.add("quana");
        names.add("tatiana");

        MyAdapter rvAdapter = new MyAdapter(names);
        recyclerView.setAdapter(rvAdapter);

        //Q.Why wouldnt we do recyclerview.setOnclick
        //A. it's going to set the listener to your entire RV
        //A. it needs to be specific! DONT!

        //MTTT -fragsss
        JSONFragment jsonFragment = new JSONFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.fragment_container, jsonFragment);
        //you can add string,tag, null to your .addToBackStack.... not on the test, goes to the previous activity vs just closing your activity
        fragmentTransaction.commit();

        //cmd d duplicates!!
        //option and drag down to highlight all of your columns


    }
}
