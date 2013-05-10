package com.lexicalscope.modweb.logging;

import java.io.IOException;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.lexicalscope.modweb.appender.MessageAppender;

public class TestSummaryServerLog {
   public final @Rule JUnitRuleMockery context = new JUnitRuleMockery();
   private @Mock MessageAppender appender;
   private SummaryServerLog log;

   @Before public void createLog() {
      log = new SummaryServerLog(appender);
   }

   @After public void closeLog() throws IOException {
      context.checking(new Expectations(){{
         oneOf(appender).close();
      }});
      log.close();
   }

   @Test public void testOpenConnection() {
      context.checking(new Expectations(){{
         oneOf(appender).writeline("connection opened");
      }});
      log.connectionOpen();
   }
}
