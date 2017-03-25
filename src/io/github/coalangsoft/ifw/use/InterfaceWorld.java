package io.github.coalangsoft.ifw.use;

import io.github.coalangsoft.ifw.classfind.DefaultClassFinder;

import java.lang.reflect.Modifier;
import java.util.Properties;

public class InterfaceWorld {
	
	private static final Properties props;
	public static final CustomClassFinder DEFAULT_CLASS_FINDER = new DefaultClassFinder();
	
	static {
		props = new Properties();
		try {
			props.load(InterfaceWorld.class.getResourceAsStream("std.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String findNotAbstract(String name){
		return findNotAbstract(name, DEFAULT_CLASS_FINDER);
	}
	public static void addWrapper(String raw, String wrapper){
		props.setProperty(raw, wrapper);
	}
	public static String findNotAbstract(String name, CustomClassFinder f) {
		String r = props.getProperty(name);
		if(r == null){
			try {
				Class<?> c = f.find(name);
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
	
}
