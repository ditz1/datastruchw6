# datastruchw6

Implement a class called ExpressionTree in the provided ExpressionTree.java file. This class implements the ExpressionTreeInterface file. The constructor to ExpressionTree will take in only one String that contains a postfix expression. The operands will be integers and the operators will be restricted to +, -, *, and /. Individual tokens, that is, the operands and operators, will be delimited by only one space. So for example:

34 2 - 5 *

would mean (34-2)*5.

Your constructor will run the stack based algorithm we discussed in class to build an expression tree. In order to implement the ExpressionTree class, you will have to implement a static nested class called ExpressionNode, which will contain the implementation of the individual nodes that form an expression tree. You should use these nodes to represent the individual operators and operands. You may use any code posted on Canvas or from the Weiss textbook as a starting point for this assignment. For a stack data structure, you can use java.util.LinkedList.

Once you have the ExpressionTree constructed you should provide the following four methods as required by the interface as well as the constructor as specified below:

public int eval() - this method, when invoked on an expression tree object, will return the integer result of evaluating the expression tree. Your algorithm will need to call a private recursive method that takes in the root. Assume integer arithmetic at all times, including during division. Assume that no invalid arithmetic operations occur in the expression (e.g. no division by zero).

public String postfix() - this method, when invoked on an expression tree object, will return a String that contains the corresponding postfix expression. It will need to call a private recursive method that takes in the root. Each operator and operand must be delimited by only one space and there should be no extraneous white space on either ends of the String. Any deviations from these instructions, will result in a loss of points.

public String prefix() - this method, when invoked on an expression tree object, will return a String that contains the corresponding prefix expression. It will need to call a private recursive method that takes in the root. Each operator and operand must be delimited by only one space and there should be no extraneous white space on either ends of the String. Any deviations from these instructions, will result in a loss of points.

public String infix() - this method, when invoked on an expression tree object, will return a String that contains the corresponding correct infix expression. Keep in mind that parentheses will be needed (excessive parenthesis will be tolerated as long as they are correctly placed). It will need to call a private recursive method that takes in the root. Each operator and operand must be delimited by only one space and there should be no extraneous white space on either ends of the String. Any deviations from these instructions, will result in a loss of points.

public ExpressionTree(String expression) - this is the constructor of the expression tree. It will take in a String that stores a postfix expression (as indicated above). Build the expression tree from that postfix expression using the stack based algorithm here.

We will test this program with our own tester class in a separate file. You should also create a tester class for your own testing purposes - make sure to consider edge cases such as invalid postfix expression inputs to your constructor. Your tester class will not be graded.
