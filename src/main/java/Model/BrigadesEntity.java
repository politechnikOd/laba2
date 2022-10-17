package Model;

import javax.persistence.*;

@Entity
@Table(name = "brigades", schema = "chebanova", catalog = "")
public class BrigadesEntity {
    private int iDbrig;
    private String speciality;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDbrig", nullable = false)
    public int getiDbrig() {
        return iDbrig;
    }

    @Override
    public String toString() {
        return iDbrig+"";
    }

    public void setiDbrig(int iDbrig) {
        this.iDbrig = iDbrig;
    }

    @Basic
    @Column(name = "speciality", nullable = false, length = 45)
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrigadesEntity that = (BrigadesEntity) o;

        if (iDbrig != that.iDbrig) return false;
        if (speciality != null ? !speciality.equals(that.speciality) : that.speciality != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iDbrig;
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        return result;
    }
}
