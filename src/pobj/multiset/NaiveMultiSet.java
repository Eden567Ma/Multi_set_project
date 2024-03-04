package pobj.multiset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NaiveMultiSet<T> implements MultiSet<T>{ 
	
	private List<T> list;
	
    
	public NaiveMultiSet(){				
		list = new ArrayList<T>();
	}
	
    public NaiveMultiSet(Collection<T> c){

		list = new ArrayList<T>();
       	for (T i : c) {
    		this.add(i);   		
    	} 
    	}




@Override
public Iterator<T> iterator() {
	return list.iterator();
}

@Override
public boolean add(T e, int count) {
	for(int i=0; i<count; i++)
	{
	list.add(e);
	}
	return true;
}

@Override
public boolean add(T e) {
	return list.add(e);
}

@Override
public boolean remove(Object e) {
	return list.remove(e);		
}

@Override
public boolean remove(Object e, int count) {
	for(int i=0; i<count; i++)
	{
	list.remove(e);
	}
	return true;
}

@Override
public int count(T o) {
	return Collections.frequency(list, o);
}

@Override
public void clear() {
	list.clear();
}

@Override
public int size() {
	return list.size();
}

public T max(List<T> L) {
	int max =0;
	T t =null;
	for (T i : L) {
		if(count(i) >= max) {
			max = count(i);
			t = (T) i;
		}
	}
	//System.out.println(max);
	//System.out.println(t.toString());



	return t;
}

@Override
public List<T> elements() { 
	List<T> copy = list;
	//System.out.println(list.get(0));

	//System.out.println(copy.get(0));
	
	List<T> sorted = new ArrayList<T>();
	int k = 0;
	while (copy.size()>0) {
		T m = max(copy);
		sorted.add(m);
		int v = count(m);
		for(int i=0; i < v ; i++)
		{
		copy.remove(m);
		}
		k++;
		for(T elem: copy)
	       {
	       	 //System.out.println (elem.toString());
	       }
      	 //System.out.println ();

	}
	//System.out.println(sorted.get(0));

	return sorted;
}


}