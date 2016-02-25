package org.messing.common.net;

import org.junit.Assert;
import org.junit.Test;

public class IPv4Tests {

	@Test
	public void isIPv4Test() {
		Assert.assertTrue(IPv4.isIPv4("1.2.3.4"));
		Assert.assertTrue(IPv4.isIPv4("255.255.255.255"));
		
		Assert.assertFalse(IPv4.isIPv4("a"));
		Assert.assertFalse(IPv4.isIPv4("1.2.333.4"));
		Assert.assertFalse(IPv4.isIPv4("a.b.3.4"));
		Assert.assertFalse(IPv4.isIPv4("1.2.3"));
	}
	
}
