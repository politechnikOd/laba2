package Model;

import javax.persistence.*;

@Entity
@Table(name = "workersbrigades", schema = "chebanova", catalog = "")
public class WorkersbrigadesEntity {
    private int idworkersbrigades;
    private WorkersEntity workersByIDworker;
    private BrigadesEntity brigadesByIDbrigade;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idworkersbrigades", nullable = false)
    public int getIdworkersbrigades() {
        return idworkersbrigades;
    }

    public void setIdworkersbrigades(int idworkersbrigades) {
        this.idworkersbrigades = idworkersbrigades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkersbrigadesEntity that = (WorkersbrigadesEntity) o;

        if (idworkersbrigades != that.idworkersbrigades) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idworkersbrigades;
    }

    @ManyToOne
    @JoinColumn(name = "IDworker", referencedColumnName = "idworker", nullable = false)
    public WorkersEntity getWorkersByIDworker() {
        return workersByIDworker;
    }

    public void setWorkersByIDworker(WorkersEntity workersByIDworker) {
        this.workersByIDworker = workersByIDworker;
    }

    @ManyToOne
    @JoinColumn(name = "IDbrigade", referencedColumnName = "IDbrig", nullable = false)
    public BrigadesEntity getBrigadesByIDbrigade() {
        return brigadesByIDbrigade;
    }

    public void setBrigadesByIDbrigade(BrigadesEntity brigadesByIDbrigade) {
        this.brigadesByIDbrigade = brigadesByIDbrigade;
    }
}
