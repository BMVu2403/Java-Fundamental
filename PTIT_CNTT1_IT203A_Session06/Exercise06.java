package PTIT_CNTT1_IT203A_Session06;

public class Exercise06 {

    static class User {
        private int id;
        private String username;
        private String password;
        private String email;

        public User(int id, String username, String password, String email) {
            this.id = id;
            this.username = username;
            setPassword(password);
            setEmail(email);
        }

        public void setPassword(String password) {
            if (password != null && !password.isEmpty()) {
                this.password = password;
            } else {
                System.out.println("Password khong duoc rong");
            }
        }

        public void setEmail(String email) {
            if (email != null && email.contains("@")) {
                this.email = email;
            } else {
                System.out.println("Email khong hop le");
            }
        }

        public boolean checkPassword(String input) {
            return password != null && password.equals(input);
        }

        public void hienThiThongTin() {
            System.out.println("ID: " + id);
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: ******");
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        User u1 = new User(1, "user1", "123456", "user1@gmail.com");

        u1.hienThiThongTin();

        System.out.println(u1.checkPassword("123456"));
        System.out.println(u1.checkPassword("abc"));
    }
}
