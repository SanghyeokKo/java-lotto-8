package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RankCountTest {
    @DisplayName("모든 등수의 로또를 하나씩 발급해 1씩 카운트 되는지 확인")
    @Test
    void 모든_등수_카운트_1() {
        //Given
        List<Integer> winNumbers = List.of(1,2,3,4,5,6);
        int bonusNum = 7;
        List<Lotto> myLottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),//1등
                new Lotto(List.of(1,2,3,4,5,7)),//2등
                new Lotto(List.of(1,2,3,4,5,8)),//3등
                new Lotto(List.of(1,2,3,4,8,9)),//4등
                new Lotto(List.of(1,2,3,8,9,10)),//5등
                new Lotto(List.of(1,2,8,9,10,11))//No_PRIZE
        );
        RankCount rankCount = new RankCount();
        //When
        Map<Rank, Integer> count = rankCount.countRank(myLottos,winNumbers,bonusNum);
        //Then
        assertThat(count).hasSize(6);
        assertThat(count.getOrDefault(Rank.FIRST,0)).isEqualTo(1);
        assertThat(count.getOrDefault(Rank.SECOND,0)).isEqualTo(1);
        assertThat(count.getOrDefault(Rank.THIRD,0)).isEqualTo(1);
        assertThat(count.getOrDefault(Rank.FOURTH,0)).isEqualTo(1);
        assertThat(count.getOrDefault(Rank.FIFTH,0)).isEqualTo(1);
        assertThat(count.getOrDefault(Rank.NO_PRIZE,0)).isEqualTo(1);
    }
}
