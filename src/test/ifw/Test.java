package test.ifw;

import javafx.stage.Stage;
import io.github.coalangsoft.ifw.use.InterfaceWorld;
import io.github.coalangsoft.ifw.wrap.javafx.IfwApplication;
import io.github.coalangsoft.lib.data.Func;

public class Test {
	
	public static void main(String[] args) {
		new IfwApplication(new Func<Stage, Void>() {
			
			@Override
			public Void call(Stage p) {
				p.show();
				return null;
			}
		}).launch(args);
	}
	
}
