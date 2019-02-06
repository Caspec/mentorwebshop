package facade;

import iFace.IUser;
import javax.persistence.Persistence;

public class FacadeFactoryUser {
    private static final IUser instance = new FacadeUser(Persistence.createEntityManagerFactory("pu_backend"));
    public static IUser getInstance(){
        return instance;
    }
}
