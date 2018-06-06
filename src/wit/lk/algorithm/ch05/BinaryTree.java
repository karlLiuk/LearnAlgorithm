package wit.lk.algorithm.ch05;

/**
 * 创建二叉树
 * 
 * @author lk
 *
 */
public class BinaryTree {
	private BinaryTreeNode root;

	public BinaryTree() {

	}

	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	/**
	 * 清楚某个子树上的所有节点
	 * 
	 * @param node
	 */
	public void clear(BinaryTreeNode node) {
		if (node != null) {
			clear(node.getLeftChild());// 递归地删除左子节点
			clear(node.getRightChild());// 递归地删除右子节点
			node = null;
		}
	}

	/**
	 * 清空树
	 */
	public void clear() {
		clear(root);
	}
	
	/**
	 * 判断二叉树是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * 获取二叉树的高度
	 * @return
	 */
	public int height(){
		return height(root);
	}

	/**
	 * 获取某节点的高度
	 * @param node
	 * @return
	 */
	public int height(BinaryTreeNode node) {		
		if (node == null) {
			return 0;//递归结束，空子树的高度为0
		}else{
			//递归选取左子树的高度
			int l = height(node.getLeftChild());
			//递归选取右子树的高度
			int r = height(node.getRightChild());
			
			//高度再加上node这一层
			return l < r ? r + 1 : l + 1;
		}
	}
	
	/**
	 * 获取二叉树的节点数
	 * @return
	 */
	public int size(){
		return size(root);
	}

	/**
	 * 获取某节点为子树的节点数
	 * @param node
	 * @return
	 */
	public int size(BinaryTreeNode node) {
		
		if (node == null) {
			return 0;
		}else{
			return 1 + size(node.getLeftChild()) + size(node.getRightChild());
		}
	}
	
	/**
	 * 查找node节点在二叉树中的父节点
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode node){
		return (root == null || root == node) ? null : getParent(root,node);
	}

	/**
	 * 递归查找node节点在subTree子树中的父节点
	 * @param subTree
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
		
		if (subTree == null) {
			return null;
		}
		if(subTree.getLeftChild() == node || subTree.getRightChild() == node){
			return subTree;
		}
		
		BinaryTreeNode parent = null;
		if((parent = getParent(subTree.getLeftChild(), node)) != null){
			return parent;
		}else{
			return getParent(subTree.getRightChild(), node);
		}
	}
	
	/**
	 * 获取某个节点的左子树
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getLeftTree(BinaryTreeNode node){
		return node.getLeftChild();
	}
	
	/**
	 * 获取某个节点的右子树
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getRightTree(BinaryTreeNode node){
		return node.getRightChild();
	}
	
	/**
	 * 给某节点插入左子节点
	 * @param parent
	 * @param newNode
	 */
	public void insertLeft(BinaryTreeNode parent, BinaryTreeNode newNode){
		parent.setLeftChild(newNode);
	}
	
	/**
	 * 给某节点插入右子节点
	 * @param parent
	 * @param newNode
	 */
	public void insertRight(BinaryTreeNode parent, BinaryTreeNode newNode){
		parent.setRightChild(newNode);
	}
	
	/**
	 * 前序遍历
	 * @param node
	 */
	public void preOrder(BinaryTreeNode node){
		if(node != null){
			visted(node);
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	
	/**
	 * 中序遍历
	 * @param node
	 */
	public void inOrder(BinaryTreeNode node){
		if(node != null){
			preOrder(node.getLeftChild());
			visted(node);
			preOrder(node.getRightChild());
		}
	}
	
	/**
	 * 后序遍历
	 * @param node
	 */
	public void postOrder(BinaryTreeNode node){
		if(node != null){
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
			visted(node);
		}
	}

	private void visted(BinaryTreeNode node) {
		System.out.println(node.getData());
	}
}
