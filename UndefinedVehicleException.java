public class UndefinedVehicleException extends Exception{
    String message;

    public UndefinedVehicleException(String message){
            this.message = message;
    }
    @Override
    public String getMessage(){
        return this.message;
    }
}
