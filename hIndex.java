//Algo: we need to find fixed h papers that can range from 0 -> n
// check for max limit of h, if we have atleast h papers greater than limit.
// applied count sort kind of array.

//Tc: O(n);
//Sc: O(n);
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length ==0) return 0;
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>= n) {
                buckets[n]++;
            }
            else{
                buckets[citations[i]]++;
            }
        }

        int sum =0;
        for(int i=n;i>=0; i--){
            sum+=buckets[i];
            if(sum>=i) return i;
        }

        return 0;
    }
}