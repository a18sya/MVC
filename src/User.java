public class User {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public class Profile {


        private String name = "Алеся";
        private int age = 21;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void printNameAndAge() {
            System.out.println("Имя пользователя: " + this.getName() + ", возраст пользователя: " + this.getAge());
        }
    }

    // нестатический класс
    /*public class SecurityManager {
        public boolean validatePassword(String password) {
            if (password.length() < 8) {
                System.out.println("Ненадежный пароль!");
                return false;
            } else {
                System.out.println("Пароль одобрен!");
                return true;
            }
        }
    }*/

    // статический класс
   /* public static class SecurityManager {
        public boolean validatePassword(String password) {
            if (password.length() < 8) {
                System.out.println("Ненадежный пароль!");
                return false;
            } else {
                System.out.println("Пароль одобрен!");
                return true;
            }
        }
    }*/

    /*// анонимный класс
    public static class SecurityManager {
        public boolean validatePassword(String password) {
            if (password.length() < 8) {
                System.out.println("Ненадежный пароль!");
                return false;
            } else {
                System.out.println("Пароль одобрен!");
                return true;
            }
        }
    }*/

}

interface SecurityManager {
    boolean validate();
}