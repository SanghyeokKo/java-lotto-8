package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public static int parseAmount(String input){
        try {
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }
    public static List<Integer> parseLotto(String input){
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)//공백 제거
                    .map(Integer::parseInt)//정수로 전환
                    .collect(Collectors.toList());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 1,2,3,4,5,6과 같은 형식으로 입력해야 합니다.");
        }
    }
    public static int parseBonusNum(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }
}
