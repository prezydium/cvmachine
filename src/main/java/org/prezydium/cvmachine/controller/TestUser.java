package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class TestUser {

    /*Test class to be removed TODO*/

    public CVModel create() {
        CVModel cvModel = new CVModel();
        UserData userData = new UserData();
        userData.setFirstName("Jan");
        userData.setLastName("Kowalski");
        userData.setLinkedInProfile("www.test.pl/test");
        userData.setPhone("111-111-111");
        userData.setVcsRepo("github.com/prezydium");
        Address address = new Address();
        address.setCity("Gdańsk");
        address.setPostalCode("00-000");
        address.setStreet("Los Defendos 90C/11");
        userData.setAddress(address);
        cvModel.setUserData(userData);
        cvModel.setLegalNote("test legal note");
        Education education = new Education();
        Education education2 = new Education();
        education.setSchoolName("INFOSHER");
        education.setStartDate(LocalDate.of(2015, 1, 22));
        education.setEndDate(LocalDate.of(2017, 7, 4));
        education.setDescription("LERNEN Programmer\n * much lernen\n * much fun \n * arbeit");
        education2.setSchoolName("kindergarten");
        education2.setStartDate(LocalDate.of(2015, 1, 22));
        education2.setEndDate(LocalDate.of(2017, 7, 4));
        education2.setDescription("LERNEN Programmer in kindergarten\n * fun\n * much fun");
        cvModel.setEducationList(new ArrayList<Education>() {{
            add(education);
            add(education2);
        }});
        WorkExperience workExperience = new WorkExperience();
        WorkExperience workExperience2 = new WorkExperience();
        workExperience.setStartDate(LocalDate.of(2014, 1, 22));
        workExperience.setEndDate(LocalDate.of(2016, 12, 4));
        workExperience.setDescription("NIERZĄD\n * nothing lernen\n * much fun \n * arbeit not frei");
        workExperience.setCompanyName("CITYHALL");
        workExperience2.setStartDate(LocalDate.of(2019, 11, 2));
        workExperience2.setEndDate(LocalDate.of(2020, 4, 4));
        workExperience2.setDescription("Making ordnung\n * arbeit zum ordnung");
        workExperience2.setCompanyName("CleanUp House");
        cvModel.setWorkExperienceList(new ArrayList<WorkExperience>() {{
            add(workExperience);
            add(workExperience2);
        }});
        Skill skill = new Skill();
        skill.setName("JAVA");
        Skill skill2 = new Skill();
        skill2.setName("HTML");
        Skill skill3 = new Skill();
        skill3.setName("scrum");
        cvModel.setSkillList(Arrays.asList(skill, skill2, skill3));
        return cvModel;
    }

}
