package search;

public class BinarySearch {
    public boolean binarySearch(int[] ar, int target) {
        return binarySearch(ar, 0, ar.length-1, target);
    }

    private boolean binarySearch(int[] ar, int left, int right, int target) {
        if(left <= right) {
            int mid = (left + right) / 2;
            if(ar[mid] == target)
                return true;
            if(target > ar[mid]) {
                return binarySearch(ar, mid + 1, right, target);
            } else {
                return binarySearch(ar, left, mid -1, target);
            }
        }
        return false;
    }
}
