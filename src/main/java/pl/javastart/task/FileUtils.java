package pl.javastart.task;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FileUtils {
    private static final String FILE_HEADER = "Type;Producer;Model;YearOfProduction;Mileage;Vin";

    static void saveVehicleQueueToFile(String fileName, Queue<Vehicle> queue) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(FILE_HEADER);
            writer.newLine();
            for (Vehicle vehicle : queue) {
                writer.write(vehicle.getType() + ";" + vehicle.getProducer() + ";" + vehicle.getModel() +
                        ";" + vehicle.getYearOfProduction() + ";" + vehicle.getMileage() + ";" + vehicle.getVin());
                writer.newLine();
            }
        }
    }

    static Queue<Vehicle> fillVehicleQueueFromFile(String fileName) {
        Queue<Vehicle> vehicles = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                parseLine(line, vehicles);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new UncheckedIOException("Nie można zapisać pliku" + fileName, e);
        }
        return vehicles;
    }

    private static void parseLine(String line, Queue<Vehicle> vehicles) {
        String[] split = line.split(";");
        VehicleType type = VehicleType.valueOf(split[0]);
        String producer = split[1];
        String model = split[2];
        int yearOfProduction = Integer.parseInt(split[3]);
        double mileage = Double.parseDouble(split[4]);
        String vin = split[5];
        vehicles.offer(new Vehicle(type, producer, model, yearOfProduction, mileage, vin));
    }
}
