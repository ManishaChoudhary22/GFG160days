package Array;
public class buyAndSells{
    static int maxProfit(int[] prices) {
        int res = 0;
                                    // using accumalating profit 
        // Keep on adding the difference between
        // adjacent when the prices a
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) 
                res += prices[i] - prices[i - 1];
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] prices = { 100, 180, 260, 310, 40, 535, 695 };
        System.out.println(maxProfit(prices));
    }
}