package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoSort;
import lotto.service.RandomLottoGenerator;
import lotto.service.RankCount;
import lotto.view.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private RankCount rankCount;
    public LottoController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.rankCount = new RankCount();
    }
    public List<Lotto> issuedLotto(int purchaseAmount){
        if(purchaseAmount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야합니다.");
        int lottoCount = purchaseAmount/1000;
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < lottoCount ; i++){
            List<Integer> newLottoNumbers = RandomLottoGenerator.getRandomLotto();
            new LottoSort(newLottoNumbers).Sorter();
            Lotto lotto = new Lotto(newLottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }
    public void calculateResult(List<Lotto> mylottos, List<Integer> winningLotto, int bonusNum, int purchaseAmount){
        Map<Rank, Integer> statistics = rankCount.countRank(mylottos,winningLotto,bonusNum);
        outputView.printStatistics(statistics);
        long totalPrize = calculateTotalPrize(statistics);
        outputView.printRateofReturn(totalPrize,purchaseAmount);
    }
    private long calculateTotalPrize(Map<Rank, Integer> statistics){
        long totalPrize = 0;
        for(Map.Entry<Rank, Integer> entry: statistics.entrySet()){
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += (long)rank.getPrizeMoney()*count;
        }
        return totalPrize;
    }
    public void printMyLottos(List<Lotto> lotto){
        outputView.printPurchaseLottoCount(lotto.size());
        outputView.issuedLotto(lotto);
    }

    public void run(){
        try {
            int purchaseAmount = InputParser.parseAmount(inputView.getPurchaseAmount());
            List<Lotto> myLotto = issuedLotto(purchaseAmount);

            printMyLottos(myLotto);

            List<Integer> winningNumbers = InputParser.parseLotto(inputView.getWinningNumbers());
            int bonusNum = InputParser.parseBonusNum(inputView.getBonusNum());

            calculateResult(myLotto, winningNumbers, bonusNum, purchaseAmount);
        }catch(IllegalArgumentException e){
            outputView.printError(e.getMessage());
        }
    }
}
