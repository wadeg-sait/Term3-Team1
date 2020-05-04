/*
 * Created by Wade Grimm
 *
 * */


package oosd.team1.workshop8;

import java.io.Serializable;

public class Agent implements Serializable {
    private int agentId;
    private int agencyId;
    private String agtBusPhone;
    private String agtEmail;
    private String agtFirstName;
    private String agtLastName;
    private String agtMiddleInitial;
    private String agtPosition;


    //constructor
    public Agent(int agentId, int agencyId, String agtBusPhone, String agtEmail, String agtFirstName, String agtLastName, String agtMiddleInitial, String agtPosition) {
        this.agentId = agentId;
        this.agencyId = agencyId;
        this.agtBusPhone = agtBusPhone;
        this.agtEmail = agtEmail;
        this.agtFirstName = agtFirstName;
        this.agtLastName = agtLastName;
        this.agtMiddleInitial = agtMiddleInitial;
        this.agtPosition = agtPosition;

    }

    public Agent() {

    }
    //public Agent (){}

    // getters
    public int getAgentId() {
        return agentId;
    }

    public String getAgtFirstName() {
        return agtFirstName;
    }

    public String getAgtMiddleInitial() {
        return agtMiddleInitial;
    }

    public String getAgtLastName() {
        return agtLastName;
    }

    public String getAgtBusPhone() {
        return agtBusPhone;
    }

    public String getAgtEmail() {
        return agtEmail;
    }

    public String getAgtPosition() {
        return agtPosition;
    }

    public int getAgencyId() {
        return agencyId;
    }

    //setters
    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public void setAgtFirstName(String agtFirstName) {
        this.agtFirstName = agtFirstName;
    }

    public void setAgtMiddleInitial(String agtMiddleInitial) {
        this.agtMiddleInitial = agtMiddleInitial;
    }

    public void setAgtLastName(String agtLastName) {
        this.agtLastName = agtLastName;
    }

    public void setAgtBusPhone(String agtBusPhone) {
        this.agtBusPhone = agtBusPhone;
    }

    public void setAgtEmail(String agtEmail) {
        this.agtEmail = agtEmail;
    }

    public void setAgtPosition(String agtPosition) {
        this.agtPosition = agtPosition;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public String toString() {
        return agtFirstName + " " + agtLastName;
    }
}
