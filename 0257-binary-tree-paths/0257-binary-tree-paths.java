
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        helper(root,new StringBuilder(), result);
        return result;
    }
    private void helper(TreeNode root, StringBuilder strB,List<String> res){
        if(root != null){
            int len = strB.length();
            strB.append(root.val);
            if(root.left == null && root.right == null){
                String str = strB.toString();
                res.add(str);
            }else{
                strB.append("->");
                helper(root.left,strB, res);
                helper(root.right, strB, res);
            }
            strB.delete(len, strB.length());
        }
    }
}