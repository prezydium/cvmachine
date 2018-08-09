package org.prezydium.cvmachine.model;

import java.util.Objects;
import java.util.TreeMap;

public class CVModel {

    private UserData userData;
    private TreeMap<Long, Education> educationMap;
    private TreeMap<Long, WorkExperience> workExperienceMap;
    private TreeMap<Long, Skill> skillMap;
    private String legalNote;

    public CVModel() {
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public TreeMap<Long, Education> getEducationMap() {
        return educationMap;
    }

    public void setEducationMap(TreeMap<Long, Education> educationMap) {
        this.educationMap = educationMap;
    }

    public TreeMap<Long, WorkExperience> getWorkExperienceMap() {
        return workExperienceMap;
    }

    public void setWorkExperienceMap(TreeMap<Long, WorkExperience> workExperienceMap) {
        this.workExperienceMap = workExperienceMap;
    }

    public TreeMap<Long, Skill> getSkillMap() {
        return skillMap;
    }

    public void setSkillMap(TreeMap<Long, Skill> skillMap) {
        this.skillMap = skillMap;
    }

    public String getLegalNote() {
        return legalNote;
    }

    public void setLegalNote(String legalNote) {
        this.legalNote = legalNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CVModel cvModel = (CVModel) o;
        return Objects.equals(userData, cvModel.userData) &&
                Objects.equals(educationMap, cvModel.educationMap) &&
                Objects.equals(workExperienceMap, cvModel.workExperienceMap) &&
                Objects.equals(skillMap, cvModel.skillMap) &&
                Objects.equals(legalNote, cvModel.legalNote);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userData, educationMap, workExperienceMap, skillMap, legalNote);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CVModel{");
        sb.append("userData=").append(userData);
        sb.append(", educationMap=").append(educationMap);
        sb.append(", workExperienceMap=").append(workExperienceMap);
        sb.append(", skillMap=").append(skillMap);
        sb.append(", legalNote='").append(legalNote).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
