package org.houseofsoft.katas;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
 * Given an arbitrary set of coin denominations, calculate the number of different ways to change an amount of money.
 * 
 * For example: 15 cents could be changed with {25, 10, 5, 1} coins in 6 ways
 */
public class CoinChange {
    private List<Integer> coins;

    public CoinChange(Set<Integer> coins) {
        this.coins.addAll(coins);
    }

    public CoinChange(Integer... values) {
        this.coins = Arrays.asList(values);
    }

    public long waysToChange(int amount) {
        return waysToChange(amount, coins);
    }

    public long waysToChange(int amount, List<Integer> coins) {
        if (amount <= 0 || coins.size() == 0) {
            return 0;
        }
        Integer theCoin = coins.get(0);
        List<Integer> otherCoins = coins.subList(1, coins.size());

        return waysToChange(amount, otherCoins) + // Without the coin
                (amount == theCoin ? 1 : waysToChange(amount - theCoin, coins)); // With the coin
    }
}
