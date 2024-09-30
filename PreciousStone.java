package project_02;

public class PreciousStone extends Stones {
    public PreciousStone(String type, double value, double transparency, int weight) {
        super(type, value, transparency, weight);
    }

	@Override
	public double getPrice() {
		return Math.pow(getWeight(), 2)* getValue();
	}
}
