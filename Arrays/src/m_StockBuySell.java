public class m_StockBuySell {
    /*
    Naive app: buy every single day and sell every single day to check max
    TC: O(n^2), AS: O(1)

    Eff app: check where the stock is going up and add all that into profit
    when going down dont add
    this way we can get only profit by selling at the point where it starts going down
    TC: O(n), AS: O(1)
     */
    static int maxProfit(int price[], int n)
    {
        int profit = 0;
        for(int i = 1; i < n; i++)
        {
            if(price[i] > price[i - 1])
                profit += price[i] - price[i -1];
        }
        return profit;
    }

    public static void main(String args[])
    {
        int arr[] = {1, 5, 3, 8, 12}, n = 5;
        System.out.println(maxProfit(arr, n));

    }
}
