package weekone.labs.reflectionandannottation;

public class TestingClassLoader {
    private String message;

    public TestingClassLoader() {
        this.message = "Dynamic class loaded and method invoked!";
    }

    public void printMessage() {
        System.out.println(message);
    }
}
