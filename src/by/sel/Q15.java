package by.sel;

import java.util.*;

public class Q15 {
    // 双迭代 + 双指针 更优！！！
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        // 找出 a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            // if (nums[i] == nums[i + 1]) { // 去重操作
            //     continue;
            // }

            // 不能使用上面的，避免误杀 -1,-1,2
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
                // 等于 0
                else {
                    // 去重逻辑应该放在找到一个三元组之后。先记录三元组，再对b 和 c去重
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 注意别越界
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        threeSum(new int[]{0, 2, 2, 3, 0, 1, 2, 3, -1, -4, 2});
    }

    // 双迭代 + 集合
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[j], c = -(a + b)
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么不可能凑成三元组
            int a = nums[i];
            if (a > 0) {
                break;
            }

            // if (nums[i] == nums[i + 1]) { // 去重操作
            //     continue;
            // }

            // 不能使用上面的，避免误杀 -1,-1,2
            if (i > 0 && a == nums[i - 1]) { // 三元组元素a去重
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; ) {
                // 如果存在元素满足条件，执行以下逻辑
                int b = nums[j];
                int c = -a - b;
                if (set.contains(c)) {
                    result.add(Arrays.asList(a, b, c));
                    // 如果寻找到解，那么不需要将b加入set，因为此时已经将b作为答案赋值给res了，
                    // b已经不可能和其他元素搭配组成答案了。后续nums[j]的取值，只可能大于等于当前的b值,
                    // 也就说后续的 c 只会小于等于当前的 c。
                    // 如果继续将这个b放入set，那么后续遇到匹配的 c 时，肯定就重复了(a,b,c)和(a,c,b), 例如(1,2,-3) 和 (1,-3,2)

                    // 寻找到一个解，如果下一个元素值和当前值一样，那么会出现一个重复的答案，所以直接跳过，直到出现不一样的元素
                    // c = - a - b。当 b 一样的时候，c肯定也是唯一的
                    j++;
                    while (j < nums.length && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else {
                    // 如果当前元素不存在，同时也不满足解条件，那么将当前元素加入set
                    set.add(nums[j++]);
                }
            }
        }
        return result;
    }
}
