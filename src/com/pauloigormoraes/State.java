package com.pauloigormoraes;
import java.util.ArrayList;

/**
 * Created by Paulo Igor Moraes (http://www.moraespaulo.com).
 */

public class State {
    // "Q0,Q1,Q2"
    String id = "";
    ArrayList<State> paths;

    public String PrintPaths() {
        String s = "";
        for (int i = 0; i < this.paths.size(); i++) {
            s += this.paths.get(i).id;
            s += " | ";
        }
        return s;
    }

    public void geraPaths(ArrayList<State> lista_de_states, int tamanho_alfabeto ){
        String[] vetor_de_strings = this.id.split(",");
        String novo_path;
        this.paths = new ArrayList();
        for (int j=0;j<tamanho_alfabeto;j++) {
            novo_path = "";
            if (vetor_de_strings.length > 1) {
                for (int i = 0; i < vetor_de_strings.length; i++) {
                    for (State state_da_lista : lista_de_states) {
                        if (state_da_lista.id.equals(vetor_de_strings[i])) {
                            novo_path += state_da_lista.paths.get(j).id;
                            break;
                        }
                    }
                    if (i < vetor_de_strings.length - 1)
                        novo_path += ",";
                }
            }
            this.paths.add(new State());
            this.paths.get(j).id = novo_path;
        }
    }

}
