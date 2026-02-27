package family.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class HexStringToInt extends Convertion {
    final private String hexString;
    final private List<Integer> hexIntegers;

    public HexStringToInt(String hexString) {
        hexIntegers = new ArrayList<>();
        this.hexString = hexString;
        convertion(this.hexString);
    }

    public HexStringToInt(HexStringToInt source) {
        hexIntegers = new ArrayList<>();
        this.hexString = source.hexString;
        convertion(this.hexString);
    }

    @Override
    protected  void convertion(String hexString) {
        if (hexString == null || hexString.isBlank()) {
            throw new IllegalArgumentException("\n\t\tadik ka ba? Hindi puwedeng null o blank (space, tabs, etc) ang ilalagay mo!!!");
        } else {
            for (int i = 0; i < hexString.length(); i++) {
                int a = Integer.parseInt(String.valueOf(i), 16);
                hexIntegers.add(a);
            }
        }
    }

    public final List<Integer> getHexIntegers() {
        return new ArrayList<>(hexIntegers);
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HexStringToInt)) {
            return false;
        }
        HexStringToInt hexStringToInt = (HexStringToInt) o;
        return Objects.equals(hexString, hexStringToInt.hexString) && Objects.equals(hexIntegers, hexStringToInt.hexIntegers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hexString, hexIntegers);
    }
    
}

