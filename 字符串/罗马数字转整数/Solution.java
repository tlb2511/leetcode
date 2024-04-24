package 字符串.罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int l = 0, r = 1;
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        while(l < n){
            if(arr[l] == 'I'){
                if(l + 1 < n){
                    if(arr[l+1] == 'V'){
                        ans += 4;
                        l += 2;
                    }else if(arr[l+1] == 'X'){
                        ans += 9;
                        l += 2;
                    }else{
                        ans += 1;
                        l++;
                    }
                }else{
                    ans += 1;
                    l++;
                }
            }
            else if(arr[l] == 'X'){
                if(l + 1 < n){
                    if(arr[l+1] == 'L'){
                        ans += 40;
                        l += 2;
                    }else if(arr[l+1] == 'C'){
                        ans += 90;
                        l += 2;
                    }else{
                        ans += 10;
                        l++;
                    }
                }else{
                    ans += 10;
                    l++;
                }
            }
            else if(arr[l] == 'C'){
                if(l + 1 < n){
                    if(arr[l+1] == 'D'){
                        ans += 400;
                        l += 2;
                    }else if(arr[l+1] == 'M'){
                        ans += 900;
                        l += 2;
                    }else{
                        ans += 100;
                        l++;
                    }
                }else{
                    ans += 100;
                    l++;
                }
            }else{
                ans += map.get(arr[l]);
                l++;
            }

        }
        return ans;
    }
}
