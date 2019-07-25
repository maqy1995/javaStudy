package codePractice.leetCode.array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numsLong,numsShort;
        if(nums1.length>nums2.length){
            numsLong=nums1;
            numsShort=nums2;
        }else{
            numsLong=nums2;
            numsShort=nums1;
        }
        int mini=0;
        int maxi=numsShort.length;
        int mid=0;
        int j=0;

        while(mini<=maxi){
            mid=(maxi+mini)/2;
            j=(numsLong.length+numsShort.length)/2-mid;
            if(mid<numsShort.length&&numsLong[j-1]>numsShort[mid]){
                mini=mid+1;
            }else if(mid>0&&numsShort[mid-1]>numsLong[j]){
                maxi=mid-1;
            }else{
                //we find answer
                int minRight=0;
                if(mid==numsShort.length){
                    minRight=numsLong[j];
                }else if(j==numsLong.length){
                    minRight=numsShort[mid];
                }else{
                    minRight=Math.min(numsShort[mid],numsLong[j]);
                }
                if((nums1.length+nums2.length)%2==1){
                    return minRight;
                }

                int maxLeft=0;
                if(mid==0){
                    maxLeft=numsLong[j-1];
                }else if(j==0){
                    maxLeft=numsShort[mid-1];
                }else{
                    maxLeft=Math.max(numsShort[mid-1],numsLong[j-1]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays x=new MedianofTwoSortedArrays();
        int[] a={1};
        int[] b={2,3,4,5,6};
        System.out.println(x.findMedianSortedArrays(a,b));
    }
}
