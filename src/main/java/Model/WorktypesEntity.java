package Model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "worktypes", schema = "chebanova", catalog = "")
public class WorktypesEntity {
    private int iDworktype;
    private String name;
    private BigDecimal cost;
    private String adinfo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDworktype", nullable = false)
    public int getiDworktype() {
        return iDworktype;
    }

    public void setiDworktype(int iDworktype) {
        this.iDworktype = iDworktype;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "cost", nullable = false, precision = 2)
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "adinfo", nullable = true, length = 200)
    public String getAdinfo() {
        return adinfo;
    }

    public void setAdinfo(String adinfo) {
        this.adinfo = adinfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorktypesEntity that = (WorktypesEntity) o;

        if (iDworktype != that.iDworktype) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (adinfo != null ? !adinfo.equals(that.adinfo) : that.adinfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iDworktype;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (adinfo != null ? adinfo.hashCode() : 0);
        return result;
    }
}
