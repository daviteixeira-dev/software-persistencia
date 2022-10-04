import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.zip.ZipOutputStream;

public class ConverterZip {
    public static void main(String[] args) throws IOException {

        int count = 0;
        int buffer = 4096;
        byte[] data = new byte[buffer];
        
        System.out.print("Qual arquivo você deseja compactar? ");
        Scanner scanner = new Scanner(System.in);
        String arquivo = scanner.nextLine();

        FileOutputStream inputFile = new FileOutputStream(new File("animes.zip"));
        ZipOutputStream outputFile = new ZipOutputStream(new BufferedOutputStream(inputFile));

        File file = new File(arquivo);
        FileInputStream input = new FileInputStream(arquivo);

        BufferedInputStream origem = new BufferedInputStream(input, buffer);
        ZipEntry entryZip = new ZipEntry(file.getName());
        outputFile.putNextEntry(entryZip);

        while ((count = origem.read(data, 0, buffer)) != -1) {
            outputFile.write(data, 0, count);
        }

        origem.close();
        scanner.close();
        outputFile.close();
    }
}
