public class Bus extends Vehicle{
    double initialPrice = 25000;

    @Override
    void setPrice() {
        this.price = this.initialPrice * 1.66;
    }
}

