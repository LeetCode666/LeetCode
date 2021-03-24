package exam;

public class leetcode1052 {
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int notGrumpy = 0;
        int maxGrumpy = 0;
        for(int i = 0; i<customers.length;i++){
            if(grumpy[i]==0){
                notGrumpy+=customers[i];
                customers[i] = 0;
            }
        }
    
        int sum = 0;
        for(int i = 0;i< customers.length;i++){
            sum += customers[i];
            if(i >= X -1){
                maxGrumpy = Math.max(sum, maxGrumpy);
                sum = sum - customers[i-X+1];
            }
            
        }
        return notGrumpy + maxGrumpy;
    }
}
