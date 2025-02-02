package preProd;
import java.util.*;
class Main {

  public static void main(String[] args) {
    BinNode<Integer> t1 = new BinNode<Integer>(16);
    BinNode<Integer> t2 = new BinNode<Integer>(-14);
    BinNode<Integer> t3 = new BinNode<Integer>(12);
    BinNode<Integer> t4 = new BinNode<Integer>(-26);
    BinNode<Integer> t5 = new BinNode<Integer>(-30);
    BinNode<Integer> t6 = new BinNode<Integer>(1);
    BinNode<Integer> t7 = new BinNode<Integer>(19);
    BinNode<Integer> t8 = new BinNode<Integer>(100);
    t1.setLeft(t2);
    t1.setRight(t3);
    t2.setLeft(t4);
    t2.setRight(t5);
    t3.setLeft(t6);
    t3.setRight(t7);
    t4.setLeft(t8);
    BinNode<Integer> t11 = new BinNode<Integer>(4);
    BinNode<Integer> t12 = new BinNode<Integer>(2);
    BinNode<Integer> t13 = new BinNode<Integer>(5);
    BinNode<Integer> t14 = new BinNode<Integer>(-2);
    BinNode<Integer> t15 = new BinNode<Integer>(-1);

    t11.setLeft(t12);
    t11.setRight(t13);
    t12.setLeft(t14);
    t12.setRight(t15);

    
    
    

    BinNode<String> t = fromString("( ( ( a b c ) g null ) a ( null a b ) )");
    BinNode<Integer> t100 = fromString2("( ( ( 9 6 7 ) 1 6 ) 3 ( null 2 null ) )");
    System.out.println(t100);
  
    
//    System.out.println(t1);
//    postorderIfBelowZ(t1); 
//    printLeftChildren(t1); 
//    printLeftChildrenOrBelowZ(t1);
//    System.out.println(t);
//    preOrderChangeLetters(t);
//    System.out.println(t); 
    System.out.println(t1);
//    inOrderL(t1);
    inOrderdouble(t1);
    System.out.println(areAllElementsInT1(t1,t11)); 
    System.out.println(ifEtzOkev(t11,6));  
    System.out.println(IfTSymmetrical(t100));
//    System.out.println(maxNumInT(t11)); 
//    System.out.println(minNumInT(t11));
//    System.out.println(maxNumInT(t11)-minNumInT(t11));
//    System.out.println(differenceInT(t11));
//    System.out.println(sumNegativeNum(t11)); 
//    System.out.println(t11);
//    System.out.println(getHeight(t11));
//    System.out.println(ifTShalem(t11)); 
    System.out.println(ifMeuzanBoys(t100));


  }
  

  public static BinNode<Integer> fromString2(String s) {
		StringTokenizer tokenizer = new StringTokenizer(s);
		return fromString2(tokenizer);
	}


	/* Construct from in-order with brackets */
	public static BinNode<Integer> fromString2(StringTokenizer tokenizer) {
		if (!tokenizer.hasMoreElements())
			return null;
		String s = tokenizer.nextToken();
		if (s.equals("null"))
			return null;
		if (s.equals("(")) {
			BinNode<Integer> left = fromString2(tokenizer);
			s = tokenizer.nextToken();
			Integer value = Integer.valueOf(s);
			BinNode<Integer> right = fromString2(tokenizer);
			s = tokenizer.nextToken();
			if (!s.equals(")"))
				System.out.println("Note: missing ')'");
			return new BinNode<Integer>(left, value, right);
		}
		return new BinNode<Integer>(Integer.valueOf(s));
	}
	
	/* Construct from in-order with brackets */
	public static BinNode<String> fromString(String s) {
		StringTokenizer tokenizer = new StringTokenizer(s);
		return fromString(tokenizer);
	}

  
	/* Construct from in-order with brackets */
	public static BinNode<String> fromString(StringTokenizer tokenizer) {
		if (!tokenizer.hasMoreElements())
			return null;
		String s = tokenizer.nextToken();
		if (s.equals("null"))
			return null;
		if (s.equals("(")) {
			BinNode<String> left = fromString(tokenizer);
			s = tokenizer.nextToken();
			String value = String.valueOf(s);
			BinNode<String> right = fromString(tokenizer);
			s = tokenizer.nextToken();
			if (!s.equals(")"))
        System.out.println("Note: missing ')'");
			return new BinNode<String>(left, value, right);
		}
		return new BinNode<String>(String.valueOf(s));
	}

  public static void preOrder(BinNode<Integer> t) {
    if (t != null) {
      System.out.println(t.getValue());
      preOrder(t.getLeft());
      preOrder(t.getRight());
    }
  }
  public static <T> void inOrder(BinNode<T> t) {
    if (t != null) {
      inOrder(t.getLeft());
      System.out.println(t.getValue());
      inOrder(t.getRight());
    }
  }
  public static void postorder(BinNode<Integer> t) {
      if (t == null) 
    	  return;

      // בקר בתת-העץ השמאלי
      postorder(t.getLeft());

      // בקר בתת-העץ הימני
      postorder(t.getRight());
     System.out.print(t.getValue() + " ");
  }
  
  public static void postorderIfBelowZ(BinNode<Integer> t) {
      if (t == null) 
    	  return;

      // בקר בתת-העץ השמאלי
      postorderIfBelowZ(t.getLeft());

      // בקר בתת-העץ הימני
      postorderIfBelowZ(t.getRight());
      if(t.getValue()<0)
    	  System.out.print(t.getValue() + " ");
  }
  public static void printLeftChildren(BinNode<Integer> t) {
      if (t == null) 
    	  return;

      // אם קיים בן שמאלי, הדפס אותו
      if (t.getLeft() != null) {
          System.out.println(t.getLeft().getValue());
      }

      // עבור לתת-העץ השמאלי
      printLeftChildren(t.getLeft());

      // עבור לתת-העץ הימני
      printLeftChildren(t.getRight());
  }
  public static void printLeftChildrenOrBelowZ(BinNode<Integer> t) {
      if (t == null) 
    	  return;
      if (t.getValue()>0)
    	  preOrderAboveZ(t);
      if (t.getValue()<0)
    	  printLeftChildren(t);
  }
  public static void preOrderAboveZ (BinNode<Integer> t) {
	  if (t != null) {
		  if (t.getValue()>0)
			  System.out.println(t.getValue());
		  preOrderAboveZ(t.getLeft());
		  preOrderAboveZ(t.getRight());
  }
  }
 public static void preOrderChangeLetters (BinNode<String> t) {
		  if (t != null) {
			  char c = t.getValue().charAt(0);
			  int l = c+1;
			  if (t.getValue()=="z")
				  t.setValue("a");
			  else
				  t.setValue((new Character((char) l).toString()));
			  preOrderChangeLetters(t.getLeft());
			  preOrderChangeLetters(t.getRight());
	  }
  }
	  public static <T> void inOrderL(BinNode<T> t) {
		    if (t != null) {
		    	inOrderL(t.getLeft());
		    	if (!t.hasLeft() && !t.hasRight())
		    		System.out.println(t.getValue());
		      inOrderL(t.getRight());
		    }
		  }
	  public static void inOrderdouble(BinNode<Integer> t) {
		    if (t != null) {
		    	inOrderdouble(t.getLeft());
		    	if (t.hasLeft()&& t.hasRight()&& t.getValue()%2==0 && t.getLeft().getValue()%2==0 && t.getRight().getValue()%2==0)
		    		System.out.println(t.getValue());
		    	else if (!t.hasLeft() && !t.hasRight() && t.getValue()%2==0)
		    		System.out.println(t.getValue());
		    	inOrderdouble(t.getRight());
		    }
		  }
		  public static int preOrderCount(BinNode<Integer> t) {
			  if (t==null)
				  return 0;
			  int c=0;
			  if (t.getValue()<0)
				  c=1;
			  int cLeft = preOrderCount(t.getLeft());
			  int cRight = preOrderCount(t.getRight());
			  return c+cLeft+cRight;
			  
		  }
		  public static int preOrderBiggerThenN1AndSmallerThenN2(BinNode<Integer> t, int n1, int n2) {
			  if (t==null)
				  return 0;
			  int c=0;
			  if (t.getValue()>=n1 && t.getValue()<=n2)
				  c=1;
			  int cLeft = preOrderBiggerThenN1AndSmallerThenN2(t.getLeft(), n1,n2);
			  int cRight = preOrderBiggerThenN1AndSmallerThenN2(t.getRight(),n1,n2);
			  return c+cLeft+cRight;
			  
		  }
		  public static <T> int inOrderCountAlim(BinNode<T> t) {
			  if (t == null) 
				  return 0;
			    	
			  int c=0;
			  if (!t.hasLeft() && !t.hasRight())
				  c=1;
			  int cLeft = inOrderCountAlim(t.getLeft());
			  int cRight = inOrderCountAlim(t.getRight());
			  return c+cLeft+cRight;
			  
		  }
	  public static int preOrderCountS(BinNode<Integer> t) {
			  if (t==null)
				  return 0;
			  int c=0;
			  if (t.hasLeft() && t.hasRight()) {
				  if (t.getLeft().hasLeft()|| t.getRight().hasRight() && t.getRight().hasLeft()|| t.getLeft().hasRight())
				  c=1;
			  }
			  int cLeft = preOrderCountS(t.getLeft());
			  int cRight = preOrderCountS(t.getRight());
			  return c+cLeft+cRight;
			  
		  }
	  public static boolean areAllElementsInT1(BinNode<Integer> t1, BinNode<Integer> t2) { //18
	        return areAllElementsInT1Helper(t1, t2);
	    }

	    public static boolean areAllElementsInT1Helper(BinNode<Integer> t1, BinNode<Integer> t2) {
	        if (t2 == null) {
	            return true;
	        }
	        if (!isElementInTree(t1, t2.getValue())) {
	            return false;
	        }
	        return areAllElementsInT1Helper(t1, t2.getLeft()) && areAllElementsInT1Helper(t1, t2.getRight());
	    }

	    public static boolean isElementInTree(BinNode<Integer> root, Integer value) {
	        if (root == null) {
	            return false;
	        }
	        if (root.getValue().equals(value)) {
	            return true;
	        }
	        return isElementInTree(root.getLeft(), value) || isElementInTree(root.getRight(), value);
	    }

	    public static boolean ifEtzOkev(BinNode<Integer> t, int n) { //20
	    	BinNode<Integer> p = t;
	    	int k=1;
	    	while (k!=n) {
	    		if (HowManyTimesNumIsInT(p,k)!=1)
	    			return false;
	    		p=t;
	    		
	    		k+=1;
	    	}
	    	if (!checkIfAllTheNumsInTIsInNRange(p,n))
	    		return false;
	    	
	    	return true;
	    	
	    }
	    public static int HowManyTimesNumIsInT(BinNode<Integer> t, int n) {
	    	 if (t == null) 
				  return 0;
			    	
			  int c=0;
			  if (t.getValue()==n)
				  c=1;
			  int cLeft = HowManyTimesNumIsInT(t.getLeft(), n);
			  int cRight = HowManyTimesNumIsInT(t.getRight(), n);
			  return c+cLeft+cRight;
	    }
	    public static boolean checkIfAllTheNumsInTIsInNRange (BinNode<Integer> t, int n) {
	    	if (t == null) 
				  return true;
	    	if (!checkIfInRangN(t.getValue(),n))
	    		return false;
	    	
	    	 return checkIfAllTheNumsInTIsInNRange(t.getLeft(), n) && checkIfAllTheNumsInTIsInNRange(t.getRight(), n);
	    }
	    public static boolean checkIfInRangN(int nFromT, int n) {
	    	for(int i=1; i<n; i++) {
	    		if (nFromT==i)
	    			return true;
	    	}
	    	return false;
	    }
	    
	    

	    public static boolean IfTSymmetrical(BinNode<Integer> t) { //21
	    	if (t == null) 
	    		return true;
	  		  if (t.hasLeft()&& t.hasRight() && !IfTSymmetricalHelper(t))
	  			  return false;
	  		return IfTSymmetrical(t.getLeft()) && IfTSymmetrical(t.getRight());
	    
	    	
	    }
	    public static boolean IfTSymmetricalHelper(BinNode<Integer> t) {
	    	BinNode<Integer> p = t;
	    	int leftHeight = getHeight(p.getLeft());
	    	p=t;
	    	int rightHeight = getHeight(p.getRight());
	    	if (Math.abs(leftHeight-rightHeight)>1)
	    		return false;
	    	return true;
	    }
	    public static int maxNumInT(BinNode<Integer> t) {//23
	        if (t == null) 
	            return Integer.MIN_VALUE; 

	        int leftMax = maxNumInT(t.getLeft()); 
	        int rightMax = maxNumInT(t.getRight()); 

	        return Math.max(t.getValue(), Math.max(leftMax, rightMax)); 
	    }
	    public static int minNumInT(BinNode<Integer> t) {//23
	        if (t == null) 
	            return Integer.MAX_VALUE; 

	        int leftMin = minNumInT(t.getLeft()); 
	        int rightMin = minNumInT(t.getRight()); 

	        return Math.min(t.getValue(), Math.min(leftMin, rightMin)); 
	    }
	    public static int differenceInT(BinNode<Integer> t) {//19
	    	BinNode<Integer> p = t;
	    	int positiveNumSum = sumPositiveNum(p);
	    	p=t;
	    	int negativeNumSum = sumNegativeNum(p);
	    	p=t;
	    	if (positiveNumSum>negativeNumSum)
	    		return positiveNumSum-negativeNumSum;
	    	else
	    		return positiveNumSum-negativeNumSum;
	    }
	    public static int sumPositiveNum(BinNode<Integer> t) {
	    	if (t == null) 
	      	  return 0;
	    	int n = 0;
	    	if (t.getValue()>0)
	    		n = t.getValue();

	    	return sumPositiveNum(t.getLeft()) + sumPositiveNum(t.getRight()) + n;
	    }
	    
	    public static int sumNegativeNum(BinNode<Integer> t) {
	    	if (t == null) 
		      	  return 0;
		    	int n = 0;
		    	if (t.getValue()<0)
		    		n = Math.abs(t.getValue());

		    	return sumNegativeNum(t.getLeft()) + sumNegativeNum(t.getRight()) + n;
	    }
	    public static boolean ifTShalem(BinNode<Integer> t) {//26
	    	BinNode<Integer> p = t;
	    	int heightT = getHeight(t);
	    	int numAlim = countAlim(t);
	    	if ((int)Math.pow(2, heightT)==numAlim)
	    		return true;
	    	return false;
	    }
	    public static int getHeight(BinNode<Integer> root) {//27
	        if (root == null)
	            return -1; 

	        int leftHeight = getHeight(root.getLeft());
	        int rightHeight = getHeight(root.getRight());

	        return Math.max(leftHeight, rightHeight) + 1;
	    }
	    public static int countAlim (BinNode<Integer> t) {
	    	if (t == null) 
		      	  return 0;
		    	int n = 0;
		    	if (!t.hasLeft() && !t.hasRight())
		    		n = 1;

		    	return sumNegativeNum(t.getLeft()) + sumNegativeNum(t.getRight()) + n;
	    }
	    
	    public static boolean ifMeuzanBoys (BinNode<Integer> t) {
	    	if (t == null) 
		      	  return true;

		    	if (!((t.hasLeft() && t.hasRight()) || (!t.hasLeft() && !t.hasRight())))
		    		return false;

		    	return ifMeuzanBoys(t.getLeft()) && ifMeuzanBoys(t.getRight());
	    }
	    
	    
	    
}
