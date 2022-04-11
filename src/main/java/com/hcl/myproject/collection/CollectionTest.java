package com.hcl.myproject.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] inputVals = {"Altaf", "Krishna", "Altaf", "Neil", "Neil", "Aibak"};
		List<String> arr = new ArrayList<String>();
		
		for(String inpVal: inputVals) {
			
			if(!arr.contains(inpVal)) {
				arr.add(inpVal);
			}
		}
		System.out.println(arr);
		
		Set<String> set= new HashSet<String>();
		
		for(String inpVal: inputVals) {
			set.add(inpVal);
		}
		
		System.out.println(set);

		set= new TreeSet<String>();
		
		for(String inpVal: inputVals) {
			set.add(inpVal);
		}
		
		System.out.println(set);
		
		

	}

}
