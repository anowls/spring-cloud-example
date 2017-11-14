package me.nibo.spring.boot.logging.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NiBo
 */
@RestController
@RequestMapping("/logging")
public class LoggingController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "hello/{message}", method = RequestMethod.GET)
    public ResponseEntity hello(@PathVariable String message) {
        logger.debug("Say Hello: {}", message);
        logger.info("Say Hello: {}", message);
        logger.warn("Say Hello: {}", message);
        logger.error("Say Hello: {}", message);
        // 测试系统异常从日志定位到错误代码执行的行数
//        if ("hello".equalsIgnoreCase(message)) {
//            throw new NullPointerException("出错拉！！");
//        }
        logger.debug("测试..{}", message);
        logger.info("测试..{}", message);
        logger.warn("测试..{}", message);
        logger.error("测试..{}", message);
        return ResponseEntity.ok(message);
    }

    @RequestMapping(value = "size/{size}", method = RequestMethod.POST)
    public ResponseEntity hello(@PathVariable int size) {
        for (int i = 0; i < size; i++) {
            logger.debug("测试超过指定大小的日志文件分拆：{}",  i);
        }
        return ResponseEntity.ok("完成");
    }
}
