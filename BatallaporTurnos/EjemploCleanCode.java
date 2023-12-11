/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatallaporTurnos;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class EjemploCleanCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner Batalla = new Scanner(System.in);
        System.out.println("Batalla por turnos mediante Texto: Pulsa s o S para empezar");
        String confirmacion;
        String ataque;
        int definitiva;
        int ReinicioUltiE;
        int desgastePtsm;
        int ataqueJM;
        //Comprobacion de Contorno
        do{
            confirmacion = Batalla.nextLine();
            if( !("s".equalsIgnoreCase(confirmacion)) ){   
                System.out.println("*Reinicio del juego al no pulsar s o S*\nBatalla por turnos mediante Texto: Pulsa s o S para empezar");
            }    
        }while( !("s".equalsIgnoreCase(confirmacion)) );
        //Info Batalla
        System.out.println("... Batalla Cargada");
        Estadistica Jugador = new Estadistica(1000,200,20);
        System.out.println("Tus estadisticas:\n " + "\b" + Jugador);
        Estadistica Enemigo = new Estadistica(1900,10000,10);
        System.out.println("Las estadisticas de tu enemigo:\n" + "\b" + Enemigo);
        System.out.println("Se necesita un 100 en el medidor de Habilidad Definitiva para activarla pero el Enemigo tambien puede activar la suya por lo cual ten cuidado");
        System.out.println("Si tus PS llegan a 0 o menos GAME OVER,si los de tu enemigo llegan a 0 o menos Ganas la Batalla");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Empieza la Batalla:");          
        //Codigo de la Batalla
        while(Enemigo.pts > 0){    
            if( Jugador.pts <= 0){    
                System.out.println("GAME OVER");
                break;
            }
            System.out.println("Elige un Ataque:\n" + "\b" + "Golpes Normales,Vacio Purpura(Consume 40PM),Golpes Serios Serios Serie Consecutiva"
            + "(Habilidad Definitiva solo se puede usar cuando el Medidor de esta misma llegue a 100).");
            ataque = Batalla.nextLine();   
            if( ataque.equals("Golpes Normales") ){
                int ataqueJ = Jugador.punosNormales(Enemigo);
                definitiva = Enemigo.aumentaUlti(Enemigo);
                Enemigo.pts = ataqueJ;
                Enemigo.ulti = definitiva;
                System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                System.out.println("El enemigo Contrataca");
                int ataqueE = Enemigo.punosNormales(Jugador);
                definitiva = Jugador.aumentaUlti(Jugador);
                Jugador.pts = ataqueE;
                Jugador.ulti = definitiva;
                System.out.println("Tus estadisticas actuales:" + Jugador);
            }else if( ataque.equals("Vacio Purpura")){
                if(Jugador.ptsm == 0){
                    System.out.println("No puedes usar Vacio Purpura si no te queda PM");    
                }else if(Enemigo.ptsm == 0){
                    System.out.println("Al enemigo no le queda PM para contratacar buena Jugada");
                    definitiva = Jugador.aumentaUlti(Jugador);
                    Jugador.ulti = definitiva;
                    desgastePtsm = Jugador.desgastePM(Jugador);
                    Jugador.ptsm = desgastePtsm;
                    System.out.println("Tus estadisticas actuales:" + Jugador);    
                    ataqueJM = Jugador.vacioPurpura(Enemigo);
                    definitiva = Enemigo.aumentaUlti(Enemigo);
                    Enemigo.pts = ataqueJM;
                    Enemigo.ulti = definitiva;
                    System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                }else if(Enemigo.ptsm > 0){    
                ataqueJM = Jugador.vacioPurpura(Enemigo);
                desgastePtsm = Enemigo.desgastePM(Enemigo);
                definitiva = Enemigo.aumentaUlti(Enemigo);
                Enemigo.pts = ataqueJM;
                Enemigo.ptsm = desgastePtsm;
                Enemigo.ulti = definitiva;
                System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                System.out.println("El enemigo Contrataca");
                int ataqueEM = Enemigo.vacioPurpura(Jugador);
                desgastePtsm = Jugador.desgastePM(Jugador);
                definitiva = Jugador.aumentaUlti(Jugador);
                Jugador.pts = ataqueEM;
                Jugador.ptsm = desgastePtsm;
                Jugador.ulti = definitiva;
                System.out.println("Tus estadisticas actuales:" + Jugador);
                }
            }else if( ataque.equals("Golpes Serios Serios Serie Consecutiva")){    
                 if(Jugador.ulti != 100){    
                    System.out.println("No puedes usar la Habilidad definitiva si tu medidor no esta a 100");
                    if(Enemigo.ulti == 100){
                        System.out.println("Aun asi El enemigo usa su Habilidad Definitiva aprovechandose de tu error");
                        int ataqueESupremo = Enemigo.habilidadDefinitiva(Jugador);
                        Jugador.pts = ataqueESupremo;
                        System.out.println("Tus estadisticas actuales:" + Jugador);
                        ReinicioUltiE = Enemigo.desgasteUlti(Enemigo);
                        Enemigo.ulti = ReinicioUltiE;
                    }    
                }
                if(Jugador.ulti == 100){
                    int ataqueJSupremo = Jugador.habilidadDefinitiva(Enemigo);
                    int ReinicioUltiJ = Jugador.desgasteUlti(Jugador);
                    Enemigo.pts = ataqueJSupremo;
                    Jugador.ulti = ReinicioUltiJ;
                    System.out.println("Estadisticas Actuales del Enemigo: "+Enemigo);
                    System.out.println("Tus estadisticas actuales:" + Jugador);           
                }    
                 if (Enemigo.ulti == 100 & Jugador.ulti <= 100){    
                    System.out.println("El enemigo usa su Habilidad Definitiva");
                    int ataqueESupremo = Enemigo.habilidadDefinitiva(Jugador);
                    Jugador.pts = ataqueESupremo;
                    System.out.println("Tus estadisticas actuales:" + Jugador);
                    ReinicioUltiE = Enemigo.desgasteUlti(Enemigo);
                    Enemigo.ulti = ReinicioUltiE;
                }           
            }else{
                System.out.println("Incorrecto introduce uno de los 3 ataques mencionados");
            }   
            if(Enemigo.pts <= 0){
                System.out.println("Has ganado la batalla");
                break;
            }    
        }    
    }
    
}
