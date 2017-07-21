package io.github.coalangsoft.ifw.use;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.data.ImmutablePair;
import io.github.coalangsoft.lib.data.Pair;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Matthias on 18.06.2017.
 */
public class JavacImpl implements Func<Iterable<File>, JavacResult> {

    private final JavaCompiler javac;

    public JavacImpl(Object javaCompiler){
        this.javac = (JavaCompiler) javaCompiler;
    }

    @Override
    public JavacResult call(Iterable<File> files) {
        StandardJavaFileManager fileManager = fileManager = javac.getStandardFileManager(null,null, null);;

        StringWriter writer = new StringWriter();

        Boolean result = javac.getTask(writer,
                fileManager,
                null,
                null,
                null,
                fileManager.getJavaFileObjectsFromFiles(files))
                .call();

        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JavacResult(writer.toString(), result);
    }
}
