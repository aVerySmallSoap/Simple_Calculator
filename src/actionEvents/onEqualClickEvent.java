package actionEvents;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class onEqualClickEvent {
    static ArrayList<Float> numbers = new ArrayList<>();
    static ArrayList<String> operations = new ArrayList<>();

    public String  compileStatement(String s){
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(-\\d+\\.\\d+|-\\d+|\\d+\\.\\d+|\\d+|)([^.])");
        Matcher match = pattern.matcher(sb.append(s).append(" "));

        while (match.find()){
            numbers.add(Float.parseFloat(match.group(1)));
            operations.add(match.group(2));
        }
        return String.valueOf(getAnswer());
    }

    private float getAnswer(){
        float result = numbers.get(0);
        int count = 0;
        while (count < numbers.size()-1){
            for (int i = 1; i < numbers.size(); i++) {
                for (int j = 0; j < operations.size(); j++) {
                    if(!operations.get(j).equals("null")){
                        result = cases(result, numbers.get(i), operations.get(j));
                        operations.set(j, "null");
                        count++;
                        break;
                    }
                }
            }
        }
        numbers.clear();
        operations.clear();
        return result;
    }

    private float cases(float a, float b, String op){
        float temp = 0;
        switch(op){
            case "+" -> temp = a + b;
            case "-" -> temp = a - b;
            case "*" -> temp = a*b;
            case "/" -> temp = a/b;
        }
        return temp;
    }
}
