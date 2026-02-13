import java.util.ArrayList;
import java.util.List;

public class UMLParser {

    public List<UMLClass> parse(List<String> values) {

        List<UMLClass> classes = new ArrayList<>();
        UMLClass currentClass = null;

        for (String value : values) {

            if (value == null) continue;

            // Replace <div> with newline BEFORE removing HTML
            value = value.replace("<div>", "\n");
            value = value.replace("</div>", "");
            value = value.replace("<br>", "\n");

            // Remove any remaining HTML tags
            value = value.replaceAll("<.*?>", "");

            // Split into lines
            String[] lines = value.split("\n");

            for (String line : lines) {

                line = line.trim();
                if (line.isEmpty()) continue;

                // Skip multiplicity labels like 0..*, 1, 1..*
                if (line.matches("\\d+\\.\\.\\*") ||
                    line.matches("\\d+") ||
                    line.matches("\\d+\\.\\.\\d+")) {
                    continue;
                }

                // Class name (no + or -)
                if (!line.startsWith("+") && !line.startsWith("-")) {
                    currentClass = new UMLClass(line);
                    classes.add(currentClass);
                }
                else if (currentClass != null) {

                    if (line.contains("(")) {
                        currentClass.addMethod(line);
                    } else {
                        currentClass.addAttribute(line);
                    }
                }
            }
        }

        return classes;
    }
}
