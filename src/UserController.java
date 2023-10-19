import java.util.HashMap;
import java.util.Scanner;

public class UserController {
    private User user;
    private UserView view;

    public UserController(User user, UserView view) {
        this.user = user;
        this.view = view;
    }
    public void setUserLogin(String login) {
        user.setLogin(login);
    }
    public String getUserLogin() {
        return user.getLogin();
    }
    public void setUserPassword(String password) {
        user.setPassword(password);
    }
    public String getUserPassword() {
        return user.getPassword();
    }

    HashMap<String, String> loginAndPassword = new HashMap<>();

    public void register() {
            Scanner sc1 = new Scanner(System.in);
            System.out.print("Придумайте логин: ");
            String chooseLogin = sc1.nextLine();
            System.out.print("Придумайте пароль: ");
            String choosePassword = sc1.nextLine();

            user.setLogin(chooseLogin);
            user.setPassword(choosePassword);
            loginAndPassword.put(chooseLogin, choosePassword);
    }
    public void login() {
            Scanner sc2 = new Scanner(System.in);
            System.out.print("Введите логин: ");
            String yourLogin = sc2.nextLine();
            System.out.print("Введите пароль: ");
            String yourPassword = sc2.nextLine();

            if (loginAndPassword.containsKey(yourLogin) && loginAndPassword.containsValue(yourPassword)) {
                System.out.println("Вы успешно вошли в систему!");
                view.printUserData(yourLogin, yourPassword);
            } else if (loginAndPassword.containsKey(yourLogin) && !loginAndPassword.containsKey(yourPassword)) {
                System.out.println("Неправильный пароль");
            } else {
                System.out.println("Пользователь не найден в системе");
            }
    }

    public void updateView(){
        view.printUserData(user.getLogin(), user.getPassword());
    }
}
