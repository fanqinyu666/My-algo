package 代码随想录.字符串;

public class 反转字符串 {
    public static void main(String[] args) {
        反转字符串 反转字符串 = new 反转字符串();
        System.out.println(反转字符串.reverseStr1("abcdef", 2));
    }

    public String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = stringBuilder.reverse();
        return reverse.toString();
    }




    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int start = 0;

        for (int i = 0; i < length; i += 2 * k) {
            StringBuilder temp = new StringBuilder();
            if (i + k > length) {
                temp.append(s.substring(i));
                StringBuilder reverse = temp.reverse();
                sb.append(reverse);
            } else if (i + 2 * k > length && i + k < length) {
                temp.append(s.substring(i, i + k));
                StringBuilder reverse = temp.reverse();
                sb.append(reverse);
                sb.append(s.substring(i + k, length));
            } else {
                temp.append(s.substring(i, i + k));
                StringBuilder reverse = temp.reverse();
                sb.append(reverse);
                sb.append(s.substring(i + k, i + 2 * k));

            }
        }
        return sb.toString();

        /*while (start < length) {
            // 找到k处和2k处
            StringBuilder temp = new StringBuilder();
            // 与length进行判断，如果大于length了，那就将其置为length
            int firstK = (start + k > length) ? length : start + k;
            int secondK = (start + (2 * k) > length) ? length : start + (2 * k);

            //无论start所处位置，至少会反转一次
            temp.append(s.substring(start, firstK));
            res.append(temp.reverse());

            // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
            if (firstK < secondK) { //此时剩余长度一定大于k。
                res.append(s.substring(firstK, secondK));
            }
            start += (2 * k);
        }
        return res.toString();*/
    }

    public String reverseStr2(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int start = 0;

        for (int i = 0; i < length; i += 2 * k) {
            StringBuilder temp = new StringBuilder();
            if (i + k >= length) {
                temp.append(s.substring(i));
                StringBuilder reverse = temp.reverse();
                sb.append(reverse);
                continue;
            } else if (i + 2 * k > length && i + k < length) {
                temp.append(s.substring(i, i + k));
                StringBuilder reverse = temp.reverse();
                sb.append(reverse);
                sb.append(s.substring(i + k, length));
                continue;
            }

            temp.append(s.substring(i, i + k));
            StringBuilder reverse = temp.reverse();
            sb.append(reverse);
            sb.append(s.substring(i + k, i + 2 * k));


        }
        return sb.toString();
    }



    public String reverseStr1(String s, int k) {
        StringBuilder res = new StringBuilder();
        int index=0;
        while (index<s.length()){
            if(s.length()-index<k){
                String substring = s.substring(s.length()-index);
                String string = reverseString(substring);
                res.append(string);
                index+=k;
            }else if(k<=s.length()-index){
                int min = Math.min(k, s.length()-index-k);
                String substring = s.substring(index,index+k);
                String string = reverseString(substring);
                res.append(string);
                if(min==k){
                    res.append(s.substring(index+min,index+min+k));
                }else {
                    if(index+k<=s.length()-1) {
                        res.append(s.substring(index + k));
                    }
                }
                index+=4;
            }
        }
        return res.toString();
    }
}
