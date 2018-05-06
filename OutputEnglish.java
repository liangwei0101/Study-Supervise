package µÚÆßÕÂ;

public class OutputEnglish extends OutputAlphabet {

	@Override
	public void output() {
    for(char c='a';c<='z';c++){
    System.out.printf("%3c",c);
    }
	}

}
