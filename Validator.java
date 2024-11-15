public class Validator {
    public boolean isValid (Vehicle currentVehicle){
    return (currentVehicle.getAssurance() && currentVehicle.getInspection());
    }
}
