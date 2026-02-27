package family.vernam;

import family.util.StringToChar;
import java.util.List;
import java.util.Objects;


public final class Encryption extends Cryptography{
    final private String plainText;
    final private String keyText;
    private final StringBuffer cipherText;

    public Encryption(String plainText, String keyText) {
        super(plainText, keyText);
        if (plainText == null || plainText.isBlank() || keyText == null || keyText.isBlank()) {
            throw new IllegalArgumentException("\n\t\t\tBossing K*p** ka ba? kta mo wala kang nilagay na input, bala ka jan error ko to HAHAHA!!!");
        } else {
            cipherText = new StringBuffer(); 
            this.plainText = plainText;
            this.keyText = super.resolution();
            cryptography(this.plainText, this.keyText);
        }
    }

    public Encryption(Encryption source) {
        super(source.plainText, source.keyText);
        if (source.plainText == null || source.plainText.isBlank() || source.keyText == null || source.keyText.isBlank()) {
            throw new IllegalArgumentException("\n\t\t\tBossing K*p** ka ba? kta mo wala kang nilagay na input, bala ka jan error ko to HAHAHA!!!");
        } else {
            cipherText = new StringBuffer(); 
            this.plainText = source.plainText;
            this.keyText = super.resolution();
            cryptography(this.plainText, this.keyText);
        }
    }

    // private String encryptResolution(String plainText, String keyText) {
    //     if (plainText.length() > keyText.length()) {
    //         int noOfRepetition = (plainText.length() / keyText.length()) + 5;
    //         return keyText.repeat(noOfRepetition).substring(0,plainText.length());
    //     } else if (plainText.length() < keyText.length()) {
    //         return keyText.substring(0, plainText.length());
    //     } 
    //     return keyText;
    // }

    @Override
    protected void cryptography(String plainText, String keyText) {
        StringToChar listPlainText = new StringToChar(this.plainText);
        StringToChar listKeyText = new StringToChar(this.keyText);

        List<Character> newPlainText = listPlainText.getStrToChar();
        List<Character> newKeyText = listKeyText.getStrToChar();
        int length = newPlainText.size();
        
        while (length > 0) {
            length--;
            final int sum = (newPlainText.get(length) % 96) + (newKeyText.get(length) % 96);
            if (sum % 26 > 0) { 
                cipherText.append((char)(96 + (sum % 26))); 
            }  else {
                cipherText.append((char)122);
            }
        }
    }

    public final String getCipherText() {
        return new StringBuffer(cipherText).reverse().toString();
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Encryption)) {
            return false;
        }
        Encryption encryption = (Encryption) o;
        return Objects.equals(plainText, encryption.plainText) && Objects.equals(keyText, encryption.keyText) && Objects.equals(cipherText, encryption.cipherText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plainText, keyText, cipherText);
    }
   
}
