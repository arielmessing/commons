package org.arielmessing.commons.datastruct;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class RangesTressTests {
		
	@Test
	public void validRanges() {
		
		Collection<IntegersRange> c = new LinkedList<>();
		c.add(IntegersRange.between(1, 4));
		c.add(IntegersRange.between(6, 8));
		c.add(IntegersRange.between(9, 10));
		
		new RangesTree<Integer>(c);
	}
	
	@Test
	public void intersectingRanges() {
		
		Collection<IntegersRange> c = new LinkedList<>();
		c.add(IntegersRange.between(1, 7));
		c.add(IntegersRange.between(3, 8));
		
		try {
			new RangesTree<Integer>(c);
		
		} catch (IllegalArgumentException e) {
			return;
		}
		
		Assert.fail();
	}

}
