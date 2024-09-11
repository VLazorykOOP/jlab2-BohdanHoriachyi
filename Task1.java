import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Task1 {
    private int rik;
    private int misyac;
    private int den;

    // Konstruktor z chyslamy (rik, misyac, den)
    public Task1(int rik, int misyac, int den) {
        this.rik = rik;
        this.misyac = misyac;
        this.den = den;
    }

    // Konstruktor z ryadkom formatu "rik.misyac.den"
    public Task1(String dateStr) {
        String[] parts = dateStr.split("\\.");
        this.rik = Integer.parseInt(parts[0]);
        this.misyac = Integer.parseInt(parts[1]);
        this.den = Integer.parseInt(parts[2]);
    }

    // Konstruktor z inshoyu datoyu
    public Task1(Task1 other) {
        this.rik = other.rik;
        this.misyac = other.misyac;
        this.den = other.den;
    }

    // Perevirka na vysokosnyi rik
    public boolean isLeapYear() {
        return (rik % 4 == 0 && rik % 100 != 0) || (rik % 400 == 0);
    }

    // Otrymaty rik
    public int getRik() {
        return rik;
    }

    // Prysvoyity rik
    public void setRik(int rik) {
        this.rik = rik;
    }

    // Otrymaty misyac
    public int getMisyac() {
        return misyac;
    }

    // Prysvoyity misyac
    public void setMisyac(int misyac) {
        this.misyac = misyac;
    }

    // Otrymaty den
    public int getDen() {
        return den;
    }

    // Prysvoyity den
    public void setDen(int den) {
        this.den = den;
    }

    // Dodavannya dniv do daty
    public Task1 addDays(int dni) {
        LocalDate localDate = toLocalDate().plusDays(dni);
        return fromLocalDate(localDate);
    }

    // Vidnimannya dniv vid daty
    public Task1 subtractDays(int dni) {
        LocalDate localDate = toLocalDate().minusDays(dni);
        return fromLocalDate(localDate);
    }

    // Kilkist dniv mizh dvoma datamy
    public long daysBetween(Task1 other) {
        LocalDate thisDate = toLocalDate();
        LocalDate otherDate = other.toLocalDate();
        return ChronoUnit.DAYS.between(thisDate, otherDate);
    }

    // Porivnyannya daty: dorivnyuye
    public boolean equals(Task1 other) {
        return this.rik == other.rik && this.misyac == other.misyac && this.den == other.den;
    }

    // Porivnyannya daty: do
    public boolean isBefore(Task1 other) {
        return toLocalDate().isBefore(other.toLocalDate());
    }

    // Porivnyannya daty: pislya
    public boolean isAfter(Task1 other) {
        return toLocalDate().isAfter(other.toLocalDate());
    }

    // Peretvorennya na LocalDate dlya zruchnoyi roboty z datamy
    private LocalDate toLocalDate() {
        return LocalDate.of(this.rik, this.misyac, this.den);
    }

    // Stvorennya ob'yekta MyDate z LocalDate
    private static Task1 fromLocalDate(LocalDate localDate) {
        return new Task1(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }

    // Perevyznachennya metodu toString
    @Override
    public String toString() {
        return String.format("%d.%02d.%02d", this.rik, this.misyac, this.den);
    }

    // Testuvannya funktsionalu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vvedennya pershoyi daty
        System.out.println("Vvedit pershu datu u formati RRRR.MM.DD (napryklad, 2022.09.11): ");
        String date1Input = scanner.nextLine();
        Task1 date1 = new Task1(date1Input);

        // Vvedennya drugoyi daty
        System.out.println("Vvedit drugu datu u formati RRRR.MM.DD (napryklad, 2022.09.10): ");
        String date2Input = scanner.nextLine();
        Task1 date2 = new Task1(date2Input);

        System.out.println("\n===== Oryhinalni daty =====");
        System.out.println("Data 1: " + date1);
        System.out.println("Data 2: " + date2);
        System.out.println();

        // Dodavannya dniv
        System.out.println("===== Operatsiyi z datamy =====");
        System.out.print("Vvedit kilkist dniv dlya dodavannya do pershoyi daty: ");
        int addDays = scanner.nextInt();
        Task1 date1PlusDays = date1.addDays(addDays);
        System.out.println("Data 1 cherez " + addDays + " dniv: " + date1PlusDays);

        // Vidnimannya dniv
        System.out.print("Vvedit kilkist dniv dlya vidnimannya vid drugoyi daty: ");
        int subtractDays = scanner.nextInt();
        Task1 date2MinusDays = date2.subtractDays(subtractDays);
        System.out.println("Data 2 pislya vidnimannya " + subtractDays + " dniv: " + date2MinusDays);
        System.out.println();

        // Vysokosnyi rik
        System.out.println("===== Perevirka na vysokosnyi rik =====");
        System.out.println("Chi ye rik " + date1.getRik() + " vysokosnym? " + (date1.isLeapYear() ? "Tak" : "Ni"));

        // Kilkist dniv mizh datamy
        System.out.println("Kilkist dniv mizh datamy: " + date1.daysBetween(date2));

        // Porivnyannya dat
        System.out.println("\n===== Porivnyannya dat =====");
        System.out.println("Data 1 do daty 2: " + (date1.isBefore(date2) ? "Tak" : "Ni"));
        System.out.println("Data 1 pislya daty 2: " + (date1.isAfter(date2) ? "Tak" : "Ni"));
    }
}
