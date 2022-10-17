package Controller;

import Model.*;
import Session.UserSession;
import Util.NewWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.persistence.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class ManagerMenuController implements Initializable {

    @FXML
    private Label managerLabel;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TableView<ApplicationsEntity> ordersTableView;

    private ObservableList orders;

    private Boolean isAlreadyUsed = false;

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        managerLabel.setText(UserSession.getInstance().getWorker().getSurname());
        updateTable();
        setupTable();
    }

    public void newOrder(ActionEvent event) throws IOException {
        NewWindow.setNewWindow("addOrderMenu.fxml", event);
    }

    public void toMaterials(ActionEvent event) throws IOException {
        NewWindow.setNewWindow("materialsMenu.fxml", event);
    }


    public void logout(ActionEvent event) {
        addManagerLogoutLog();
        NewWindow.logout(scenePane);
    }

    private void addManagerLogoutLog() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            LogEntity log = new LogEntity();
            log.setTime(Timestamp.valueOf(LocalDateTime.now()));
            log.setActivity("Вышел из системы");
            log.setWorkersByIdWorkers(UserSession.getInstance().getWorker());
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

    private void updateTable() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<ApplicationsEntity> tq;

        tq = em.createQuery("SELECT o FROM ApplicationsEntity o WHERE o.dateApp IS NOT NULL ", ApplicationsEntity.class);

        List<ApplicationsEntity> results = tq.getResultList();
        if (orders == null) {
            orders = FXCollections.observableArrayList(results);
        } else {
            orders.clear();
            orders.addAll(results);
        }
        em.close();
    }

    private void setupTable() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

            TableColumn<ApplicationsEntity, String> telTableColumn = new TableColumn<>();
            telTableColumn.setText("Адресс");
            telTableColumn.setMinWidth(93);
            telTableColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

            TableColumn<ApplicationsEntity, Date> orderDateTableColumn = new TableColumn<>();
            orderDateTableColumn.setText("Дата заявки");
            orderDateTableColumn.setMinWidth(72);
            orderDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateApp"));
            ;

            TableColumn<ApplicationsEntity, Double> priceTableColumn = new TableColumn<>();
            priceTableColumn.setText("Инфо");
            priceTableColumn.setMinWidth(40);
            priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("info"));



            ordersTableView.getColumns().addAll(telTableColumn, orderDateTableColumn, priceTableColumn);
            ordersTableView.setItems(orders);
    }
/* private TypedQuery<ThingserviceEntity> getServices(EntityManager em, OrderrEntity o) {
        return em.createQuery("SELECT ts FROM ThingserviceEntity ts " +
                        "INNER JOIN ThingEntity t ON ts.thingByIdThing.idThing = t.idThing " +
                        "LEFT JOIN OrderrEntity o ON t.orderrByIdOrder.idOrder = o.idOrder WHERE o.idOrder=:idOrder", ThingserviceEntity.class).
                setParameter("idOrder", o.getIdOrder());
    }

    private TypedQuery<WorkerthingserviceEntity> getWorkers(EntityManager em, OrderrEntity o) {
        return em.createQuery("SELECT wts FROM WorkerthingserviceEntity wts " +
                        "INNER JOIN ThingserviceEntity ts ON wts.thingserviceByIdThingService.idThingService = ts.idThingService " +
                        "LEFT JOIN ThingEntity t ON ts.thingByIdThing.idThing = t.idThing " +
                        "LEFT JOIN OrderrEntity o ON t.orderrByIdOrder.idOrder = o.idOrder WHERE o.idOrder=:idOrder", WorkerthingserviceEntity.class).
                setParameter("idOrder", o.getIdOrder());
    }*/

}
