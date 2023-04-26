package pl.javastart.task;

import java.util.Objects;
import java.util.Scanner;

public class VehicleUtils {
    static Vehicle createVehicle(Scanner scanner) {
        System.out.println("Podaj dane pojazdu do przeglądu: ");

        VehicleType type = getVehicleType(scanner);
        System.out.println("Marka: ");
        String producer = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        System.out.println("Rocznik: ");
        int yearOfProduction = scanner.nextInt();
        System.out.println("Przebieg: ");
        double mileage = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Numer VIN");
        String vin = scanner.nextLine();
        return new Vehicle(type, producer, model, yearOfProduction, mileage, vin);
    }

    private static VehicleType getVehicleType(Scanner scanner) {
        VehicleType type = null;
        do {
            System.out.println("Typ pojazdu [MOTORBIKE | CAR | TRUCK]");
            try {
                type = VehicleType.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Niewłaściwy typ pojazdu.");
            }
        } while (Objects.isNull(type));
        return type;
    }
}
