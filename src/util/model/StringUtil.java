package util.model;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {

    public static String minecraftColorToHTML(String input) {
        Map<Character, String> colorMap = new HashMap<>();
        colorMap.put('0', "#000000");
        colorMap.put('1', "#0000AA");
        colorMap.put('2', "#00AA00");
        colorMap.put('3', "#00AAAA");
        colorMap.put('4', "#AA0000");
        colorMap.put('5', "#AA00AA");
        colorMap.put('6', "#FFAA00");
        colorMap.put('7', "#AAAAAA");
        colorMap.put('8', "#555555");
        colorMap.put('9', "#5555FF");
        colorMap.put('a', "#55FF55");
        colorMap.put('b', "#55FFFF");
        colorMap.put('c', "#FF5555");
        colorMap.put('d', "#FF55FF");
        colorMap.put('e', "#FFFF55");
        colorMap.put('f', "#FFFFFF");
        colorMap.put('g', "#DDD605");
        colorMap.put('h', "#E3D4D1");
        colorMap.put('i', "#CECACA");
        colorMap.put('j', "#443A3B");
        colorMap.put('m', "#971607");
        colorMap.put('n', "#B4684D");
        colorMap.put('p', "#DEB12D");
        colorMap.put('q', "#47A036");
        colorMap.put('s', "#2CBAA8");
        colorMap.put('t', "#21497B");
        colorMap.put('u', "#9A5CC6");

        StringBuilder result = new StringBuilder("<html><span style='color:#FFFFFF;'>");
        String color = "#FFFFFF";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if ((c == '§' || c == '&') && i + 1 < input.length()) {
                char code = Character.toLowerCase(input.charAt(i + 1));
                if (colorMap.containsKey(code)) {
                    color = colorMap.get(code);
                    result.append("</span><span style='color:").append(color).append(";'>");
                    i++;
                    continue;
                }
            }

            if (c >= '\uE000' && c <= '\uF8FF') {
                continue;
            }

            result.append(c);
        }

        result.append("</span></html>");
        return result.toString();
    }
}
