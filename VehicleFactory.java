public class VehicleFactory {
    public static Vehicle createVehicle(String type) throws UndefinedVehicleException {
        switch (type) {
            case "Car":
                return new Car();
            case "Bus":
                return new Bus();
            case "Motorbike":
                return new Motorbike();
            default:
                throw new UndefinedVehicleException("Undefined vehicle type: " + type);
        }
    }
}
