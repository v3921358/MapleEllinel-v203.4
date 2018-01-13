package client.jobs.legend;

import client.Client;
import client.character.Char;
import client.character.HitInfo;
import client.character.skills.AttackInfo;
import client.jobs.Job;
import connection.InPacket;
import constants.JobConstants;

/**
 * Created on 12/14/2017.
 */
public class Aran extends Job {

    public static final int POLEARM_BOOSTER = 21001003; //Buff
    public static final int BODY_PRESSURE = 21001008; //Buff (on/off)

    public static final int SNOW_CHARGE = 21101006; //Buff
    public static final int MAHA_BLESSING = 21111012; //Buff
    public static final int MAPLE_WARRIOR_ARAN = 21121000; //Buff
    /*public static final int
    public static final int
    public static final int
    public static final int
    public static final int
    public static final int*/


    public Aran(Char chr) {
        super(chr);
    }

    @Override
    public void handleAttack(Client c, AttackInfo attackInfo) {

    }

    @Override
    public void handleSkill(Client c, int skillID, byte slv, InPacket inPacket) {

    }

    @Override
    public void handleHit(Client c, InPacket inPacket, HitInfo hitInfo) {

    }

    @Override
    public boolean isHandlerOfJob(short id) {
        return id >= JobConstants.JobEnum.ARAN1.getJobId() && id <= JobConstants.JobEnum.ARAN4.getJobId();
    }
}
