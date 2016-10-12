//package com.pauloigormoraes;
//import java.util.Scanner;
//
//public class Application {
//    Estado[] estados;
//    int qtde;
//    String estInicial = "q";
//    String estFinal;
//    String[] alfabeto = {"0","1"};
//
//    public static void main(String[] args) {
//
//        Application app = new Application();
//
//        app.Initialize();
//
//        app.CriarTabelaAFN();
//
//        app.SolicitaAFN();
//
//        app.SendAFD();
//
//    }
//
//    public void Initialize(){
//        //create the Scanner
//        Scanner terminalInput = new Scanner(System.in);
//        //read input
//        System.out.printf("Quantidade de estados: ");
//        String s = terminalInput.nextLine();
//        this.qtde = Integer.parseInt(s);
////        System.out.printf("Informe o estado inicial: ");
////        this.estInicial = terminalInput.nextLine();
////        System.out.printf("Informe o estado final: ");
////        this.estFinal = terminalInput.nextLine();
//
//    }
//
//    public void CriarTabelaAFN(){
//        this.estados = new Estado[this.qtde];
//        for (int i=0; i< this.qtde; i++ ){
//            this.estados[i] = new Estado(alfabeto.length);
//            this.estados[i].id = estInicial + i;
//        }
//    }
//
//    public void SolicitaAFN(){
//        Scanner terminalInput = new Scanner(System.in);
//        String s;
//        String[] vs;
//        System.out.println("Informe a Tabela AFN:");
//        System.out.println("ES: 0   1");
//        for (int i=0;i<this.qtde;i++) {
//            System.out.print(this.estados[i].id+": ");
//            s = terminalInput.nextLine();
////            vs = s.split("\\|");
//            vs = s.split(" ");
//            for (int j = 0; j < vs.length; j++) {
//                this.estados[i].paths.get(j) = new Estado(alfabeto.length);
//                this.estados[i].paths[j].id = vs[j];
////                System.out.println(vs[j]);
////                System.out.println(this.estados[i].paths[j]);
////                System.out.println(this.estados[i].paths[j].id);
//            }
//        }
//    }
//
//    public void SendAFD() {
////        for (int i = 0; i < this.estados.length; i++) {
////            System.out.println(this.estados[i].id + " : " + this.estados[i].PrintPaths());
////        }
////        new ConverteParaAFD(this.estados);
//    }
//}