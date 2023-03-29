import java.util.LinkedList;

public class PracticeTree implements PracticeTreeInterface{
    public String test2 = "test2";
    public String test3 = "test3";

    public Tree root;

    public PracticeTree(String postfix){
        Tree right;
        Tree left;
        String[] split = postfix.split(" ");
        LinkedList<Tree> NodeList = new LinkedList<Tree>();
        
        //now have to read through input string
        for(int i = 0; i<split.length;i++){
            
            //means it is an int
            if(!isOperator(split[i])){
                //int leaves will not have children so we can just make them null
                right = null;
                left = null;
                Tree Operand = new Tree(split[i], left, right);
                NodeList.push(Operand);
            } else {
            // is operator so have to create subtree for operator
                right = NodeList.pop();   //DUMB COMPUTER
                left = NodeList.pop();

                Tree subTree = new Tree(split[i], left, right);
                NodeList.push(subTree);
                this.root = subTree;
            }
        }
    }


    /*public String test = "test";
    public String test1 = "test1";
    public String test2 = "test2";
    public String test3 = "test3";*/


    public static class Tree{

        public String current;
        public Tree left;
        public Tree right;

        public Tree(String current, Tree left, Tree right){

            this.current = current;
            this.left = left;
            this.right = right;

        }
    }

    
    
    public int eval(){
        //this will return a parsed int from eval()
        return eval(root);  
    }
    private static int eval(Tree t){
        String node = t.current;
        //dumbass recursion computer thing
        //returns eval, but eval is actually passing in Tree of parameter t, so the node becomes t.left and t.right so yes the parse int "node" still works
        //this is actually just the evaluation of the tree to return a whole number
        if(node.equals("+")){
            return (eval(t.left) + eval(t.right));
        } else if(node.equals("-")){
            return(eval(t.left) - eval(t.right));
        } else if(node.equals("*")){
            return(eval(t.left) * eval(t.right));
        } else if(node.equals("/")){
            return(eval(t.left) / eval(t.right));
        }
        Integer parsed = Integer.parseInt(node);
        return parsed;
    }
    
    
    
    public String postfix(){
        return postfix(root);
        
    }

    public static String postfix(Tree t){
        String node = t.current;
        
        StringBuilder buildFix = new StringBuilder();
        
        if(node.equals("+")){
            return buildFix.append(postfix(t.left) + " " + postfix(t.right) + " " + "+").toString();
        }else if(node.equals("-")){
            return buildFix.append(postfix(t.left) + " " + postfix(t.right) + " " + "-").toString();
        }else if(node.equals("*")){
            return buildFix.append(postfix(t.left) + " " + postfix(t.right) + " " + "*").toString();
        }else if(node.equals("/")){
            return buildFix.append(postfix(t.left) + " " + postfix(t.right) + " " + "/").toString();
        }else{ 
            return node;
        }
    }
    
    public boolean isOperator(String split){
        
        if(split.equals("+") ||split.equals("-") ||split.equals("*") || split.equals("/")){
            return true;
       }else { 
            return false;
        }
    }

    public String prefix(){

        return prefix(root);
    }
    public static String prefix(Tree t){
        String node = t.current;
        
        StringBuilder buildFix = new StringBuilder();
        
        if(node.equals("+")){
            return buildFix.append( "+" +" "+ prefix(t.left) + " " + prefix(t.right)).toString();
        }else if(node.equals("-")){
            return buildFix.append("-" + " "+ prefix(t.left) + " " + prefix(t.right)).toString();
        }else if(node.equals("*")){
            return buildFix.append("*" + " "+ prefix(t.left) + " " + prefix(t.right)).toString();
        }else if(node.equals("/")){
            return buildFix.append("/" + " " + prefix(t.left) + " " + prefix(t.right)).toString();
        }else{ 
            return node;
        }
    }

    public String infix(){

        return infix(root);
    }
    public static String infix(Tree t){
        String node = t.current;
        
        StringBuilder buildFix = new StringBuilder();
        
        if(node.equals("+")){
            return buildFix.append("(" + infix(t.left)+ " " + "+" + " " + infix(t.right) + ")").toString();
        }else if(node.equals("-")){
            return buildFix.append("(" + infix(t.left)+ " " + "-" + " " + infix(t.right) + ")").toString();
        }else if(node.equals("*")){
            return buildFix.append(infix(t.left)+ " " + "*" + " " + infix(t.right)).toString();
        }else if(node.equals("/")){
            return buildFix.append(infix(t.left)+ " " + "/" + " " + infix(t.right)).toString();
        }else{ 
            return node;
        }
    }
  
    public static void main(String args[]){
    //String expression = "34 2 - 5 *";
    PracticeTree newTree = new PracticeTree("24 5 + 8 * ");
    System.out.println(newTree.eval());
    System.out.println(newTree.postfix());
    System.out.println(newTree.infix());
    System.out.println(newTree.prefix());
    }
}