package ������;

public class BankException extends Exception{
String message;
public BankException(int m,int n){
	message = "�����ʽ�"+m+""+n+"";
}
public String warnMess(){
	return message;
}
}
