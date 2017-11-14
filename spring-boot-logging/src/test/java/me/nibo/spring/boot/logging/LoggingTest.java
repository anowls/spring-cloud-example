package me.nibo.spring.boot.logging;

import me.nibo.spring.boot.logging.common.AbstractTestCaseSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author NiBo
 */
public class LoggingTest extends AbstractTestCaseSupport {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test() {
        logger.debug("test");
    }
}
