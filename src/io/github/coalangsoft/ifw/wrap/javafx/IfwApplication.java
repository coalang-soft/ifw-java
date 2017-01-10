package io.github.coalangsoft.ifw.wrap.javafx;

import io.github.coalangsoft.data.Func;
import javafx.application.Application;
import javafx.stage.Stage;

public class IfwApplication extends Application {

	private static IApplication application;
	
	public static void setup(IApplication app){
		application = app;
	}
	public static void setup(final Func<Stage, Void> start){
		application = new IApplication() {
			public void stop() {}
			
			public void start(Stage stage) throws Exception {
				start.call(stage);
			}
			
			public void init() {}
		};
	}
	
	@Override
	public void start(Stage s) throws Exception {
		application.start(s);
	}
	
	@Override
	public void stop() throws Exception {
		application.stop();
	}
	
	@Override
	public void init() throws Exception {
		application.init();
	}

}
