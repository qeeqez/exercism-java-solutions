public class LogLine {

    private final LogLevel logLevel;
    private final String logMessage;

    public LogLine(String logLine) {
        String logLevelStr = logLine.substring(1, 4);
        this.logMessage = logLine.substring(7);

        this.logLevel = switch (logLevelStr) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getOutputForShortLog() {
        return logLevel.getNumericValue() + ":" + logMessage;
    }
}
