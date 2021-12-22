/**
 * MonedasDefectuosas.java
 * Programa que indica el numero de pasos para encontrar moneda defectusa
 */
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
public class MonedasDefectuosas {
    public static void main (String [] args){
        //Se crea el arreglo que contendra a las monedas
        List<Moneda> listaMonedas = new ArrayList<Moneda>();//arrayList con monedas
        double tolerancia=0.25;//tolerancia acepatada para determinar defectuosa en g
        double pesoIdeal10=10.329;//peso ideal para las monedas
        int numDefectuosas=0; //lleva registro de numero de monedas defectuosas generadas
        int numIdeales=0; //lleva registro de monedas aceptables generadas
        int pasos=1;//registro de las iteraciones realizadas hasta encontrar defectuosa
        boolean pasoIncorrecto = false; // flag para saber que ya se encontro una moneda incorrecta
        String desicionCinco="";//inicializa desicion del ususario
        int cuentaCinco=0;//lleva cuenta de monedas de 5 introducidas
        Scanner sc= new Scanner(System.in); //objeto Scanner
        double pesoEnCadaPaso; //
        System.out.println("Peso (g) || Informacion");
        //for que llenara la lista de  100 monedas
        for (int i=0; i<100;i++){
            double p = 10.029+Math.random()*0.6;//p almacena un valor entre ideal+-0.30 De 10.029 a 10.629
            listaMonedas.add(new Moneda(p,10));//Se agregan de manera aleatoria monedas 

            if(p<pesoIdeal10-tolerancia || p>pesoIdeal10+tolerancia){//defectuosas en el rango menor a 10.079 o mayor 10.579 
                numDefectuosas+=1; //Actualiza conteo de defectuosas
                System.out.print(listaMonedas.get(i).getPeso()); //Obtiene la propiedad peso de Moneda
                System.out.println(" defectuosa");
            }else{
                numIdeales+=1; //Actualiza conteo de monedas correctas
                System.out.print(listaMonedas.get(i).getPeso());//Obtiene la propiedad peso de Moneda
                System.out.println(" correcta");
            }
        }
        //iteraciones para encontar moneda defectuosa
        while(pasoIncorrecto==false){//mientras no se tenga un moneda Incorrecta
            int indiceAleatorio=(int)(Math.random()*99); //genera un indice aleatorio de la lista de monedas
            pesoEnCadaPaso = listaMonedas.get(indiceAleatorio).getPeso();//obtiene peso de cada moneda seleccionada
            System.out.println("===============================");
            System.out.println("Buscando defectuosa: "+pesoEnCadaPaso+" g");//indica que esta buscando moneda defedtuosa
            if(pesoEnCadaPaso<pesoIdeal10-tolerancia || pesoEnCadaPaso>pesoIdeal10+tolerancia){//Encuentra una moneda defectuosa
                pasoIncorrecto=true; //actualiza estado al encontrar moneda defectuosa
                //se indica informacion obtenida
                System.out.println(">>Se encontro un moneda defectuosa: "+pesoEnCadaPaso+" g");
                System.out.println("\nHay "+numDefectuosas+" monedas defectuosas");
                System.out.println("\nHay "+numIdeales+" monedas correctas");
                System.out.println("\nTomo "+pasos+" pasos encontar una moneda defectuosa");
                System.out.println("\nHay "+cuentaCinco+" monedas de 5");
                //Se pediran monedas de 5
                System.out.println("¿Desea introducir una moneda de 5?");
                System.out.println("Presione 5, si no,presione cualquier otra tecla");
                desicionCinco = sc.nextLine();
                if (desicionCinco.equals("5")){//se introdujo moneda de 5
                    listaMonedas.add(new Moneda(10.329,5));//se anade moneda de 5 a la lista
                    cuentaCinco+=1;//aumenta la cuenta de monedas de 5
                    pasos=1;//Regresa a 1 los pasos para volver a buscar
                    pasoIncorrecto=false;//actualiza variable de control
                }else{
                    break;//si no se meten mas monedas termina el ciclo
                }
            }
            else{
                pasos+=1;//aumenta los pasos
            }
        }
        sc.close(); //Se cierra el objeto Scanner
    }
}
