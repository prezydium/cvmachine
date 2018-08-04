package org.prezydium.cvmachine.model;

import java.util.List;

public class CVModel {

    private UserData userData;
    private List<Education> educationList;
    private List<WorkExperience> workExperienceList;
    private List<Skill> skillList;
    private List<String> minorSkills;
    private String legalNote;

    public CVModel() {
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<String> getMinorSkills() {
        return minorSkills;
    }

    public void setMinorSkills(List<String> minorSkills) {
        this.minorSkills = minorSkills;
    }

    public String getLegalNote() {
        return legalNote;
    }

    public void setLegalNote(String legalNote) {
        this.legalNote = legalNote;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CVModel{");
        sb.append("userData=").append(userData);
        sb.append(", educationList=").append(educationList);
        sb.append(", workExperienceList=").append(workExperienceList);
        sb.append(", skillList=").append(skillList);
        sb.append(", minorSkills=").append(minorSkills);
        sb.append(", legalNote='").append(legalNote).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
