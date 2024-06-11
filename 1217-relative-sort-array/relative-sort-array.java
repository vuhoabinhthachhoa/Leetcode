class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        for(int i = 0; i < arr1.length ; i++) {
            map[arr1[i]]++;
        }

        int j = 0;
        for(int i = 0 ; i < arr2.length ; i++) {
            while(map[arr2[i]] > 0) {
                arr1[j] = arr2[i];
                map[arr2[i]] --;
                j++;
            }

        }

        for(int i = 0 ; i < 1001 ; i++) {
            while(map[i] > 0) {
                arr1[j] = i;
                j++;
                map[i] --;
            }
        }

        return arr1;
    }
}