package controll;

import util.json.games.*;
import util.model.ApiUtil;
import util.model.GuiUtil;
import util.json.UserUtil;
import util.model.StringUtil;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Panel {

    private static JLabel[] bedwarsLabels;
    private static JLabel[] skywarsLabels;
    private static JLabel[] murderLabels;
    private static JLabel[] survivalLabels;
    private static JLabel[] hideAndSeekLabels;
    private static JLabel[] deathRunLabels;
    private static JLabel[] buildBattleLabels;
    private static JLabel[] captureTheFlagLabels;
    private static JLabel[] bridgeLabels;

    private static JLabel infomationLabel, equipped_hub_titleLabel;

    public static void initialize(JFrame frame) {
        JLabel authorLabel = GuiUtil.createLabel("<html><b>Author</b>: sexperimental - 07/18</html>", 15, 13, 200, 25);
        JLabel authorBoarder1 = GuiUtil.createLabel("----------------------------------", 15, 27, 300, 25);
        JLabel authorBoarder2 = GuiUtil.createLabel("----------------------------------", 15, -2, 300, 25);

        JTextField usernameField = GuiUtil.createTextField(200, 13, 220, 24);

        infomationLabel = GuiUtil.createLabel("<html>"
                + "<b>Username:</b>  " + "none" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "<b>Rank:</b>  " + "0" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "<b>Hub Title:</b>  " + "0" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "<b>Avatars:</b>  " + "0" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "<b>Costumes:</b>  " + "0" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "<b>Hats:</b>  " + "0" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "<b>Backblings:</b>  " + "0" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "<b>Friends:</b>  " + "0"
                + "</html>"
                , 35, 80, 10000, 25);

        equipped_hub_titleLabel = GuiUtil.createLabel("<html><b>Equipped hub title:  </b>none</html>", 35, 108, 10000, 25);

        JButton checkButton = GuiUtil.createButton("check", 430, 13, 80, 24, e -> {
            String json = ApiUtil.getJson(usernameField.getText());

            infomationLabel.setText("<html>"
                    + "<b>Username:</b>  " + UserUtil.getUserName(json) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "<b>Rank:</b>  " + UserUtil.getRank(json) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "<b>Hub Title:</b>  " + UserUtil.getHubTitle(json) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "<b>Avatars:</b>  " + UserUtil.getAvatarCount(json) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "<b>Costumes:</b>  " + UserUtil.getCostumeCount(json) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "<b>Hats:</b>  " + UserUtil.getHatCount(json) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "<b>Backblings:</b>  " + UserUtil.getBackBlingCount(json) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "<b>Friends:</b>  " + UserUtil.getFriendCount(json)
                    + "</html>");

            equipped_hub_titleLabel.setText("<html><b>Equipped hub title:  </b>" + StringUtil.minecraftColorToHTML(UserUtil.getEquippedHubTitle(json)) + "</html>");

            bedwarsLabels[1].setText(String.valueOf(Bedwars.getPlayed(json)));
            bedwarsLabels[2].setText(String.valueOf(Bedwars.getWin(json)));
            bedwarsLabels[3].setText(String.valueOf(Bedwars.getLose(json)));
            bedwarsLabels[4].setText(String.valueOf(Bedwars.getKill(json)));
            bedwarsLabels[5].setText(String.valueOf(Bedwars.getdeath(json)));
            bedwarsLabels[6].setText(Bedwars.getKD(json));
            bedwarsLabels[7].setText(Bedwars.getWinRate(json));

            skywarsLabels[1].setText(String.valueOf(Skywars.getPlayed(json)));
            skywarsLabels[2].setText(String.valueOf(Skywars.getWin(json)));
            skywarsLabels[3].setText(String.valueOf(Skywars.getLose(json)));
            skywarsLabels[4].setText(String.valueOf(Skywars.getKill(json)));
            skywarsLabels[5].setText(String.valueOf(Skywars.getdeath(json)));
            skywarsLabels[6].setText(Skywars.getKD(json));
            skywarsLabels[7].setText(Skywars.getWinRate(json));

            murderLabels[1].setText(String.valueOf(Murder.getPlayed(json)));
            murderLabels[2].setText(String.valueOf(Murder.getWin(json)));
            murderLabels[3].setText(String.valueOf(Murder.getLose(json)));
            murderLabels[4].setText(String.valueOf(Murder.getKill(json)));
            murderLabels[5].setText(String.valueOf(Murder.getdeath(json)));
            murderLabels[6].setText(Murder.getKD(json));
            murderLabels[7].setText(Murder.getWinRate(json));

            survivalLabels[1].setText(String.valueOf(Survival.getPlayed(json)));
            survivalLabels[2].setText(String.valueOf(Survival.getWin(json)));
            survivalLabels[3].setText(String.valueOf(Survival.getLose(json)));
            survivalLabels[4].setText(String.valueOf(Survival.getKill(json)));
            survivalLabels[5].setText(String.valueOf(Survival.getdeath(json)));
            survivalLabels[6].setText(Survival.getKD(json));
            survivalLabels[7].setText(Survival.getWinRate(json));

            hideAndSeekLabels[1].setText(String.valueOf(HideAndSeek.getPlayed(json)));
            hideAndSeekLabels[2].setText(String.valueOf(HideAndSeek.getWin(json)));
            hideAndSeekLabels[3].setText(String.valueOf(HideAndSeek.getLose(json)));
            hideAndSeekLabels[4].setText(String.valueOf(HideAndSeek.getKill(json)));
            hideAndSeekLabels[5].setText(String.valueOf(HideAndSeek.getdeath(json)));
            hideAndSeekLabels[6].setText(HideAndSeek.getKD(json));
            hideAndSeekLabels[7].setText(HideAndSeek.getWinRate(json));

            deathRunLabels[1].setText(String.valueOf(DeathRun.getPlayed(json)));
            deathRunLabels[2].setText(String.valueOf(DeathRun.getWin(json)));
            deathRunLabels[3].setText(String.valueOf(DeathRun.getLose(json)));
            deathRunLabels[4].setText(String.valueOf(DeathRun.getKill(json)));
            deathRunLabels[5].setText(String.valueOf(DeathRun.getdeath(json)));
            deathRunLabels[6].setText(DeathRun.getKD(json));
            deathRunLabels[7].setText(DeathRun.getWinRate(json));

            buildBattleLabels[1].setText(String.valueOf(BuildBattle.getPlayed(json)));
            buildBattleLabels[2].setText(String.valueOf(BuildBattle.getWin(json)));
            buildBattleLabels[3].setText(String.valueOf(BuildBattle.getLose(json)));
            buildBattleLabels[4].setText(String.valueOf(BuildBattle.getKill(json)));
            buildBattleLabels[5].setText(String.valueOf(BuildBattle.getdeath(json)));
            buildBattleLabels[6].setText(BuildBattle.getKD(json));
            buildBattleLabels[7].setText(BuildBattle.getWinRate(json));

            captureTheFlagLabels[1].setText(String.valueOf(CaptureTheFlag.getPlayed(json)));
            captureTheFlagLabels[2].setText(String.valueOf(CaptureTheFlag.getWin(json)));
            captureTheFlagLabels[3].setText(String.valueOf(CaptureTheFlag.getLose(json)));
            captureTheFlagLabels[4].setText(String.valueOf(CaptureTheFlag.getKill(json)));
            captureTheFlagLabels[5].setText(String.valueOf(CaptureTheFlag.getdeath(json)));
            captureTheFlagLabels[6].setText(CaptureTheFlag.getKD(json));
            captureTheFlagLabels[7].setText(CaptureTheFlag.getWinRate(json));

            bridgeLabels[1].setText(String.valueOf(Bridge.getPlayed(json)));
            bridgeLabels[2].setText(String.valueOf(Bridge.getWin(json)));
            bridgeLabels[3].setText(String.valueOf(Bridge.getLose(json)));
            bridgeLabels[4].setText(String.valueOf(Bridge.getKill(json)));
            bridgeLabels[5].setText(String.valueOf(Bridge.getdeath(json)));
            bridgeLabels[6].setText(Bridge.getKD(json));
            bridgeLabels[7].setText(Bridge.getWinRate(json));

        });

        TitledBorder title1 = BorderFactory.createTitledBorder(null, "Game Status");
        title1.setTitleFont(new Font("SansSerif", Font.BOLD, 12));
        JLabel titledBoarder1 = new JLabel();
        titledBoarder1.setBorder(title1);
        titledBoarder1.setBounds(15, 50, 720, 500);

        frame.add(authorLabel);
        frame.add(authorBoarder1);
        frame.add(authorBoarder2);
        frame.add(usernameField);
        frame.add(checkButton);
        frame.add(titledBoarder1);
        frame.add(infomationLabel);
        frame.add(equipped_hub_titleLabel);

        String[] titleLabels = {"Game name", "Played", "Win", "Lose", "Kill", "Death", "K/D", "Win-rate"};
        JLabel[] headerLabels = new JLabel[titleLabels.length];
        for (int i = 0; i < titleLabels.length; i++) {
            headerLabels[i] = GuiUtil.createLabel(titleLabels[i], 35 + i * 90, 140, 80, 25);
            Font currentFont = headerLabels[i].getFont();
            headerLabels[i].setFont(new Font(currentFont.getName(), Font.BOLD, currentFont.getSize()));
            frame.add(headerLabels[i]);
        }

        String[] bedLabels = {"<html><b>Bedwars</b></html>", "0", "0", "0", "0", "0", "0.00", "0.00%"};
        bedwarsLabels = new JLabel[bedLabels.length];
        for (int i = 0; i < bedLabels.length; i++) {
            bedwarsLabels[i] = GuiUtil.createLabel(bedLabels[i], 35 + i * 90, 180, 80, 25);
            frame.add(bedwarsLabels[i]);
        }

        String[] skyLabels = {"<html><b>Skywars</b></html>", "0", "0", "0", "0", "0", "0.00", "0.00%"};
        skywarsLabels = new JLabel[skyLabels.length];
        for (int i = 0; i < skyLabels.length; i++) {
            skywarsLabels[i] = GuiUtil.createLabel(skyLabels[i], 35 + i * 90, 220, 80, 25);
            frame.add(skywarsLabels[i]);
        }

        String[] msLabels = {"<html><b>Murder</b></html>", "0", "0", "0", "0", "0", "0.00", "0.00%"};
        murderLabels = new JLabel[msLabels.length];
        for (int i = 0; i < bedLabels.length; i++) {
            murderLabels[i] = GuiUtil.createLabel(msLabels[i], 35 + i * 90, 260, 80, 25);
            frame.add(murderLabels[i]);
        }

        String[] sgLabels = {"<html><b>Survival</b></html>", "0", "0", "0", "0", "0", "0.00", "0.00%"};
        survivalLabels = new JLabel[sgLabels.length];
        for (int i = 0; i < bedLabels.length; i++) {
            survivalLabels[i] = GuiUtil.createLabel(sgLabels[i], 35 + i * 90, 300, 80, 25);
            frame.add(survivalLabels[i]);
        }

        String[] hideLabels = {"<html><b>HideAndSeek</b></html>", "0", "0", "0", "0", "0", "0.00", "0.00%"};
        hideAndSeekLabels = new JLabel[hideLabels.length];
        for (int i = 0; i < bedLabels.length; i++) {
            hideAndSeekLabels[i] = GuiUtil.createLabel(hideLabels[i], 35 + i * 90, 340, 80, 25);
            frame.add(hideAndSeekLabels[i]);
        }

        String[] dsLabels = {"<html><b>DeathRun</b></html>", "0", "0", "0", "0", "0", "0.00", "0.00%"};
        deathRunLabels = new JLabel[dsLabels.length];
        for (int i = 0; i < bedLabels.length; i++) {
            deathRunLabels[i] = GuiUtil.createLabel(dsLabels[i], 35 + i * 90, 380, 80, 25);
            frame.add(deathRunLabels[i]);
        }

        String[] bbLables = {"<html><b>BuildBattle</b></html>", "0", "0", "0", "0", "0", "0.00", "0.00%"};
        buildBattleLabels = new JLabel[dsLabels.length];
        for (int i = 0; i < bedLabels.length; i++) {
            buildBattleLabels[i] = GuiUtil.createLabel(bbLables[i], 35 + i * 90, 420, 80, 25);
            frame.add(buildBattleLabels[i]);
        }

        String[] ctfLables = {"<html><b>CTF</b></html>", "0", "0", "0", "0", "0", "0.00", "0.00%"};
        captureTheFlagLabels = new JLabel[ctfLables.length];
        for (int i = 0; i < bedLabels.length; i++) {
            captureTheFlagLabels[i] = GuiUtil.createLabel(ctfLables[i], 35 + i * 90, 460, 80, 25);
            frame.add(captureTheFlagLabels[i]);
        }

        String[] bglabels = {"<html><b>Bridge</b></html>", "0", "0", "0", "0", "0", "0.00", "0.00%"};
        bridgeLabels = new JLabel[bglabels.length];
        for (int i = 0; i < bedLabels.length; i++) {
            bridgeLabels[i] = GuiUtil.createLabel(bglabels[i], 35 + i * 90, 500, 80, 25);
            frame.add(bridgeLabels[i]);
        }
    }
}