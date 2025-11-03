package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class LottoNumberVerificationTest {
    @DisplayName("로또 번호 6개 일치")
    @Test
    void matchCount_6개_반환() {
        //Given
        List<Integer> ListA = List.of(1,2,3,4,5,6);
        List<Integer> ListB = List.of(1,2,3,4,5,6);
        int BonusNum = 45;
        // when
        LottoNumberVerification LottoNumberVerification = new LottoNumberVerification(ListA, ListB, BonusNum);
        // then
        assertThat(LottoNumberVerification.Counter()).isEqualTo(6);
    }
    @DisplayName("로또 번호 5개 일치")
    @Test
    void matchCount_5개_반환() {
        //Given
        List<Integer> ListA = List.of(1,2,3,4,5,6);
        List<Integer> ListB = List.of(1,2,3,4,5,7);
        int BonusNum = 45;
        // when
        LottoNumberVerification LottoNumberVerification = new LottoNumberVerification(ListA, ListB, BonusNum);
        // then
        assertThat(LottoNumberVerification.Counter()).isEqualTo(5);
    }
    @DisplayName("로또 번호 4개 일치")
    @Test
    void matchCount_4개_반환() {
        //Given
        List<Integer> ListA = List.of(1,2,3,4,5,6);
        List<Integer> ListB = List.of(1,2,3,4,7,8);
        int BonusNum = 45;
        // when
        LottoNumberVerification LottoNumberVerification = new LottoNumberVerification(ListA, ListB, BonusNum);
        // then
        assertThat(LottoNumberVerification.Counter()).isEqualTo(4);
    }
    @DisplayName("로또 번호 3개 일치")
    @Test
    void matchCount_3개_반환() {
        //Given
        List<Integer> ListA = List.of(1,2,3,4,5,6);
        List<Integer> ListB = List.of(1,2,3,7,8,9);
        int BonusNum = 45;
        // when
        LottoNumberVerification LottoNumberVerification = new LottoNumberVerification(ListA, ListB,BonusNum);
        // then
        assertThat(LottoNumberVerification.Counter()).isEqualTo(3);
    }
    @DisplayName("로또 번호 2개 일치")
    @Test
    void matchCount_2개_반환() {
        //Given
        List<Integer> ListA = List.of(1,2,3,4,5,6);
        List<Integer> ListB = List.of(1,2,7,8,9,10);
        int BonusNum = 45;
        // when
        LottoNumberVerification LottoNumberVerification = new LottoNumberVerification(ListA, ListB, BonusNum);
        // then
        assertThat(LottoNumberVerification.Counter()).isEqualTo(2);
    }
    @DisplayName("로또 번호 1개 일치")
    @Test
    void matchCount_1개_반환() {
        //Given
        List<Integer> ListA = List.of(1,2,3,4,5,6);
        List<Integer> ListB = List.of(1,7,8,9,10,11);
        int BonusNum = 45;
        // when
        LottoNumberVerification LottoNumberVerification = new LottoNumberVerification(ListA, ListB, BonusNum);
        // then
        assertThat(LottoNumberVerification.Counter()).isEqualTo(1);
    }
    @DisplayName("로또 번호 0개 일치")
    @Test
    void matchCount_0개_반환() {
        //Given
        List<Integer> ListA = List.of(1,2,3,4,5,6);
        List<Integer> ListB = List.of(7,8,9,10,11,12);
        int BonusNum = 45;
        // when
        LottoNumberVerification LottoNumberVerification = new LottoNumberVerification(ListA, ListB, BonusNum);
        // then
        assertThat(LottoNumberVerification.Counter()).isEqualTo(0);
    }
    @DisplayName("보너스 번호 일치")
    @Test
    void 보너스_번호_일치_True() {
        //Given
        List<Integer> ListA = List.of(1,2,3,4,5,45);
        List<Integer> ListB = List.of(7,8,9,10,11,12);
        int BonusNum = 45;
        // when
        LottoNumberVerification LottoNumberVerification = new LottoNumberVerification(ListA, ListB, BonusNum);
        // then
        assertThat(LottoNumberVerification.containBonusNum()).isTrue();
    }
    @DisplayName("보너스 번호 불일치")
    @Test
    void 보너스_번호_불일치_False() {
        //Given
        List<Integer> ListA = List.of(1,2,3,4,5,44);
        List<Integer> ListB = List.of(7,8,9,10,11,12);
        int BonusNum = 45;
        // when
        LottoNumberVerification LottoNumberVerification = new LottoNumberVerification(ListA, ListB, BonusNum);
        // then
        assertThat(LottoNumberVerification.containBonusNum()).isFalse();
    }
}