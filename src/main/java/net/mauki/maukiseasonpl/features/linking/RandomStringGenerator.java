package net.mauki.maukiseasonpl.features.linking;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class RandomStringGenerator {

    /**
     * Generate a random string
     * @return A new string
     */
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String lower = upper.toLowerCase(Locale.ROOT);

    public static final String digits = "0123456789";

    public static final String alphanum = upper + lower + digits;

    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    /**
     * Initialise a new instance
     * @param length The length of the string
     * @param random A random instance (for randomising)
     * @param symbols The symbols that you want to use
     */
    public RandomStringGenerator(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    /**
     * Create an alphanumeric string generator
     * @param length The length of the string
     * @param random A random instance (for randomising)
     */
    public RandomStringGenerator(int length, Random random) {
        this(length, random, alphanum);
    }

    /**
     * Create an alphanumeric strings from a secure generator
     * @param length The length of the string
     */
    public RandomStringGenerator(int length) {
        this(length, new SecureRandom());
    }

}
