package io.github.coalangsoft.ifw.use;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Matthias on 18.06.2017.
 */
public class InterfaceWrapper {

    public static <T> T wrap(Class<T> interfaceClass, Object base){
        return (T) wrap(new Class[]{interfaceClass}, base);
    }

    public static Object wrap(Class[] interfaces, final Object base){
        //Check if base is instance
        int count = 0;
        for(int i = 0; i < interfaces.length; i++){
            if(interfaces[i].isInstance(base)){
                count++;
            }else{
                break;
            }
        }
        if(count == interfaces.length){
            return base;
        }

        //Wrap
        final Class<?> baseClass = base.getClass();

        return Proxy.newProxyInstance(interfaces[0].getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return baseClass.getMethod(method.getName(), method.getParameterTypes()).invoke(base, (Object[]) args);
            }
        });
    }

}
