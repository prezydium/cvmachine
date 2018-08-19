package org.prezydium.cvmachine.service;

import org.prezydium.cvmachine.model.*;
import org.prezydium.cvmachine.utils.NextId;

import java.util.HashMap;
import java.util.Map;

public class SaveNewCvElementService {

    private CVModel cvModel;
    private Map<Class, Map<Long, ? extends CvElement>> mapWithCvElementMaps;

    public SaveNewCvElementService(CVModel cvModel) {
        this.cvModel = cvModel;
        mapWithCvElementMaps = new HashMap<Class, Map<Long, ? extends CvElement>>() {{
            put(Education.class, cvModel.getEducationMap());
            put(WorkExperience.class, cvModel.getWorkExperienceMap());
            put(Skill.class, cvModel.getSkillMap());
        }};
    }

    public CVModel save(CvElement cvElement) {
        Map map = mapWithCvElementMaps.get(cvElement.getClass());
        long id = NextId.getNextId(map);
        map.put(id, cvElement);
        return this.cvModel;
    }
}