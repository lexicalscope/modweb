package com.lexicalscope.modweb.appender;

import java.io.IOException;
import java.util.Date;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.lexicalscope.modweb.timesource.TimeSource;

public class TestTimeMessageAppenderDecorator {
   public final @Rule JUnitRuleMockery context = new JUnitRuleMockery();
   private @Mock MessageAppender decorated;
   private @Mock TimeSource timeSource;

   private TimeMessageApenderDecorator decorator;

   @Before public void createDecorator() {
      decorator = new TimeMessageApenderDecorator(decorated, timeSource);
   }

   @After public void closeDecorator() throws IOException {
      context.checking(new Expectations(){{
         oneOf(decorated).close();
      }});
      decorator.close();
   }

   @Test public void dateIsPrefixed() {
      context.checking(new Expectations(){{
         oneOf(timeSource).nowDate(); will(returnValue(new Date(1368223911213L)));
         oneOf(decorated).writeline("2013-05-10 22:11:51:213 raw message");
      }});

      decorator.writeline("raw message");
   }
}
