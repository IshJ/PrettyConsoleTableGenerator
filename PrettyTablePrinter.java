import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrettyTablePrinter {
    static List<String> printPrettyTable(List<String> headers, List<String> rows, String columnSeparator) {
        List<String> prettyLines = new ArrayList<>();
        if (!validateInputs(headers, rows, columnSeparator)) {
            System.out.println("\nFound errors in validating! Stopping the program ..");
            return prettyLines;
        }

        List<Integer> longestWordLengths = IntStream.range(0, headers.size())
                .mapToObj(i -> Integer.max(headers.get(i).length(), rows.stream().mapToInt(r -> r.split(columnSeparator)[i].length()).max().getAsInt()))
                .collect(Collectors.toList());

        StringBuilder headerBuilder = new StringBuilder().append("|");
        StringBuilder rowFormatBuilder = new StringBuilder().append("|");
        StringBuilder borderBuilder = new StringBuilder().append("+");

        for (int i = 0; i < longestWordLengths.size(); i++) {
            borderBuilder.append(String.format(" %" + (longestWordLengths.get(i) + 2) + "d+", 8).replace(" ", "-").replace("8", ""));
            headerBuilder.append(String.format(" " + headers.get(i) + "%" + (longestWordLengths.get(i) + 2 - headers.get(i).length()) + "d|", 8).replace("8", ""));
            rowFormatBuilder.append(" %-").append(longestWordLengths.get(i)).append("s |");
        }

        System.out.println(borderBuilder);
        System.out.println(headerBuilder);
        System.out.println(borderBuilder);
        prettyLines.add(borderBuilder.toString());
        prettyLines.add(headerBuilder.toString());
        prettyLines.add(borderBuilder.toString());
        for (int i = 0; i < rows.size(); i++) {
            String prettyLine = String.format(rowFormatBuilder.toString(), rows.get(i).split(columnSeparator));
            System.out.println(prettyLine);
            prettyLines.add(prettyLine);
        }
        System.out.println(borderBuilder);
        prettyLines.add(borderBuilder.toString());
        return prettyLines;
    }

    private static boolean validateInputs(List<String> headers, List<String> rows, String columnSeparator) {
        if (headers.isEmpty()) {
            System.out.println("empty headers!");
        }
        int columnCount = headers.size();
        boolean isRightRowFormat = rows.stream().noneMatch(r->r.split(columnSeparator).length!=columnCount);
        if(!isRightRowFormat){
            System.out.println("Rows with incorrect format were found; either the seperator is wrong or have unequal # of columns compared to header count");
            rows.stream().filter(r->r.split(columnSeparator).length!=columnCount).forEach(System.out::println);
            return false;
        }
        return true;

    }



    public static void main(String[] args) throws IOException {
        List<String> headers = Arrays.asList("Column name", "ID", "Name");
        List<String> rows = Arrays.asList("c11#c12#13", "ccc21#ccc22#ccc23", "ccccc31#ccccc32#ccccc33");
        List<String> lines=printPrettyTable(headers, rows, "#");
    }
}
