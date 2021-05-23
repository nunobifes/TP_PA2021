package pt.connect4.utils;

// https://en.wikipedia.org/wiki/Xorshift
// https://stackoverflow.com/questions/13213395/adjusting-xorshift-generator-to-return-a-number-within-a-maximum
// http://www.jstatsoft.org/v08/i14/paper
public class XORShiftRandom {

    private long last;
    private long inc;
    private int max;
    
    public XORShiftRandom() {
        this(System.nanoTime());
        this.max = Integer.MAX_VALUE;
    }

    public XORShiftRandom(int max) {
        this(System.nanoTime());
        this.max = max;
    }
    
    public XORShiftRandom(long seed) {
        this.last = seed | 1;
        inc = seed;
        this.max = Integer.MAX_VALUE;
    }

    public XORShiftRandom(long seed, int max) {
        this.last = seed | 1;
        inc = seed;
        this.max = max;
    }
    
    public int nextInt() {
        last ^= (last << 21);
        last ^= (last >>> 35);
        last ^= (last << 4);
        inc += 123456789123456789L;
        int out = (int) ((last+inc) % max);     
        return (out < 0) ? -out : out;
    }
    
    }
