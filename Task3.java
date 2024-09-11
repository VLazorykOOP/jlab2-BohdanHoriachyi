import java.util.Scanner;

public class Task3 {
    private double x;
    private double y;
    private double z;
    private double radius;

    // Konstruktor dlya zadannya kulі
    public Task3(double x, double y, double z, double radius) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
    }

    // Metod dlya obchyslennya vidstanі mizh tsentrykulі
    private double distanceTo(Task3 other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) +
                         Math.pow(this.y - other.y, 2) +
                         Math.pow(this.z - other.z, 2));
    }

    // Metod dlya obchyslennya ob'omu peretynu dvokulі
    public double intersectionVolume(Task3 other) {
        double d = distanceTo(other);
        if (d >= this.radius + other.radius) {
            return 0; // kulі ne peretynayutsya
        } else if (d <= Math.abs(this.radius - other.radius)) {
            double smallerRadius = Math.min(this.radius, other.radius);
            return (4.0 / 3.0) * Math.PI * Math.pow(smallerRadius, 3);
        } else {
            double r1 = this.radius;
            double r2 = other.radius;

            double part1 = Math.pow(r1, 2) * Math.acos((d * d + Math.pow(r1, 2) - Math.pow(r2, 2)) / (2 * d * r1));
            double part2 = Math.pow(r2, 2) * Math.acos((d * d + Math.pow(r2, 2) - Math.pow(r1, 2)) / (2 * d * r2));
            double part3 = 0.5 * Math.sqrt((-d + r1 + r2) * (d + r1 - r2) * (d - r1 + r2) * (d + r1 + r2));

            return part1 + part2 - part3;
        }
    }

    // Metod dlya obchyslennya ob'omu ob'yednannya dvokulі
    public double unionVolume(Task3 other) {
        double volume1 = (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
        double volume2 = (4.0 / 3.0) * Math.PI * Math.pow(other.radius, 3);
        double intersectionVolume = intersectionVolume(other);

        return volume1 + volume2 - intersectionVolume;
    }

    // Testuvannya funktsionalu klasu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vvedennya parametriv dlya pershoyi kulі
        System.out.println("Vvedit koordinaty tsentry ta radiys pershoyi kulі:");
        System.out.print("x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("z1: ");
        double z1 = scanner.nextDouble();
        System.out.print("Radiys 1: ");
        double r1 = scanner.nextDouble();

        // Vvedennya parametriv dlya drugoyi kulі
        System.out.println("Vvedit koordinaty tsentry ta radiys drugoyi kulі:");
        System.out.print("x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("y2: ");
        double y2 = scanner.nextDouble();
        System.out.print("z2: ");
        double z2 = scanner.nextDouble();
        System.out.print("Radiys 2: ");
        double r2 = scanner.nextDouble();

        // Stvorennya ob'yektiv Baloon
        Task3 baloon1 = new Task3(x1, y1, z1, r1);
        Task3 baloon2 = new Task3(x2, y2, z2, r2);

        // Vydannia rezul'tativ
        System.out.println("Ob'em peretynu dvokulі: " + baloon1.intersectionVolume(baloon2));
        System.out.println("Ob'em ob'yednannya dvokulі: " + baloon1.unionVolume(baloon2));
    }
}
