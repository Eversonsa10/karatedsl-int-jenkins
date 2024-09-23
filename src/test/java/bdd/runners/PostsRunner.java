package bdd.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import bdd.util.ReportUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PostsRunner {

    final static Logger logger = LoggerFactory.getLogger(PostsRunner.class);

    @Test
    public void testPosts(){
        logger.info("Executando testes na api de Posts");
         Results results =
                Runner.path("classpath:bdd/feature")
                        .tags("@Post")
                        .outputCucumberJson(true)
                        .parallel(2);

       ReportUtil.generateCucumberReport( results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}
