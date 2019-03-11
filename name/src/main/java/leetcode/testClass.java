package leetcode;

import java.io.*;
import java.util.*;

/**
 * @author linlang
 * @date 2019/3/1
 */
public class testClass {


    public static void main(String[] args) {

        letterCombinations("");

    }



    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //获取之前无重复字符串的下一位
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public static String reverseOnlyLetters(String S) {
        char chars[] = S.toCharArray();
        int i = S.length() - 1;
        int j = 0;
        while (j<i){
            boolean isCharacter_I = chars[i]>='a' && chars[i]<='z' || chars[i]>='A' && chars[i]<='Z';
            boolean isCharacter_J = chars[j]>='a' && chars[j]<='z' || chars[j]>='A' && chars[j]<='Z';
            if(isCharacter_I && isCharacter_J){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i--;
                j++;
            }else if(!isCharacter_J){
                j++;
            }else if(!isCharacter_I){
                i--;
            }
        }
        return new String(chars);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;



    }

    public static List<String> letterCombinations(String digits) {
        String []s = new String[digits.length()];
        List<String> result = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            switch (digits.charAt(i)){
                case '2':s[i]="abc";break;
                case '3':s[i]="def";break;
                case '4':s[i]="ghi";break;
                case '5':s[i]="jkl";break;
                case '6':s[i]="mno";break;
                case '7':s[i]="pqrs";break;
                case '8':s[i]="tuv";break;
                case '9':s[i]="wxyz";break;
            }
        }
        contactnums(s, result, 0, "");
        return  result;

    }

    public static void contactnums(String[] ss, List<String> result, int step, String s){
        if(ss.length == 0){
            return;
        }
        if(step == ss.length){
            result.add(s);
            return;
        }
        String num = ss[step];
        char[] chars = num.toCharArray();
        for(char code : chars){
            contactnums(ss, result, step+1, s+code);
        }

    }


    public static void generate(List<String> res , String ans, int count1, int count2, int n){

        if(count1 > n || count2 > n) return;

        if(count1 == n && count2 == n)  res.add(ans);


        if(count1 >= count2){
            String ans1 = new String(ans);
            generate(res, ans+"(", count1+1, count2, n);
            generate(res, ans1+")", count1, count2+1, n);

        }
    }




    private static boolean convertHtmlToPdf(String srcPath, String destPath) {
        File file = new File(destPath);
        File parent = file.getParentFile();
        // 如果pdf保存路径不存在，则创建路径
        if (!parent.exists()) {
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
        cmd.append("D:\\pdfdown\\wkhtmltox-0.12.5-1.mxe-cross-win64\\wkhtmltox\\bin\\wkhtmltopdf.exe");
        cmd.append(" ");
        cmd.append("--page-size A4");// 参数
        cmd.append(" ");
        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);
        boolean result = true;
        try {
            Process proc = Runtime.getRuntime().exec(cmd.toString());
            InputStream stream = proc.getInputStream();
            HtmlToPdfInter error = new HtmlToPdfInter(
                    proc.getErrorStream());
            HtmlToPdfInter output = new HtmlToPdfInter(
                    proc.getInputStream());
//            executors.execute(error);
//            executors.execute(output);
            error.start();
            output.start();
            proc.waitFor();

        } catch (Exception e) {
            result = false;
        }
        return result;
    }


    public static class HtmlToPdfInter extends Thread {
        private InputStream is;

        public HtmlToPdfInter(InputStream is) {
            this.is = is;
        }
        @Override
        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isr);
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
