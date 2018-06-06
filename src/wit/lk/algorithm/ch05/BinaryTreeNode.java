package wit.lk.algorithm.ch05;
/**
 * 左右链表的表示二叉树结点
 * @author lk
 *
 */
public class BinaryTreeNode {
	private int data;//数据
	private BinaryTreeNode leftChild;//左孩子
	private BinaryTreeNode rightChild;//右孩子
	
	public int getData(){
		return data;
	}
	public void setData(int data){
		this.data = data;
	}
	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
}
