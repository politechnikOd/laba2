package Model;

import javax.persistence.*;

@Entity
@Table(name = "materials", schema = "chebanova", catalog = "")
public class MaterialsEntity {
    private int iDmaterial;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDmaterial", nullable = false)
    public int getiDmaterial() {
        return iDmaterial;
    }

    public void setiDmaterial(int iDmaterial) {
        this.iDmaterial = iDmaterial;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialsEntity that = (MaterialsEntity) o;

        if (iDmaterial != that.iDmaterial) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iDmaterial;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
