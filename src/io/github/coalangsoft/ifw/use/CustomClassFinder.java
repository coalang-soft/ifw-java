package io.github.coalangsoft.ifw.use;

public interface CustomClassFinder {
	
	Class<?> find(String name) throws ClassNotFoundException;
	
}
