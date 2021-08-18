package juegoschinos;
import java.util.Scanner;

public class JuegosChinos {

    public static void main(String[] args) {
       //Comienza el Juego
       juego();
    }
    
    public static int pedir(){
        Scanner leer = new Scanner(System.in);
        int num = 0;
        boolean continua;
        do{
            //El tratamiento de excepciones empieza aquí
                try{
                    continua = false;
                    num = leer.nextInt();
                    if(num < 0 || num > 3){
                        System.out.print("Lo que has introducido no está en el "
                                + "rango obligatorio (0-3)\n");
                        continua = true;
                    }
                }catch(java.util.InputMismatchException e){
                        System.out.println("Se ha introducido un carácter");
                        leer.next();
                        continua = true;
                }
            //El tratamiento de excepciones acaba aquí
            }while(continua == true);
        //Devolvemos el Valor
        return num;
    }
    
    public static void juego(){
        Scanner leer = new Scanner(System.in);
        
        //Variables
        int partidas = 0, ganador, g1=0, g2=0;
        String j1 = "Jugador1";
        String j2 = "Jugador2";
        int alt = (int) (Math.random()*4);
        int monJ1, monJ2, total;
        
        //Empezamos la partida hasta que llegamos a 5
        do{
            System.out.print("\nEMPEZAMOS "+partidas+"-5"+"\n");
            System.out.print("¿Cuantas monedas quieras guardar? "+j1+"\n");
            monJ1 = pedir();
            System.out.println("\n\n\n\n\n");
            System.out.print("\nAhora es el turno de "+j2);
            monJ2 = (int) (Math.random()*4);
            System.out.print(monJ2);
            
            total = monJ1 + monJ2;
            
            if(partidas % 2 == 0)
            {
                ganador=probar(j1,j2,monJ1,monJ2, partidas, total);
                
                switch(ganador){
                    case 0:System.out.print("\nNo ha ganado ninguno\n");
                        partidas++;break;
                    case 1:System.out.print("\n"+j1+" Ha ganado\n");
                        g1++; partidas++;break;
                    case 2:System.out.print("\n"+j2+" Ha ganado\n");
                        g2++; partidas++;break;
                    case 3:System.out.print("\n Habéis ganado los Dos\n");
                        g1++;g2++; partidas++;break;
                }
            }
            else
            {
                ganador=probar(j1,j2,monJ1,monJ2, partidas, total);
                
                switch(ganador){
                    case 0:System.out.print("\nNo ha ganado ninguno\n");
                        partidas++;break;
                    case 1:System.out.print("\n"+j1+" Ha ganado\n");
                        g1++; partidas++;break;
                    case 2:System.out.print("\n"+j2+" Ha ganado\n");
                        g2++; partidas++;break;
                    case 3:System.out.print("\n Habéis ganado los Dos\n");
                        g1++;g2++; partidas++;break;
                }
            }
        }while(partidas < 5);
        
        if(g1 == g2){
            System.out.print("\nHabéis quedado empate "+g1+" - "+g2);
        }
        else if(g1 > g2){
            System.out.print("\nHa ganado "+j1+" "+g1+" - "+g2);
        }
        else{
            System.out.print("\nHa ganado "+j2+" "+g2+" - "+g1);
        }
    }
    
    public static int probar(String j1, String j2, int num1, int num2, int cont, int total)
    {
        Scanner leer = new Scanner(System.in);
        int p1, p2;
        
        if(cont % 2 == 0){
            System.out.print("\nEmpieza "+j1);
            System.out.print("\n¿Cuantas monedas crees que hay en total? "+j1+"\n");
            p1 = leer.nextInt();
            System.out.print("\n"+j1+" cree que hay "+p1+" monedas");
            p2 = (int) (Math.random()*7);
            System.out.print("\n"+j2+" cree que hay "+p2+" monedas\n");
            
            int n = num1 + num2;
            
            System.out.print("El "+j1+" Ha guardado "+num1+" monedas "+
                    j2+" Ha guardado "+num2 +"y en total había "+n+" monedas por lo que");
            
            if(total == p1 && total == p2){
                cont ++;
                return 3;
            }
            else if(total == p1){
                cont ++;
                return 1;
            }
            else if(total == p2){
                cont ++;
                return 2;
            }
            return 0;
        }
        else
        {
            System.out.print("\nEmpieza "+j2+"\n");
            System.out.print("\n"+j2+" ya ha apostados cuantas monedas hay\n");
            p2 = (int) (Math.random()*7);
            System.out.print("\n¿Cuantas monedas crees que hay en total? "+j1+"\n");
            p1 = leer.nextInt();
            
            if(total == p1 && total == p2){
                cont ++;
                return 3;
            }
            else if(total == p1){
                cont ++;
                return 1;
            }
            else if(total == p2){
                cont ++;
                return 2;
            }
            return 0;
        }
    }
}