package third;

import java.util.Arrays;
import java.util.HashSet;

public class StringArray {
    public static void main(String[] args) {
        String[] arr = {"abc", "de", "gong", "De", "abc", "Foo", "gong"};

        // 使用HashSet去重
        HashSet<String> set = new HashSet<String>(Arrays.asList(arr));
        String[] uniqueArr = set.toArray(new String[0]);

        // 对去重后的数组进行排序
        Arrays.sort(uniqueArr);

        // 输出结果
        System.out.println("去重后并排序后的数组：");
        for (String str : uniqueArr) {
            System.out.print(str + " ");
        }
    }
}
