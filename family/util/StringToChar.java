package family.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class StringToChar {
    private final String text;
    private final List<Character> textConverted;  // pag ginawa ko tong static, pag dinebug di makikita sa Main class or kung saan mo siya ni ra run

    public StringToChar(String text) {
        textConverted = new ArrayList<>();
        this.text = text;
        convertion(this.text);
    }

    public StringToChar(StringToChar source) {
        textConverted = new ArrayList<>();
        this.text = source.text;
        convertion(this.text);
    }

    protected void convertion(String text) {       // private setter.... I mean change it to private setter then remove the extends,  since it's not really neccesary
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("\n\t\tadik ka ba? Hindi puwedeng null o blank (space, tabs, etc) ang ilalagay mo!!!");
        } else {
            for (int i = 0; i < text.length(); i++) {
                textConverted.add(text.charAt(i));
            }
        }
    }

    public final List<Character> getStrToChar() {
        return new ArrayList<>(textConverted);
    }

    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StringToChar)) {
            return false;
        }
        StringToChar stringToChar = (StringToChar) o;
        return Objects.equals(text, stringToChar.text) && Objects.equals(textConverted, stringToChar.textConverted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, textConverted);
    }

}
