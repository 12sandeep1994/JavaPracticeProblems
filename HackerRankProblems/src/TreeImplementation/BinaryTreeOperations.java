package TreeImplementation;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeOperations {
	Node root;
	int maxlevel;
	int deepstNodeValue;
	
	public Node AVLInsert(int key) {
		Node node = insert(key);
		if(node.LeftChild!=null)
		if(node.LeftChild.leftHeight-node.LeftChild.rightHeight>1) {
			if(node.LeftChild.LeftChild.leftHeight>node.LeftChild.LeftChild.rightHeight) {
				rightRotate(node);
			}else {
				leftRotate(node);
				rightRotate(node);
			}
		}
		
		return null;
	}
	
	public void rightRotate(Node node) {
		Node newNode = node.LeftChild.LeftChild;
		newNode.RightChild = node.LeftChild;
		node.LeftChild = newNode;
	}
	
	public void leftRotate(Node node) {
		Node newNode = node.LeftChild.LeftChild.RightChild;
		newNode.LeftChild = node.LeftChild.LeftChild;
		node.LeftChild.LeftChild = newNode;
	}

	public Node insert(int key) {
		Node node = new Node(key);
		Node focusNode = root;
		Node parent = root;
		Node grandParent = root;
		Node ancestor = root;
		if(root == null) {
			root=node;
			return root;
		}
		
		while(focusNode!=null)
		{
			ancestor = grandParent;
			grandParent=parent;
			parent=focusNode;
			if(key<focusNode.key){
			focusNode.leftHeight+=1;
			focusNode = focusNode.LeftChild;
				}
			else {
				focusNode.rightHeight+=1;
			focusNode = focusNode.RightChild;
				}
		}
		if(key<parent.key) {
			parent.LeftChild = node;
		} else {
			parent.RightChild = node;
		}
		return ancestor;
	}
	
	public void inorder(Node focus) {
		if(focus!=null) {
			inorder(focus.LeftChild);
			System.out.println(focus.toString());
			inorder(focus.RightChild);
		}
	}
	
	public Node find(int key) {
		if(key==root.key) {
			return root;
		}
		Node focusNode = root;
		Node parent = null;
		
		while(focusNode!=null && focusNode.key!=key) {

			parent=focusNode;
			if(key<focusNode.key){
			
			focusNode = focusNode.LeftChild;
				}
			else {
			
			focusNode = focusNode.RightChild;
				}
		
		}
		if(focusNode.key == key) {
			return focusNode;
		}else {
			return parent;	
		}
		
	}
	
	/*public void delete(int key) {
		Node parentOfnodeToBeDeleted = findParent(key);
		Node nodeToBeDeleted = null;
		boolean left = true;
		if(key<parentOfnodeToBeDeleted.key) {
			nodeToBeDeleted=parentOfnodeToBeDeleted.LeftChild;
			left=true;
		}else {
			nodeToBeDeleted=parentOfnodeToBeDeleted.RightChild;
			left=false;
		}
		if(nodeToBeDeleted.key == key) {
			if(nodeToBeDeleted.LeftChild == null && nodeToBeDeleted.RightChild == null) {
				nodeToBeDeleted= null;
				if(left) {
					parentOfnodeToBeDeleted.LeftChild=null;
				}else {
					parentOfnodeToBeDeleted.RightChild=null;
				}
			}else if(nodeToBeDeleted.RightChild == null) {
				Node nodeToBeReplaced = largestNodeOfLeftTree(nodeToBeDeleted);
				if(left) {
					parentOfnodeToBeDeleted.LeftChild=nodeToBeReplaced;
				}else {
					parentOfnodeToBeDeleted.RightChild=nodeToBeReplaced;
				}
				nodeToBeDeleted = nodeToBeReplaced;
				delete(nodeToBeReplaced.key);
			}else {
				Node nodeToBeReplaced = smallestNodeOfRightTree(nodeToBeDeleted);
				if(left) {
					parentOfnodeToBeDeleted.LeftChild=nodeToBeReplaced;
				}else {
					parentOfnodeToBeDeleted.RightChild=nodeToBeReplaced;
				}
				nodeToBeDeleted = nodeToBeReplaced;
				delete(nodeToBeReplaced.key);
			}
		}
	}*/
	
	Node deleteRecursive(Node node,int key) {
		if(node == null) {
			return null;
		}
		
		if(key<node.key) {
			node.LeftChild = deleteRecursive(node.LeftChild, key);
		}else if(key>node.key) {
			node.RightChild = deleteRecursive(node.RightChild, key);
		}else {
			if(node.LeftChild == null && node.RightChild == null) {
				return null;
			}else if(node.LeftChild==null) {
				return node.RightChild;
			}else if(node.RightChild == null) {
				return node.LeftChild;
			}else {
				node.key = smallestNodeOfRightTree(node);
				node.RightChild = deleteRecursive(node.RightChild, node.key);
			}
		}
		
		return node;
		
	}
	
	public void deepestNode(Node node, int level) {
		if(node!=null) {
		deepestNode(node.LeftChild, level++);
		if(maxlevel<level) {
			maxlevel = level;
			deepstNodeValue = node.key;
		}
		deepestNode(node.RightChild, level);
		
		}
	}
	
	public void deepestLeftNode(Node node, int level,boolean Left) {
		if(node!=null) {
		deepestLeftNode(node.LeftChild, level++,true);
		if(maxlevel<level && Left) {
			maxlevel = level;
			deepstNodeValue = node.key;
		}
		deepestLeftNode(node.RightChild, level,false);
		
		}
	}
	
	private Node findParent(int key) {
		if(key==root.key) {
			return root;
		}
		Node focusNode = root;
		Node parent = null;
		
		while(focusNode!=null && focusNode.key!=key) {

			parent=focusNode;
			if(key<focusNode.key){
			focusNode = focusNode.LeftChild;
				}
			else {
			focusNode = focusNode.RightChild;
				}
		
		}
		if(focusNode.key == key) {
			return parent;
		}else {
			return null;	
		}
		
	}

	private int smallestNodeOfRightTree(Node nodeToBeDeleted) {
		//int max = nodeToBeDeleted.LeftChild.key;
		Node focusNode = nodeToBeDeleted.RightChild;
		Node nodeToBeReturned = null;
		while(focusNode!=null) {
			nodeToBeReturned = focusNode;
			focusNode = focusNode.LeftChild;
		}
		return nodeToBeReturned.key;
	}

	private Node largestNodeOfLeftTree(Node nodeToBeDeleted) {
		//int max = nodeToBeDeleted.LeftChild.key;
		Node focusNode = nodeToBeDeleted.LeftChild;
		Node nodeToBeReturned = null;
		while(focusNode!=null) {
			nodeToBeReturned = focusNode;
			focusNode = focusNode.RightChild;
		}
		return nodeToBeReturned;
	}

	public int height(Node node) {
		if(node == null) {
			return 0;
		}
		
		int leftHeight = height(node.LeftChild);
		int rightHeight = height(node.RightChild);
		return 1+max(leftHeight,rightHeight);
	}
	
	public int size(Node node) {
		if(node == null) {
			return 0;
		}
		
		int leftsize = size(node.LeftChild);
		int rightsize = size(node.RightChild);
		return 1+leftsize+rightsize;
	}
	
	public boolean leafToRootSum(int sum,Node node,List<Integer> result) {
		if(node == null) {
			return false;
		}
		
		if(node.LeftChild==null && node.RightChild==null) {
			if(sum==node.key) {
				result.add(node.key);
				return true;
			}else {
				return false;
			}
		}
		
		if(leafToRootSum(sum-node.key, node.LeftChild, result)) {
			result.add(node.key);
			return true;
		}
		if(leafToRootSum(sum-node.key, node.RightChild, result)) {
			result.add(node.key);
			return true;
		}
		
		return false;
		
		
	}
	
	public boolean isBinary(Node node,int lowerLimit, int upperLimit) {
		if(node == null) {
			return true;
		}
		if(node.LeftChild == null && node.RightChild == null) {
			if(node.key >= lowerLimit && node.key <= upperLimit) {
			return true;
			}else {
				return false;
			}
		}
		if(node.LeftChild == null) {
			if(node.key >= lowerLimit && node.key <= upperLimit && node.key < node.RightChild.key) {
			if(!isBinary(node.RightChild,node.key , upperLimit)) {
				return false;
			}else {
				return true;
			}}
			else {
				return false;
			}
		}
		if(node.RightChild == null) {
			if(node.key >= lowerLimit && node.key <= upperLimit && node.key > node.LeftChild.key) {
			if(!isBinary(node.LeftChild,lowerLimit , node.key)) {
				return false;
			}else {
				return true;
			}}
			else {
				return false;
			}
		}
		if(node.key >= lowerLimit && node.key <= upperLimit  && node.key < node.RightChild.key  && node.key > node.LeftChild.key) {
			if(!isBinary(node.LeftChild, lowerLimit, node.key)) {
				return false;
			}
			if(!isBinary(node.RightChild,node.key , upperLimit)) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public boolean isBinaryEasy(Node node,int lowerLimit, int upperLimit) {
		if(node == null)
			return true;
		
		if(node.key<=lowerLimit || node.key>=upperLimit) {
			return false;
		}
		
		return isBinary(node.LeftChild, lowerLimit, node.key) && 
				isBinary(node.RightChild, node.key, upperLimit);
	}
	public Node LowestCommonAncestor(Node node,int val1,int val2) {
		if(node==null) {
			return node;
		}
		if(node.key==val1 || node.key == val2) {
			return node;
		}
		Node left = LowestCommonAncestor(node.LeftChild, val1, val2);
		
		Node right = LowestCommonAncestor(node.RightChild, val1, val2);
		
		if(left !=null && right !=null) {
			return node;
		}
		if(left ==null && right ==null) {
			return null;
		}
		return (left==null?right:left);
	}
	public void  levelOrderTraversal() {
		ArrayList<Node> queue = new ArrayList<>();
		queue.add(root);
		queue.add(null);
		while(queue.size()>1) {
			Node node = queue.get(0);
			if(node==null) {
				queue.add(null);
				queue.remove(0);
				System.out.println();
				continue;
			}
			else if(node.LeftChild==null && node.RightChild==null) {
				System.out.println(queue.remove(0));
				continue;
			}
			else if(node.LeftChild!=null && node.RightChild!=null) {
				queue.add(node.LeftChild);
				queue.add(node.RightChild);
			}
			else if(node.LeftChild==null) {
				queue.add(node.RightChild);
			}
			else if(node.RightChild==null) {
				queue.add(node.LeftChild);
			}
			
			System.out.println(queue.remove(0));
		}
	}
	
	private int max(int leftHeight, int rightHeight) {
		return leftHeight>rightHeight?leftHeight:rightHeight;
	}

	public static void main(String[] args) {
		BinaryTreeOperations binaryTreeOperations = new BinaryTreeOperations();
		/*
		binaryTreeOperations.insert(50);
		binaryTreeOperations.insert(25);
		binaryTreeOperations.insert(40);
		binaryTreeOperations.insert(60);
		binaryTreeOperations.insert(70);
		binaryTreeOperations.insert(10);
		binaryTreeOperations.insert(30);
		binaryTreeOperations.insert(55);
		binaryTreeOperations.insert(58);
		binaryTreeOperations.insert(53);
		//Node newNode = new Node(24);
		//Node node = binaryTreeOperations.find(53);
		//node.LeftChild = newNode;
		//binaryTreeOperations.insert(24);
		binaryTreeOperations.inorder(binaryTreeOperations.root);
		//binaryTreeOperations.deleteNode(60);
		binaryTreeOperations.insert(75);
		System.out.println("---------------------");
		System.out.println(binaryTreeOperations.height(binaryTreeOperations.root));
		System.out.println("--------SIZE-------------");
		System.out.println(binaryTreeOperations.size(binaryTreeOperations.root));
		System.out.println("---------------------");
		List<Integer> result = new ArrayList<>();
		if(binaryTreeOperations.leafToRootSum(85, binaryTreeOperations.root, result)) {
			for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
			}
		}
		System.out.println("-------ISBINARY--------------");
		System.out.println(binaryTreeOperations.isBinaryEasy(binaryTreeOperations.root, -999, +999));
		System.out.println("-------LCT--------------");
		System.out.println(binaryTreeOperations.LowestCommonAncestor(binaryTreeOperations.root, 53, 55).key);
		System.out.println("-------LEVEL--------------");
		binaryTreeOperations.levelOrderTraversal();*/
	
		
		binaryTreeOperations.AVLInsert(5);
		binaryTreeOperations.AVLInsert(6);
		binaryTreeOperations.AVLInsert(4);
		binaryTreeOperations.AVLInsert(2);
		binaryTreeOperations.AVLInsert(3);
		System.out.println(binaryTreeOperations.root.LeftChild);
		System.out.println(binaryTreeOperations.root.LeftChild.LeftChild);
		System.out.println(binaryTreeOperations.root.LeftChild.RightChild);
		//binaryTreeOperations.AVLInsert(1);
	}

	private void deleteNode(int key) {
		deleteRecursive(root, key);
		
	}

}


class Node {
	
	Node LeftChild;
	Node RightChild;
	
	int key;
	int leftHeight;
	int rightHeight;
	
	Node(int key){
		this.key=key;
		this.LeftChild = null;
		this.RightChild = null;
		this.leftHeight = 0;
		this.rightHeight = 0;
	}
	
	public String toString() {
		return("The key is "+key);
	}
}