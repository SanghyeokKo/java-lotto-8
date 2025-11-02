package lotto.service;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoGenerator {
    public static List<Integer> getRandomLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
