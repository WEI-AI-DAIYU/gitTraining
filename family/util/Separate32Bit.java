package family.util;

import java.util.ArrayList;
import java.util.List;

public final class Separate32Bit {
    final private List<Integer> listIntegers;
    final private List<Integer> firstHalf;
    final private List<Integer> secondHalf;
    // final private List<Character> listCharacter;

    public Separate32Bit(List<Integer> listIntegers) {
        this.listIntegers = new ArrayList<>(listIntegers);
        this.firstHalf = firstHexInt(listIntegers);
        this.secondHalf = secondHexInt(listIntegers);
        //this.listCharacter = null;
    }

    // public Separate32Bit(List<Character> listCharacter) {
    //     //this.listIntegers = null;
    //     this.listCharacter = listCharacter;
    // }

    private List<Integer> firstHexInt(List<Integer> listIntegers) {
        return new ArrayList<>(listIntegers.subList(0, 16));
    }

    private List<Integer> secondHexInt(List<Integer> listIntegers) {
        return new ArrayList<>(listIntegers.subList(16, 32));
    }

    public final List<Integer> firstIntegers() {
        return firstHalf;
    }

    public final List<Integer> secondIntegers() {
        return secondHalf;
    }

}
