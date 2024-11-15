import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    // DEMO
    public static void addToDatabase(List<Vehicle> vehicles){
        Validator validator = new Validator();

        for(Vehicle vehicle : vehicles){
            if (validator.isValid(vehicle)){
                vehicle.setPrice();
                System.out.println("Araç sisteme eklendi Fiyat : " + vehicle.getPrice());
            }
            else{
                System.out.println("Araç bilgileri geçersiz !");
            }
        }

    }

    public static void main(String[] args) throws UndefinedVehicleException {

       List<String> lines = readFile("vehicleList.txt");
       List<Vehicle> vehicleList = processFile(lines);
       addToDatabase(vehicleList);
    }
}


