package com.pauloigormoraes;
import java.util.ArrayList;

/**
 * Created by Paulo Igor Moraes (http://www.moraespaulo.com).
 */

public class Transition {

    ArrayList<State> eafn, eafn_copy;
    String[] alphabet;
    String[] ar_aux_first, ar_aux_second;

    public Transition(ArrayList<State> user_states, String[] alphabet){

        this.eafn = user_states;
        this.alphabet = alphabet;

        DoExchange(user_states);

    }

    public void DoExchange(ArrayList<State> user_states) {

        int size = user_states.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < user_states.get(i).paths.size(); j++) {
                ar_aux_first = (user_states.get(i).paths.get(j).id).split(",");
                if (ar_aux_first.length > 1) {
                    user_states.add(new State());
                    user_states.get(user_states.size()-1).id = user_states.get(i).paths.get(j).id;
                    user_states.get(user_states.size()-1).geraPaths(this.eafn,this.alphabet.length);
                }
            }
        }
        CompareSets(user_states);
    }


    public void CompareSets(ArrayList<State> states) {

        eafn_copy = states;
        int tam = states.size();

        for (int i = tam-1; i <= tam; i++){
            for(int j=0;j<states.get(i).paths.size();j++){
                if (((states.get(i).id) != (states.get(i).paths.get(j).id)) && states.size() > i) {
                    ar_aux_second = (states.get(i).paths.get(j).id).split(",");
                    for (int k = 0; k < ar_aux_second.length; k++) {
                        if (ar_aux_second[k] == "0") j++; }
                    states.add(new State());
                    states.get(states.size()-1).id=states.get(i).paths.get(j).id;
                    states.get(states.size()-1).geraPaths(this.eafn,this.alphabet.length);
                }
            }
        }
        ReportingArray(states);
    }

    public void ReportingArray(ArrayList<State> array) {
        for (int k = 0; k < array.size(); k++) {
            System.out.println(array.get(k).id + " | " + array.get(k).ReportingPaths());
        }
    }

}
