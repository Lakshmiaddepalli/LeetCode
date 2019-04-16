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
