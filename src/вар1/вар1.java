package вар1;
import java.io.*;
import java.util.Scanner;

public class вар1 {
    public static void main(String[] args) throws IOException {
        DataOutputStream wr = null;
        DataInputStream rd = null;
        DataInputStream rd2 = null;
        File f2 = null;
        try {
            File f1 = new File("numbers.txt");
            f1.createNewFile();
            Scanner sc = new Scanner(System.in, "cp1251");
            wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));

            System.out.println("Введите количество чисел:");
            int count = sc.nextInt();

            System.out.println("Введите числа:");
            for (int i = 0; i < count; i++)
                wr.writeInt(sc.nextInt());

            f2 = new File("results.txt");
            if (f2.exists()) f2.delete();
            f2.createNewFile();

            rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));

            int numNotDivideTwo = 0;
            try {
                while(true) {
                    numNotDivideTwo = rd.readInt();
                    if (numNotDivideTwo%2 == 0) {
                        wr.writeInt(numNotDivideTwo);
                        System.out.println("Number: " + numNotDivideTwo);
                    }
                }
            }  finally {
                wr.flush();
                wr.close();
                rd.close();
            }
        } catch (IOException e) {
            System.out.println("End of File");
        }
    }
}
