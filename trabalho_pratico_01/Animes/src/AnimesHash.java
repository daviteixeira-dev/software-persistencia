import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;

public class AnimesHash {
    public static void main(String[] args) throws Exception {
        String arquivo, hexa;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo: ");
        arquivo = scanner.nextLine();
        
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(arquivo.getBytes(),0,arquivo.length());
        byte[] digest = md.digest();
        hexa = new BigInteger(1,digest).toString(16);
        System.out.println("A hash SHA-1 do arquivo é : "+ hexa);

        scanner.close();
    }
}
