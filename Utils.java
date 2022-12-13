package aed.individual5;

import java.util.Iterator;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.*;
import es.upm.aedlib.map.*;

public class Utils {
  
  public static <E> PositionList<E> deleteRepeated(PositionList<E> l) {
	  PositionList<E> list = new NodePositionList<E>();
	  
	  Position<E> cursor = l.first();
	  boolean hayNull = false;
	  while (cursor!=null) {
		  if (cursor.element() == null) {
			  if(!hayNull) {
			  
				hayNull = true;
				list.addLast(cursor.element());
			  }
		  }else {
			  
			  
			  Position<E> cursor2 = list.first();
			  
			  
			  while(cursor2!=null && (cursor2.element() == null||!cursor2.element().equals(cursor.element()))) {
				  cursor2 = list.next(cursor2);
				  
			  }
			  if(cursor2==null) {
				  list.addLast(cursor.element());
			  }
			  
		  }
		  cursor = l.next(cursor);
		  
	  }
	  
	  
    return list;
  }
  
  public static <E> PositionList<E> compactar (Iterable<E> lista) {
	 if (lista == null) {
		 throw new IllegalArgumentException();
	 }
	 
	 
	 Iterator<E> it = lista.iterator();
	 PositionList<E> list = new NodePositionList<E>();
	 if(!it.hasNext()) return list;
	 
	 E actual = it.next();
	 while (it.hasNext()) {
		 
		 E siguiente = it.next();
		 if(!eqNull(actual, siguiente)) {
			 list.addLast(actual);
		 }
		 actual = siguiente;
	 }
	list.addLast(actual);
    return list;
  }
  
  public static Map<String,Integer> maxTemperatures(TempData[] tempData) {
	  
	Map<String,Integer> map =   new HashTableMap<String, Integer>();
	
	
	for (int i = 0; i < tempData.length; i++) {
		TempData actual = tempData[i];
		if (!map.containsKey(actual.getLocation())) {
			map.put(actual.getLocation(), actual.getTemperature());
		}else {
			if(map.get(actual.getLocation()) < actual.getTemperature()) {
				map.put(actual.getLocation(), actual.getTemperature());
			}
		}

	}
	
	
	
    return map;
  }
  
  
  public static <E> boolean eqNull (E o1, E o2) {
	  return o1 == o2 || o1!=null && o1.equals(o2);
	  }
  
  
}


