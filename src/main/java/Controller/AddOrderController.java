package Controller;

import Model.ApplicationsEntity;
import Model.LogEntity;
import Model.WorkersEntity;
import Session.UserSession;
import Util.NewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.persistence.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


public class AddOrderController {
    @FXML
    private TextField fTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField oTextField;


    private String f;
    private String o;
    private LocalDate date;
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");

    public void addAplication(ActionEvent event) throws IOException {
        f = fTextField.getText();
        date = datePicker.getValue();
        o = oTextField.getText();
        addNewAplication(f, o, date);
        ENTITY_MANAGER_FACTORY.close();
        NewWindow.setNewWindow("managerMenu.fxml", event);
    }
    private void addNewAplication(String f, String o, LocalDate date) {
        addLoginLog();
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            ApplicationsEntity worker = new ApplicationsEntity();
            worker.setAddress(f);
            worker.setDateApp(Date.valueOf(date));
            worker.setInfo(o);
            em.persist(worker);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    private void addLoginLog() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        String query = "SELECT w FROM WorkersEntity w WHERE w.idworker=:idworker";
        TypedQuery<WorkersEntity> tq = em.createQuery(query, WorkersEntity.class);
        tq.setParameter("idworker", UserSession.getInstance().getWorker().getIdworker() );
        try {
            et = em.getTransaction();
            et.begin();
            LogEntity log = new LogEntity();
            log.setTime(Timestamp.valueOf(LocalDateTime.now()));
            log.setActivity("Выполнил работу");
            log.setWorkersByIdWorkers(tq.getSingleResult());
            UserSession.getInstance(tq.getSingleResult());
            em.persist(log);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void cancel(ActionEvent event) throws IOException {
        //OrderSession.getInstance().cleanOrderSession();
        NewWindow.setNewWindow("managerMenu.fxml", event);
    }




}
