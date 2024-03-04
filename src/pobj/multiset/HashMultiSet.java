package pobj.multiset;


import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;


import pobj.multiset.*;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>{
	
	private HashMap<T,Integer> gc ;
	int size = 0;
	int some=0;
	 
    
	public HashMultiSet(){				
		gc = new HashMap<T,Integer>();
	} 
	
    public HashMultiSet(Collection<T> c){

		gc = new HashMap<T,Integer>();
       	for (T i : c) {
    		this.add(i); 
    		some++;
    	} 
    	}
    
    
    @Override
	public Iterator<T> iterator() {
		return new HashMultiSetIterator();
	}
    

    public class HashMultiSetIterator implements Iterator<T>{
    	  private Set<Entry<T, Integer>> entrySet;
          private Iterator<Entry<T, Integer>> I;
          private Map.Entry<T, Integer> set;
          int cp=size();
          int c;
          
          public HashMultiSetIterator() {
        	  entrySet = gc.entrySet();
        	  I = entrySet.iterator();
		       if(hasNext()) {
		    	   set = I.next();
		    	   c = set.getValue();
		       } else { I=Collections.emptyIterator();}
          }
          
    	  @Override 
    		public boolean hasNext() {
    			return cp>0;
    		} 
    	  
    		@Override 
    		public T next() { 
    		    	   cp--;
    		    	   if(c>0) {
    		    		   c--;
    		    	   }
    		    	   else {
    		    		   set = I.next();
    		    		   c= set.getValue() - 1;

    		    	   } 

	    		   return set.getKey();
        		}
    }
   	               			
	
	@Override
	public boolean add(T e, int count) {
		if (count < 0) {
			throw new IllegalArgumentException("invalid number");
		}
		if (count==0) return false;
		else {
			if (gc.containsKey(e)==true) {
				gc.put(e, gc.get(e)+Integer.valueOf(count));
				return true;	
			}
			else {
				gc.put(e, count);
				return true;
			}
			
		}	
		
	}

	@Override
	public boolean add(T e) {
		
		return add(e, 1);
		
		
	}

	@Override
	public boolean remove(Object e) {
		
		return remove(e, 1);
		
	}

	@Override
	public boolean remove(Object e, int count) {
		if (count < 0) {
			throw new IllegalArgumentException("invalid number");
		}
		if (count==0) return false;
		else {
			if (gc.containsKey(e)==true) {
				if(gc.get(e)>count) {
				gc.put((T)e, gc.get(e)-Integer.valueOf(count));
				}
				else {gc.put((T)e, 0);}
				return true;
			}
			else return false;
		}
		
	}

	@Override
	public int count(T o) {
		if (!gc.containsKey(o)) return 0;
		else return gc.get(o);
	}	

	@Override
	public void clear() {
		gc.clear();
		
	}

	@Override
	public int size() {	
		for (Integer i : gc.values()) {
    		size+=i;   		
    	} 
		return size;
	}

	@Override
	public List<T> elements() {
		List l = new ArrayList<T>();
		HashMap<T, Integer>  hm = sort(gc);
		for (HashMap.Entry<T, Integer> entrySet : hm.entrySet()) {
			l.add(entrySet.getKey());

		}
		return l;
	}
	
	public HashMap<T, Integer> sort(HashMap<T, Integer> map) {
		 Map <T, Integer> myMap = new LinkedHashMap<T, Integer> ();
	        Set set = new TreeSet(
	            new Comparator()
	            {
	                public int compare(Object obj, Object obj1)
	                {
	                    Integer val1 = (Integer) ((Map.Entry) obj).getValue();
	                    Integer val2 = (Integer) ((Map.Entry) obj1).getValue();
	                    if (val2.compareTo(val1)==0) return -1;
	                    return val2.compareTo(val1);
	                }   
	            }
	        );
	 	        set.addAll(map.entrySet());
	 
	        for(Iterator it = set.iterator(); it.hasNext() ;) {
	            Map.Entry<T, Integer>  myMapEntry = (Map.Entry) it.next();
	            myMap.put( myMapEntry.getKey(), myMapEntry.getValue());
	            
	        }
	 return (HashMap<T, Integer>) myMap;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("[ ");
		boolean pv = false;
		for (Map.Entry mapentry : gc.entrySet()) {
			if(pv) b.append("; ");
			else pv=true;
			 b.append(mapentry.getKey() 
			 + ":" + mapentry.getValue());
			 }
		b.append(" ]");
		return b.toString();
	}
	
	
	
	
}


	
	

