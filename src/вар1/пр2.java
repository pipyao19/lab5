package вар1;

        import java.io.*;
        import java.net.URL;

public class пр2 {
    public static void main (String[]args) throws IOException {
        try {
// С потоком связан файл
            InputStream inFile = new FileInputStream("C:\\Users\\user\\Documents\\MyFile2.txt");
            readAllBytes(inFile);
            System.out.print("\n\n\n");
            inFile.close();
// С потоком связана интернет-страница
            InputStream inUrl = new URL("http://google.com").openStream();
            readAllBytes(inUrl);
            System.out.print("\n\n\n");
            inUrl.close();
// С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[]{7, 9, 3, 7, 4});
            readAllBytes(inArray);
            System.out.print("\n\n\n");
            inArray.close();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
    // Метод для чтения данных из потока по байтам с выводом
    public static void readAllBytes(InputStream in) throws IOException {
        while (true) {
            int oneByte = in.read(); // читает 1 байт
            if (oneByte != -1) { // признак отсутствия конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + "end");
                break;
            }
        }
    }
}