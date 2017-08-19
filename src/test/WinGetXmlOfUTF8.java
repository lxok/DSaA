package test;

/**
 * Created by nick on 2017/5/20.
 */
public class WinGetXmlOfUTF8 {
    public int m1(int a) {
        return a;
    }

    public void m1(String s) {

    }

    public static void main(String[] args) throws Exception{
        int a = 0xff;
        byte b = (byte)a;
        System.out.println(b);
        int k = -1;
        int c = -1 & 0xff;
        System.out.println(c);
        System.out.println((int)b);

        char cs = 65535;
        int csi = (int)cs;
        System.out.println(csi);
    }
}
