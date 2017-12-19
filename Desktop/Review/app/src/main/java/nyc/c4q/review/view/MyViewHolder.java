package nyc.c4q.review.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.review.JSONFragment;
import nyc.c4q.review.MainActivity;
import nyc.c4q.review.R;

/**
 * Created by joannesong on 12/18/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView myTextView;
    private String str;
    private Context context;
    //helps with scope. keep your instance var here

    public MyViewHolder(View itemView) {
        super(itemView);
        //cmd E - opens your folders
        //cmd W - removes your folder
        //itemview only contains a textview widget

        myTextView = (TextView) itemView.findViewById(R.id.item_textview);
        context = itemView.getContext();

    }

    public void onBind(String string){
        //onBIND SETS YOUR STUFF
        this.str = string; //*********** str is a global var
        myTextView.setText(str);
        //option + shift and movement key (up/down) = this moves your line to whereever


        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //bundle has my string!!!!
                bundle.putString("string", str);
                //how do i add this bundle to my frag???

                Toast.makeText(itemView.getContext(), str ,Toast.LENGTH_LONG ).show();
                JSONFragment jsonFragment = new JSONFragment();
                FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                //CLAPS FOR AJ!
                jsonFragment.setArguments(bundle);
                //.setArguments is the way that you ship your bundle!!!!!!!!!
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null).replace(R.id.fragment_container, jsonFragment);
                //you can add string,tag, null to your .addToBackStack.... not on the test, goes to the previous activity vs just closing your activity
                fragmentTransaction.commit();



                /*
                * W*/

                //if it's a view use .getContext()
                //if it's an activity/fragment use .getApplicationContext()
                //Log.d(); debug
                /*error - logs in red and it STANDS OUT FOR LEGIBILITY
                * verbose - prints everything*/
            }
        });

    }
}









