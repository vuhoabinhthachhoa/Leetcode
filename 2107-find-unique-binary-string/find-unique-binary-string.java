class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        StringBuilder sb=new StringBuilder();
        // we do this to ensure that our res string is different from ith string at ith char 
        for(int i=0; i<n; i++){   
            if(nums[i].charAt(i)=='0'){         
                sb.append('1');
            }else{
                sb.append('0');
            }            
        }
        
        return sb.toString();
    }

}