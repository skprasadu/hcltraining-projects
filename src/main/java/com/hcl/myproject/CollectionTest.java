package com.hcl.myproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lombok.val;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] inputVals = {"Altaf", "Krishna", "Altaf", "Neil", "Neil", "Aibak"};
		val arr = new ArrayList<String>();
		
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
