package datastructure_algorithm;

/**
 * Created by Json Wan on 2017/11/6.
 */
public class Train2 {
    public static int array[] = new int[]{-1, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5, 2, 3, -1, 4, 5, 6, -6, -3, 8, 1, 1, 3, -9, -4, 5, 6, 7, -2, -1, 5};

    /**
     * 求最大子序列和
     *
     * @param a
     * @return
     */
    public static int maxSubSum1(int[] a) {
        System.out.println("array length=" + a.length);
        long startTime = System.currentTimeMillis();
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++)
                    thisSum += a[k];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        System.out.println("use time:" + (System.currentTimeMillis() - startTime) + "ms");
        return maxSum;
    }

    public static int maxSubSum2(int[] a) {
        System.out.println("array length=" + a.length);
        long startTime = System.currentTimeMillis();
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        System.out.println("use time:" + (System.currentTimeMillis() - startTime) + "ms");
        return maxSum;
    }

    /**
     * Recursive maximum contiguous subsequence sum algorithm.
     * Finds maximum sum in subarray spanning a[left..right].
     * Does not attempt to maintain actual best sequence.
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int maxSumRec(int[] a,int left,int right){
        if(left==right)//Base Case
        if(a[left]>0)
            return a[left];
        else
            return 0;
        int center=(left+right)/2;
        int maxLeftSum=maxSumRec(a,left,center);
        int maxRightSum=maxSumRec(a,center+1,right);

        //计算左边部分的边界最大序列和
        int maxLeftBorderSum=0,leftBorderSum=0;
        for(int i=center;i>=left;i--){
            leftBorderSum+=a[i];
            if(leftBorderSum>maxLeftBorderSum)
                maxLeftBorderSum=leftBorderSum;
        }
        //计算右边部分的边界最大序列和
        int maxRightBorderSum=0,rightBorderSum=0;
        for(int i=center+1;i<=right;i++){
            rightBorderSum+=a[i];
            if(rightBorderSum>maxRightBorderSum)
                maxRightBorderSum=rightBorderSum;
        }
        //最终最大序列和为左边、右边、左边界+右边界当中最大的一个
        int max=maxLeftSum>maxRightSum?maxLeftSum:maxRightSum;
        max=max>(maxLeftBorderSum+maxRightBorderSum)?max:(maxLeftBorderSum+maxRightBorderSum);
        return max;
    }

    /**
     * Driver for divide-and-conquer maximum contiguous subsequence sum algorithm.
     * @param a
     * @return
     */
    public static int maxSubSum3(int[] a){
        System.out.println("array length=" + a.length);
        long startTime = System.currentTimeMillis();
        int max=maxSumRec(a,0,a.length-1);
        System.out.println("use time:" + (System.currentTimeMillis() - startTime) + "ms");
        return max;
    }

    /**
     * Linear-time maximum contiguous subsequence sum algorithm.
     * @param a
     * @return
     */
    public static int maxSubSum4(int[] a){
        System.out.println("array length=" + a.length);
        long startTime = System.currentTimeMillis();
        int maxSum=0,thisSum=0;
        for(int j=0;j<a.length;j++){
            thisSum+=a[j];
            if(thisSum>maxSum)
                maxSum=thisSum;
            else if(thisSum<0)
                thisSum=0;
        }
        System.out.println("use time:" + (System.currentTimeMillis() - startTime) + "ms");
        return maxSum;
    }

    /**
     * Performs the standard binary search.
     * @param a
     * @param x
     * @param <AnyType>
     * @return index where item is found, or -1 if not found.
     */
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a,AnyType x){
        int low=0,high=a.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid].compareTo(x)<0)
                low=mid+1;
            else if(a[mid].compareTo(x)>0)
                high=mid-1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * 欧几里得算法求最大公因数，原理：gcd(a,b) = gcd(b,a mod b)
     * @param m
     * @param n
     * @return
     */
    public static long gcd(long m,long n){
        while(n!=0){
            long rem=m%n;
            m=n;
            n=rem;
        }
        return m;
    }
    public static void main(String[] args) {
//        System.out.println(maxSubSum1(array));
//        System.out.println(maxSubSum2(array));
//        System.out.println(maxSubSum3(array));
//        System.out.println(maxSubSum4(array));
        System.out.println(gcd(123456,223456));
    }
}
