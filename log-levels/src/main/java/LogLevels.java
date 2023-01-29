public class LogLevels {

    public static final String LOG_LEVEL_INFO = "INFO";
    public static final String LOG_LEVEL_WARNING = "WARNING";
    public static final String LOG_LEVEL_ERROR = "ERROR";


    public static String message(String logLine) {
        logLine = removeLogLevelFromMessage(logLine, LOG_LEVEL_INFO);
        logLine = removeLogLevelFromMessage(logLine, LOG_LEVEL_WARNING);
        logLine = removeLogLevelFromMessage(logLine, LOG_LEVEL_ERROR);

        return logLine.trim();
    }

    // remove "[LOG_LEVEL]:" from string
    public static String removeLogLevelFromMessage(String message, String logLevel) {
        if (message.contains(logLevel)) {
            return message.substring(logLevel.length() + 3);
        }
        return message;
    }

    public static String logLevel(String logLine) {
        return logLine.substring(1, logLine.indexOf("]")).toLowerCase();
    }

    public static String reformat(String logLine) {
        int indexOfClosingBracket = logLine.indexOf("]");
        String logLevel = logLine.substring(1, indexOfClosingBracket).toLowerCase();
        String message = logLine.substring(indexOfClosingBracket + 2).trim();

        return message + " (" + logLevel + ")";
    }
}
