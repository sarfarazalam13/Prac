class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 != 0) 
        {
            return findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1);
        } 
        else 
        {
            return (findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1) +
                findKth(nums1, nums2, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }
    private double findKth(int[] nums1, int[] nums2, int k, int start1, int end1, int start2, int end2) {
    int len1 = end1 - start1 + 1;
    int len2 = end2 - start2 + 1;
    if (len1 == 0) 
    {
        return nums2[start2 + k];
    }
    if (len2 == 0) 
    {
        return nums1[start1 + k];
    }
    if (k == 0) 
    {
        return Math.min(nums1[start1], nums2[start2]);
    }

    int mid1 = start1 + len1 * k / (len1 + len2);
    int mid2 = start2 + k - (mid1 - start1 + 1);

    if (nums1[mid1] > nums2[mid2]) 
    {
        return findKth(nums1, nums2, k - (mid2 - start2 + 1), start1, mid1, mid2 + 1, end2);
    } 
    else 
    {
        return findKth(nums1, nums2, k - (mid1 - start1 + 1), mid1 + 1, end1, start2, mid2);
    }
    }


}