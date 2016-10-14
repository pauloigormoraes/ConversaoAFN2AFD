package com.pauloigormoraes;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Paulo Igor Moraes (http://www.moraespaulo.com).
 */

public class Application {

    ArrayList<State> states;
    int qtde;
    String estInicial = "q";
    String estFinal;
    String[] alfabeto = {"0","1"};

    public static void main(String[] args) {

        Application app = new Application();

        app.Initialize();

        app.CriarTabelaAFN();

        app.SolicitaAFN();

        app.SendAFD();

    }

    public void Initialize(){
        Scanner terminalInput = new Scanner(System.in);
        System.out.printf("Quantidade de states: ");
        String s = terminalInput.nextLine();
        this.qtde = Integer.parseInt(s);
    }

    public void CriarTabelaAFN(){
        this.states = new ArrayList();
        for (int i=0; i< this.qtde; i++ ){
            this.states.add(new State());
            this.states.get(i).id = estInicial + i;
        }
    }

    public void SolicitaAFN(){
        Scanner terminalInput = new Scanner(System.in);
        String s;
        String[] vs;
        System.out.println("Informe a Tabela AFN:");
        System.out.println("ES: 0   1");
        for (int i=0;i<this.qtde;i++) {
            System.out.print(this.states.get(i).id+": ");
            s = terminalInput.nextLine();
//            vs = s.split("\\|");
            vs = s.split(" ");
            this.states.get(i).paths = new ArrayList();
            for (int j = 0; j < vs.length; j++) {
                this.states.get(i).paths.add(new State());
                this.states.get(i).paths.get(j).id = vs[j];
            }
        }
    }

    public void SendAFD() {
        new Convert2AFD(this.states,alfabeto);
    }
}