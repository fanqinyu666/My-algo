package 其他算法.其他.二次尝试;

import java.util.*;

public class llls {
    //前序
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            arrayList.add(pop.val);
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
        }
        return arrayList;
    }//中左右


    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            arrayList.add(pop.val);
            if (pop.left != null) {
                stack.add(pop.left);
            }
            if (pop.right != null) {
                stack.add(pop.right);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }//左右中=中右左（fan）


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        deque.addLast(root);
        int sum = 1;
        while (!deque.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (sum > 0 || !deque.isEmpty()) {
                TreeNode pop = deque.removeFirst();
                sum--;
                if (pop.right != null) {
                    deque.addLast(pop.right);
                }
                if (pop.left != null) {
                    deque.addLast(pop.left);
                }
                arrayList.add(pop.val);
            }
            sum = deque.size();
            res.add(arrayList);
        }
        return res;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public int maxContainers(int n, int w, int maxWeight) {
        int max = n * n * w;
        int min = Math.min(max, maxWeight);
        int i = min / w;
        return i;
    }


    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean one = check(p.left, q.right);
        boolean two = check(p.right, q.left);
        boolean t = p.val == q.val;
        return one && two && t;

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = minDepth(node.left);
        int right = minDepth(node.right);
        if (node.left == null && node.right != null) return right++;
        if (node.left != null && node.right == null) return left++;
        return Math.min(left, right) + 1;
    }


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int i = 0;
        while (left != null) {
            left = left.left;
            i++;
        }
        int j = 0;
        while (right != null) {
            right = right.right;
            j++;
        }

        if (i == j) {
            return (2 << i) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> ints = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        for (Map.Entry entry : map.entrySet()) {
            int[] a = new int[2];
            a[0] = (int) entry.getKey();
            a[1] = (int) entry.getValue();
            if (ints.size() < k) {
                ints.add(a);
            } else {
                if ((int) entry.getValue() > ints.peek()[1]) {
                    ints.poll();
                    ints.add(a);
                }
            }
        }
        int[] ints1 = new int[k];
        for (int i = k - 1; i > 0; i--) {
            int[] poll = ints.poll();
            ints1[i] = poll[0];
        }
        return ints1;


    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        if (left == -1) return -1;
        int right = getHeight(root.right);
        if (right == -1) return -1;

        int i = left - right;
        if (Math.abs(i) > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }

    public List<Integer> s(TreeNode node) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        c(arrayList, node);
        return arrayList;
    }

    public void c(ArrayList arrayList, TreeNode root) {
        if (root == null) {
            return;
        }
        arrayList.add(root.val);
        c(arrayList, root.left);
        c(arrayList, root.right);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList();
        deque.addLast(root);
        int sum = 1;
        while (!deque.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < sum; i++) {
                TreeNode treeNode = deque.removeFirst();
                arrayList.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.add(treeNode.right);
                }
            }
            lists.add(arrayList);
            sum = deque.size();
        }
        return lists;
    }



    public String[] ChaiFen(String str,String fuhao){
        ArrayList<String> list = new ArrayList<>();
        while (str.indexOf(fuhao)!=-1){
            int i = str.indexOf(fuhao);
            int length = fuhao.length();
            list.add(str.substring(0,i));
            str=str.substring(i+length);
        }
        list.add(str);
        String[] strings = new String[list.size()];
        for (int i = 0; i <strings.length ; i++) {
            strings[i]=list.get(i);
        }
        return strings;
    }
    public String HeBin2(ArrayList<String> strs,String fuhao){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strs.size()-1; i++) {
            String str = strs.get(i);
            list.add(str);
            list.add(fuhao);
        }
        list.add(strs.get(strs.size()-1));
        String string = list.toString();
        return string;
    }







}
