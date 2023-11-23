import java.util.Scanner;

public class MVCPatternDemo {
    public static void main(String[] args) {
        User model = register();
        UserView view = new UserView();

        UserController controller = new UserController(model, view);

        controller.updateView();


        while (true) {
            System.out.println();
            System.out.println("Уже есть аккаунт? 1 - да, 2 - нет, 3 - выйти");
            Scanner sc = new Scanner(System.in);
            int answer = sc.nextInt();
            if (answer == 1) {
                controller.login();
            } else if (answer == 2) {
                controller.register();
            } else if (answer == 3) {
                break;
            } else {
                System.out.println("Неправильный ввод!");
            }

            System.out.println();
            User.Profile profile = model.new Profile();
            profile.printNameAndAge();

            // для нестатического класса
            /*System.out.println();
            User.SecurityManager securityManager = model.new SecurityManager();
            securityManager.validatePassword(model.getPassword());*/

            // для статического класса
            /*System.out.println();
            User.SecurityManager securityManager = new User.SecurityManager();
            securityManager.validatePassword(model.getPassword());*/

            // для анонимного класса
            SecurityManager loginManager = () -> {
                if (model.getLogin().length() < 3) {
                    System.out.println("Недопустимый логин!");
                    return false;
                } else {
                    System.out.println("Логин одобрен!");
                    return true;
                }
            };
            loginManager.validate();

            SecurityManager passwordManager = new SecurityManager() {
                public boolean validate() {
                    if (model.getPassword().length() < 8) {
                        System.out.println("Ненадежный пароль!");
                        return false;
                    } else {
                        System.out.println("Пароль одобрен!");
                        return true;
                    }
                }
            };
            passwordManager.validate();
        }
    }

    private static User register() {
        User user = new User();
        user.setLogin("");
        user.setPassword("");
        return user;
    }

    private static User login() {
        User user = new User();
        user.setLogin("");
        user.setPassword("");
        return user;
    }
}
