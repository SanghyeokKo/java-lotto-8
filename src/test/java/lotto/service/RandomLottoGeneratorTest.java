package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class RandomLottoGeneratorTest {
    @DisplayName("로또 번호 생성기는 6개의 숫자를 반환해야 한다.")
    @Test
    void getRandomLotto의_6개의_숫자를_반환() {
        // when
        List<Integer> lottoNumbers = RandomLottoGenerator.getRandomLotto();
        // then
        assertThat(lottoNumbers).hasSize(6);
    }

    @DisplayName("로또 번호는 중복되지 않아야 한다.")
    @Test
    void getRandomLotto의_번호가_중복되지않음() {
        // when
        List<Integer> lottoNumbers = RandomLottoGenerator.getRandomLotto();
        // then
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @DisplayName("로또 번호는 1과 45 사이의 값이어야 한다.")
    @Test
    void getRandomLotto의_번호가_1과_45사이의_값() {
        // when
        List<Integer> lottoNumbers = RandomLottoGenerator.getRandomLotto();
        // then
        assertThat(lottoNumbers).allSatisfy(number -> {
            assertThat(number).isBetween(1, 45);
        });
    }
    @DisplayName("로또 번호 생성 결과가 모든 규칙(6개, 중복X, 1-45 범위)을 만족하는지 검증")
    @Test
    void getRandomLotto의_번호가_모든_규칙을_만족하는가() {
        // given & when
        List<Integer> lottoNumbers = RandomLottoGenerator.getRandomLotto();
        // then
        assertThat(lottoNumbers)
                .isNotNull()           // 1. null이 아님
                .hasSize(6)            // 2. 크기가 6
                .doesNotHaveDuplicates() // 3. 중복이 없음
                .allSatisfy(number -> {
                    assertThat(number).isGreaterThanOrEqualTo(1) // 4. 모든 요소가 1 이상
                            .isLessThanOrEqualTo(45);  // 5. 모든 요소가 45 이하
                });
    }
}