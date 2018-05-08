package algorithm.subStr;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-08 10:12
 */
public class BF {
    public static void main(String[] args) {
        String str = "abcdefg";
        String ptr = "fg";

        int i = indexOf(str.toCharArray(), ptr.toCharArray());
        System.out.println(i);
    }

    //文本串str 模式串ptr
   private static int indexOf(char[] str, char[] ptr) {
       int i = 0,j = 0;
       while (i < str.length && j < ptr.length) {
           if (str[i] == ptr[j]) {
                i++;
                j++;
           } else {
               i = i - j + 1;
               j = 0;
           }
       }

       if (j == ptr.length) {
           return i - j;
       }

       return -1;
   }
}
