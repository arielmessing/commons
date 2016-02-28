package org.arielmessing.commons.datastruct;

public class IntegersRange implements Ranged<Integer> {
	
	private final Integer bottom;
	private final Integer top;
	
	public IntegersRange(Integer bottom, Integer top) {
		this.bottom = bottom;
		this.top = top;
	}

	@Override
	public Integer getBottom() {
		return bottom;
	}
	
	public Integer getTop() {
		return top;
	}

	@Override
	public boolean contains(Integer t) {	
		return t != null && t.compareTo(bottom) >= 0 && t.compareTo(top) <= 0;
	}

	public static IntegersRange between(Integer i, Integer j) {
		return new IntegersRange(i, j);
	}

}
