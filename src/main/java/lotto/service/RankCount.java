package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankCount {
    public Map<Rank, Integer> countRank(List<Lotto> myLotto, List<Integer> winNumbers, int bonusNum) {
        Map<Rank, Integer> countRank = new EnumMap<>(Rank.class);
        //발급한 모드 로또를 EnumMap에 저장(키:Rank,값:카운트값)
        for (Lotto lotto : myLotto) {
            LottoNumberVerification verification = new LottoNumberVerification(lotto.getNumbers(), winNumbers, bonusNum);
            int matchCount = verification.Counter();
            boolean cotainBonusNum = verification.containBonusNum();
            CalculateRank calculateRank = new CalculateRank(matchCount, cotainBonusNum);
            Rank rank = calculateRank.calculateRank();
            countRank.put(rank, countRank.getOrDefault(rank,0)+1);
        }
        return countRank;
    }
}
