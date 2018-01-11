package client.jobs.legend;

import client.Client;
import client.character.Char;
import client.character.skills.AttackInfo;
import client.jobs.Job;
import connection.InPacket;
import constants.JobConstants;

/**
 * Created on 12/14/2017.
 */
public class Shade extends Job {
    public Shade(Char chr) {
        super(chr);
    }

    @Override
    public void handleAttack(Client c, AttackInfo attackInfo) {

    }

    @Override
    public void handleSkill(Client c, int skillID, byte slv, InPacket inPacket) {

    }

    @Override
    public boolean isHandlerOfJob(short id) {
        return id >= JobConstants.JobEnum.SHADE.getJobId() && id <= JobConstants.JobEnum.SHADE4.getJobId();
    }
}
