public class Motorbike extends Vehicle {
    double initialPrice = 15000;

    @Override
    void setPrice() {
        this.price = this.initialPrice * 1.55;
    }
}

