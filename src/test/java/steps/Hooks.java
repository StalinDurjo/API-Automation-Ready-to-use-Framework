package steps;

import context.TestContext;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks extends TestContext{
    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }
    private static final Logger log = LogManager.getLogger();

    // TODO:: clear log file and archive previous test report with archived date
    // TODO:: after test cleanup procedure -> i.e., revert test account to previous state

//    @BeforeAll
//    public void beforeStartingTestSuite(){
//      log.info("Pre-test procedure initiated...")
//    }

    @Before
    public void beforeScenario(Scenario scenario){
        log.info("Test Scenario - [" + scenario.getName() + "] - Status --> (EXECUTED)");
    }

    @After
    public void afterScenario(Scenario scenario){
        log.info("Test Scenario - [" + scenario.getName() + "] - Status --> (" + scenario.getStatus() + ")");

        log.info("Test Scenario state clearing procedure initiated...");

        clearGlobalVariable();
        log.info("Global variables deleted");

        setAccessToken(null);
        log.info("Access token is set to null");

        setResponse(null);
        log.info("HTTP Response state is set to null");
        log.info("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

//    @AfterAll
//    public void afterExecutingTestSuite(){
//        log.info("Post-test procedure initiated...");
//    }
}
