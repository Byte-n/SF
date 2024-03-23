package by.sel;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 */
public class Q239 {
    // 双向队列 & 单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 存储的是索引
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            // 维持 deque中索引对应的数值是 非递增 的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 放入尾部
            deque.offerLast(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    // 优先队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        // PriorityQueue<[值,值对应的索引]>
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            // 两个值不相同，则比较值
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            // 值相同，则比较索引
            return b[1] - a[1];
        });
        // 先入队列k个元素
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        // 存入初始k个元素对应的答案
        ans[0] = pq.peek()[0];
        // 迭代将后续的元素入队列
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            // 将队列中索引小于 i-k 的元素 从队列中移除
            // 也就是将滑动窗口外左侧的元素移除，避免队列里当前的最大值是滑动窗口外的。
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            // 记录当前滑动窗口内的最大值
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
