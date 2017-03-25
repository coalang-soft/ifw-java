package io.github.coalangsoft.ifw.classfind;

import io.github.coalangsoft.ifw.use.CustomClassFinder;

public class LoaderClassFinder implements CustomClassFinder {

	private ClassLoader loader;
	
	public LoaderClassFinder(ClassLoader l){
		this.loader = l;
	}
	
	@Override
	public Class<?> find(String name) throws ClassNotFoundException {
		return loader.loadClass(name);
	}

}
