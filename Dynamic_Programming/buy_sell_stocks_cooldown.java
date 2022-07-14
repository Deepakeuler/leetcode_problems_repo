class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;
        for(int i = 1; i<n; i++){
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            if(ocsp - prices[i] > obsp){
                nbsp = ocsp - prices[i];
            }else{
                nbsp = obsp;
            }if(ossp < obsp + prices[i]){
                nssp = obsp + prices[i];
            }else{
                nssp = ossp;
            }if(ocsp < ossp){
                ncsp = ossp;
            }else{
                ncsp = ocsp;
            }
            ocsp = ncsp;
            ossp = nssp;
            obsp = nbsp;
        }
        return ossp;
    }
}