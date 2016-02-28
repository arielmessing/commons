package org.arielmessing.commons.datastruct;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RangesTree<T> {

	private NavigableMap<T, Ranged<T>> rangesStore = new TreeMap<>();
	
	public RangesTree(Collection<? extends Ranged<T>> c) {
		for (Ranged<T> ranged : c) {
			
			if (findRangeContaining(ranged.getBottom()) != null || findRangeContaining(ranged.getTop()) != null)
				throw new IllegalArgumentException("Ranges intersect");
				
			rangesStore.put(ranged.getBottom(), ranged);
			rangesStore.put(ranged.getTop(), ranged);
			
		}
	}
	
    public Ranged<T> findRangeContaining(T t) {
    	
 		Entry<T, Ranged<T>> floorEntry = rangesStore.floorEntry(t);
 		Entry<T, Ranged<T>> ceilingEntry = rangesStore.ceilingEntry(t);
 		
 		if (floorEntry != null && ceilingEntry != null) {
 			Ranged<T> floorRanged = floorEntry.getValue();
 			Ranged<T> ceilingRanged = ceilingEntry.getValue();
 			
 			if (floorRanged.equals(ceilingRanged) && floorRanged.contains(t) && ceilingRanged.contains(t)) {
 				return floorRanged;
 			}
 		}
 		
 		return null;
     }
}
