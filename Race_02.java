import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>names= Arrays.stream(scanner.nextLine().split(", "))
        .collect(Collectors.toList());
        Map<String,Integer>racersDistance=new LinkedHashMap<>();
        String regexName="[A-Za-z]+";
        Pattern patternName= Pattern.compile(regexName);

        String regexKm="[0-9]";
        Pattern patternKm= Pattern.compile(regexKm);
        names.forEach(name->racersDistance.put(name,0));
        String command=scanner.nextLine();
        while (!command.equals("end of race")){
            Matcher matcherName=patternName.matcher(command);
            StringBuilder builder= new StringBuilder();
            int distance=0;
            while (matcherName.find()){
                builder.append(matcherName.group());
            }
          String name = builder.toString();
            Matcher matcherKm=patternKm.matcher(command);
            while (matcherKm.find()){
                distance+=Integer.parseInt(matcherKm.group());
            }
            if (racersDistance.containsKey(name)){
                racersDistance.put(name.toString(), (racersDistance.get(name)+distance));
            }

            command=scanner.nextLine();
        }
            List<String>firstThree=  racersDistance.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());


        System.out.println("1st place: " + firstThree.get(0) );
        System.out.println("2nd place: " + firstThree.get(1) );
        System.out.println("3rd place: " + firstThree.get(2) );


    }
}
