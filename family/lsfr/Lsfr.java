package family.lsfr;

import family.util.HexStringToInt;
import family.util.Separate32Bit;
import java.util.ArrayList;
import java.util.List;

public class Lsfr {
    final private String hex32bits;
    final private List<Integer> firstIntegers;
    final private List<Integer> secondIntegers;
    final private int rotation;

    private final List<Integer> firstIntClone;
    private final List<Integer> secondIntClone;

    public Lsfr(String hex32bits, int rotation) {
        this.hex32bits = hex32bits;
        this.rotation = rotation;

        HexStringToInt hexString = new HexStringToInt(this.hex32bits);
        Separate32Bit separateHexInt = new Separate32Bit(hexString.getHexIntegers());
        
        this.firstIntegers = separateHexInt.firstIntegers();
        this.secondIntegers = separateHexInt.secondIntegers();

        this.firstIntClone = performLsfrMethod1(rotation, this.firstIntegers);
        this.secondIntClone = performLsfrMethod1(rotation, this.secondIntegers);


    }
    
    private List<Integer> performLsfrMethod1(int rotation, List<Integer> intClone) {
        //int rotation1 = this.rotation;
        //final List<Integer> names = this.firstIntegers;     

        final List<Integer> insideIntClone= new ArrayList<>(intClone);  
        while (rotation-- > 0) {
        int firstHalf_lastBit = insideIntClone.get(15);
        insideIntClone.add(0, firstHalf_lastBit);
        insideIntClone.set(2, firstHalf_lastBit ^ insideIntClone.get(2));
        insideIntClone.set(3, firstHalf_lastBit ^ insideIntClone.get(3));
        insideIntClone.set(5, firstHalf_lastBit ^ insideIntClone.get(5));
        insideIntClone.remove(16);
        //System.out.println("rotate "+ rotation1 + ": " + firstIntClone + "  :  " + firstIntClone.getClass());
        }
        return insideIntClone;
    }

    // final private List<Integer> performLsfrMethod2(int rotation, List<Integer> intClone) {
    //     // int rotation2 = this.rotation;
    // // final List<Integer> secondIntClone = this.secondIntegers;
    //     while (rotation-- > 0) {
    //     int second_lastBit = secondIntClone.get(15);
    //     secondIntClone.add(0, second_lastBit);
    //     secondIntClone.set(2, second_lastBit ^ secondIntClone.get(2));
    //     secondIntClone.set(3, second_lastBit ^ secondIntClone.get(3));
    //     secondIntClone.set(5, second_lastBit ^ secondIntClone.get(5));
    //     secondIntClone.remove(16);

    //     }
    //     return secondIntClone;
    // }

    public void get() {
        System.out.println(firstIntClone);
        System.out.println(secondIntClone);
    }


    // I Put comment on LFSR.java as signed that I add something for me to commit on git



}
