package io.github.coalangsoft.ifw.wrap.java.io;

import io.github.coalangsoft.lib.data.Func;

import java.io.IOException;
import java.io.InputStream;

public class IfwInputStream extends InputStream implements Func<Void, Integer>{
	private IInputStream stream;

	public IfwInputStream(final Func<Void, Number> read){
		stream = new IInputStream() {
			public int read() {
				return read.call(null).intValue();
			}
		};
	}
	public IfwInputStream(IInputStream stream){
		this.stream = stream;
	}
	@Override
	public int read() throws IOException {
		return stream.read();
	}
	@Override
	public Integer call(Void p) {
		try {
			return read();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
