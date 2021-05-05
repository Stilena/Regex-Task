import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SoftUniBarIncome_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String regex= "%(?<name>[A-Z][a-z]*)%[^$%|.]*<(?<product>[A-Z][a-z]*)>[^$%|.]*\\|(?<count>[0-9])[^$%|.]*\\|(?<price>[0-9]+.?[0-9]+)\\$";
        Pattern pattern=Pattern.compile(regex);
        double totalSum=0;
        String command=scanner.nextLine();
        while (!command.equals("end of shift")){
            Matcher matcher=pattern.matcher(command);
                if (matcher.find()){
                    String name=matcher.group("name");
                    String product=matcher.group("product");
                    int count=Integer.parseInt(matcher.group("count"));
                    double price=Double.parseDouble(matcher.group("price"));
                    totalSum+=count*price;
                    System.out.printf("%s: %s - %.2f%n",name,product,price*count);
                }
            command=scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",totalSum);

    }
}
/*Pattern pattern = Pattern.compile("%(?<customer>[A-Z][a-z]+)%[^$%|.]*<(?<product>\\w+)>[^$%|.]*\\|(?<quantity>\\d+)\\|[^$%|.]*?(?<price>\\d+\\.?\\d+)\\$");
        String input = scanner.nextLine();
        double sum = 0;
        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                double totalPrice = Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
                System.out.printf("%s: %s - %.2f%n", matcher.group("customer"), matcher.group("product"), totalPrice);
                sum += totalPrice;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", sum);
    }*/