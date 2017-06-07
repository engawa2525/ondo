package jp.engawa.ondo.graph;

public class Line {
	protected String color;
	protected double range_min = Double.MIN_VALUE;
	protected double range_max = Double.MIN_VALUE;
	
	private LineItem[] items;

	public LineItem[] getItems() {
		return items;
	}

	public void setItems(LineItem[] items) {
		this.items = items;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getRange_min() {
		return range_min;
	}

	public void setRange_min(double range_min) {
		this.range_min = range_min;
	}

	public double getRange_max() {
		return range_max;
	}

	public void setRange_max(double range_max) {
		this.range_max = range_max;
	}
}
