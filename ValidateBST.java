// Check if the given binary tree is a BST or not.


// function to check if a given binary tree is a BST or not.
public boolean checkBST(TreeNode root) {
		
		// helper function
		return checkBST(root, null, null);
}

public boolean checkBST(TreeNode root, int min, int max) {

	if(root == null)
		return true;
		
	// when the given node violates the range values	
	if((min != null && root.data <= min) || (max != null && root.data > max))	
			return false;
			
	if(!checkBST(root.left,min,root.data)) || (!checkBST(root.right,root.data,max)
		return false;
		
	return true;
}
