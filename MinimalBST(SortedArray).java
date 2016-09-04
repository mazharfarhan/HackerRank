class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;
	
	void TreeNode(int value) {
	
		this.val = value;
	}
}

// function to get the minimum binary search tree constructed from the given array
public TreeNode createMinimalBST(int[] arr) {

	// helper function to construct the BST recursively.
	return createMinimal(arr, 0, arr.length -1);
}

public TreeNode createMinimal(int[] arr, int start, int end) {

	// check for boundary condition
	if(end < start)
		return null;
	
	// find the middle element that will be the root of the BST.
	int mid = (start + end) / 2;
	
	// create the root with this new node.
	TreeNode root = new TreeNode(arr[mid]);

	// left part of the tree will have values between 0 and mid-1
	root.left = createMinimal(arr, start, mid -1);

	// right part will have values from mid + 1 to n-1
	root.right = craeteMinimal(arr, mid+1, end)	
	
	return root;	
}
