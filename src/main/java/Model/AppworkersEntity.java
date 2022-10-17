package Model;

import javax.persistence.*;

@Entity
@Table(name = "appworkers", schema = "chebanova", catalog = "")
public class AppworkersEntity {
    private int idappworkers;
    private ApplicationsEntity applicationsByIDapp;
    private WorkersEntity workersByIDworker;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idappworkers", nullable = false)
    public int getIdappworkers() {
        return idappworkers;
    }

    public void setIdappworkers(int idappworkers) {
        this.idappworkers = idappworkers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppworkersEntity that = (AppworkersEntity) o;

        if (idappworkers != that.idappworkers) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idappworkers;
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
    @JoinColumn(name = "IDworker", referencedColumnName = "idworker", nullable = false)
    public WorkersEntity getWorkersByIDworker() {
        return workersByIDworker;
    }

    public void setWorkersByIDworker(WorkersEntity workersByIDworker) {
        this.workersByIDworker = workersByIDworker;
    }
}
