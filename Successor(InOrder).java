public TreeNode inOrderSucc(TreeNode n) {

	if(n == null)
		return null;
		
		
	// if we found the right children, then return the leftmost child of the right subtree
	if(n.right != null)
		return leftmost(n.right);
	else{
		// Else get the parent of the node n;
		TreeNode q = n;
		
		// If it is already the left node then we have to print the parent
		TreeNode x = q.parent;
		
		// Go up until we get the left side from right
		while(x != null && x.left != q) {
		
			q = x;
			x = x.parent;
		
		}
		
		return x;
		
		
	}
	
}

public TreeNode leftmost(TreeNode n) {

	if(n == null)
		return null;

	// Until it reaches the leftmost part of the subtree	
	while(n.left != null)
		n = n.left;
		
	return n;	
}
