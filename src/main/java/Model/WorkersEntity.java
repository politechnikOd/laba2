package Model;

import javax.persistence.*;

@Entity
@Table(name = "workers", schema = "chebanova", catalog = "")
public class WorkersEntity {
    private int idworker;
    private String surname;
    private String nameW;
    private String patronomic;
    private String addinf;
    private String login;
    private String password;
    private Integer usertypes;

    @Override
    public String toString() {
        return surname + " " + nameW;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idworker", nullable = false)
    public int getIdworker() {
        return idworker;
    }

    public void setIdworker(int idworker) {
        this.idworker = idworker;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "nameW", nullable = false, length = 45)
    public String getNameW() {
        return nameW;
    }

    public void setNameW(String nameW) {
        this.nameW = nameW;
    }

    @Basic
    @Column(name = "patronomic", nullable = true, length = 45)
    public String getPatronomic() {
        return patronomic;
    }

    public void setPatronomic(String patronomic) {
        this.patronomic = patronomic;
    }

    @Basic
    @Column(name = "addinf", nullable = true, length = 200)
    public String getAddinf() {
        return addinf;
    }

    public void setAddinf(String addinf) {
        this.addinf = addinf;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 70)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 70)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "usertypes", nullable = true)
    public Integer getUsertypes() {
        return usertypes;
    }

    public void setUsertypes(Integer usertypes) {
        this.usertypes = usertypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkersEntity that = (WorkersEntity) o;

        if (idworker != that.idworker) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (nameW != null ? !nameW.equals(that.nameW) : that.nameW != null) return false;
        if (patronomic != null ? !patronomic.equals(that.patronomic) : that.patronomic != null) return false;
        if (addinf != null ? !addinf.equals(that.addinf) : that.addinf != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (usertypes != null ? !usertypes.equals(that.usertypes) : that.usertypes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idworker;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (nameW != null ? nameW.hashCode() : 0);
        result = 31 * result + (patronomic != null ? patronomic.hashCode() : 0);
        result = 31 * result + (addinf != null ? addinf.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (usertypes != null ? usertypes.hashCode() : 0);
        return result;
    }
}
