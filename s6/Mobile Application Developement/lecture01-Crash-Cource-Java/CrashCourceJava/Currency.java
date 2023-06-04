
public enum Currency {
	EURO("20AC","EUR"),
	DOLLAR("&#X24", "DOL");
	
	private String hexCode;
	private String name;
	
	Currency(String h, String n) {
		hexCode = h;
		name = n;
	}
}
