class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0) return null;
        int L = pre.length;
        TreeNode root = new TreeNode(pre[0]);
        if (L == 1) return root;
        int i = 0;
        for (;i < post.length;i++){
            if (post[i] == pre[1]) break;
        }
        
        int[] left_pre = new int[i + 1];
        int[] left_post = new int[i + 1];
        int[] right_pre = new int[L - i - 2];
        int[] right_post = new int[L - i - 2];
        
        for (int j = 0; j <= i;j++){
            left_pre[j] = pre[j + 1];
            left_post[j] = post[j];
        }
        
        for (int j = 0; j < L - i - 2;j++){
            right_pre[j] = pre[j + i + 2];
            right_post[j] = post[j + i + 1];
        }
        
        root.left = constructFromPrePost(left_pre,left_post);
        root.right = constructFromPrePost(right_pre,right_post);
        return root;
    }
}