package by.sel;

import java.util.*;

public class Q347 {
    // ��ϣ�� ͳ�ƴ��� -> �󶥶� ��ȡ���
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();// keyΪ����Ԫ��ֵ,valΪ��Ӧ���ִ���
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // �����ȶ����д洢��Ԫ��(num,cnt),cnt��ʾԪ��ֵnum�������еĳ��ִ���
        // ���ִ������Ӷ�ͷ����β��˳���ǴӴ�С��,���ִ��������ڶ�ͷ(�൱�ڴ󶥶�)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {// �󶥶���Ҫ������Ԫ�ؽ�������
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {// ���δӶ�ͷ����k��,���ǳ���Ƶ��ǰk�ߵ�Ԫ��
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

    // ��ϣ��ͳ�ƴ��� -> Ͱ���� -> ������ȡ���
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // ʹ���ֵ䣬ͳ��ÿ��Ԫ�س��ֵĴ�����Ԫ��Ϊ����Ԫ�س��ֵĴ���Ϊֵ
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // Ͱ����
        // ��Ƶ����Ϊ�����±꣬���ڳ���Ƶ�ʲ�ͬ�����ּ��ϣ������Ӧ�������±�
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // ��ȡ���ֵĴ�����Ϊ�±�
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // ������������ȡ����˳��Ӵ�С������
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }
}
