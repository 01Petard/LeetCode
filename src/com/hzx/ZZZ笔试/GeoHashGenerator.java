package com.hzx.ZZZ笔试;

public class GeoHashGenerator {

    public static final String ALPHABET = "0123456789bcdefghjkmnpqrstuvwxyz";
    private static final int BITS_IN_BYTE = 8;
    private static final int BASE32_LENGTH = 5; // Each base32 character represents 5 bits.

    public static String encode(double lat, double lon) {
        long latitudeBits = getBits(lat, -90, 90);
        long longitudeBits = getBits(lon, -180, 180);
        return base32Encode(merge(latitudeBits, longitudeBits));
    }

    private static long getBits(double value, double min, double max) {
        long bits = 0L;
        double range = max - min;
        for (int i = 0; i < 32; i++) { // 32 bits for each coordinate
            if (value > min + range / 2) {
                bits |= 1L << (31 - i);
                min += range / 2;
            } else {
                max -= range / 2;
            }
            range /= 2;
        }
        return bits;
    }

    private static long merge(long latitudeBits, long longitudeBits) {
        long mergedBits = 0L;
        for (int i = 0; i < 32; i++) {
            mergedBits <<= 1;
            mergedBits |= (latitudeBits >> (31 - i)) & 1;
            mergedBits <<= 1;
            mergedBits |= (longitudeBits >> (31 - i)) & 1;
        }
        return mergedBits;
    }

    private static String base32Encode(long bits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = (int) (bits & 0x1F); // Get the last 5 bits.
            sb.insert(0, ALPHABET.charAt(index));
            bits >>>= BASE32_LENGTH;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String encode = encode(52.2296756, 21.0122287);
        System.out.println(encode);
    }
}
