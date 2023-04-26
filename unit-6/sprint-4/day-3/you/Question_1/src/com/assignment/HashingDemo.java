package com.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashingDemo {
	public static Map<Character, List<String>> addName(String names[]){
		
		Map<Character, List<String>> nameList = new HashMap<Character, List<String>>();
		
		for(int i = 0; i < names.length; i++) {
			String str = names[i];
			Character ch = str.charAt(0);
			
			if(nameList.containsKey(ch)) {
				List<String> name = nameList.get(ch);
				name.add(str);
				nameList.put(ch, name);
			} else {
				List<String> name = new ArrayList<String>();
				name.add(str);
				nameList.put(ch, name);
			}
		}
		
		return nameList;
	}
	
	
	public static void display(Map<Character, List<String>> map) {
		for(Map.Entry<Character, List<String>> m : map.entrySet()) {
			System.out.print(m.getKey() + " : ");
			List<String> arr = (List<String>) m.getValue();
			
//			for(String name : arr) {
//				System.out.print(name + ", ");
//			}
//			System.out.println();
			
			System.out.println(m.getKey() + " : " + String.join(", ", arr));
		}
	}
	
	
	public static boolean searchName(Map<Character, List<String>> map, String name) {
//		boolean flag = false;
//		for(Map.Entry<Character, List<String>> m : map.entrySet()) {
//			List<String> arr = (List<String>)m.getValue();
//			
//			if(arr.contains(name)) {
//				flag = true;
//			}
//		}
//		
//		return flag;
		
		char ch = name.toUpperCase().charAt(0);
		
		if(!map.containsKey(ch)) {
			return false;
		}
		
		List<String> arr = map.get(ch);
		
		return arr.contains(name);
	}
	
	
	public static boolean removeName(Map<Character, List<String>> map, String name) {
//		Character ch = '0';
//		for(Map.Entry<Character, List<String>> m : map.entrySet()) {
//			List<String> arr = (List<String>)m.getValue();
//			
//			if(arr.contains(name)) {
//				return arr.remove(name);
//			}
//			
//			if(arr.isEmpty()) {
//				ch = m.getKey();
//			}
//		}
//		
//		if(map.containsKey(ch)) {
//			map.remove(ch);
//		}
//		
//		return false;
		
		Character ch = name.toUpperCase().charAt(0);
		
		if(!map.containsKey(ch)) {
			return false;
		}
		
		List<String> arr = map.get(ch);
		
		arr.remove(name);
		
		if(arr.isEmpty()) {
			map.remove(ch);
		}
		
		return true;
	}
  
  public static void main(String[] args) {
    String names[] = {"Naya", "Ishaan", "Jai", "Inaya", "Amar", "Navi", "Dhruv",
        "Kanan", "Diya", "Shyla", "Agastya", "Ananya", "Nila", "Tenzin", "Tamia",
        "Shaan", "Ajay", "Jaya", "Anjali", "Aditi", "Reva", "Sahil", "Darsh", "Aja",
        "Ambar", "Deven", "Ishani", "Kavi", "Marjane", "Jasleen", "Ashwin", "Aadhira",
        "Candy", "Kum", "Salina", "Artha", "Raghav", "Avan", "Sitara", "Shylah", "Divya",
        "Varun", "Sona", "Shaila", "Kimaya", "Farid", "Kashvi", "Devi", "Charu", "Mihir", "Tulsi",
        "Anila", "Anala", "Vivan", "Amitabh", "Mahika", "Sudhir", "Lata", "Anand", "Akshay"};
    
    Map<Character, List<String>> map = addName(names);
    
    System.out.println("The original map is ");
    display(map);
    
    System.out.println();
    if(searchName(map, "Farid")) {
      System.out.println("Name 'Farid' found in Map");
    }else {
      System.out.println("Name 'Farid' not found in Map");
    }
    
    System.out.println();
    if(searchName(map, "Harish")) {
      System.out.println("Name 'Harish' found in Map");
    }else {
      System.out.println("Name 'Harish' not found in Map");
    }
    
    System.out.println();
    if(removeName(map, "Lata")) {
      System.out.println("Name 'lata' removed from Map");
    }else {
      System.out.println("Name 'lata' not in map hence not deleted");
    }

    System.out.println();
    if(removeName(map, "Harish")) {
      System.out.println("Name 'Harish' removed from Map");
    }else {
      System.out.println("Name 'Harish' not in map hence not deleted");
    }
    
    System.out.println();
    display(map);
  }
}