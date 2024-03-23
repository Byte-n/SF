package by.sel;

import java.util.*;

public class Q15 {
    // ˫���� + ˫ָ�� ���ţ�����
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // ������
        Arrays.sort(nums);
        // �ҳ� a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // ����֮�������һ��Ԫ���Ѿ������㣬��ô���������϶������ܴճ���Ԫ�飬ֱ�ӷ��ؽ���Ϳ�����
            if (nums[i] > 0) {
                return result;
            }

            // if (nums[i] == nums[i + 1]) { // ȥ�ز���
            //     continue;
            // }

            // ����ʹ������ģ�������ɱ -1,-1,2
            if (i > 0 && nums[i] == nums[i - 1]) {  // ȥ��a
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
                // ���� 0
                else {
                    // ȥ���߼�Ӧ�÷����ҵ�һ����Ԫ��֮���ȼ�¼��Ԫ�飬�ٶ�b �� cȥ��
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // ע���Խ��
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

    // ˫���� + ����
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // ������
        Arrays.sort(nums);
        // �ҳ�a + b + c = 0
        // a = nums[i], b = nums[j], c = -(a + b)
        for (int i = 0; i < nums.length; i++) {
            // ����֮�������һ��Ԫ���Ѿ������㣬��ô�����ܴճ���Ԫ��
            int a = nums[i];
            if (a > 0) {
                break;
            }

            // if (nums[i] == nums[i + 1]) { // ȥ�ز���
            //     continue;
            // }

            // ����ʹ������ģ�������ɱ -1,-1,2
            if (i > 0 && a == nums[i - 1]) { // ��Ԫ��Ԫ��aȥ��
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; ) {
                // �������Ԫ������������ִ�������߼�
                int b = nums[j];
                int c = -a - b;
                if (set.contains(c)) {
                    result.add(Arrays.asList(a, b, c));
                    // ���Ѱ�ҵ��⣬��ô����Ҫ��b����set����Ϊ��ʱ�Ѿ���b��Ϊ�𰸸�ֵ��res�ˣ�
                    // b�Ѿ������ܺ�����Ԫ�ش�����ɴ��ˡ�����nums[j]��ȡֵ��ֻ���ܴ��ڵ��ڵ�ǰ��bֵ,
                    // Ҳ��˵������ c ֻ��С�ڵ��ڵ�ǰ�� c��
                    // ������������b����set����ô��������ƥ��� c ʱ���϶����ظ���(a,b,c)��(a,c,b), ����(1,2,-3) �� (1,-3,2)

                    // Ѱ�ҵ�һ���⣬�����һ��Ԫ��ֵ�͵�ǰֵһ������ô�����һ���ظ��Ĵ𰸣�����ֱ��������ֱ�����ֲ�һ����Ԫ��
                    // c = - a - b���� b һ����ʱ��c�϶�Ҳ��Ψһ��
                    j++;
                    while (j < nums.length && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else {
                    // �����ǰԪ�ز����ڣ�ͬʱҲ���������������ô����ǰԪ�ؼ���set
                    set.add(nums[j++]);
                }
            }
        }
        return result;
    }
}
