package com.pauloigormoraes;
import java.util.ArrayList;

/**
 * Created by Paulo Igor Moraes (http://www.moraespaulo.com).
 */

public class ConverteParaAFD {

    ArrayList<Estado> eafn;
    String[] alfabeto;

    String[] tab_ax;

    public ConverteParaAFD(ArrayList<Estado> estados_usu, String[] alfabeto){

        this.eafn = estados_usu;
        this.alfabeto = alfabeto;

        FazerTroca(estados_usu);

        ReportingArray(estados_usu);

    }

    public void FazerTroca(ArrayList<Estado> estados_usu) {

        int tam = estados_usu.size();

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < estados_usu.get(i).paths.size(); j++) {

                tab_ax = (estados_usu.get(i).paths.get(j).id).split(",");

                if (tab_ax.length > 1) {
                    estados_usu.add(new Estado());
                    estados_usu.get(estados_usu.size()-1).id = estados_usu.get(i).paths.get(j).id;
                    estados_usu.get(estados_usu.size()-1).geraPaths(this.eafn,this.alfabeto.length);

                }

            }

        }

    }

    public void ReportingArray(ArrayList<Estado> array) {
        for (int k = 0; k < array.size(); k++) {
            System.out.println(array.get(k).id + " | " + array.get(k).PrintPaths());
        }
    }

}
