package io.github.coalangsoft.ifw.wrap.javafx;

import javafx.stage.Stage;

public interface IApplication {
	
	void start(Stage stage) throws Exception;
	void stop();
	void init();
	
}
