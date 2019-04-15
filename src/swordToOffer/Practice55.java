package swordToOffer;

import java.util.LinkedHashMap;

/**
 * 字符流中第一个不重复的字符
 */
public class Practice55 {
    LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap<Character, Integer>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(linkedHashMap.get(ch)==null){
            linkedHashMap.putIfAbsent(ch,1);
        }else {
            linkedHashMap.put(ch,2);
        }
    }
//    //return the first appearence once char in current stringstream
//    public char FirstAppearingOnce()
//    {
//
//    }
public static void main(String[] args) {
    char[] chars = new char[256];
    System.out.println(chars);
}

}
