package lotto.service;

import java.util.Comparator;
import java.util.List;

public class LottoSort {
    private List<Integer> Numbers;
    public LottoSort(List<Integer> Numbers){
        this.Numbers = Numbers;
    }
    public List<Integer> Sorter(){
        Numbers.sort(Comparator.naturalOrder());
        return Numbers;
    }
}
