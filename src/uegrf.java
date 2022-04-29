import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class uegrf {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://myip.ipip.net");
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            builder.append(next);
        }
        String s = builder.toString();

        int i = s.indexOf("：");
        int j=s.lastIndexOf(".");
        int e = 0;
        for (int k = j+2; k <= j+3; k++) {
            if (!isNum(String.valueOf(s.charAt(k)))) {
                e=k;
                break;
            }
        }
        System.out.println(builder);

        //====================分隔===================

        System.out.println(s.substring(i+1,e));

        int i1 = s.lastIndexOf("：");
        int i2=s.lastIndexOf("  ");
        String substring = s.substring(i1+1,i2);
        String[] s1 = substring.split(" ");
        for (String s2 : s1) {
            System.out.println(s2);
        }

        int i3=s.lastIndexOf("  ");
        System.out.println(s.substring(i3+2));

    }

    public static boolean isNum(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }


}