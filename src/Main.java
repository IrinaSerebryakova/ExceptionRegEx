import exception.WrongLoginException;
import exception.WrongPasswordException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static String login;
    static String password;
    static String confirmPassword;
    static boolean checkLogin;
    static boolean checkPassword;
    static boolean checkConfirmPassword;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        login = input.nextLine();
        password = input.nextLine();
        confirmPassword = input.nextLine();
        try{
            inputBox(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            e.printStackTrace();
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        } finally {
            System.out.println(String.format("Проверка ввода логина: %b, Проверка ввода пароля: %b, Проверка пароля на соответствие: %b",checkLogin,checkPassword,checkConfirmPassword));
        }
    }

    public static void inputBox(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        checkLogin = Pattern.matches("^[a-zA-Z\\d\\_]{1,20}$",login);
        checkPassword = Pattern.matches("^[a-zA-Z\\d\\_]{1,19}$",password);
        checkConfirmPassword = password.equals(confirmPassword);
        if(!checkLogin){
            throw new WrongLoginException("Логин длиннее 20 символов");
        }
        if(!checkPassword){
            throw new WrongPasswordException("Пароль должен быть меньше 20 символов");
        }
    }
}

