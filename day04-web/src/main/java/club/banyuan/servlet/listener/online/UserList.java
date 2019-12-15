package club.banyuan.servlet.listener.online;

import java.util.*;

public class UserList {
    private static final UserList userList = new UserList();
    private List<String> nameList;

    private UserList() {
        nameList = Collections.synchronizedList(new ArrayList<String>());
    }

    public static UserList getInstance() {
        return userList;
    }

    public void addUser(String name) {
        if (name != null)
            nameList.add(name);
    }

    public void removeUser(String name) {
        if (name != null)
            nameList.remove(name);
    }

    public List<String> getUserList() {
        return nameList;
    }

    public int getUserCount() {
        return nameList.size();
    }
}
