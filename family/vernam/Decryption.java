package family.vernam;

import family.util.StringToChar;
import java.util.List;
import java.util.Objects;

public final class Decryption extends Cryptography{
    final private String cipherText;
    final private String keyText;
    private final StringBuffer plainText;

    public Decryption(String cipherText, String keyText) {
        super(cipherText, keyText);
        if (cipherText == null || cipherText.isBlank() || keyText == null || keyText.isBlank()) {
            throw new IllegalArgumentException("\n\t\t\tBossing K*p** ka ba? kta mo wala kang nilagay na input, bala ka jan error ko to HAHAHA!!!");
        } else {
            plainText = new StringBuffer(); 
            this.cipherText = cipherText;
            this.keyText = super.resolution();
            cryptography(this.cipherText, this.keyText);
        }
    }

    public Decryption(Decryption source) {
        super(source.cipherText, source.keyText);
        if (source.cipherText == null || source.cipherText.isBlank() || source.keyText == null || source.keyText.isBlank()) {
            throw new IllegalArgumentException("\n\t\t\tBossing K*p** ka ba? kta mo wala kang nilagay na input, bala ka jan error ko to HAHAHA!!!");
        } else {
            plainText = new StringBuffer(); 
            this.cipherText = source.cipherText;
            this.keyText = super.resolution();
            cryptography(this.cipherText, this.keyText);
        }
    }

    // private String decryptResolution(String cipherText, String keyText) {
    //     if (cipherText.length() > keyText.length()) {
    //         int noOfRepetition = (plainText.length() / keyText.length()) + 5;
    //         return keyText.repeat(noOfRepetition).substring(0,plainText.length());
    //     } else if (plainText.length() < keyText.length()) {
    //         return keyText.substring(0, plainText.length());
    //     } 
    //     return keyText;
    // }

    @Override
    protected void cryptography(String cipherText, String keyText) {
        StringToChar listCipherText = new StringToChar(this.cipherText);
        StringToChar listKeyText = new StringToChar(this.keyText);

        List<Character> newCipherText = listCipherText.getStrToChar();
        List<Character> newKeyText = listKeyText.getStrToChar();
        int length = newCipherText.size();
        
        while (length > 0) {
            length--;
            int sum =  newCipherText.get(length) + 26 - newKeyText.get(length) + 96; // get() ginagamit para i access ung nth element ng List
            if (sum > 122) {
                plainText.append((char)(sum - 26));
            }  else if (sum <= 122) {
                plainText.append((char)sum);
            }
        }
    }

    public final String getPlainText() {
        return new StringBuffer(plainText).reverse().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Decryption)) {
            return false;
        }
        Decryption decryption = (Decryption) o;
        return Objects.equals(cipherText, decryption.cipherText) && Objects.equals(keyText, decryption.keyText) && Objects.equals(plainText, decryption.plainText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cipherText, keyText, plainText);
    }
    
    
}
