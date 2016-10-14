package com.pauloigormoraes;
import java.util.ArrayList;

/**
 * Created by Paulo Igor Moraes (http://www.moraespaulo.com).
 */

public class State {
    String id = "";
    ArrayList<State> paths;

    public String ReportingPaths() {
        String s = "";
        for (int i = 0; i < this.paths.size(); i++) {
            s += this.paths.get(i).id;
            s += " | ";
        }
        return s;
    }

    public void geraPaths(ArrayList<State> state_list, int alphabet_size ){
        String[] array_strings = this.id.split(",");
        String new_path;
        this.paths = new ArrayList();
        for (int j=0;j<alphabet_size;j++) {
            new_path = "";
            if (array_strings.length > 1) {
                for (int i = 0; i < array_strings.length; i++) {
                    for (State state_on_list : state_list) {
                        if (state_on_list.id.equals(array_strings[i])) {
                            new_path += state_on_list.paths.get(j).id;
                            break;
                        }
                    }
                    if (i < array_strings.length - 1)
                        new_path += ",";
                }
            }
            this.paths.add(new State());
            this.paths.get(j).id = new_path;
        }
    }
}
