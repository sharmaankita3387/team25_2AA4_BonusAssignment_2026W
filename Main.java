import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        XMLReader reader = new XMLReader();
        List<String> values = reader.readValues("car.xml");

        UMLParser parser = new UMLParser();
        List<UMLClass> classes = parser.parse(values);

        CodeGenerator generator = new CodeGenerator();

        for (UMLClass umlClass : classes) {
            generator.generate(umlClass);
        }

        System.out.println("Code generation complete.");
    }
}
