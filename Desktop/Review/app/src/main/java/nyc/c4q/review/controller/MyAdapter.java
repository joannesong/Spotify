package nyc.c4q.review.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.review.R;
import nyc.c4q.review.view.MyViewHolder;

/**
 * Created by joannesong on 12/18/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<String> myStrings;


    public MyAdapter(List<String> myStrings) {
        this.myStrings = myStrings;
    }

    //The constructor was created because we need to create an instance of this adapter at some point.
    // This adapter has MY DATA!! and we need to pass on this DATA.
    /*Then we need to set this data to the instance of the class. We can use a setter. But this
    is the basic way. DO it this way.
    * */

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_itemview, parent, false);
                //Q. Why do we need false? A. it has to do with the rootview? it has to do with the RV container. LOOK IT UP
                //Q. why do we need parent.getContext()? Who is the parent? what is the getContext?
                //A. this is the view that's going to be displayed for the RV.

        return new MyViewHolder(childView);
        //Q. Why did we use the MyViewHolder? A. this childview has my itemview layout.
        // It's being shipped to myVIEWHOLDER that has my binder!!!!!!

        //cmd p sometimes give you clues of parameters
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String string = myStrings.get(position);
        //Q. What is position? when youre scrolling, this position is impt because its the location of the data in the RV.
        //Q. Why am i getting the position? impt for locating/binding the data into position

        holder.onBind(string);
        //Q. why do we need holder? A. holder is OUR VIEWHOLDER. ONBIND IS A METHOD INSIDE MYVIEWHOLDER!!!!
        //WE'RE SENDING OUR STRING TO THE VIEWHOLDER! HOLDER IS THE PARAMETER! LOOK UP
    }

    @Override
    public int getItemCount() {
        return myStrings.size();
        //we return size because we're telling the RV how large it needs to be.
        //impt because the RV needs to know how many times it needs to recycle. This helps with
        //loading and be more efficient
    }
}













