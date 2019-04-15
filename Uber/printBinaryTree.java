class Solution {
  int m = 0, n = 0;   
  String[][] array;
  
  // Helper function #1
  private void bFSTraversal(TreeNode current, int height, int left, int right, int column) {    
    if (current == null)
      return;  
    
    if (height == 0) {
      array[column][left + (right - left) / 2] = String.valueOf(current.val);   
    } else {
      int mid = left + (right - left) / 2;                       
      bFSTraversal(current.left, height-1, left, mid-1, column);   // [left , mid-1]
      bFSTraversal(current.right, height-1, mid+1, right, column); // [mid+1, right]
    }
  }

  // Helper function #2
  private int findMaxHeight(TreeNode node) {
    if (node == null)
      return 0;
    
    return Math.max(findMaxHeight(node.left), findMaxHeight(node.right)) + 1;
  }
  
  public List<List<String>> printTree(TreeNode root) {
    // Init Array with proper size and default values
    m = findMaxHeight(root);
    n = (int)(Math.pow(2, m) - 1.0);
    array = new String[m][n];
    for(String[] a : array)
      Arrays.fill(a, "");
    
    // Insert all nodes into the Array[][] at the right indices
    for (int i = 0; i < m; i++) {
      bFSTraversal(root, i, 0, n-1, i);
    }
    
    // Convert the Array[][] into a List<List<String>>
    List<List<String>> result = new ArrayList<List<String>>();
    for(String[] a : array)
      result.add(Arrays.asList(a));
      
    return result;      
  }
}
