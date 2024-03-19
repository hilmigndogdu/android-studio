package com.gazi.tekfak.ayberk.beltek71recyclerview;

public class Sehirler {

    private String sehir_adi;
    private String ulke_adi;
    private String resim_adi;

    public Sehirler(String sehir_adi, String ulke_adi, String resim_adi) {
        this.sehir_adi = sehir_adi;
        this.ulke_adi = ulke_adi;
        this.resim_adi = resim_adi;
    }

    public String getSehir_adi() {
        return sehir_adi;
    }

    public void setSehir_adi(String sehir_adi) {
        this.sehir_adi = sehir_adi;
    }

    public String getUlke_adi() {
        return ulke_adi;
    }

    public void setUlke_adi(String ulke_adi) {
        this.ulke_adi = ulke_adi;
    }

    public String getResim_adi() {
        return resim_adi;
    }

    public void setResim_adi(String resim_adi) {
        this.resim_adi = resim_adi;
    }
}
