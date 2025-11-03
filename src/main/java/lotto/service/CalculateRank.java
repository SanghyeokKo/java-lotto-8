package lotto.service;

import lotto.domain.Rank;

public class CalculateRank {
    private int matchCount;
    private boolean containBonusNum;
    public CalculateRank(int matchCount, boolean containBonusNum){
        this.matchCount = matchCount;
        this.containBonusNum = containBonusNum;
    }
    public Rank calculateRank(){
        if(matchCount == 6)
            return Rank.FIRST;
        if(matchCount == 5 && containBonusNum)
            return Rank.SECOND;
        if(matchCount == 5)
            return Rank.THIRD;
        if(matchCount == 4)
            return Rank.FOURTH;
        if(matchCount == 3)
            return Rank.FIFTH;
        return Rank.NO_PRIZE;
    }
}
