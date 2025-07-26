package util.json.games;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuildBattle {

    private static String getStringOrDefault(String json, String key) {
        try {
            JsonObject root = JsonParser.parseString(json).getAsJsonObject();
            if (root.has("build") && !root.get("build").isJsonNull()) {
                JsonObject main = root.getAsJsonObject("build");
                if (main.has(key) && !main.get(key).isJsonNull()) {
                    JsonElement elem = main.get(key);
                    return elem.getAsString();
                }
            }
        } catch (Exception e) {
        }
        return "0";
    }

    public static int getPlayed(String json) {
        try {
            return Integer.parseInt(getStringOrDefault(json, "played"));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int getWin(String json) {
        try {
            return Integer.parseInt(getStringOrDefault(json, "victories"));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int getLose(String json) {
        return getPlayed(json) - getWin(json);
    }

    public static int getKill(String json) {
        try {
            return Integer.parseInt(getStringOrDefault(json, "kills"));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int getdeath(String json) {
        try {
            return Integer.parseInt(getStringOrDefault(json, "deaths"));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String getKD(String json) {
        int kills = getKill(json);
        int deaths = getdeath(json);

        if (deaths == 0) {
            return deaths == 0 && kills == 0 ? "0.00" : String.format("%.2f", (float) kills);
        }

        float kd = (float) kills / deaths;
        return String.format("%.2f", kd);
    }

    public static String getWinRate(String json) {
        int played = getPlayed(json);
        int wins = getWin(json);

        if (played == 0) {
            return "0.00%";
        }

        float rate = (float) wins / played * 100;
        return String.format("%.2f%%", rate);
    }
}
