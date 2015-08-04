package Pojo;

import javax.persistence.*;

/**
 * Created by korhanozbek on 4.08.15.
 */
@Entity
@Table(name = "yurt_foto_table", schema = "", catalog = "yurt")
public class YurtFoto {
    private int id;
    private String yurtId;
    private String yurtAdi;
    private String fotoAdi;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "yurt_id")
    public String getYurtId() {
        return yurtId;
    }

    public void setYurtId(String yurtId) {
        this.yurtId = yurtId;
    }

    @Basic
    @Column(name = "yurt_adi")
    public String getYurtAdi() {
        return yurtAdi;
    }

    public void setYurtAdi(String yurtAdi) {
        this.yurtAdi = yurtAdi;
    }

    @Basic
    @Column(name = "foto_adi")
    public String getFotoAdi() {
        return fotoAdi;
    }

    public void setFotoAdi(String fotoAdi) {
        this.fotoAdi = fotoAdi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YurtFoto that = (YurtFoto) o;

        if (id != that.id) return false;
        if (yurtId != null ? !yurtId.equals(that.yurtId) : that.yurtId != null) return false;
        if (yurtAdi != null ? !yurtAdi.equals(that.yurtAdi) : that.yurtAdi != null) return false;
        if (fotoAdi != null ? !fotoAdi.equals(that.fotoAdi) : that.fotoAdi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (yurtId != null ? yurtId.hashCode() : 0);
        result = 31 * result + (yurtAdi != null ? yurtAdi.hashCode() : 0);
        result = 31 * result + (fotoAdi != null ? fotoAdi.hashCode() : 0);
        return result;
    }
}
