/*
 * Workshop 8 base skeleton created by Wade Grimm
 *
 * */

package com.wade.day12exercise;

import java.io.Serializable;

public class Agent implements Serializable {
    private int agentId;
    private String agtFirstName;
    private String agtMiddleInitial;
    private String agtLastName;
    private String agtBusPhone;
    private String agtEmail;
    private String agtPosition;
    private int agencyId;

    //constructor
    public Agent(int agentId, String agtFirstName, String agtMiddleInitial, String agtLastName, String agtBusPhone, String agtEmail, String agtPosition, int agencyId) {
        this.agentId = agentId;
        this.agtFirstName = agtFirstName;
        this.agtMiddleInitial = agtMiddleInitial;
        this.agtLastName = agtLastName;
        this.agtBusPhone = agtBusPhone;
        this.agtEmail = agtEmail;
        this.agtPosition = agtPosition;
        this.agencyId = agencyId;
    }

    // getters
    public int getAgentId() { return agentId; }
    public String getAgtFirstName() { return agtFirstName; }
    public String getAgtMiddleInitial() { return agtMiddleInitial; }
    public String getAgtLastName() { return agtLastName; }
    public String getAgtBusPhone() { return agtBusPhone; }
    public String getAgtEmail() { return agtEmail; }
    public String getAgtPosition() { return agtPosition; }
    public int getAgencyId() { return agencyId; }

    //setters
    public void setAgentId(int agentId) { this.agentId = agentId; }
    public void setAgtFirstName(String agtFirstName) { this.agtFirstName = agtFirstName; }
    public void setAgtMiddleInitial(String agtMiddleInitial) { this.agtMiddleInitial = agtMiddleInitial; }
    public void setAgtLastName(String agtLastName) { this.agtLastName = agtLastName; }
    public void setAgtBusPhone(String agtBusPhone) { this.agtBusPhone = agtBusPhone; }
    public void setAgtEmail(String agtEmail) { this.agtEmail = agtEmail; }
    public void setAgtPosition(String agtPosition) { this.agtPosition = agtPosition; }
    public void setAgencyId(int agencyId) { this.agencyId = agencyId; }

    @Override
    public String toString() {
        return agtFirstName + " " + agtLastName;
    }
}
