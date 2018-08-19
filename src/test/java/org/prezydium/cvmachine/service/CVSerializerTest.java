package org.prezydium.cvmachine.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.prezydium.cvmachine.model.CVModel;
import org.prezydium.cvmachine.testutil.CVModelExampleGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class CVSerializerTest {

    private CVSerializer cvSerializer;
    private CVModel cvModel;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private File testFolder;
    private String testFolderPath;

    @Before
    public void setUp() throws IOException {
        cvSerializer = new CVSerializer();
        cvModel = CVModelExampleGenerator.create();
        testFolder = temporaryFolder.newFolder();
        testFolderPath = testFolder.getAbsolutePath();
    }

    @Test
    public void shouldCreateFileOnDisc() {
        //given
        String fileName = "test";
        //when
        cvSerializer.serializeCVModelToXMLFile(cvModel, testFolderPath, fileName);
        //then
        Assertions.assertThat(Files.exists(Paths.get(testFolderPath + "/" + fileName + ".json"), LinkOption.NOFOLLOW_LINKS)).isTrue();
    }

    @Test
    public void shouldReadFromFile() {
        String fileName = "test2";
        //when
        cvSerializer.serializeCVModelToXMLFile(cvModel, testFolderPath, fileName);
        CVModel actualCVModel = cvSerializer.deserializeFromXMLToCVModel(testFolderPath + "/" + fileName + ".json");
        //then
        Assertions.assertThat(actualCVModel.getEducationMap()).isNotEmpty();
    }

}