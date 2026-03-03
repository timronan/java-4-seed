package edu.iris.dmc;


import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;

// JUnit 5 does not require @RunWith. Use only JUnit 5 suite annotations.
@SuiteDisplayName("JUnit Platform Suite for validator")
@SelectPackages("edu.iris.dmc")
public final class AllTestsSuite {
} // or ModuleFooSuite, and that in AllTests
