import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        Set<String> output = new LinkedHashSet<>();

        Settings settings = new Settings(flags, files);

        files.forEach(fileName -> output.addAll(grepFile(pattern, settings, fileName)));

        return String.join("\n", output).trim();
    }

    private List<String> grepFile(String pattern, Settings settings, String fileName) {
        List<String> output = new ArrayList<>();

        try {
            FileInputStream fs = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));

            String line;
            int index = 1;
            while ((line = br.readLine()) != null) {
                if (isCorrectLine(line, pattern, settings)) {
                    line = applyFormat(line, index, fileName, settings);
                    output.add(line);
                }
                index++;
            }

            fs.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

    private boolean isCorrectLine(String line, String pattern, Settings settings) {
        if (settings.isMatchCaseInsensitive()) {
            line = line.toLowerCase();
            pattern = pattern.toLowerCase();
        }

        if (settings.isMatchEntireLine() && settings.isMatchInvert()) {
            return !line.equals(pattern);
        } else if (settings.isMatchEntireLine()) {
            return line.equals(pattern);
        } else if (settings.isMatchInvert()) {
            return !line.contains(pattern);
        } else {
            return line.contains(pattern);
        }
    }

    private String applyFormat(String line, int index, String fileName, Settings settings) {
        if (settings.isOutputFilenameOnly()) {
            return fileName;
        }
        if (settings.isPrependLineNumber()) {
            line = index + ":" + line;
        }

        if (settings.isMultipleFiles()) {
            return fileName + ":" + line;
        } else {
            return line;
        }
    }


}