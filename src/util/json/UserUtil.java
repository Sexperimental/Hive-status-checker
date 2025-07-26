package util.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UserUtil {

    private static String getStringOrDefault(String json, String key) {
        try {
            JsonObject root = JsonParser.parseString(json).getAsJsonObject();
            if (root.has("main") && !root.get("main").isJsonNull()) {
                JsonObject main = root.getAsJsonObject("main");
                if (main.has(key) && !main.get(key).isJsonNull()) {
                    JsonElement elem = main.get(key);
                    return elem.getAsString();
                }
            }
        } catch (Exception e) {
        }
        return "0";
    }

    public static String getUserName(String json) {
        return getStringOrDefault(json, "username_cc");
    }

    public static String getRank(String json) {
        String rank = getStringOrDefault(json, "rank");
        if (rank.equalsIgnoreCase("Plus") || rank.equalsIgnoreCase("VIP")) {
            return "<font color='#00ff00'>" + rank + "</font>";
        } else if (rank.equalsIgnoreCase("Ultimate")) {
            return "<font color='#C084FC'>" + rank + "</font>";
        } else {
            return rank;
        }
    }

    public static String getHubTitle(String json) {
        return getStringOrDefault(json, "hub_title_count");
    }

    public static String getAvatarCount(String json) {
        return getStringOrDefault(json, "avatar_count");
    }

    public static String getCostumeCount(String json) {
        return getStringOrDefault(json, "costume_count");
    }

    public static String getHatCount(String json) {
        return getStringOrDefault(json, "hat_count");
    }

    public static String getBackBlingCount(String json) {
        return getStringOrDefault(json, "backbling_count");
    }

    public static String getFriendCount(String json) {
        return getStringOrDefault(json, "friend_count");
    }

    public static String getEquippedHubTitle(String json) {
        return getStringOrDefault(json, "equipped_hub_title");
    }
}
