package uni.eszterhazy.keretrendszer.model;

import uni.eszterhazy.keretrendszer.exception.NevNemUres;
import uni.eszterhazy.keretrendszer.exception.RosszGyartasiNap;

import java.time.LocalDate;
import java.util.UUID;

public class Termek {
    private String nev;
    private String id;
    private LocalDate gyartasinap;
    private Kategoria kategoria;
    private double ar;


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


    public double getAr() {
        return ar;
    }
    public void setAr(double ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "Termek{" +
                "nev='" + nev + '\'' +
                ", id='" + id + '\'' +
                ", gyartasinap=" + gyartasinap +
                ", kategoria=" + kategoria +
                ", ar=" + ar +
                '}';
    }
}
