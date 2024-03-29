package Model;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager instance;
    private List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
        userList.add(new User("Frodon", "Saquet"));
        userList.add(new User("Denethor", "Hectelion"));
        userList.add(new User("Peregrin", "Touc"));
    }

    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
