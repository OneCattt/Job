package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @ClassName TwoSum
 * @Author jiangruliang
 * @Date 2019/9/5 16:13
 * @Version 1.0
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 9}, 9)));

    }

    private static int[] twoSum(int[] nums,int target){
        int[] num=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                num[0]=map.get(target-nums[i]);
                num[1]=i;
            }
            map.put(nums[i],i);
        }
        return num;
    }
}
