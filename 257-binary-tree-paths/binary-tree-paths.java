class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        
        for (String s : binaryTreePaths(root.left))
            res.add(root.val + "->" + s);
        
        for (String s : binaryTreePaths(root.right))
            res.add(root.val + "->" + s);
        
        return res;
    }
}