package ������;

public class CargoBoat {
int realContent;
int maxContent;
public void setMaxContent(int c){
	maxContent = c;
}
public void loading(int m) throws Danger{
	realContent += m;
	if(realContent>maxContent){
		realContent-=m;
		throw new Danger();
	}
	System.out.println("Ŀǰ�b�d��"+realContent+"��؛��");
}
}
