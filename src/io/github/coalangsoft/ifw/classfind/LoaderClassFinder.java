package io.github.coalangsoft.ifw.classfind;

import java.net.URL;

import io.github.coalangsoft.lib.reflect.CustomClassFinder;

public class LoaderClassFinder implements CustomClassFinder {

	private ClassLoader loader;
	
	public LoaderClassFinder(ClassLoader l){
		this.loader = l;
	}
	
	@Override
	public Class<?> find(String name) throws ClassNotFoundException {
		return loader.loadClass(name);
	}

	@Override
	public URL resource(String name) {
		return loader.getResource(name);
	}

}
