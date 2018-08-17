package org.prezydium.cvmachine.testutil;

import org.prezydium.cvmachine.model.*;

import java.time.LocalDate;
import java.util.TreeMap;

public class CVModelExampleGenerator {


    public static CVModel create() {
        CVModel cvModel = new CVModel();
        UserData userData = new UserData();
        userData.setFirstName("Jan");
        userData.setLastName("Kowalski");
        userData.setLinkedInProfile("www.test.pl/test");
        userData.setPhone("111-111-111");
        userData.setVcsRepo("github.com/prezydium");
        userData.setEmail("test@ee.ee");
        Address address = new Address();
        address.setCity("Gdańsk");
        address.setPostalCode("00-000");
        address.setStreet("Los Manianas 90C/11");
        userData.setAddress(address);
        cvModel.setUserData(userData);
        cvModel.setLegalNote("test legal note");
        Education education = new Education();
        Education education2 = new Education();
        education.setId(0);
        education.setSchoolName("INFOSHER");
        education.setStartDate(LocalDate.of(2015, 1, 22));
        education.setEndDate(LocalDate.of(2017, 7, 4));
        education.setDescription("LERNEN Programmer * much lernen * much fun  * arbeit");
        education2.setId(1);
        education2.setSchoolName("kindergarten");
        education2.setStartDate(LocalDate.of(2015, 1, 22));
        education2.setEndDate(LocalDate.of(2017, 7, 4));
        education2.setDescription("LERNEN Programmer in kindergarten * fun * much fun");
        cvModel.setEducationMap(new TreeMap<Long, Education>() {{
            put(0L, education);
            put(1L, education2);
        }});
        WorkExperience workExperience = new WorkExperience();
        workExperience.setId(0);
        WorkExperience workExperience2 = new WorkExperience();
        workExperience.setStartDate(LocalDate.of(2014, 1, 22));
        workExperience2.setId(1);
        workExperience.setEndDate(LocalDate.of(2016, 12, 4));
        workExperience.setDescription("NIERZĄD * nothing lernen * much fun  * arbeit not frei");
        workExperience.setCompanyName("CITYHALL");
        workExperience2.setStartDate(LocalDate.of(2019, 11, 2));
        workExperience2.setEndDate(LocalDate.of(2020, 4, 4));
        workExperience2.setDescription("Making ordnung * arbeit zum ordnung");
        workExperience2.setCompanyName("CleanUp House");
        cvModel.setWorkExperienceMap(new TreeMap<Long, WorkExperience>() {{
            put(0L, workExperience);
            put(1L, workExperience2);
        }});
        Skill skill = new Skill();
        skill.setName("JAVA");
        Skill skill2 = new Skill();
        skill2.setName("HTML");
        Skill skill3 = new Skill();
        skill3.setName("scrum");
        cvModel.setSkillMap(new TreeMap<Long, Skill>(){{
            put(0L, new Skill(0L, "JAVA"));
            put(1L, new Skill(1L, "HTML"));
            put(2L, new Skill(2L, "scrum"));

        }});
        return cvModel;
    }

}
