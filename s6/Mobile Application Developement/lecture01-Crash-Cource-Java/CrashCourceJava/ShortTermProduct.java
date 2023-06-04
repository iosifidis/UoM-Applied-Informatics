
public class ShortTermProduct implements Product {

	@Override
	public double calculateProfit(double a) {
		return a * 120 * 0.015;
	}

}
