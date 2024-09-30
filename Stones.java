//Камені. Визначити ієрархію дорогоцінних і напівдорогоцінних каменів.
//Підібрати камені для намиста. Порахувати загальну вагу (в каратах) і вартість
//намиста. Провести сортування каменів намиста на базі цінності. Знайти
//камені в намисті, що відповідають заданому діапазону параметру прозорості.
//Вартість каменю залежить від його цінності, рівня прозорості та типу.

package project_02;

public abstract class Stones implements Comparable<Stones> {
	private int weight;
	private double value;
	private double transparency; //прозорість
	private String type;
	
	public Stones( String type, double value, double transparency, int weight) {
		this.weight = weight;
		this.value = value;
		this.transparency = transparency;
		this.type = type;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public double getValue() {
		return value;
	}
	
	public double getTransparency() {
		return transparency;
	}
	
	public String getType() {
		return type;
	}
	
	public abstract double getPrice();

	@Override
	public String toString() {
		return ("ваги " + getWeight() + ", прозорості " 
	+ getTransparency() + ", цінності " + getValue() + 
	", типу " + getType() + " та ціни " + getPrice());
	}
	
	public int compareTo(Stones other) {
		if (this.transparency > other.transparency)
			return 1;
		else if (this.transparency < other.transparency)
			return -1;
		else
			return 0;
	}
}
