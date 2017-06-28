package io.github.coalangsoft.ifw.use;

import io.github.coalangsoft.lib.data.ImutablePair;
import io.github.coalangsoft.lib.data.Pair;

/**
 * Created by Matthias on 18.06.2017.
 */
public class JavacResult {

    private final boolean success;
    private final String out;

    public JavacResult(String out, boolean success){
        this.out = out;
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getOut() {
        return out;
    }

    public Pair<String, Boolean> toPair() {
        return new ImutablePair<String, Boolean>(out, success);
    }

    public void makeException() throws RuntimeException {
        if(!isSuccess()){
            throw new RuntimeException(getOut());
        }
    }

}
