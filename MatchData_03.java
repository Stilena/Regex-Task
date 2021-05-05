import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchData_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String regex="\\b(?<data>\\d{2})([\\-\\.\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>[0-9]{4})\\b";
        Pattern pattern=Pattern.compile(regex);
        String input=scanner.nextLine();
        Matcher matcher=pattern.matcher(input);
        while (matcher.find()){
            String data=matcher.group("data");
            String month=matcher.group("month");
            String year=matcher.group("year");
            System.out.printf("Day: %s, Month: %s, Year: %s%n",data,month,year);
        }
    }
}
