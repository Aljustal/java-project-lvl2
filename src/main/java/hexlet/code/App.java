package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {

    //@Parameters(description = "path to first file")
    private String  filepath1;

    //@Parameters(description = "path to second file")
    private String  filepath2;

    //@Option(names = {"-f", "--format "}, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    public static void main(String... args) throws Exception {

        String filepath1 = ("src/main/json/file1.json");
        String filepath2 = ("src/main/json/file2.json");
        Differ.generate(filepath1, filepath2);
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
