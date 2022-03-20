package org.picmg.test.TestMaker;

import java.util.ArrayList;

public class TestContainer {

    ArrayList<Test> tests;
    private String testContainerName;
    public TestContainer()
    {
        tests = new ArrayList<Test>();
    }

    /**
     * This method sets the test container name
     * @param name
     */
    public void setTestContainerName(String name)
    {
        this.testContainerName = name;
    }

    /**
     * This method returns the name which is the class name
     * @return
     */
    public String getTestContainerName()
    {
        return testContainerName;
    }
    /**
     * This method adds a test to the test container
     * @param test
     */
    public void addTest(Test test)
    {
        tests.add(test);
    }

    /**
     * This method returns the test inside the container
     * @return
     */
    public ArrayList<Test> getTest()
    {
        return tests;
    }

    public void print()
    {
        for(Test t : tests)
        {
            t.print();
        }
    }
}
