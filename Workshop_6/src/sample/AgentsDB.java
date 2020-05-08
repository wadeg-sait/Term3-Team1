package sample;
// Zoha Ahmed Code
public class AgentsDB {
    // Private fields for Agent Class
    private  int AgentId;
    private String AgentFirstName;
    private String AgentMiddleName;
    private String AgentLastName;
    private  String AgentBusinessPhone;
    private String AgentEmail;
    private String AgentPosition;
    private  int AgencyId;


    //Getter and Setter for private field of Agent Class

    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int agentId) {
        AgentId = agentId;
    }

    public String getAgentFirstName() {
        return AgentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        AgentFirstName = agentFirstName;
    }

    public String getAgentMiddleName() {
        return AgentMiddleName;
    }

    public void setAgentMiddleName(String agentMiddleName) {
        AgentMiddleName = agentMiddleName;
    }

    public String getAgentLastName() {
        return AgentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        AgentLastName = agentLastName;
    }

    public String getAgentBusinessPhone() {
        return AgentBusinessPhone;
    }

    public void setAgentBusinessPhone(String agentBusinessPhone) {
        AgentBusinessPhone = agentBusinessPhone;
    }

    public String getAgentEmail() {
        return AgentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        AgentEmail = agentEmail;
    }

    public String getAgentPosition() {
        return AgentPosition;
    }

    public void setAgentPosition(String agentPosition) {
        AgentPosition = agentPosition;
    }

    public int getAgencyId() {
        return AgencyId;
    }

    public void setAgencyId(int agencyId) {
        AgencyId = agencyId;
    }


    // to String method implementation for combo box dropdown
    @Override
    public String toString() {
        return  Integer.toString(AgentId);
    }
}
