class TreeNode {
	public Object info;
	public TreeNode left, right; //parent;
	public boolean isLeft;
	
	public TreeNode() {}
	
	public TreeNode(Object x) {}
	
	public TreeNode(Object x, TreeNode L, TreeNode R, TreeNode P) {}
	
	public void setLeft(Object x) {
		if (this.left != null) {
			System.out.println("Void insertion");
		} else {
			TreeNode p = TreeNode(x);
			this.left = P;
			p.parent = this;
			p.isLeft = true;
		}
	}
}