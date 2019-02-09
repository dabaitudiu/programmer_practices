## 101. Symmetric Tree [Easy]

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following [1,2,2,null,3,null,3] is not:
```
    1
   / \
  2   2
   \   \
   3    3
```
思路：这个题首先想到recursion，但是第一次写完发现自己条件想错了,一直在递归isSymmetric，return isSymmetric(root.left) && isSymmetric(root.right), 这么做检查的是树的每个左右节点，而不两个branch.正解应该是输入两个node，比较(node1.left, node2.right)和(node1.right, node2.left)

```java
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }


class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
        }
    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1== null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val) && isMirror(root1.left,root2.right) && isMirror(root1.right, root2.left);
    }
}
```
