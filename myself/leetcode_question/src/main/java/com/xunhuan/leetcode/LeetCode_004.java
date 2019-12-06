package com.xunhuan.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * <p>
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * <p>
 * <p>
 * <p>
 * 两个有序数组的中位数 时间复杂度是O(log (m+n))
 */
public class LeetCode_004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(nums1, 0, nums2, 0, l) + getkth(nums1, 0, nums2, 0, r)) / 2.0;
    }


    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) aMid = A[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < B.length) bMid = B[bStart + k / 2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2);// Check: aRight + bLeft
        else
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2);// Check: bRight + aLeft
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int t = (len1 + len2) / 2;
        int l = 0;
        int r = t;
        while (l <= r) {
            int index1 = (l + r) / 2;
            if (index1 > len1) {
                r = index1;
                continue;
            }
            int index2 = t - index1;
            if (index2 > len2) {
                l = index1 + 1;
                continue;
            }
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (index1 - 1 < len1 && 0 <= index1 - 1) {
                l1 = nums1[index1 - 1];
            }
            if (index1 < len1 && 0 <= index1) {
                r1 = nums1[index1];
            }

            if ((index2 - 1) < len2 && 0 <= (index2 - 1)) {
                l2 = nums2[index2 - 1];
            }
            if (index2 < len2 && 0 <= index2) {
                r2 = nums2[index2];
            }


            if (Math.max(l1, l2) <= Math.min(r1, r2)) {
                if (((len1 + len2) & 1) == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2f;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l1 > Math.min(r1, r2)) {
                r = index1;
            } else {
                l = index1 + 1;
            }

        }
        return 0.00;
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2, 5};
        LeetCode_004 leetCode_004 = new LeetCode_004();
        double res = leetCode_004.findMedianSortedArrays2(a, b);
        System.out.println(res);
    }
}