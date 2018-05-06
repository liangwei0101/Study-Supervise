package 第七章;

public class BankException extends Exception{
String message;
public BankException(int m,int n){
	message = "入账资金"+m+""+n+"";
}
public String warnMess(){
	return message;
}
}
