package com.pauloigormoraes;

import java.util.ArrayList;

/**
 * Created by developer on 01/10/16.
 */

public class Estado {
    // "Q0,Q1,Q2"
    String id = "";
    ArrayList<Estado> paths;

//    public Estado(){
//
//    }

//    public Estado(int alfa_lenght){
//        this.paths = new Estado[alfa_lenght];
//    }

    public String PrintPaths() {
        String s = "";
        for (int i = 0; i < this.paths.size(); i++) {
            s += this.paths.get(i).id;
            s += " | ";
        }
        return s;
    }
}
