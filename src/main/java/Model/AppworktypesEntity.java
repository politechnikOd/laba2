package Model;

import javax.persistence.*;

@Entity
@Table(name = "appworktypes", schema = "chebanova", catalog = "")
public class AppworktypesEntity {
    private int idappworktypes;
    private int workamount;
    private ApplicationsEntity applicationsByIdapp;
    private WorktypesEntity worktypesByIdworktype;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idappworktypes", nullable = false)
    public int getIdappworktypes() {
        return idappworktypes;
    }

    public void setIdappworktypes(int idappworktypes) {
        this.idappworktypes = idappworktypes;
    }

    @Basic
    @Column(name = "workamount", nullable = false)
    public int getWorkamount() {
        return workamount;
    }

    public void setWorkamount(int workamount) {
        this.workamount = workamount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppworktypesEntity that = (AppworktypesEntity) o;

        if (idappworktypes != that.idappworktypes) return false;
        if (workamount != that.workamount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idappworktypes;
        result = 31 * result + workamount;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idapp", referencedColumnName = "IDapp", nullable = false)
    public ApplicationsEntity getApplicationsByIdapp() {
        return applicationsByIdapp;
    }

    public void setApplicationsByIdapp(ApplicationsEntity applicationsByIdapp) {
        this.applicationsByIdapp = applicationsByIdapp;
    }

    @ManyToOne
    @JoinColumn(name = "idworktype", referencedColumnName = "IDworktype", nullable = false)
    public WorktypesEntity getWorktypesByIdworktype() {
        return worktypesByIdworktype;
    }

    public void setWorktypesByIdworktype(WorktypesEntity worktypesByIdworktype) {
        this.worktypesByIdworktype = worktypesByIdworktype;
    }
}
