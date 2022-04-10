package org.picmg.test.integrationTest.TestMaker;

import java.util.ArrayList;

public class Test {

    private String name;
    private ArrayList<Step> steps;

    public static class Step
    {
        public String id;
        public String data;
        public String type;
        public String name;

        public Step(String type, String id, String data)
        {
            this.id = id;
            this.data = data;
            this.type = type;
        }

        public void print()
        {
            System.out.println("Method = " + type + " Id = " + id + " Data =" + data);
        }

        @Override
        public String toString()
        {

            return "Method = " + type + " Id = " + id + " Data =" + data;
        }
    }

    public Test()
    {
        steps = new ArrayList<Step>();
    }

    /**
     * This sets the test name
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * This method gets the test name
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method adds a step to the test
     * @param type
     * @param id
     * @param data
     */
    public void addStep(String type, String id, String data)
    {
        Step newStep = new Step(type,id,data);
        steps.add(newStep);
    }

    public void addStep(Step step)
    {
        steps.add(step);
    }
    /**
     * This method returns the steps for the test
     * @return
     */
    public ArrayList<Step> getSteps()
    {
        return steps;
    }

    /**
     * This method is for debugging
     */
    public void print()
    {
        System.out.println("Test Name is " + name);
        System.out.println("Test Steps \n");
        for(Step s : steps)
        {
            s.print();
        }
    }

}
