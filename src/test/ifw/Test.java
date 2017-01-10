package test.ifw;

import io.github.coalangsoft.ifw.use.InterfaceWorld;

public class Test {
	
	public static void main(String[] args) {
		String name = InterfaceWorld.findNotAbstract("java.awt.event.ActionListener");
		System.out.println(name);
	}
	
}
