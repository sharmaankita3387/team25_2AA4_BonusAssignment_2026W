import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    public void generate(UMLClass umlClass) throws IOException {

        FileWriter writer = new FileWriter(umlClass.getClassName() + ".java");

        writer.write("public class " + umlClass.getClassName() + " {\n\n");

        // Attributes
        for (String attr : umlClass.getAttributes()) {
            String formatted = convertAttribute(attr);
            if (!formatted.isEmpty()) {
                writer.write("    " + formatted + ";\n");
            }
        }

        writer.write("\n");

        // Methods
        for (String method : umlClass.getMethods()) {
            writer.write("    " + convertMethod(method) + " {\n");
            writer.write("        // TODO Auto-generated method\n");
            writer.write("    }\n\n");
        }

        writer.write("}");
        writer.close();
    }

    private String convertAttribute(String attr) {
        if (!attr.contains(":")) return "";
        String visibility = attr.startsWith("+") ? "public" : "private";
        attr = attr.substring(1).trim();
    
        String[] parts = attr.split(":");
    
        if (parts.length == 2) {

            String name = parts[0].trim();
            String type = formatType(parts[1]);

            return visibility + " " + type + " " + name;
        }

        return "";
    }

    private String convertMethod(String method) {
        String visibility = method.startsWith("+") ? "public" : "private";

        method = method.substring(1).trim();

        String methodName = method.substring(0, method.indexOf("(")).trim();
        String paramSection = method.substring(method.indexOf("(") + 1, method.indexOf(")")).trim();
        String formattedParams = "";

        if (!paramSection.isEmpty()) {

            String[] params = paramSection.split(",");

            for (int i = 0; i < params.length; i++) {

                String[] parts = params[i].trim().split(":");

                if (parts.length == 2) {

                    String paramName = parts[0].trim();
                    String paramType = formatType(parts[1]);

                    formattedParams += paramType + " " + paramName;

                    if (i < params.length - 1) {
                        formattedParams += ", ";
                    }
                }
            }
        }

        return visibility + " void " + methodName + "(" + formattedParams + ")";
    }


private String formatType(String type) {

    type = type.trim();

    // Do NOT capitalize primitives
    if (type.equals("int") ||
        type.equals("double") ||
        type.equals("float") ||
        type.equals("boolean") ||
        type.equals("char") ||
        type.equals("long") ||
        type.equals("short") ||
        type.equals("byte") ||
        type.equals("String")) {
        return type;
    }

    // Capitalize object types
    return type.substring(0,1).toUpperCase() + type.substring(1);
}



}
