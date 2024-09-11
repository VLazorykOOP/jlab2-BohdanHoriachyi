import java.util.Scanner;

public class Task2 {
    private double storona;

    // Konstruktor dlya zadannya storony kvadrata
    public Task2(double storona) {
        this.storona = storona;
    }

    // Metod dlya obchyslennya perymetra kvadrata
    public double getPerimetr() {
        return 4 * storona;
    }

    // Metod dlya obchyslennya ploshchi kvadrata
    public double getPloshcha() {
        return storona * storona;
    }

    // Metod dlya obchyslennya dovzhyny dihanali kvadrata
    public double getDiagonal() {
        return storona * Math.sqrt(2);
    }

    // Getter dlya otrymannya dovzhyny storony kvadrata
    public double getStorona() {
        return storona;
    }

    // Setter dlya vstanovlennya dovzhyny storony kvadrata
    public void setStorona(double storona) {
        this.storona = storona;
    }

    // Testuvannya funktsionalu klasu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vvedennya dovzhyny storony kvadrata
        System.out.print("Vvedit dovzhynu storony kvadrata: ");
        double storona = scanner.nextDouble();
        
        // Stvorennya ob'yekta Kvadrat
        Task2 kvadrat = new Task2(storona);

        System.out.println("Storona kvadrata: " + kvadrat.getStorona());
        System.out.println("Perimetr kvadrata: " + kvadrat.getPerimetr());
        System.out.println("Ploshcha kvadrata: " + kvadrat.getPloshcha());
        System.out.println("Dovzhyna dihanali kvadrata: " + kvadrat.getDiagonal());
    }
}
