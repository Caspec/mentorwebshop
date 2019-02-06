package iFace;

import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface IUser {
    public List<User> getAllUsers();
    public List<User> getUser(Long id);
    public User addUser(User user);
    public User editUser(User user);
    public User deleteUser(User user);
}
