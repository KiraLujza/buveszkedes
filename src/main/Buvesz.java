
package main;

import java.util.Scanner;


public class Buvesz {

    static String[] pakli = new String[22];
    
    public static void main(String[] args) {
        
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        pakli =osszerak(szinek,ertekek);
        kirak(pakli);
        for (int i = 1; i < 4; i++) {
            int oszlop = bekeres();
            String[] ujPakli = kever(oszlop, pakli);
            pakli = ujPakli;
            kirak(pakli);
        }
        melyikVolt();
        
    }
    public static String[] osszerak(String[] szinek, String[] ertekek){
        String[] ujPakli = new String[22];
        ujPakli[0] = "";
        int sz = 1;
        for (int i = 0; i < 4; i++) {
          
            if(i<3){
            for (int j = 0; j < 6; j++) {
            String ujElem = szinek[i] +"_"+ ertekek[j] ;
            ujPakli[sz] =ujElem;
                
            sz++;
            }
            }else if(i == 3){
                    for (int j = 0; j < 3; j++) {
     String ujElem =szinek[i] +"_"+ ertekek[j] ; 
     ujPakli[sz] =ujElem;
     sz++;
                    }
                    }
            
        }
        return ujPakli;
    }
    public static int bekeres(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Melyik oszlopban van?");
        int sor = sc.nextInt();
        return sor;
    }
    
    private static String[] kever( int bekertSzam,  String[] regipakli){
        
        String[] ujPakli = new String[22];
        
        switch (bekertSzam) {
            case 1: for (int i = 1; i < 8; i++) {
                    ujPakli[i] = regipakli[20 - (i - 1) * 3];
                    ujPakli[i + 7] = regipakli[19 - (i - 1) * 3];
                    ujPakli[i + 14] = regipakli[21 - (i -1) * 3];
                }
            case 3: for (int i = 1; i < 8; i++) {
                    ujPakli[i] =  regipakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = regipakli[21 - (i -1) *3];
                    ujPakli[i + 14] = regipakli[20 - (i - 1) * 3];
                }
                
            break;
               
        }
        return ujPakli;
        
    }
    private static void melyikVolt(){
        System.out.println("A gondolt lap:" + pakli[11]);
    }
    private static void kirak(String[] pakli){
       
        for (int i = 1; i < pakli.length; i++) {
             
             System.out.print("%-7s".formatted(pakli[i]));     
        if(i%3==0){
            System.out.println("\n");
        }    
          
        }
    }
    
    
}
