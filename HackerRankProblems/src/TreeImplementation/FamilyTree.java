package TreeImplementation;

import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;

public class FamilyTree {
		
	TreeNode root = null;
	
	public void insert(String parent,String child) {
		if(root == null) {
			TreeNode TreeNode = new TreeNode(child);
			root = TreeNode;
			return;
		}
		TreeNode newTreeNode = new TreeNode(child);
		TreeNode TreeNode = find(parent, root);
		if(TreeNode!=null)
		if(TreeNode.leftChild==null) {
			TreeNode.leftChild = newTreeNode;
		}else {
			TreeNode.rightChild = newTreeNode;
		}
	}
	
	public void preorder(TreeNode TreeNode) {
		if(TreeNode == null)
			return;
		System.out.println(TreeNode.name);
		preorder(TreeNode.leftChild);
		preorder(TreeNode.rightChild);
	}
	public TreeNode findName(String s) {
		return find(s, root);
	}
	
	private  boolean check(String person1, String relation, String person2) {
		// TODO Auto-generated method stub
		TreeNode first = find(person1,root);
		TreeNode second = find(person2, root);
		if(relation.equals("child")) {
			if(second.leftChild!=null && second.leftChild.name.equals(first.name))
				return true;
			else if(second.rightChild!=null && second.rightChild.name.equals(first.name))
				 return true;
			else
				return false;
		} else if(relation.equals("parent")) {
			if(first.leftChild!=null && first.leftChild.name.equals(second.name))
				return true;
			else if(first.rightChild!=null && first.rightChild.name.equals(second.name))
				 return true;
			else
				return false;
		}  else if(relation.equals("sibling")) {
			TreeNode n = findParent(person1, root,root);
			if(	((n.leftChild!=null && n.leftChild.name.equalsIgnoreCase(person1)) && (n.rightChild!=null && n.rightChild.name.equalsIgnoreCase(person2))) 
					|| ((n.rightChild!=null && n.rightChild.name.equalsIgnoreCase(person1)) && (n.leftChild!=null && n.leftChild.name.equalsIgnoreCase(person2))) ) {
				return true;
			}else {
				return false;
			}
		} else if(relation.equals("ancestor")) {
			TreeNode n = find(person2, first);
			if(n!=null) {
				return true;
			}else {
				return false;
			}
		} else if(relation.equals("descendant")) {

			TreeNode n = find(person1, second);
			if(n!=null) {
				return true;
			}else {
				return false;
			}
		
		}
		
		return false;
	}
	
	public TreeNode find(String name,TreeNode TreeNode) {
		if(TreeNode == null) {
			return null;
		}
		
		if(TreeNode.name.equalsIgnoreCase(name)) {
			return TreeNode;
		}
		TreeNode left = find(name, TreeNode.leftChild);
		if(left!=null)
			return left;
		TreeNode right = find(name, TreeNode.rightChild);
		if(right!=null)
			return right;
		
		return null;
		
	}
	public TreeNode findParent(String name,TreeNode TreeNode,TreeNode parents) {
		if(TreeNode == null) {
			return null;
		}
		
		if(TreeNode.name.equalsIgnoreCase(name)) {
			return parents;
		}
		TreeNode parent =TreeNode;
		TreeNode left = findParent(name, TreeNode.leftChild,parent);
		if(left!=null)
			return left;
		TreeNode right = findParent(name, TreeNode.rightChild,parent);
		if(right!=null)
			return right;
		
		return null;
		
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		FamilyTree tree = new FamilyTree();
		for(int i=0;i<n;i++) {
			String[] s = scanner.nextLine().split(" ");
			if(i==0) {
				tree.insert(null,s[0]);
				tree.insert(s[0],s[1]);
			}else {
			tree.insert(s[0],s[1]);
			}
		}
		
		int m = Integer.parseInt(scanner.nextLine());
		for(int i=0;i<m;i++) {
			String[] s = scanner.nextLine().split(" ");
			System.out.println(tree.check(s[0],s[1],s[2]));
		}
		tree.preorder(tree.root);
		
	}


}

class TreeNode{
	String name;
	
	TreeNode leftChild;
	TreeNode rightChild;
	
	TreeNode(String Name){
		
		this.name = Name ;
		this.leftChild = null;
		this.rightChild = null;
	}
}