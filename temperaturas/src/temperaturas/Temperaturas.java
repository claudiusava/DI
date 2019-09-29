package temperaturas;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Temperaturas {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        
        boolean finPrograma = false;
        int eleccionMenuPrincipal = 0;
        double temperatura = 0;
        int contador = 0;
        int aux;
        
        ArrayList <Double> temperaturas = new ArrayList<>();

        while (finPrograma == false){            
        System.out.println("==============================");
        System.out.println("1. Introducir temperaturas.");
        System.out.println("------------------------------");
        System.out.println("2. Borrar temperaturas.");
        System.out.println("------------------------------");
        System.out.println("3. Mostrar temperaturas.");
        System.out.println("------------------------------");
        System.out.println("4. Ordenar temperaturas.");
        System.out.println("------------------------------");
        System.out.println("5. Mostrar extremos.");
        System.out.println("------------------------------");
        System.out.println("6. Mostrar medias.");
        System.out.println("------------------------------");
        System.out.println("7. Salir.");
        System.out.println("==============================");
        eleccionMenuPrincipal = sc.nextInt();
            
            switch(eleccionMenuPrincipal){           
                
                case 1:                        
                    boolean finIntroducirTemperatura = false;
                    int eleccionOtraTemperatura = 0;
        
                        System.out.println("Temperatura: ");
                        temperaturas.add (sc.nextDouble());   
                           
                        while (finIntroducirTemperatura == false){
                        System.out.println("Quieres introducir otra temperatura?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        eleccionOtraTemperatura = sc.nextInt();
                                  
                        switch(eleccionOtraTemperatura){                       
                        case 1:
                        System.out.println("Nueva temperatura: ");
                        temperaturas.add (sc.nextDouble());                            
                        break;
                            
                        case 2:
                            finIntroducirTemperatura = true;
                            break;
        
                        default:
                            System.out.println("La opción elegida no existe.");
                        }
                        }                    
                break;
                    
                case 2:           
                    if(temperaturas.size()==0){
                        System.out.println("Todavía no existen temperaturas registradas para poder borrar.");
                    }else{
                    for(int i=0;i < temperaturas.size(); i++){                  
                    System.out.println((i+1)+". "+temperaturas.get(i)+"ºC.");    
                    }                    
                    System.out.println("");
                    System.out.println("¿Qué temperatura quieres borrar?");
                    temperaturas.remove(sc.nextInt()-1); 
                    System.out.println("");
                    }
                    break;
                
                case 3:
                    System.out.println("");
                    for(int i=0;i < temperaturas.size(); i++){
                    System.out.println((i+1)+". "+temperaturas.get(i)+"ºC.");                       
                    }                    
                    if(temperaturas.size()==0){
                        System.out.println("Todavía no existen temperaturas registradas.");
                    }  
                    System.out.println("");
                    break;
       
                case 4:
                    if(temperaturas.size()==0){
                        System.out.println("Todavía no existen temperaturas registradas para poder ordenar.");
                    }
                    System.out.println("");
                    Collections.sort(temperaturas);
                    for(int i=0;i < temperaturas.size(); i++){
                    System.out.println((i+1)+". "+temperaturas.get(i)+"ºC.");                       
                    }       
                    System.out.println("");
                    break;
    
                case 5:
                    if(temperaturas.size()==0){
                        System.out.println("Todavía no existen temperaturas registradas para poder mostrar los extremos.");
                    }else{
                    System.out.println("");
                    System.out.println("La temperatura minima registrada es de: "+Collections.min(temperaturas)+"ºC");
                    System.out.println("La temperatura máxima registrada es de: "+Collections.max(temperaturas)+"ºC");
                    System.out.println("");
                    System.out.println("Hay "+temperaturas.size()+" temperaturas registradas.");
                    }
                    break;
            
                case 6:
                    if(temperaturas.size()==0){
                        System.out.println("Todavía no existen temperaturas registradas para poder hacer la media.");
                    }else{
                    double n = 0;
                    for (Double temperatura1 : temperaturas) {
                    n += Double.parseDouble(temperatura1.toString());
                    }                    
                    System.out.println("La media de las temperaturas registradas es: "+n/temperaturas.size()+"ºC");
                    }
                    break;
                                       
                case 7: 
                    finPrograma = true;
                    System.out.println("Programa finalizado.");
                    break;
                                  
                default:
                    System.out.println("Introduce un opción correcta!");
            }
        }
        
    }
    
}
