package cn.brianxia.brian.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class OpLog {

    private static Logger logger = LoggerFactory.getLogger(OpLog.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void optLogAOP(){

    }

    @Around("optLogAOP()")
    public Object aroundOplog(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();

        Object retVal = joinPoint.proceed();//执行主方法

        long end = System.currentTimeMillis();

        logger.info("调用方法：{}，\n参数：{}，\n执行耗时：{}纳秒，\r\n耗时：{}毫秒",
                joinPoint.getSignature().toString(), Arrays.toString(joinPoint.getArgs()),
                (end - start), (end - start) / 1000000);

        return retVal;
    }
}
