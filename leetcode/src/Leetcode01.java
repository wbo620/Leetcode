import java.util.HashMap;
import java.util.Map;

public class Leetcode01 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            //声明一个map集合
            //key存放的是数值中的值,value存放的是值对应的下标

            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            //遍历数组
            for (int i = 0; i < nums.length; i++) {
                //如果map里存在的值(key)=target-当前遍历到的数字
                if (map.containsKey(target - nums[i])) {
                    ///就返回数组中的那个值(key)所对应的下标(value)和当前遍历到的下标进行返回
                    return new int[]{map.get(target - nums[i]), i};
                }
                //此时遍历到的值不能匹配,就把他的值当做(key)和下标当做(value)存放到map里
                map.put(nums[i], i);
            }
            return new int[]{0, 0};
        }
    }

//runtime:2 ms
//memory:42.6 MB

}
