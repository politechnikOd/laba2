package Session;

import Model.WorkersEntity;

public final class UserSession {
    private static UserSession instance;

    private WorkersEntity worker;

    public UserSession(WorkersEntity worker) {
        this.worker = worker;
    }

    public static UserSession getInstance(WorkersEntity worker) {
        if (instance == null) {
            instance = new UserSession(worker);
        }
        return instance;
    }

    public static UserSession getInstance() {
        return instance;
    }

    public WorkersEntity getWorker() {
        return worker;
    }

    public void cleanUserSession() {
        worker = null;
    }


}
