package exam;

public class leetcode105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preLen = preorder.length;
		int inLen = inorder.length;
		return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
	}

	private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
			int[] inorder, int inLeft, int inRight) {
		if (preLeft > preRight || inLeft > inRight) {
			return null;
		}

		int pivot = preorder[preLeft];
		TreeNode root = new TreeNode(pivot);
		int pivotIndex = inLeft;

		while (inorder[pivotIndex] != pivot) {
			pivotIndex++;
		}
		root.left = buildTree(preorder, preLeft + 1, pivotIndex - inLeft + preLeft,
				inorder, inLeft, pivotIndex - 1);
		root.right = buildTree(preorder, pivotIndex - inLeft + preLeft + 1, preRight,
				inorder, pivotIndex + 1, inRight);
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
