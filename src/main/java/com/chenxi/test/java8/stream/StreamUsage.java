package com.chenxi.test.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

/**
 * 流测试
 * Date: 2017-11-04
 *
 * @author chenxi
 */
public class StreamUsage {
    final static Trader raoul = new Trader("Raoul", "Cambridge");
    final static Trader mario = new Trader("Mario", "Milan");
    final static Trader alan = new Trader("Alan", "Cambridge");
    final static Trader brian = new Trader("Brian", "Cambridge");

    final static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    private static <T> void print(T t) {
        System.out.println(JSON.toJSONString(t));
    }

    public static void main(String[] args) {
        //1. 找出2011年的交易，并按交易额从低到高排序
        List<Transaction> transactionList = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        print(transactionList);

        //2. 交易员都在哪些城市工作过
        Set<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        print(cities);

        //3. 查找所有来自剑桥的交易员，并按姓名排序
        List<Trader> traderList = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        print(traderList);

        //4. 返回所有交易员的姓名字符串，按字母顺序排序
        String nameWords = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (w1, w2) -> w1 + w2);
        System.out.println(nameWords);

        //5. 有没有交易员是在米兰工作的
        boolean inMilan = transactions.stream().anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        System.out.println(inMilan);

        //6. 打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //7. 所有交易中，最高的交易额是多少
        Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(highestValue);

        //8. 找出交易额最小的交易
        Optional<Transaction> lowestValueTransaction = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        print(lowestValueTransaction);
    }
}
