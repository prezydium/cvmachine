package org.prezydium.cvmachine.model;

public class MainSkill {

    private Integer points;
    private String skillName;

    public MainSkill() {
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainSkill mainSkill = (MainSkill) o;

        if (points != null ? !points.equals(mainSkill.points) : mainSkill.points != null) return false;
        return skillName != null ? skillName.equals(mainSkill.skillName) : mainSkill.skillName == null;
    }

    @Override
    public int hashCode() {
        int result = points != null ? points.hashCode() : 0;
        result = 31 * result + (skillName != null ? skillName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MainSkill{");
        sb.append("points=").append(points);
        sb.append(", skillName='").append(skillName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
