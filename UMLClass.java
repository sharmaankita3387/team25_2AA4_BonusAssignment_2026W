import java.util.ArrayList;
import java.util.List;

public class UMLClass {

    private String className;
    private List<String> attributes = new ArrayList<>();
    private List<String> methods = new ArrayList<>();

    public UMLClass(String className) {
        this.className = className;
    }

    public void addAttribute(String attribute) {
        attributes.add(attribute);
    }

    public void addMethod(String method) {
        methods.add(method);
    }

    public String getClassName() {
        return className;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public List<String> getMethods() {
        return methods;
    }
}
