package weekone.labs.reflectionandannottation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            String classPath = "src/weekone/labs/reflectionandannottation";

            CustomClassLoader customClassLoader = new CustomClassLoader(classPath);

            Class<?> loadedClass = customClassLoader.loadClass("weekone.labs.reflectionandannottation.TestingClassLoader");

            // Creating a new instance from the loaded class
            Object instance = loadedClass.getDeclaredConstructor().newInstance();

            Method method = loadedClass.getDeclaredMethod("printMessage");
            method.invoke(instance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
