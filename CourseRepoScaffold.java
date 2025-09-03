import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class CourseRepoScaffold {

    // You can override these via command-line args if you want.
    private static final String DEFAULT_ROOT = "C:\\\\fal25oop";
    private static final String[] SECTIONS = {"SectionA", "SectionB"};
    private static final int NUM_CLASSES = 30;
    private static final int NUM_LABS = 15;

    public static void main(String[] args) {
        String root = (args.length > 0 && !args[0].isBlank()) ? args[0] : DEFAULT_ROOT;

        System.out.println("Scaffolding course repo at: " + root);
        try {
            Path rootPath = Paths.get(root);
            Files.createDirectories(rootPath);

            // Optional top-level README
            createReadmeIfMissing(rootPath, "# fal25oop\n\nAuto-generated course repo scaffold.\n");

            for (String section : SECTIONS) {
                Path sectionPath = rootPath.resolve(section);
                Files.createDirectories(sectionPath);

                Path classesPath = sectionPath.resolve("Classes");
                Path labsPath = sectionPath.resolve("Labs");
                Files.createDirectories(classesPath);
                Files.createDirectories(labsPath);

                // Create Class01..Class30
                for (int i = 1; i <= NUM_CLASSES; i++) {
                    Path classDir = classesPath.resolve("Class" + pad2(i));
                    Files.createDirectories(classDir);
                    touchGitkeep(classDir);
                }

                // Create Lab01..Lab15
                for (int i = 1; i <= NUM_LABS; i++) {
                    Path labDir = labsPath.resolve("Lab" + pad2(i));
                    Files.createDirectories(labDir);
                    touchGitkeep(labDir);
                }

                // Optional READMEs for sections
                createReadmeIfMissing(sectionPath,
                        "## " + section + "\n\n- `Classes/` = Class01..Class" + NUM_CLASSES +
                        "\n- `Labs/` = Lab01..Lab" + NUM_LABS + "\n");
            }

            System.out.println("Done. You can now `git add .` and commit the structure.");
        } catch (IOException e) {
            System.err.println("Error while creating scaffold: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void touchGitkeep(Path dir) throws IOException {
        Path keep = dir.resolve(".gitkeep");
        if (Files.notExists(keep)) {
            Files.write(keep, new byte[0], StandardOpenOption.CREATE_NEW);
        }
    }

    private static void createReadmeIfMissing(Path folder, String content) throws IOException {
        Path readme = folder.resolve("README.md");
        if (Files.notExists(readme)) {
            Files.writeString(readme, content, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
        }
    }

    private static String pad2(int n) {
        return (n < 10 ? "0" : "") + n;
    }
}
