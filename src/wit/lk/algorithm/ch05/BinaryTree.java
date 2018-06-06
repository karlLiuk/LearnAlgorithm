package wit.lk.algorithm.ch05;

/**
 * ����������
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
	 * ���ĳ�������ϵ����нڵ�
	 * 
	 * @param node
	 */
	public void clear(BinaryTreeNode node) {
		if (node != null) {
			clear(node.getLeftChild());// �ݹ��ɾ�����ӽڵ�
			clear(node.getRightChild());// �ݹ��ɾ�����ӽڵ�
			node = null;
		}
	}

	/**
	 * �����
	 */
	public void clear() {
		clear(root);
	}
	
	/**
	 * �ж϶������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * ��ȡ�������ĸ߶�
	 * @return
	 */
	public int height(){
		return height(root);
	}

	/**
	 * ��ȡĳ�ڵ�ĸ߶�
	 * @param node
	 * @return
	 */
	public int height(BinaryTreeNode node) {		
		if (node == null) {
			return 0;//�ݹ�������������ĸ߶�Ϊ0
		}else{
			//�ݹ�ѡȡ�������ĸ߶�
			int l = height(node.getLeftChild());
			//�ݹ�ѡȡ�������ĸ߶�
			int r = height(node.getRightChild());
			
			//�߶��ټ���node��һ��
			return l < r ? r + 1 : l + 1;
		}
	}
	
	/**
	 * ��ȡ�������Ľڵ���
	 * @return
	 */
	public int size(){
		return size(root);
	}

	/**
	 * ��ȡĳ�ڵ�Ϊ�����Ľڵ���
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
	 * ����node�ڵ��ڶ������еĸ��ڵ�
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode node){
		return (root == null || root == node) ? null : getParent(root,node);
	}

	/**
	 * �ݹ����node�ڵ���subTree�����еĸ��ڵ�
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
	 * ��ȡĳ���ڵ��������
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getLeftTree(BinaryTreeNode node){
		return node.getLeftChild();
	}
	
	/**
	 * ��ȡĳ���ڵ��������
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getRightTree(BinaryTreeNode node){
		return node.getRightChild();
	}
	
	/**
	 * ��ĳ�ڵ�������ӽڵ�
	 * @param parent
	 * @param newNode
	 */
	public void insertLeft(BinaryTreeNode parent, BinaryTreeNode newNode){
		parent.setLeftChild(newNode);
	}
	
	/**
	 * ��ĳ�ڵ�������ӽڵ�
	 * @param parent
	 * @param newNode
	 */
	public void insertRight(BinaryTreeNode parent, BinaryTreeNode newNode){
		parent.setRightChild(newNode);
	}
	
	/**
	 * ǰ�����
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
	 * �������
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
	 * �������
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
