# 951000000 - Monster Park

from net.swordie.ms.constants import GameConstants
from net.swordie.ms.enums import QuestStatus
from net.swordie.ms.client.character.quest import Quest

status = -1
minLv = 105
maxLv = 115

maps = [
    ["Auto Security Area (Lv.105-114)", 953020000]
]
sm.setSpeakerID(9071004)

def init():
    if not sm.getParty() is None:
        sm.sendSayOkay("Please leave your party to enter Monster Park.")
        sm.dispose()
    else:
        if sm.getChr().getLevel() < minLv or sm.getChr().getLevel() > maxLv:
            sm.sendSayOkay("You need to be between Level "+ str(minLv) +" and "+ str(maxLv) +" to enter.")
            sm.dispose()
        else:
            if sm.getMonsterParkCount() >= GameConstants.MAX_MONSTER_PARK_RUNS:
                colour = "#r"
            else:
                colour = "#b"
            string = "#eToday is #b"+ sm.getDay() +"#k.\r\nToday's Clear Count "+ colour +""+ str(sm.getMonsterParkCount()) +"/"+ str(GameConstants.MAX_MONSTER_PARK_RUNS) +"#k (per Maple Character)\r\n\r\nYou have #b"+ str(2) +"#k free clears left for today.\r\n\r\n#n#b"
            i = 0
            while i < len(maps):
                string += "#L"+ str(i) +"#"+ maps[i][0] +"#l\r\n"
                i += 1
            sm.sendNext(string)

def action(response, answer):
    global status, selection
    status += 1

    if status == 0:
        if sm.getMonsterParkCount() >= GameConstants.MAX_MONSTER_PARK_RUNS:
            sm.sendSayOkay("I'm sorry, but you've used up all your clears for today.")
            sm.dispose()
        else:
            selection = answer
            sm.sendAskYesNo("#eToday is #b"+ sm.getDay() +"#k.\r\n\r\n"
                                                          "Selected Dungeon: #b"+ maps[selection][0] +"#k\r\n"
                                                                                                      "Clearing the dungeon will use up #bone of your free clears#k \r\nfor today.\r\n\r\n"
                                                                                                      "Would you like to enter the dungeon?")


    elif status == 1:
        if response == 1:
            sm.warpInstanceIn(maps[selection][1])
            sm.incrementMonsterParkCount()
            sm.createQuestWithQRValue(GameConstants.MONSTER_PARK_EXP_QUEST, "0")
        sm.dispose()