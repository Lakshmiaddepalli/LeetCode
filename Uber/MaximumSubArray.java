class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxtillhere = nums[0];
        int maxsofar = nums[0];
        
        for(int i =1;i< nums.length;i++){
            
            maxtillhere = Math.max(maxtillhere + nums[i], nums[i]); 
            maxsofar = Math.max(maxsofar, maxtillhere);
        }
        
        return maxsofar;
    }
}
