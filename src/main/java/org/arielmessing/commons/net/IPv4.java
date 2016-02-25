package org.arielmessing.commons.net;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IPv4 {
	
	// 255.255.255.255
	private static final long MAX_IP = 4294967295L;	
	
	private static final String IP = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
	private static final Pattern IP_PATTERN = Pattern.compile(IP);

	private IPv4() {}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isIPv4(String string) {
		if (string == null)
			return false;
		
		if (string.length() < 7)
			return false;
		
		if (string.charAt(1) == '.' || 
			string.charAt(2) == '.' || 
			string.charAt(3) == '.') {
			
			Matcher matcher = IP_PATTERN.matcher(string);
			return (matcher.find());
		
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the long format of the provided IP address.
	 *
	 * @param ipAddress the IP address
	 * @return the long format of <code>ipAddress</code>
	 * @throws IllegalArgumentException if <code>ipAddress</code> is not a valid one
	 */
	public static long toLong(String ipAddress) {
		if (ipAddress == null || ipAddress.isEmpty()) {
			throw new IllegalArgumentException("IP address cannot be null or empty");
		}

		StringTokenizer st = new StringTokenizer(ipAddress, ".");
		long[] octets = new long[4];
		int count = 0;
		while (st.hasMoreTokens()) {
			long octet = Long.parseLong(st.nextToken());
			if (count > 4 || octet > 255 || octet < 0) {
				throw new IllegalArgumentException("Invalid IP address");
			}
			octets[count] = octet;
			count++;
		}
		
		long ip = 0;
		for (int i = 3; i >= 0; i--) {
			long octet = octets[3 - i];
			
			if (octet > 255 || octet < 0) {
				throw new IllegalArgumentException("Invalid IP address");
			}
			
			ip |= octet << (i * 8);
		}
		
		return ip;
	}

	/**
	 * Returns the 32bit dotted format of the provided long ip.
	 *
	 * @param ip the long ip
	 * @return the 32bit dotted format of <code>ip</code>
	 * @throws IllegalArgumentException if <code>ip</code> is invalid
	 */
	public static String toString(long ip) {
		
		if (ip < 0 || ip > MAX_IP) {
			throw new IllegalArgumentException("Invalid IP");
		}
		
		StringBuilder ipAddress = new StringBuilder();
		for (int i = 3; i >= 0; i--) {
			int shift = i * 8;
			
			ipAddress.append((ip & (0xff << shift)) >> shift);
			
			if (i > 0) {
				ipAddress.append(".");
			}
		}
		
		return ipAddress.toString();
	}
}
