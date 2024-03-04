package pobj.multiset.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pobj.multiset.HashMultiSet;
import pobj.multiset.MultiSet;

public class HashMultiSetTest2 {
	
private MultiSet<String> m;
			
	@Test
	public void testAdd1() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("a");
		m.add("a",5);
		assertEquals(m.count("a"), 6);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testAdd2() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("a");
		m.add("a",-1);
	}
		
	@Test 
	public void testaddremove() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("a");
		m.add("a",5);
		m.add("b",3);
		m.remove("a");
		m.remove("b",4);
		assertFalse(m.add("c", 0));
		assertEquals(5, m.count("a"));
		assertEquals(5,m.size());
		assertEquals(0,m.count("d"));
	}
	
	@Test
	public void testclear() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("a",9);
		m.add("h");
		m.clear();
		assertEquals(0, m.count("a"));
		assertEquals(0, m.count("h"));
		assertEquals(0,m.size());
	}
	
	@Test
	public void testtostring() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("a",3);
		m.add("e",7);
		m.add("a");
		m.remove("e");
		m.add("t", 55);
		m.toString();
	}
	
	public void testaddremove2() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("a",5);
		m.remove("a",5);
		assertEquals(0, m.count("a"));
		assertEquals(0,m.size());
	}
	
	public void testremovenonexist() {
		MultiSet<String> m = new HashMultiSet<>();
		assertFalse(m.remove("c"));
		assertFalse(m.remove("b", 8));
		assertEquals(0,m.size());
	}
	
	public void testcount() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("a");
		m.add("b");
		assertEquals(0,m.count("c"));
	}


}
