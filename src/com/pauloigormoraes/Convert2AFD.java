package com.pauloigormoraes;
import java.util.ArrayList;

/**
 * Created by Paulo Igor Moraes (http://www.moraespaulo.com).
 */

public class Convert2AFD {

    ArrayList<Estado> eafn, eafn_copia;
    String[] alfabeto;

    String[] tab_ax_um, tab_ax_dois;

    public Convert2AFD(ArrayList<Estado> estados_usu, String[] alfabeto){

        this.eafn = estados_usu;
        this.alfabeto = alfabeto;

        FazerTroca(estados_usu);

    }

    public void FazerTroca(ArrayList<Estado> estados_usu) {

        int tam = estados_usu.size();

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < estados_usu.get(i).paths.size(); j++) {
                tab_ax_um = (estados_usu.get(i).paths.get(j).id).split(",");
                if (tab_ax_um.length > 1) {
                    estados_usu.add(new Estado());
                    estados_usu.get(estados_usu.size()-1).id = estados_usu.get(i).paths.get(j).id;
                    estados_usu.get(estados_usu.size()-1).geraPaths(this.eafn,this.alfabeto.length);
                }
            }
        }
        ComparaConjuntos(estados_usu);
    }


    public void ComparaConjuntos(ArrayList<Estado> estados) {

        eafn_copia = estados;
        int tam = estados.size();

        for (int i = tam-1; i <= tam; i++){
            for(int j=0;j<estados.get(i).paths.size();j++){
                if (((estados.get(i).id) != (estados.get(i).paths.get(j).id)) && estados.size() > i) {
                    tab_ax_dois = (estados.get(i).paths.get(j).id).split(",");
                    for (int k = 0; k < tab_ax_dois.length; k++) {
                        if (tab_ax_dois[k] == "0") j++; }
                    estados.add(new Estado());
                    estados.get(estados.size()-1).id=estados.get(i).paths.get(j).id;
                    estados.get(estados.size()-1).geraPaths(this.eafn,this.alfabeto.length);
                }
            }
        }
        ReportingArray(estados);
    }

    public void ReportingArray(ArrayList<Estado> array) {
        for (int k = 0; k < array.size(); k++) {
//            if (array.get(k).id != array.get(k+1).id) {
            System.out.println(array.get(k).id + " | " + array.get(k).PrintPaths());
        }
    }

}
