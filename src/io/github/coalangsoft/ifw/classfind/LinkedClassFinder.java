package io.github.coalangsoft.ifw.classfind;

import java.util.ArrayList;

import io.github.coalangsoft.lib.reflect.CustomClassFinder;

public class LinkedClassFinder implements CustomClassFinder{

	private ArrayList<CustomClassFinder> parts;
	
	public LinkedClassFinder(){
		parts = new ArrayList<CustomClassFinder>();
	}
	
	public void add(CustomClassFinder f){
		parts.add(f);
	}
	
	@Override
	public Class<?> find(String name) throws ClassNotFoundException {
		for(int i = 0; i < parts.size(); i++){
			try{
				return parts.get(i).find(name);
			}catch(Exception e){}
		}
		throw new ClassNotFoundException(name);
	}

}
