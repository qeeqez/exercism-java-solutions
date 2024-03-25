import java.util.List;

class Settings {
    private boolean prependLineNumber = false;
    private boolean outputFilenameOnly = false;
    private boolean matchCaseInsensitive = false;
    private boolean matchInvert = false;
    private boolean matchEntireLine = false;
    private boolean multipleFiles = false;

    Settings(List<String> flags, List<String> files) {
        flags.forEach(flag -> {
            switch (flag) {
                case "-n": {
                    prependLineNumber = true;
                    break;
                }
                case "-l": {
                    outputFilenameOnly = true;
                    break;
                }
                case "-i": {
                    matchCaseInsensitive = true;
                    break;
                }
                case "-v": {
                    matchInvert = true;
                    break;
                }
                case "-x": {
                    matchEntireLine = true;
                    break;
                }
            }
        });

        multipleFiles = files.size() > 1;
    }

    public boolean isPrependLineNumber() {
        return prependLineNumber;
    }

    public boolean isOutputFilenameOnly() {
        return outputFilenameOnly;
    }

    public boolean isMatchCaseInsensitive() {
        return matchCaseInsensitive;
    }

    public boolean isMatchInvert() {
        return matchInvert;
    }

    public boolean isMatchEntireLine() {
        return matchEntireLine;
    }

    public boolean isMultipleFiles() {
        return multipleFiles;
    }
}
