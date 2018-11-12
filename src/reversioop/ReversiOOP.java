/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversioop;

/**
 *
 * @author soola
 */
public class ReversiOOP {
    private static  String s = "F;4;1;0;1";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tabla tabla = new Tabla("allas.txt");
        System.out.println(tabla); //Megjelenít metódus helyett
        System.out.println(tabla.megszamlal('#') +" db üres hely található!");
        System.out.println(tabla.megszamlal('F') +" db Fekete korong található!");
        System.out.println(tabla.megszamlal('K') +" db Kék korong található!");
        System.out.println(String.format("[jatekos;sor;oszlop;iranySor;iranyOszlop] = %s", s));
        String[] split;
        split = s.split(";");
        if (tabla.VanForditas(split[0].charAt(0),Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]),Integer.parseInt(split[4])) == true) {
            System.out.println("Van fordítás!");
        }
        else{
            System.out.println("Nincs fordítás!");
        }
        
        
    }
    
}
