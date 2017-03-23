package io.github.coalangsoft.ifw.use;

public class DefaultClassFinder implements CustomClassFinder {

	@Override
	public Class<?> find(String name) throws ClassNotFoundException {
		return Class.forName(name);
	}

}
