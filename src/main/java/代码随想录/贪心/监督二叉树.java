package 代码随想录.贪心;

public class 监督二叉树 {
    int result=0;
    public int minCameraCover(TreeNode root) {
        int res = test(root);
        if(res==0){
            result++;
        }//最后一个情况
        return result;
    }


    public int test(TreeNode root) {
        if(root==null){
            return 2;
        }
        int left = test(root.left);
        int right= test(root.right);
        // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
        if(left==2&&right==2){
            return 0;
        }else if(left==0||right==0){
            // 左右节点都是无覆盖状态,那 根节点此时应该放一个摄像头
            // (0,0) (0,1) (0,2) (1,0) (2,0)
            // 状态值为 1 摄像头数 ++;
            result++;
            return 1;
        }else {
            // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
            // 那么本节点就是处于被覆盖状态
            return 2;
        }

    }

}
