package org.prezydium.cvmachine.utils;

import org.prezydium.cvmachine.model.CvElement;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class NextId {

    public static long getNextId(Map<Long, ? extends CvElement> mapWithCvObjects){
        Set<Long> setOfId = mapWithCvObjects.keySet();
        if (setOfId.isEmpty()){
            return 0;
        } else{
            return Collections.max(setOfId) + 1L;
        }
    }
}
