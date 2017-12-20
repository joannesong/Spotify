package nyc.c4q.jsonjosereviewpart2;

import java.util.List;
import java.util.Objects;

/**
 * Created by joannesong on 12/19/17.
 */

public class JSONModel {
    /*
    * 1. create a class that represents the entire JSON string
    * 2. id the fields in the JSON
    * 3. create getters and setters
    * 4. this is a json response!
    * */
    private String name;
    private List<Name> members;

    public String getName() {
        return name;
    }

    public List<Name> getMembers() {
        return members;
    }
}
