package io.github.coalangsoft.ifw.use;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Properties;

public class InterfaceWorld {
	
	private static final Properties props;
	
	static {
		props = new Properties();
		try {
			props.load(InterfaceWorld.class.getResourceAsStream("std.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String findNotAbstract(String name){
		String r = props.getProperty(name);
		if(r == null){
			try {
				Class<?> c = Class.forName(name);
				if(c.isInterface()){
					return name;
				}if(!Modifier.isAbstract(c.getModifiers())){
					return name;
				}
			} catch (ClassNotFoundException e) {
				return null;
			}
			
		}
		return r;
	}
	public static void addWrapper(String raw, String wrapper){
		props.setProperty(raw, wrapper);
	}
	
}
