package weekone.labs.reflectionandannottation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader {
    private final String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath= classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classData = loadClassFromFile(name);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(name);
        }
    }

    private void prints(){
        System.out.println("CustomClassLoader");
    }

    private byte[] loadClassFromFile(String className) throws IOException {
        String path = classPath + File.separator + className.replace('.', File.separatorChar) + ".class";
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            return buffer;
        } catch (IOException e) {
            e.printStackTrace();
      return new byte[0];
        }
    }
}

