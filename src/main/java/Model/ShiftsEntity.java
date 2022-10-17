package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "shifts", schema = "chebanova", catalog = "")
public class ShiftsEntity {
    private int iDshift;
    private Date date;
    private int number;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDshift", nullable = false)
    public int getiDshift() {
        return iDshift;
    }

    public void setiDshift(int iDshift) {
        this.iDshift = iDshift;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShiftsEntity that = (ShiftsEntity) o;

        if (iDshift != that.iDshift) return false;
        if (number != that.number) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iDshift;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + number;
        return result;
    }
}
