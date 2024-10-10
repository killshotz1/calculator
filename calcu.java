import java.util.*;
public class calcu
{
	static boolean has;
    public static int oper(char ch, int left ,int right){
    	int result=0;
    	switch (ch){
    	case '/':
    		result = left/right;
    		break;
    	case '*':
    		result = left*right;
    		break;
    	case '+':
    		result = left+right;
    		break;
    	case '-':
    		result = left-right;
    		break;

    	}
    	return result;

    }
    public static String right(int i,String num){
    	String  right="";
    	for(;i<num.length();i++){
    	if(Character.isDigit(num.charAt(i))){
        		right+=num.charAt(i);
        	}
        else{
        	break;
        }
    }
    return right;
}
 static String total(String temp,String num,char op,int i){
	String n_num="";
	 int left=Integer.parseInt(temp);

        			 String righ=right(i+1,num);
        			int right=Integer.parseInt(righ);
        			int result=oper(op,left,right);
        			
        			n_num=num.substring(0,i-temp.length()+0)+result+num.substring(i+righ.length()+1);
        			        			System.out.println(n_num);
        			
        		has= num.matches(".*[+\\-*/].*");

if (!has) {
    System.out.println(num);
    System.exit(0);
}       			
        			return n_num;
        		}
        
        

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("enter ");
		String num=in.nextLine();//  36/6*9+3/3  6*9+1   
        long time=System.currentTimeMillis();
		String temp="";
		char op=' ';
		int right=0;
		int left=0;
		int i=0;
		char ch;
		String righ;
		int result;
		
		
        while(i<num.length()){
        	ch=num.charAt(i);
        	if(Character.isDigit(ch)){
        		temp+=ch;
        	}
        	else {
        		op=num.charAt(i);
        		if(op=='/'){
        			num=total(temp,num,op,i);
        			temp="";
        			left=0;
        			right=0;
        			i=0;
        			continue;
        			
        		}
        		else if(op=='*'&& num.indexOf('/')==-1){
        		num=total(temp,num,op,i);
        		temp="";
        			left=0;
        			right=0;
        			i=0;
        		continue;
        		}
        		
        		if(op=='+'&&num.indexOf("/")==-1 &&num.indexOf("*")==-1){
        			 num=total(temp,num,op,i);
        			 temp="";
        			left=0;
        			right=0;
        			i=0;
        			continue;
        		}
        		if(op=='-'&&num.indexOf("/")==-1 &&num.indexOf("*")==-1){
        			num=total(temp,num,op,i);
        			temp="";
        			left=0;
        			right=0;
        			i=0;
        			continue;
        		}
        		
        		temp="";
        	}
        	i++;
        	}
        	System.out.print("time--");
        	System.out.println(System.currentTimeMillis()-time );
        }
}

	
