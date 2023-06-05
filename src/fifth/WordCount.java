package fifth;

import java.util.HashMap;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一句英语：");
        String input = scanner.nextLine();

        String[] words = input.split("\\s+");

        HashMap<String,Integer> wordCount = new HashMap<String,Integer>();
        for (String word : words){
            if (wordCount.containsKey(word)){
                int count = wordCount.get(word);
                wordCount.put(word,count+1);
            } else {
                wordCount.put(word,1);
            }
        }

        System.out.println("各单词出现的次数为：");
        for (String word : wordCount.keySet()) {
            int count = wordCount.get(word);
            System.out.println(word + ": " + count + "次");
        }
    }
}
