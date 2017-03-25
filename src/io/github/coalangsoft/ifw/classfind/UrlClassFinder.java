
package io.github.coalangsoft.ifw.classfind;

import java.net.URL;
import java.net.URLClassLoader;

public class UrlClassFinder extends LoaderClassFinder {

	public UrlClassFinder(URL... urls) {
		super(new URLClassLoader(urls));
	}

}
