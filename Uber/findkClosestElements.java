class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> al = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++){
            al.add(arr[i]);
        }
        Collections.sort(al, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
     al = al.subList(0, k);
     Collections.sort(al);
        return al;
    }
}


//Better solution

/*
The original array has been sorted so we can take this advantage by the following steps.

If the target x is less or equal than the first element in the sorted array, the first k elements are the result.
Similarly, if the target x is more or equal than the last element in the sorted array, the last k elements are the result.
Otherwise, we can use binary search to find the index of the element, which is equal (when this list has x) or a little bit larger than x (when this list does not have it). Then set low to its left k-1 position, and high to the right k-1 position of this index as a start. The desired k numbers must in this rang [index-k-1, index+k-1]. So we can shrink this range to get the result using the following rules.
If low reaches the lowest index 0 or the low element is closer to x than the high element, decrease the high index.
If high reaches to the highest index arr.size()-1 or it is nearer to x than the low element, increase the low index.
The looping ends when there are exactly k elements in [low, high], the subList of which is the result.

*/

public class Solution {
	public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
		int n = arr.size();
		if (x <= arr.get(0)) {
			return arr.subList(0, k);
		} else if (arr.get(n - 1) <= x) {
			return arr.subList(n - k, n);
		} else {
			int index = Collections.binarySearch(arr, x);
			if (index < 0)
				index = -index - 1;
			int low = Math.max(0, index - k - 1), high = Math.min(arr.size() - 1, index + k - 1);

			while (high - low > k - 1) {
				if (low < 0 || (x - arr.get(low)) <= (arr.get(high) - x))
					high--;
				else if (high > arr.size() - 1 || (x - arr.get(low)) > (arr.get(high) - x))
					low++;
				else
					System.out.println("unhandled case: " + low + " " + high);
			}
			return arr.subList(low, high + 1);
		}
	}
}
