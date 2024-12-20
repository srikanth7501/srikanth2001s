class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
      Deque<TreeNode> dq = new ArrayDeque<>();
      dq.offerLast(root);
      int level = 0;
      while(!dq.isEmpty()){
        int n = dq.size();
          if(level%2 != 0){
             ArrayList<TreeNode> arr = new ArrayList<>();
             while(!dq.isEmpty()){
                arr.add(dq.pollFirst());
             }
             int i = 0 , j = arr.size()-1;
             while(i < j){
               int val = arr.get(i).val;
               arr.get(i).val = arr.get(j).val;
               arr.get(j).val = val;
               i++;
               j--;
             }
            for(int k= 0 ; k < n ; k++){
                dq.offerLast(arr.get(k));
            }
             

            
          }
                for(int i = 0 ; i< n ; i++){
                      TreeNode x = dq.pollFirst();
                      if(x.left != null){
                           dq.offerLast(x.left); 
                      }
                      if(x.right!= null){
                           dq.offerLast(x.right); 
                      }
                }

          
          level++;
      }  
      return root;  
    }
}
