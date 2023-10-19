import java.beans.PropertyEditorSupport;
import java.util.HashMap;
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


        }

    }
    private static User register(){
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
