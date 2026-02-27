import family.lsfr.Lsfr;

public class LevelOne {
    public static void main(String[] args) {
        // String to char
        // StringToChar convert = new StringToChar("Hey");
        // //StringToChar trial = new StringToChar("HEY");
        // System.out.println(convert.getStrToChar());
        // StringToChar convert2 = convert;
        // StringToChar convert3 = new StringToChar(convert);
        // System.out.println(convert2.getStrToChar());
        
        // System.out.println(convert3.getStrToChar());

        // System.out.println(convert.equals(convert3));


        // Encryption
        // Encryption encrypt = new Encryption("abcdef","abc");
        // System.out.println("cipherText: " + encrypt.getCipherText());
        // Encryption encrypt2 = encrypt;
        // Encryption encrypt3 = new Encryption(encrypt);

        // // Decryption
        // Decryption decrypt = new Decryption(encrypt.getCipherText(), "abc");
        // System.out.println("plainText: " + decrypt.getPlainText());


        // LSFR
        Lsfr lsfr = new Lsfr("0123456789ABCDEF0123456789ABCDEF", 100);
        lsfr.get();
    }
}
