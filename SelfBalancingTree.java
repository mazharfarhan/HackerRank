   /* Class node is defined as :
    class Node 
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child

   */

    // function to get the max height of the tree at the given node
   public static int heightMax(Node root) {
       
       int maxHeight = -1;
       
       if(root.left != null)
            maxHeight = Math.max(maxHeight, root.left.ht);
       
       if(root.right != null)
            maxHeight = Math.max(maxHeight, root.right.ht);
       
       return maxHeight;
       
   } 

   // function to insert new value in the AVL tree.
   static Node insert(Node root,int val)
    {
       
       
       // if this is the first node to be inserted.
       if(root == null) {
           Node node = new Node();
           node.val = val;
           node.left = node.right = null;
           node.ht = 0;
           return node;
       }
           
       // check where to insert the new value
       if(root.val > val )
            root.left = insert(root.left, val);
       else
            root.right = insert(root.right, val);
       
       int balanceFactor = balanceFactor(root);
       
       // when the balance factor is less than -1 . Right subtree is unbalanced.
       if(balanceFactor < -1) {
           
           // Balance factor of right subtree is greater than 0 then node added to left of right subtree.
           if(balanceFactor(root.right) > 0 ){
               
                 root.right = rotateRight(root.right);
                 root = rotateLeft(root);
                 return root;
               
           }
           // if balance factor is less then it means it is attached to the right of rightsubtree
           else {
                  return rotateLeft(root);
           }
            
       }
       else if(balanceFactor > 1) {
           
           if(balanceFactor(root.left) < 0) {
               
               root.left = rotateLeft(root.left);
               root = rotateRight(root);
               return root;
           }
           else{
               return rotateRight(root);
           }
           
       }
       
       root.ht = heightMax(root) + 1;
       return root;
    }


    public static Node rotateRight(Node x) {
        
        // get the left node first
        Node y = x.left;
        // Attach the right part of the left subtree to the left of the current root
        x.left = y.right;
        // attach the root the right of the left subtree.
        y.right = x;
        
        x.ht = heightMax(x) +1;
        y.ht = heightMax(y) + 1;
        
        return y;
        
    }
    
    public static Node rotateLeft(Node x) {
        
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        
        x.ht = heightMax(x) + 1;
        y.ht = heightMax(y) + 1;
        
        return y;
    }

    


    public static int balanceFactor(Node root){
        
        int left = -1;
        int right = -1;
        
        if(root.left != null)
               left = root.left.ht;
        
        if(root.right != null)
                right = root.right.ht;
        
        return (left - right);
    }

    
