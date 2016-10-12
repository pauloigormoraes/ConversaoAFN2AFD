package com.pauloigormoraes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by developer on 12/10/16.
 */
public class Application2 {

    ArrayList<Estado> estados;
    int qtde;
    String estInicial = "q";
    String estFinal;
    String[] alfabeto = {"0","1"};

    public static void main(String[] args) {

        Application2 app = new Application2();

        app.Initialize();

        app.CriarTabelaAFN();

        app.SolicitaAFN();

        app.SendAFD();

    }

    public void Initialize(){
        //create the Scanner
        Scanner terminalInput = new Scanner(System.in);
        //read input
        System.out.printf("Quantidade de estados: ");
        String s = terminalInput.nextLine();
        this.qtde = Integer.parseInt(s);
//        System.out.printf("Informe o estado inicial: ");
//        this.estInicial = terminalInput.nextLine();
//        System.out.printf("Informe o estado final: ");
//        this.estFinal = terminalInput.nextLine();

    }

    public void CriarTabelaAFN(){
        this.estados = new ArrayList();
        for (int i=0; i< this.qtde; i++ ){
            this.estados.add(new Estado());
            this.estados.get(i).id = estInicial + i;
        }
    }

    public void SolicitaAFN(){
        Scanner terminalInput = new Scanner(System.in);
        String s;
        String[] vs;
        System.out.println("Informe a Tabela AFN:");
        System.out.println("ES: 0   1");
        for (int i=0;i<this.qtde;i++) {
            System.out.print(this.estados.get(i).id+": ");
            s = terminalInput.nextLine();
//            vs = s.split("\\|");
            vs = s.split(" ");
            this.estados.get(i).paths = new ArrayList();
            for (int j = 0; j < vs.length; j++) {
                this.estados.get(i).paths.add(new Estado());
                this.estados.get(i).paths.get(j).id = vs[j];
            }
        }
    }

    public void SendAFD() {
        new ConverteParaAFD(this.estados,alfabeto);
    }
}