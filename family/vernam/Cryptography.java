package family.vernam;

// walang kwenta sa part na to, pero wala lang trip ko lang lagay hahahaha
public abstract class Cryptography {
    private final String text;
    private final String keyText;

    public Cryptography(String text, String keyText) {
        this.text = text;
        this.keyText = keyText;
    }
    abstract protected void cryptography(String text, String keyText);

    protected final String resolution() {
        if (text.length() > keyText.length()) {
            int noOfRepetition = (text.length() / keyText.length()) + 5;
            return keyText.repeat(noOfRepetition).substring(0,text.length());
        } else if (text.length() < keyText.length()) {
            return keyText.substring(0, text.length());
        } 
        return keyText;
    }
}
