package lotto.service;

import java.util.List;

//로또 번호 일치 여부 검증
public class LottoNumberVerification {
    private List<Integer> Numbers;
    private List<Integer> LottoNumbers;
    private int BonusNum;
    public LottoNumberVerification(List<Integer> Numbers, List<Integer> LottoNumbers, int BonusNum){
        this.Numbers = Numbers;
        this.LottoNumbers = LottoNumbers;
        this.BonusNum = BonusNum;
    }
    public int Counter(){
        int matchCount = (int)Numbers.stream().filter(num -> LottoNumbers.contains(num)).count();
        return matchCount;
    }
    public boolean containBonusNum(){
        return this.Numbers.contains(BonusNum);
    }
}
