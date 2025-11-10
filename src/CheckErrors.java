import java.util.Scanner;

public class CheckErrors {
    Scanner scanner = new Scanner(System.in);

    public int CheckNumber() {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Неверный ввод. Введите число: ");
            }
        }
    }
}
