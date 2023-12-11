/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatallaporTurnos;

/**
 *
 * @author user
 */
public class Estadistica {
    int pts;
    int ptsm;
    int ulti;
    
    Estadistica(int Vida,int Magia,int Definitiva){
        pts = Vida;
        ptsm = Magia;
        ulti = Definitiva;
    }    
    Estadistica(){
        pts = 0;
        ptsm = 0;
        ulti = 0;
    }    
    public String toString(){
        String estadisticas = "PS: " + pts + " PM: " + ptsm + ",Medidor Habilidad Definitiva: " + ulti;    
        return estadisticas;
    }    
    int punosNormales(Estadistica Herida){
        int daño = 100;
        int ataque = (Herida.pts - daño);
        return ataque;
    }    
    
    int vacioPurpura(Estadistica HeridaM){
        int dañoM = 400;
        int ataqueM = (HeridaM.pts - dañoM);
        return ataqueM;
    }    
    
    int desgastePM(Estadistica Potencia){
        int agota = 40;
        int desgaste = (Potencia.ptsm - agota);
        return desgaste;
    }    
    
    int aumentaUlti(Estadistica Aumento){
        int sube = 10;
        int incremento = (Aumento.ulti + sube);
        return incremento;
    }    
    
    int habilidadDefinitiva(Estadistica Ultima){    
        int dañoUlti = 1000;
        int ataqueUlti = (Ultima.pts - dañoUlti);
        return ataqueUlti;
    }    
    
    int desgasteUlti(Estadistica Reinicio){
        int desgasteSupremo = Reinicio.ulti = 0; 
        return desgasteSupremo;
    }
}
