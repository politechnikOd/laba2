package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "applications", schema = "chebanova", catalog = "")
public class ApplicationsEntity {
    private int iDapp;
    private Date dateApp;
    private String address;
    private String info;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDapp", nullable = false)
    public int getiDapp() {
        return iDapp;
    }

    public void setiDapp(int iDapp) {
        this.iDapp = iDapp;
    }

    @Basic
    @Column(name = "dateApp", nullable = false)
    public Date getDateApp() {
        return dateApp;
    }

    public void setDateApp(Date dateApp) {
        this.dateApp = dateApp;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "info", nullable = true, length = 500)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationsEntity that = (ApplicationsEntity) o;

        if (iDapp != that.iDapp) return false;
        if (dateApp != null ? !dateApp.equals(that.dateApp) : that.dateApp != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iDapp;
        result = 31 * result + (dateApp != null ? dateApp.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }
}
