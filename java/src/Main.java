import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Professor> Lists;
        String  filename="E:\\test.txt";
        Util.writefilecontent(filename);
        Lists = Util.readFileContent();
        double all = 0;

        for (Professor professor :Lists) {
          String st= professor.getSalary();
            all += Double.parseDouble(st);
        }

        double a = all;
    }
}
