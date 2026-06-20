package com.cognizant.junitadvanced.exercise2;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SampleTest1.class, SampleTest2.class})
public class AllTests {
}
