package io.github.coalangsoft.ifw.wrap.javafx;

import io.github.coalangsoft.data.Func;
import javafx.animation.AnimationTimer;

public class IfwAnimationTimer extends AnimationTimer {

	private IAnimationTimer timer;

	public IfwAnimationTimer(final Func<Long, Void> handle){
		timer = new IAnimationTimer() {
			public void handle(long time) {
				handle.call(time);
			}
		};
	}
	public IfwAnimationTimer(IAnimationTimer timer){
		this.timer = timer;
	}
	
	public void handle(long l) {
		timer.handle(l);
	}

}
