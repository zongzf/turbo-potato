package com.imooc.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载manager的工厂
 */
public class ManagerFactory {
    //记录热加载类的加载信息
    private static final Map<String,LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();

    public static final String CLASS_PATH = "/";//todo:

    public static final String MY_MANAGER = "com.imooc.classloader.MyManager";

    public static BaseManager getManager(String className){
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\","/")+".class");
        long lastModified = loadFile.lastModified();
        if(loadTimeMap.get(className)==null){
            load(className,lastModified);
        }else if(loadTimeMap.get(className).getLoadTime()!=lastModified){
            load(className,lastModified);

        }
        return loadTimeMap.get(className).getBaseManager();
    }

    private static void load(String className,long lastModified){
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader,lastModified);
        loadInfo.setBaseManager(manager);
        loadTimeMap.put(className,loadInfo);
    }

    private static BaseManager newInstance(Class<?> loadClass) {
        try {
            return (BaseManager)loadClass.getConstructor(new Class[]{}).newInstance(new Object());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


}
