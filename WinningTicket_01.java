import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningTicket_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tickets = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String regexTicket = "\\${6,10}|@{6,10}|#{6,10}|\\^{6,10}";
        Pattern pattern = Pattern.compile(regexTicket);
        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String leftside = ticket.substring(0, 10);
                String rightside = ticket.substring(10);
                Matcher leftMatcher = pattern.matcher(leftside);
                Matcher rightMatcher = pattern.matcher(rightside);
                String left = "";
                String right = "";
                if (!leftMatcher.find() || !rightMatcher.find())
                    System.out.printf("ticket \"%s\" - no match\n", ticket);
                else {
                    left += leftMatcher.group();
                    right += rightMatcher.group();
                    if (left.equals(right)) {
                        if (left.length() < 10) {
                            System.out.printf("ticket \"%s\" - %d%c%n", ticket, left.length(), left.charAt(0));
                        } else
                            System.out.printf("ticket \"%s\" - %d%c Jackpot!\n", ticket, left.length(), left.charAt(0));
                    }
                }
            }
        }
    }
}