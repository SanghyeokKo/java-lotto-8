package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void printPurchaseLottoCount(int count){
        System.out.println(count+ "개를 구매했습니다.");
    }
    public static void issuedLotto(List<Lotto> lottos){
        for(Lotto lotto:lottos){
            String lottoNumbers = lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(",","[","]"));
            System.out.println(lottoNumbers);
        }
    }
    public static void printStatistics(Map<Rank, Integer> statistics){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%,d원) - %d개\n",Rank.FIFTH.getPrizeMoney(), statistics.getOrDefault(Rank.FIFTH,0));
        System.out.printf("4개 일치 (%,d원) - %d개\n",Rank.FOURTH.getPrizeMoney(), statistics.getOrDefault(Rank.FOURTH,0));
        System.out.printf("5개 일치 (%,d원) - %d개\n",Rank.THIRD.getPrizeMoney(), statistics.getOrDefault(Rank.THIRD,0));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n",Rank.SECOND.getPrizeMoney(), statistics.getOrDefault(Rank.SECOND,0));
        System.out.printf("6개 일치 (%,d원) - %d개\n",Rank.FIRST.getPrizeMoney(), statistics.getOrDefault(Rank.FIRST,0));
    }
    public static void printRateofReturn(long total, int purchaseAmount){
        double rate = (double)total / purchaseAmount * 100;
        DecimalFormat df = new DecimalFormat("#,##0.0");
        System.out.println("총 수익률은 " + df.format(rate) + "%입니다.");
    }
    public void printError(String message){
        System.out.println(message);
    }
}
