package ������;

public class Exaample7_2 {

	public static void main(String[] args) {
    ShowBoard board = new ShowBoard();
	board.showMess(new OutputEnglish());
	board.showMess(new OutputAlphabet()
			{public void output()
				{for(char c='��';c<='��';c++)
				System.out.printf("%1c",c);
				
				}	
			
			}		
			);
	}

}
