package PTIT_CNTT1_IT203A_Session07;

public class Exercise06 {

    static class User {
        private final int id;
        private String username;
        private String password;

        public User(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
        }

        public int getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    static class UserManager {
        private static User[] userList = new User[100];
        private static int size = 0;

        public static void addUser(User user) {
            userList[size++] = user;
        }

        public static User findUserById(int id) {
            for (int i = 0; i < size; i++) {
                if (userList[i].getId() == id) {
                    return userList[i];
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {

        User u1 = new User(1, "admin", "123456");
        User u2 = new User(2, "user01", "abcdef");

        UserManager.addUser(u1);
        UserManager.addUser(u2);

        User result = UserManager.findUserById(2);

        if (result != null) {
            System.out.println(result.getUsername());
            System.out.println(result.getPassword());
        } else {
            System.out.println("Khong tim thay user");
        }
    }
}
