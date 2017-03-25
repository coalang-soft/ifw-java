package io.github.coalangsoft.ifw.classfind;

import io.github.coalangsoft.ifw.use.CustomClassFinder;

public class DefaultClassFinder implements CustomClassFinder {

	@Override
	public Class<?> find(String name) throws ClassNotFoundException {
		return Class.forName(name);
	}

}
