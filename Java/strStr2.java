//find the index of a target string in a given string in O(n) time
public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
        // write your code here
        int BASE=1000000;
        int hashcode=0;
        int targetcode=0;
        int power=1;
        //special cases
        if(source==null || target==null){
            return -1;
        }
        int m=target.length();
        if(m==0){
            return 0;
        }
        //targetcode and power 31^m
        for(int i=0;i<m;i++){
            targetcode=(targetcode*31+target.charAt(i))%BASE;
            power=(power*31)%BASE;
        }
        //use hash function
        for(int i=0;i<source.length();i++){
            hashcode=(hashcode*31+source.charAt(i))%BASE;
            if(i<m-1){
                continue;
            }
            if(i>=m){
                hashcode=(hashcode-source.charAt(i-m)*power)%BASE;
                if(hashcode<0){
                    hashcode=hashcode+BASE;
                }
            }
            if(hashcode==targetcode){
                if(source.substring(i-m+1,i+1).equals(target)){
                    return i-m+1;
                }
            }
        }
        return -1;
    }
}
