import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // ONLY READS LINES
    public static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // ONLY PROCESS LINES
    public static List<Vehicle> processFile(List<String> lines) throws UndefinedVehicleException {
        List<Vehicle> vehicles = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            Vehicle vehicle = VehicleFactory.createVehicle(parts[0]);
            vehicle.setName(parts[1]);
            vehicle.setColor(parts[2]);
            vehicle.setKilometer(Integer.parseInt(parts[3]));
            vehicle.setAssurance(Boolean.parseBoolean(parts[4]));
            vehicle.setInspection(Boolean.parseBoolean(parts[5]));

            vehicles.add(vehicle);
        }
        return vehicles;
    }

    // SEND DATA TO DATABASE
    public static void addToDatabase(List<Vehicle> vehicles) throws SQLException {
        Validator validator = new Validator();
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.connection = databaseManager.getConnection();

        for(Vehicle vehicle : vehicles){
            if (validator.isValid(vehicle)){
                vehicle.setPrice();
                databaseManager.insertData(vehicle);
                System.out.println("Araç bilgileri veri tabanına eklendi.");
            }
            else{
                System.out.println("Araç bilgileri geçersiz ! Eklenemedi ! ");
            }
        }
        databaseManager.connection.close();
    }

    public static void main(String[] args) throws UndefinedVehicleException, SQLException {

       List<String> lines = readFile("vehicleList.txt");
       List<Vehicle> vehicleList = processFile(lines);
       addToDatabase(vehicleList);
    }
}


