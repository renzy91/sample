package algorithm.subStr;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-08 22:36
 */
public class KMP {
    public static void main(String[] args) {
        int[] next = next("ababcab".toCharArray());
        int i = indexOf("ababcab".toCharArray(), "ca".toCharArray());
        System.out.println(i);
    }

    public static int indexOf(char[] str, char[] ptr) {
        int[] next = next(ptr);

        int si = 0;
        int pi = 0;
        while(si < str.length && pi < ptr.length) {
            if (pi == -1 || str[si] == ptr[pi]) {
                si++;
                pi++;
            } else {
                pi = next[pi];
            }
        }

        return pi == ptr.length ? si - pi : -1;
    }

    //next值表示此位置冲突时 ptr需要回溯的位置
    public static int[] next(char[] ptr) {
        int[] next = new int[ptr.length];
        next[0] = -1;
        int prefix = -1;
        int suffix = 0;
        while (suffix < ptr.length - 1) {
            if (prefix == -1 || ptr[prefix] == ptr[suffix]) {
                prefix++;
                suffix++;
                next[suffix] = prefix;
            } else {
                prefix = next[prefix];
            }
        }

        return next;
    }
}
