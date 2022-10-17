package Model;

import javax.persistence.*;

@Entity
@Table(name = "brigadesshifts", schema = "chebanova", catalog = "")
public class BrigadesshiftsEntity {
    private int idbrigadesshifts;
    private BrigadesEntity brigadesByIDbrigade;
    private ShiftsEntity shiftsByIDshift;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbrigadesshifts", nullable = false)
    public int getIdbrigadesshifts() {
        return idbrigadesshifts;
    }

    public void setIdbrigadesshifts(int idbrigadesshifts) {
        this.idbrigadesshifts = idbrigadesshifts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrigadesshiftsEntity that = (BrigadesshiftsEntity) o;

        if (idbrigadesshifts != that.idbrigadesshifts) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idbrigadesshifts;
    }

    @ManyToOne
    @JoinColumn(name = "IDbrigade", referencedColumnName = "IDbrig", nullable = false)
    public BrigadesEntity getBrigadesByIDbrigade() {
        return brigadesByIDbrigade;
    }

    public void setBrigadesByIDbrigade(BrigadesEntity brigadesByIDbrigade) {
        this.brigadesByIDbrigade = brigadesByIDbrigade;
    }

    @ManyToOne
    @JoinColumn(name = "IDshift", referencedColumnName = "IDshift", nullable = false)
    public ShiftsEntity getShiftsByIDshift() {
        return shiftsByIDshift;
    }

    public void setShiftsByIDshift(ShiftsEntity shiftsByIDshift) {
        this.shiftsByIDshift = shiftsByIDshift;
    }
}
