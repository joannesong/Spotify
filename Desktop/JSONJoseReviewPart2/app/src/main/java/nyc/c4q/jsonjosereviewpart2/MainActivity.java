package nyc.c4q.jsonjosereviewpart2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Q. How do we create a JSON String?
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name","Joanne");
            jsonObject.put("members", new JSONArray()
                    .put(new JSONObject().put("name", "Jose"))
                    .put(new JSONObject().put("name", "Francisco"))
                    .put(new JSONObject().put("name", "Siran")));
            Log.e("JSON!", jsonObject.toString());
//
//            {"name":"Joanne",
//              "members":[
//                  {"name":"Jose"},
//                  {"name":"Francisco"}
//                  ]
//            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        //Q.Why is a try/catch impt for JSON?
        //A. try/catch will catch the JSONException error -- this error can be nullpointer or
        //malformed JSON (someone wrote the JSON and they screwed up the syntax)
        //Q.What are the data that we store in JSONOBJECT?
        //A. Key/Value Pairs: all primitives
        //Q.How do we extract data from our JSONObject???????
        //A. jsonparse()

    }

    public void JSONparse(String str){
        try {
            JSONObject jsonObject = new JSONObject(str); // sets my string input as a JSON OBJECT. My string is not an JSONObject yet! We need to set it!
            JSONArray jsonArray = jsonObject.getJSONArray("members"); //lets extract the objects in my array and put them in an arraylist!

            List<Name> membersList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i); //this will store each index.       remember to cast!
                // i: {"name":"Jose"},{"name":"Francisco"},{"name":"Siran"}
                Name name = new Name();
                String objectName = jsonObject1.getString("name");
//                String objectName = jsonObject1.get("name").toString();
                name.setName(objectName);
                membersList.add(name);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
















