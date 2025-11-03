package lotto.service;

import java.util.List;

//로또 번호 일치 여부 검증
public class LottoNumberVerification {
    private List<Integer> Numbers;
    private List<Integer> LottoNumbers;
    public LottoNumberVerification(List<Integer> Numbers, List<Integer> LottoNumbers){
        this.Numbers = Numbers;
        this.LottoNumbers = LottoNumbers;
    }
    public int Verfication(){
        int matchCount = (int)Numbers.stream().filter(num -> LottoNumbers.contains(num)).count();
        return matchCount;
    }

}
