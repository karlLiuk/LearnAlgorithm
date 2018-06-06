package wit.lk.algorithm.ch05;

public class BinarySearchingTree {
	private BinaryTreeNode root;
	
	public BinarySearchingTree(BinaryTreeNode root){
		this.root = root;
	}
	
	/**
	 * ����������Ĳ���
	 * @param data
	 * @return
	 */
	public BinaryTreeNode search(int data){
		return search(root,data);
	}

	/**
	 * �ݹ���������
	 * @param node
	 * @param data
	 * @return
	 */
	public BinaryTreeNode search(BinaryTreeNode node, int data) {
		if(node == null){
			return null;
		}else if(node.getData() == data){
			return node;
		}else if(data > node.getData()){
			return search(node.getRightChild(),data);
		}else{
			return search(node.getLeftChild(),data);
		}
	}
	
	/**
	 * ����������Ĳ���
	 * @param data
	 */
	public void insert(int data){
		if(root == null){
			root = new BinaryTreeNode();
			root.setData(data);
		}else{
			searchAndInsert(null,root,data);
		}
	}

	/**
	 * �ݹ��������������û���ҵ������½�һ������λ�õĽڵ㣩
	 * @param parent
	 * @param node
	 * @param data
	 */
	public BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
		if(node == null){
			node = new BinaryTreeNode();
			node.setData(data);
			if(data > parent.getData()){
				parent.setRightChild(node);
			}else{
				parent.setLeftChild(node);
			}
			return node;
		}else if(node.getData() == data){
			return node;
		}else if(node.getData() < data){
			return searchAndInsert(node, node.getRightChild(), data);
		}else{
			return searchAndInsert(node, node.getLeftChild(), data);
		}
	}
	
	/**
	 * ������ɾ������
	 * @param data
	 */
	public void delete(int data){
		//�Ը��ڵ�ֱ�Ӹ�ֵΪ��
		if(root.getData() == data){
			root = null;
			return;
		}
		//�������̶���Ҫ֪�����ڵ㣬��ΪJava�����ô��ݣ�����ֱ�Ӹ�ֵ
		BinaryTreeNode parent = searchParent(data);
		if(parent == null){
			return;
		}
		BinaryTreeNode node = search(parent,data);
		if(node.getLeftChild() == null && node.getRightChild() == null){
			//Ҷ�ӽڵ�ֱ��ɾ��
			if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data){
				parent.setLeftChild(null);
			}else{
				parent.setRightChild(null);
			}
		}else if(node.getLeftChild() != null && node.getRightChild() == null){
			//��������Ϊ����
			if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data){
				parent.setLeftChild(node.getLeftChild());
			}else{
				parent.setRightChild(node.getLeftChild()); 
			}
		}else if(node.getLeftChild() == null && node.getRightChild() != null){
			//��������Ϊ����
			if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data){
				parent.setLeftChild(node.getRightChild());
			}else{
				parent.setRightChild(node.getRightChild()); 
			}
		}else{
			//������������Ϊ����
			//1.�����������е������ӽڵ�
			BinaryTreeNode deleteNode = node;//Ҫɾ���Ľڵ�
			BinaryTreeNode temp = node.getRightChild();//Ҫɾ���ڵ������������
			if(temp.getLeftChild() == null){
				//���������û�����ӣ�ֱ������
				temp.setLeftChild(deleteNode.getLeftChild());
			}else{
				//�����������Ӳ�Ϊ��
				while(temp.getLeftChild() != null){
					node = temp;
					temp = temp.getLeftChild();
				}
				//2.�̳нڵ�ԭ����������
				node.setLeftChild(temp.getRightChild());
				//3.�̳нڵ��λ
				temp.setLeftChild(deleteNode.getLeftChild());
				temp.setRightChild(deleteNode.getRightChild());
			}
			//4.���¸��ڵ�Ϊɾ���ڵ��ԭ���ڵ�
			if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data){
				parent.setLeftChild(temp);
			}else{
				parent.setRightChild(temp);
			}
		}
	}

	/**
	 * ������������Ҹ��ڵ�
	 * @param data
	 * @return
	 */
	public BinaryTreeNode searchParent(int data) {
		
		return searchParent(null,root,data);
	}

	/**
	 * �ݹ���������
	 * @param parent
	 * @param node
	 * @param data
	 * @return
	 */
	public BinaryTreeNode searchParent(BinaryTreeNode parent, BinaryTreeNode node, int data) {
		if(node == null){
			return null;
		}else if(node.getData() == data){
			return node;
		}else if(data > node.getData()){
			return search(node.getRightChild(),data);
		}else{
			return search(node.getLeftChild(),data);
		}
	}
	
	public BinaryTreeNode getRoot(){
		return root;
	}
}
