package com.pauloigormoraes;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Paulo Igor Moraes (http://www.moraespaulo.com).
 */

public class Application {

    ArrayList<State> states;
    int qtd;
    String staStart = "q";
    String[] alphabet = {"0","1"};

    public static void main(String[] args) {

        Application app = new Application();

        app.Initialize();
        app.CreateTableAFN();
        app.RequertAFN();
        app.SendAFD();

    }

    public void Initialize(){
        Scanner terminalInput = new Scanner(System.in);
        System.out.printf("Quantidade: ");
        String s = terminalInput.nextLine();
        this.qtd = Integer.parseInt(s);
    }

    public void CreateTableAFN(){
        this.states = new ArrayList();
        for (int i = 0; i< this.qtd; i++ ){
            this.states.add(new State());
            this.states.get(i).id = staStart + i;
        }
    }

    public void RequertAFN(){
        Scanner terminalInput = new Scanner(System.in);
        String s;
        String[] vs;
        System.out.println("Informe a Tabela AFN:");
        System.out.println("ES:    0     1");
        for (int i = 0; i<this.qtd; i++) {
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

    public void SendAFD() { new Transition(this.states, alphabet); }
}