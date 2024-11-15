public abstract class Vehicle {
    private String name;
    private String color;
    private int kilometer;
    protected double price;
    private boolean assurance;
    private boolean inspection;

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getKilometer() {
        return kilometer;
    }
    public double getPrice() {
        return price;
    }
    public boolean getAssurance() {
        return assurance;
    }
    public boolean getInspection() {
        return inspection;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setKilometer(int km){
        this.kilometer = km;
    }
    public void setAssurance(boolean assurance){
        this.assurance = assurance;
    }
    public void setInspection(boolean inspection){
        this.inspection = inspection;
    }

    public void drive(int distance){
        this.kilometer += distance;
    }
    abstract void setPrice();
}
