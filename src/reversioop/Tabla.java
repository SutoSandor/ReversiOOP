/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversioop;

import java.io.BufferedReader;
import java.io.FileReader;


public class Tabla {
    private int N = 8;
    private int M = 8;
    private char[][] t = new char[N][M];
    
    public Tabla(String fajl){
        try{
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            char[] c;
            for (int i = 0; i < N; i++) {
                c = s.toCharArray();
                for (int j = 0; j < M; j++) {
                    t[i][j] = c[j];
                }
                s = br.readLine();
            }            
            /*
            while(s != null){
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        c[j] = s.charAt(j);
                        t[i][j] = c[j];
                    }
                }
                s = br.readLine();
            }
            */
            br.close();
            fr.close();
        }
        catch(Exception e){
            
        }
    }
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                s += t[i][j]+" ";
            }
            s += "\n";
        }
        
        return s;
    }
    public int megszamlal(char c){
        int db = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (t[i][j] == c) {
                   db++; 
                }
            }
        }
        return db;
    }
    public boolean VanForditas(char jatekos, int sor, int oszlop, int iranySor, int iranyOszlop){
        int aktSor, aktOszlop;
        char ellenfel;
        boolean nincsEllenfel;
        aktSor = sor + iranySor;
        aktOszlop = oszlop + iranyOszlop;
        ellenfel = 'K';
        if (jatekos == 'K') {
            ellenfel = 'F';
        }
        nincsEllenfel = true;
        while(((aktSor<8 && aktSor>0) && (aktOszlop<8 && aktOszlop>0) && (t[aktSor][aktOszlop] == ellenfel))){
            aktSor = aktSor + iranySor;
            aktOszlop = aktOszlop + iranyOszlop;
            nincsEllenfel = false;
        }
        if (nincsEllenfel || aktSor<0 ||aktSor>7 || aktOszlop<0 ||aktOszlop>7|| t[aktSor][aktOszlop]!=jatekos ) {
            return false;
        }
        return true;
    }

    
}
