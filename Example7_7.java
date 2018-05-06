package 第七章;

public class Example7_7 {

	public static void main(String[] args) {
    CargoBoat ship = new CargoBoat();
    ship.setMaxContent(1000);
    int m = 600;
    try{
    	ship.loading(m);
    	m=300;
    	ship.loading(m);
    	m=55;
    	ship.loading(m);
    	m=367;
    	ship.loading(m);
    }
    catch(Danger e){
    	System.out.println(e.warnMess());
    	System.out.println("無法再裝載重量是"+m+"噸的集裝箱");
    }
    finally{
    	System.out.println("貨船將正點起航");
    }
	}

}
