package net.swordie.ms.connection.packet;

import net.swordie.ms.connection.OutPacket;
import net.swordie.ms.util.FileTime;

/**
 * @author Sjonnie
 * Created on 7/12/2018.
 */
public class QuickMoveInfo {
    private int qmiID;
    private int templateID;
    private int code;
    private int levelMin;
    private String msg;
    private FileTime start;
    private FileTime end;

    public QuickMoveInfo(int qmiID, int templateID, int code) {
        this.qmiID = qmiID;
        this.templateID = templateID;
        this.code = code;
        this.start = FileTime.getFileTimeFromType(FileTime.Type.ZERO_TIME);
        this.start = FileTime.getFileTimeFromType(FileTime.Type.PERMANENT);
    }

    public QuickMoveInfo(int qmiID, int templateID, int code, int levelMin, String msg, FileTime start, FileTime end) {
        this.qmiID = qmiID;
        this.templateID = templateID;
        this.code = code;
        this.levelMin = levelMin;
        this.msg = msg;
        this.start = start;
        this.end = end;
    }

    public QuickMoveInfo withLevelMin(int level) {
        setLevelMin(level);
        return this;
    }

    public QuickMoveInfo withMsg(String msg) {
        setMsg(msg);
        return this;
    }

    public QuickMoveInfo withStartAndEnd(FileTime start, FileTime end) {
        setStart(start);
        setEnd(end);
        return this;
    }

    public void encode(OutPacket outPacket) {
        outPacket.encodeInt(getQmiID());
        outPacket.encodeInt(getTemplateID());
        outPacket.encodeInt(getCode());
        outPacket.encodeInt(getLevelMin());
        outPacket.encodeString(getMsg());
        outPacket.encodeFT(getStart());
        outPacket.encodeFT(getEnd());
    }

    public int getQmiID() {
        return qmiID;
    }

    public void setQmiID(int qmiID) {
        this.qmiID = qmiID;
    }

    public int getTemplateID() {
        return templateID;
    }

    public void setTemplateID(int templateID) {
        this.templateID = templateID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(int levelMin) {
        this.levelMin = levelMin;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FileTime getStart() {
        return start;
    }

    public void setStart(FileTime start) {
        this.start = start;
    }

    public FileTime getEnd() {
        return end;
    }

    public void setEnd(FileTime end) {
        this.end = end;
    }
}