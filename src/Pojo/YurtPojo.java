package Pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by korhanozbek on 19.07.15.
 */
@Entity
@Table(name = "yurt", schema = "", catalog = "yurt")
@IdClass(YurtPojo.class)
public class YurtPojo implements Serializable {
    private int id;
    private int turu;
    private String ili;
    private String adi;
    private String adres;
    private String sabitTelefon;
    private String cepTelefonu;
    private String webSitesi;
    private String email;
    private Integer kapasite;
    private String aciklama;
    private String imkanlari;
    private String koordinatlar;
    private String fotografOnEk;
    private Integer fotografSayisi;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "turu")
    public int getTuru() {
        return turu;
    }

    public void setTuru(int turu) {
        this.turu = turu;
    }

    @Basic
    @Column(name = "ili")
    public String getIli() {
        return ili;
    }

    public void setIli(String ili) {
        this.ili = ili;
    }

    @Basic
    @Column(name = "adi")
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Basic
    @Column(name = "adres")
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Basic
    @Column(name = "sabit_telefon")
    public String getSabitTelefon() {
        return sabitTelefon;
    }

    public void setSabitTelefon(String sabitTelefon) {
        this.sabitTelefon = sabitTelefon;
    }

    @Basic
    @Column(name = "cep_telefonu")
    public String getCepTelefonu() {
        return cepTelefonu;
    }

    public void setCepTelefonu(String cepTelefonu) {
        this.cepTelefonu = cepTelefonu;
    }

    @Basic
    @Column(name = "web_sitesi")
    public String getWebSitesi() {
        return webSitesi;
    }

    public void setWebSitesi(String webSitesi) {
        this.webSitesi = webSitesi;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "kapasite")
    public Integer getKapasite() {
        return kapasite;
    }

    public void setKapasite(Integer kapasite) {
        this.kapasite = kapasite;
    }

    @Basic
    @Column(name = "aciklama")
    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Basic
    @Column(name = "imkanlari")
    public String getImkanlari() {
        return imkanlari;
    }

    public void setImkanlari(String imkanlari) {
        this.imkanlari = imkanlari;
    }

    @Basic
    @Column(name = "koordinatlar")
    public String getKoordinatlar() {
        return koordinatlar;
    }

    public void setKoordinatlar(String koordinatlar) {
        this.koordinatlar = koordinatlar;
    }

    @Basic
    @Column(name = "fotograf_on_ek")
    public String getFotografOnEk() {
        return fotografOnEk;
    }

    public void setFotografOnEk(String fotografOnEk) {
        this.fotografOnEk = fotografOnEk;
    }

    @Basic
    @Column(name = "fotograf_sayisi")
    public Integer getFotografSayisi() {
        return fotografSayisi;
    }

    public void setFotografSayisi(Integer fotografSayisi) {
        this.fotografSayisi = fotografSayisi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YurtPojo that = (YurtPojo) o;

        if (id != that.id) return false;
        if (turu != that.turu) return false;
        if (ili != null ? !ili.equals(that.ili) : that.ili != null) return false;
        if (adi != null ? !adi.equals(that.adi) : that.adi != null) return false;
        if (adres != null ? !adres.equals(that.adres) : that.adres != null) return false;
        if (sabitTelefon != null ? !sabitTelefon.equals(that.sabitTelefon) : that.sabitTelefon != null) return false;
        if (cepTelefonu != null ? !cepTelefonu.equals(that.cepTelefonu) : that.cepTelefonu != null) return false;
        if (webSitesi != null ? !webSitesi.equals(that.webSitesi) : that.webSitesi != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (kapasite != null ? !kapasite.equals(that.kapasite) : that.kapasite != null) return false;
        if (aciklama != null ? !aciklama.equals(that.aciklama) : that.aciklama != null) return false;
        if (imkanlari != null ? !imkanlari.equals(that.imkanlari) : that.imkanlari != null) return false;
        if (koordinatlar != null ? !koordinatlar.equals(that.koordinatlar) : that.koordinatlar != null) return false;
        if (fotografOnEk != null ? !fotografOnEk.equals(that.fotografOnEk) : that.fotografOnEk != null) return false;
        if (fotografSayisi != null ? !fotografSayisi.equals(that.fotografSayisi) : that.fotografSayisi != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + turu;
        result = 31 * result + (ili != null ? ili.hashCode() : 0);
        result = 31 * result + (adi != null ? adi.hashCode() : 0);
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + (sabitTelefon != null ? sabitTelefon.hashCode() : 0);
        result = 31 * result + (cepTelefonu != null ? cepTelefonu.hashCode() : 0);
        result = 31 * result + (webSitesi != null ? webSitesi.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (kapasite != null ? kapasite.hashCode() : 0);
        result = 31 * result + (aciklama != null ? aciklama.hashCode() : 0);
        result = 31 * result + (imkanlari != null ? imkanlari.hashCode() : 0);
        result = 31 * result + (koordinatlar != null ? koordinatlar.hashCode() : 0);
        result = 31 * result + (fotografOnEk != null ? fotografOnEk.hashCode() : 0);
        result = 31 * result + (fotografSayisi != null ? fotografSayisi.hashCode() : 0);
        return result;
    }
}
