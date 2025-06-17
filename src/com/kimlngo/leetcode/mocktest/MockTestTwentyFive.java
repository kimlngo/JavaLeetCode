package com.kimlngo.leetcode.mocktest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTestTwentyFive {
    public static void main(String[] args) {
        var solution = new MockTestTwentyFive();

        // ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
        System.out.println(
                Arrays.toString(
                        solution.reorderLogFiles(
                                new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"}
                        )));

        //"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
        System.out.println(
                Arrays.toString(
                        solution.reorderLogFiles(
                                new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"}
                        )));
    }

    public String[] reorderLogFiles(String[] logs) {

        //1) convert String[] to List<LogEntry>
        List<LogEntry> logEntries = Arrays.stream(logs)
                                          .map(LogEntry::new)
                                          .toList();

        //2) filter to get all DIGIT logs
        List<LogEntry> digitLogs = logEntries.stream()
                                             .filter(log -> LogType.DIGIT.equals(log.getLogType()))
                                             .toList();

        //3) Filter to get LETTER logs and also sort the result
        List<LogEntry> sortedLetterLogs = logEntries.stream()
                                                    .filter(log -> LogType.LETTER.equals(log.getLogType()))
                                                    .sorted(this::compare)
                                                    .toList();

        //4) Merge two lists into one by ordering Letter first then Digit
        List<LogEntry> result = new ArrayList<>();
        result.addAll(sortedLetterLogs);
        result.addAll(digitLogs);

        //5) Return String[] result
        return result.stream()
                     .map(LogEntry::toString)
                     .toArray(String[]::new);

    }

    private int compare(LogEntry e1, LogEntry e2) {
        if (!e1.getContent()
               .equals(e2.getContent()))
            return e1.getContent()
                     .compareToIgnoreCase(e2.getContent());
        else
            return e1.getIdentifier()
                     .compareToIgnoreCase(e2.getIdentifier());
    }
}

class LogEntry {
    private LogType logType;
    private String identifier;
    private String content;

    public LogEntry(String log) {
        int firstSpaceIdx = log.indexOf(" ");
        this.identifier = log.substring(0, firstSpaceIdx);
        this.content = log.substring(firstSpaceIdx + 1);
        this.logType = getLogType(this.content);
    }

    private LogType getLogType(String content) {
        char firstChar = content.charAt(0);
        if (firstChar >= '0' && firstChar <= '9')
            return LogType.DIGIT;
        else
            return LogType.LETTER;
    }

    public LogType getLogType() {
        return this.logType;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getContent() {
        return this.content;
    }

    public String toString() {
        return String.format("%s %s", this.identifier, this.content);
    }
}

enum LogType {
    LETTER, DIGIT;
}