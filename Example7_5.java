package ������;

public class Example7_5 {

	public static void main(String[] args) {
		Bank bank = new Bank();
		try {
			bank.income(200, -100);
			bank.income(300, -100);
			bank.income(400, -100);
			System.out.printf("����Ŀǰ��%dԪ\n", bank.getMoney());
		} catch (BankException e) {
			System.out.println("������������г����������⣺");
			System.out.println(e.warnMess());
		}
		System.out.printf("����Ŀǰ��%dԪ", bank.getMoney());
	}

}
