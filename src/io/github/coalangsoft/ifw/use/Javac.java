package io.github.coalangsoft.ifw.use;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.data.ImmutablePair;
import io.github.coalangsoft.lib.data.Pair;

import java.io.File;

/**
 * Created by Matthias on 18.06.2017.
 */
public class Javac {

    private final Func<Iterable<File>, JavacResult> func;
    private static Javac instance;

    private Javac(Func<Iterable<File>, JavacResult> func) {
        this.func = func;
    }

    public static Javac getInstance(){
        if(instance != null){
            return instance;
        }

        try{
            Class<?> toolProvider = Class.forName("javax.tools.ToolProvider");
            return instance = new Javac((Func<Iterable<File>, JavacResult>)
                    Class.forName("io.github.coalangsoft.ifw.use.JavacImpl")
                    .getConstructor(Object.class).newInstance(
                            toolProvider.getMethod("getSystemJavaCompiler").invoke(null)
                    ));
        }catch (Exception e){
            e.printStackTrace();
            return instance = new Javac(new Func<Iterable<File>, JavacResult>(){
                @Override
                public JavacResult call(Iterable<File> aVoid) {
                    return new JavacResult("Javac not available!", false);
                }
            });
        }
    }

    public JavacResult compile(Iterable<File> files){
        return func.call(files);
    }

}
