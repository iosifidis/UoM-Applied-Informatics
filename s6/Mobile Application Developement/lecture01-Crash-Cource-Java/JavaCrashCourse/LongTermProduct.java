public class LongTermProduct implements Product{

    @Override
    public double calculateProfit(double amount) {
        return amount * 120 * 1.23;
    }
}
