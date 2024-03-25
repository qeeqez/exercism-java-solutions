import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        StringBuilder output = new StringBuilder();

        Settings settings = new Settings(flags);

        files.forEach(fileName -> {
            output.append(grepFile(pattern, settings, fileName));
        });

        // remove last new line
        if(!output.isEmpty()) {
            output.setLength(output.length() - 1);
        }

        return output.toString();
    }

    private String grepFile(String pattern, Settings settings, String fileName) {
        StringBuilder output = new StringBuilder();

        try {
            FileInputStream fs = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));

            String line;
            int index = 1;
            while ((line = br.readLine()) != null) {
                if (isCorrectLine(line, pattern, settings)) {
                    line = applyFormat(line, index, fileName, settings);
                    output.append(line).append("\n");
                }
                index++;
            }

            fs.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return output.toString();
    }

    private boolean isCorrectLine(String line, String pattern, Settings settings) {
        if (settings.isMatchCaseInsensitive()) {
            line = line.toLowerCase();
            pattern = pattern.toLowerCase();
        }
        if (settings.isMatchInvert()) {
            pattern = new StringBuilder(pattern).reverse().toString();
        }

        if (settings.isMatchEntireLine()) {
            return line.equals(pattern);
        } else {
            return line.contains(pattern);
        }
    }

    private String applyFormat(String line, int index, String fileName, Settings settings) {
        if (settings.isOutputFilenameOnly()) {
            return fileName;
        }
        if (settings.isPrependLineNumber()) {
            return index + ":" + line;
        }
        return line;
    }


}