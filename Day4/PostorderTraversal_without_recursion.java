import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}
public class PostorderTraversal_without_recursion {
    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pop();
            result.add(curr.val);
            if(curr.left!=null) stack.push(curr.left);
            if(curr.right!=null) stack.push(curr.right);
        }
        Collections.reverse(result);
        return result;
    }
     public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(postorderTraversal(root));
    }

}
