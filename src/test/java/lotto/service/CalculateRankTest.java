package lotto.service;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateRankTest {
    @DisplayName("6개 일치 시, 보너스 볼 여부와 관계없이 1등 반환")
    @Test
    void 로또_1등() {
        //Given
        int matchCount = 6;
        // when
        CalculateRank rank1 = new CalculateRank(matchCount, true);
        CalculateRank rank2 = new CalculateRank(matchCount, true);
        // then
        assertThat(rank1.calculateRank()).isSameAs(Rank.FIRST);
        assertThat(rank2.calculateRank()).isSameAs(Rank.FIRST);
    }
    @DisplayName("5개 일치 + 보너스 볼 일치 시, 2등 반환")
    @Test
    void 로또_2등() {
        //Given
        int matchCount = 5;
        boolean containBonusNum = true;
        // when
        CalculateRank rank = new CalculateRank(matchCount, containBonusNum);
        // then
        assertThat(rank.calculateRank()).isSameAs(Rank.SECOND);
    }

    @DisplayName("5개 일치 + 보너스 볼 불일치 시, 3등 반환")
    @Test
    void 로또_3등() {
        //Given
        int matchCount = 5;
        boolean containBonusNum = false;
        // when
        CalculateRank rank = new CalculateRank(matchCount, containBonusNum);
        // then
        assertThat(rank.calculateRank()).isSameAs(Rank.THIRD);
    }
    @DisplayName("4개 일치 시, 보너스 볼 여부와 관계없이 4등 반환")
    @Test
    void 로또_4등() {
        //Given
        int matchCount = 4;
        // when
        CalculateRank rank1 = new CalculateRank(matchCount, true);
        CalculateRank rank2 = new CalculateRank(matchCount, false);

        // then
        assertThat(rank1.calculateRank()).isSameAs(Rank.FOURTH);
        assertThat(rank2.calculateRank()).isSameAs(Rank.FOURTH);
    }

    @DisplayName("3개 일치 시, 보너스 볼 여부와 관계없이 5등 반환")
    @Test
    void 로또_5등() {
        //Given
        int matchCount = 3;
        // when
        CalculateRank rank1 = new CalculateRank(matchCount, true);
        CalculateRank rank2 = new CalculateRank(matchCount, false);

        // then
        assertThat(rank1.calculateRank()).isSameAs(Rank.FIFTH);
        assertThat(rank2.calculateRank()).isSameAs(Rank.FIFTH);
    }
    @DisplayName("2개 이하 일치 시, 보너스 볼 여부와 관계없이 NO_PRIZE 반환")
    @Test
    void 로또_꽝() {
        //Given
        int matchCount2 = 2;
        int matchCount1 = 1;
        int matchCount0 = 0;
        // when
        CalculateRank rank1 = new CalculateRank(matchCount2, true);
        CalculateRank rank2 = new CalculateRank(matchCount1, true);
        CalculateRank rank3 = new CalculateRank(matchCount0, false);
        // then
        assertThat(rank1.calculateRank()).isSameAs(Rank.NO_PRIZE);
        assertThat(rank2.calculateRank()).isSameAs(Rank.NO_PRIZE);
        assertThat(rank3.calculateRank()).isSameAs(Rank.NO_PRIZE);
    }
}
