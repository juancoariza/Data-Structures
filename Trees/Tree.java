class Tree {
	TreeNode root;
	
	public Tree() {
		root = null;
	}
	
	public Tree(Object x) {
		root = new TreeNode(x);
	}
	
	public void preTrav(TreeNode tree) {
		if (tree != null) {
			System.out.println(tree.info);	
			preTrav(tree.left);
			preTrav(tree.right);
		}
	}
	
	public void postTrav(TreeNode tree) {
		if (tree != null) {
			postTrav(tree.left);
			postTrav(tree.right);
			System.out.println(tree.info);
		}
	}
	
	public void inTrav(TreeNode tree) {
		if (tree != null) {
			inTrav(tree.left);
			System.out.println(tree.info);
			inTrav(tree.right);
		}
	}
	
	boolean isStrictlyBinary(TreeNode root) {
		if(root == null) {
			return true;
		} else if(root.left == null && root.right == null){
			return true;
		} else if(root.left != null && root.right != null){
			boolean leftStrict = isStrictlyBinary(root.left);
			boolean rightStrict = isStrictlyBinary(root.right);
			return leftStrict && rightStrict;
        }else{
			return false;
        }
	}
}