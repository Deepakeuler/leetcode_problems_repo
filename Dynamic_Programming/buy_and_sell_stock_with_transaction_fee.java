class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int obsp = -prices[0];
        int ossp = 0;
        for(int i = 1; i<n; i++){
            int nbsp = 0;
            int nssp = 0;
            if(ossp - prices[i] > obsp){
                nbsp = ossp - prices[i];
            }else{
                nbsp = obsp;
            }
            if(ossp < (prices[i] + obsp -fee)){
                nssp = prices[i]+obsp-fee;
            }else{
                nssp = ossp;
            }
            ossp = nssp;
            obsp = nbsp;
        }
        return ossp;
    }
}