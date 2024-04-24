package 字符串.整数转罗马数字;

public class Solution {
    public String intToRoman(int num) {
        int[] a1 = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] a2 = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int index = 0;
        String ans = "";
        while(num > 0){
            while(num >= a1[index]){
                ans += a2[index];
                num -= a1[index];
                //index++;
            }
            index++;
        }
        return ans;
    }
}
