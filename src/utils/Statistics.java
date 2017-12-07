package utils;

public class Statistics {

    public static final byte PH_MIN_RANGE = 5;
    public static final byte PH_MAX_RANGE = 7;
    public static final byte P_MIN_RANGE = 20;
    public static final byte P_MAX_RANGE = 40;
    public static final byte CA_MIN_RANGE = 3;
    public static final byte CA_MAX_RANGE = 6;
    public static final byte NA_MIN_RANGE = 0;
    public static final byte NA_MAX_RANGE = 1;
    public static final byte K_MIN_RANGE = 0;
    public static final byte K_MAX_RANGE = 1;
    public static final byte FE_MIN_RANGE = 50;
    public static final byte FE_MAX_RANGE = 100;

    public boolean filterCrops(byte ph, byte p, byte ca, byte na, byte k, byte fe){
        boolean validator = false;
        int counter = 0;

        if (staticFilter(ph, PH_MIN_RANGE, PH_MAX_RANGE) &&
                staticFilter(p, P_MIN_RANGE, P_MAX_RANGE) &&
                    staticFilter(ca, CA_MIN_RANGE, CA_MAX_RANGE) &&
                        staticFilter(na, NA_MIN_RANGE, NA_MAX_RANGE) &&
                            staticFilter(k, K_MIN_RANGE, K_MAX_RANGE) &&
                                staticFilter(fe, FE_MIN_RANGE, FE_MAX_RANGE)){
            validator = true;
            counter++;
        }

        return validator;
    }

    public boolean staticFilter(byte element, byte minRange, byte maxRange){
        boolean validator = false;

        if (element >= minRange && element <= maxRange){
            validator = true;
        }

        return validator;
    }
}


