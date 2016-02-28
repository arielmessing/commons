package org.arielmessing.commons.datastruct;

public interface Ranged<T> {
	T getBottom();
	T getTop();
	
	boolean contains(T t);
}
