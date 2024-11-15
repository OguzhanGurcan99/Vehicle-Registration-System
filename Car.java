public class Car extends Vehicle {
    double initialPrice = 40000;

    @Override
    void setPrice() {
        this.price = this.initialPrice * 1.36;
    }
}
