package 系统设计.O1时间插入删除和获取随机元素;

import java.util.*;

public class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    Random r;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
         r = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int l = list.size();
        list.set(index,list.get(l-1));
        map.put(list.get(l-1),index);
        list.remove(l-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = r.nextInt(list.size() - 1);
        return list.get(i);
    }
}
