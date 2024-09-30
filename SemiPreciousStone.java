package project_02;

public class SemiPreciousStone extends Stones {
	public SemiPreciousStone(String type, double value, double transparency, int weight) {
		super(type, value, transparency, weight);
	}

	@Override
	public double getPrice() {
		return Math.pow(getWeight(), 2)* getValue();
	}

}
