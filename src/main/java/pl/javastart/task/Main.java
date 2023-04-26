package pl.javastart.task;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.*;

import static pl.javastart.task.FileUtils.fillVehicleQueueFromFile;

public class Main {
    private Queue<Vehicle> vehicles = new LinkedList<>();
    private static final int EXIT = 0;
    private static final int ADD_VEHICLE = 1;
    private static final int VEHICLE_INSPECTION = 2;
    public static final String FILE_NAME = "kolejka_pojazdow.csv";

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int choose;
        vehicles = fillVehicleQueueFromFile(FILE_NAME);
        do {
            printMenu();
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case ADD_VEHICLE -> addVehicleToQueue(scanner);
                case VEHICLE_INSPECTION -> vehicleInspection();
                case EXIT -> closeProgram();
                default -> System.out.println("Wybrałeś niewłaściwą opcję");
            }
        } while (choose != EXIT);
    }

    private void closeProgram() {
        if (!vehicles.isEmpty()) {
            try {
                FileUtils.saveVehicleQueueToFile(FILE_NAME, vehicles);
            } catch (IOException e) {
                throw new UncheckedIOException("Nie można zapisać pliku" + FILE_NAME, e);
            }
        }
        System.out.println("Koniec pracy");
    }

    private void printMenu() {
        System.out.println("Stacja kontroli pojazdów. Wybierz jedną z opcji: ");
        System.out.println(ADD_VEHICLE + " - dodanie pojazdu do kolejki oczekujących na przegląd");
        System.out.println(VEHICLE_INSPECTION + " - przegląd pojazdu");
        System.out.println(EXIT + " - wyjście");
    }

    private void addVehicleToQueue(Scanner scanner) {
        Vehicle vehicle = VehicleUtils.createVehicle(scanner);
        vehicles.offer(vehicle);
        System.out.println("Pojazd dodany do kolejki oczekujacych na przegląd>>>\n");
    }

    private void vehicleInspection() {
        if (vehicles.isEmpty()) {
            throw new RuntimeException("Kolejka pojzadów pusta");
        }
        System.out.println("Wykonuję przegląd: " + vehicles.poll());
        System.out.println("Przegląd wykonany>>>\n");
    }
}
