package io.github.coalangsoft.ifw.classfind;

import java.net.URL;

import io.github.coalangsoft.lib.reflect.CustomClassFinder;

public class DefaultClassFinder implements CustomClassFinder {

	@Override
	public Class<?> find(String name) throws ClassNotFoundException {
		return Class.forName(name);
	}

	@Override
	public URL resource(String name) {
		return ClassLoader.getSystemResource(name);
	}

}
