package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class LottoSortTest {
    @DisplayName("로또 번호 리스트를 오름차순으로 정렬해야 한다.")
    @Test
    void 로또_번호_오름차순_정렬() {
        // Given
        List<Integer> unsortedNumbers = new ArrayList<>(Arrays.asList(6, 1, 45, 22, 15, 3));
        LottoSort lottoSort = new LottoSort(unsortedNumbers);
        // When
        List<Integer> sortedNumbers = lottoSort.Sorter();
        // Then
        assertThat(sortedNumbers).containsExactly(1, 3, 6, 15, 22, 45);
    }
    @DisplayName("이미 정렬된 리스트는 그대로 정렬된 상태를 유지해야 한다.")
    @Test
    void 정렬된_로또_번호_그대로_반환() {
        // Given
        List<Integer> alreadySortedNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoSort lottoSort = new LottoSort(alreadySortedNumbers);
        // When
        List<Integer> sortedNumbers = lottoSort.Sorter();
        // Then
        assertThat(sortedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
    @DisplayName("빈 리스트를 정렬하면 빈 리스트를 반환해야 한다.")
    @Test
    void 빈_리스트는_빈_리스트로_반환() {
        // Given
        List<Integer> emptyList = new ArrayList<>(); // 빈 ArrayList
        LottoSort lottoSort = new LottoSort(emptyList);
        // When
        List<Integer> sortedNumbers = lottoSort.Sorter();
        // Then
        assertThat(sortedNumbers).isEmpty(); // .isEmpty()로 검증
    }
}