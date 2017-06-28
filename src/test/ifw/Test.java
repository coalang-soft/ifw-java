package test.ifw;

import io.github.coalangsoft.ifw.use.InterfaceWrapper;
import io.github.coalangsoft.ifw.use.Javac;
import io.github.coalangsoft.ifw.use.JavacResult;
import io.github.coalangsoft.lib.data.Pair;

import java.io.File;
import java.util.ArrayList;

public class Test {

	public interface Out {
		void write(int i);
	}

	public static void main(String[] args) {
		Out o = InterfaceWrapper.wrap(Out.class, System.out);
		o.write(65);
		System.out.println();

		Javac javac = Javac.getInstance();

		ArrayList<File> files = new ArrayList<File>();
		files.add(new File("DemoClass.java"));

		JavacResult result = javac.compile(files);
		result.makeException();
	}
	
}
