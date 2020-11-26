package uni.eszterhazy.keretrendszer.model;

import uni.eszterhazy.keretrendszer.exception.ArNegativ;
import uni.eszterhazy.keretrendszer.exception.NevNemUres;
import uni.eszterhazy.keretrendszer.exception.RosszGyartasiNap;

import java.time.LocalDate;
import java.util.UUID;

public class Termek {
    private String nev;
    private String id;
    private double ar;
    private LocalDate gyartasinap;
    private Kategoria kategoria;


    public Termek() {
        this.id= UUID.randomUUID().toString();
    }


    public String getNev() {
        return nev;
    }
    public void setNev(String nev) throws NevNemUres {
        if(nev.trim().length()==0){
            throw new NevNemUres();
        }
        this.nev = nev;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public double getAr() {
        return ar;
    }
    public void setAr(double ar) throws ArNegativ {
        if(ar < 0){
            throw new ArNegativ(ar);
        }
        this.ar = ar;
    }


    public LocalDate getGyartasinap() {
        return gyartasinap;
    }
    public void setGyartasinap(LocalDate gyartasinap) throws RosszGyartasiNap {
        if(gyartasinap.isAfter(LocalDate.now())){
            throw new RosszGyartasiNap("A gyártási nap dátuma nem megfelelő " +gyartasinap);
        }
        this.gyartasinap = gyartasinap;
    }


    public Kategoria getKategoria() {
        return kategoria;
    }
    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }


    @Override
    public String toString() {
        return "Termek{" +
                "nev='" + nev + '\'' +
                ", id='" + id + '\'' +
                ", ar=" + ar +
                ", gyartasinap=" + gyartasinap +
                ", kategoria=" + kategoria +
                '}';
    }
}
