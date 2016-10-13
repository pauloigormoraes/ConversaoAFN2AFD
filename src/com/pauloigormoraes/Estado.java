package com.pauloigormoraes;
import java.util.ArrayList;

/**
 * Created by developer on 01/10/16.
 */

public class Estado {
    // "Q0,Q1,Q2"
    String id = "";
    ArrayList<Estado> paths;

    public String PrintPaths() {
        String s = "";
        for (int i = 0; i < this.paths.size(); i++) {
            s += this.paths.get(i).id;
            s += " | ";
        }
        return s;
    }

    public void geraPaths( ArrayList<Estado> lista_de_estados, int tamanho_alfabeto ){
        String[] vetor_de_strings = this.id.split(",");
        String novo_path;
        this.paths = new ArrayList();
        for (int j=0;j<tamanho_alfabeto;j++) {
            novo_path = "";
            if (vetor_de_strings.length > 1) {
                for (int i = 0; i < vetor_de_strings.length; i++) {
                    for (Estado estado_da_lista : lista_de_estados) {
                        if (estado_da_lista.id.equals(vetor_de_strings[i])) {
                            novo_path += estado_da_lista.paths.get(j).id;
                            break;
                        }
                    }
                    if (i < vetor_de_strings.length - 1)
                        novo_path += ",";
                }
            }
            this.paths.add(new Estado());
            this.paths.get(j).id = novo_path;
        }
    }

}
