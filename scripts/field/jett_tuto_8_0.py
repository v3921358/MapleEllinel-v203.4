# Created by MechAviv
# Map ID :: 620100028
# Spaceship : In Front of the Shuttle

sm.curNodeEventEnd(True)
sm.setTemporarySkillSet(0)
sm.setInGameDirectionMode(True, True, False, False)
sm.setStandAloneMode(True)

sm.forcedInput(0)
OBJECT_1 = sm.sendNpcController(9270083, 34, -137)
sm.showNpcSpecialActionByObjectId(OBJECT_1, "summon", 0)
sm.sendSessionValue("mastema", 9270083)
sm.forcedInput(2)