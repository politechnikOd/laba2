package Model;

import javax.persistence.*;

@Entity
@Table(name = "appmaterials", schema = "chebanova", catalog = "")
public class AppmaterialsEntity {
    private int idappmaterials;
    private int count;
    private ApplicationsEntity applicationsByIDapp;
    private MaterialsEntity materialsByIDmaterial;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idappmaterials", nullable = false)
    public int getIdappmaterials() {
        return idappmaterials;
    }

    public void setIdappmaterials(int idappmaterials) {
        this.idappmaterials = idappmaterials;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppmaterialsEntity that = (AppmaterialsEntity) o;

        if (idappmaterials != that.idappmaterials) return false;
        if (count != that.count) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idappmaterials;
        result = 31 * result + count;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IDapp", referencedColumnName = "IDapp", nullable = false)
    public ApplicationsEntity getApplicationsByIDapp() {
        return applicationsByIDapp;
    }

    public void setApplicationsByIDapp(ApplicationsEntity applicationsByIDapp) {
        this.applicationsByIDapp = applicationsByIDapp;
    }

    @ManyToOne
    @JoinColumn(name = "IDmaterial", referencedColumnName = "IDmaterial", nullable = false)
    public MaterialsEntity getMaterialsByIDmaterial() {
        return materialsByIDmaterial;
    }

    public void setMaterialsByIDmaterial(MaterialsEntity materialsByIDmaterial) {
        this.materialsByIDmaterial = materialsByIDmaterial;
    }
}
