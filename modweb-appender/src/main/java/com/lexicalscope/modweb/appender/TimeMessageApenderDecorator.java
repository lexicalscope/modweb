package com.lexicalscope.modweb.appender;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import com.lexicalscope.modweb.timesource.CurrentTimeSource;
import com.lexicalscope.modweb.timesource.TimeSource;


public class TimeMessageApenderDecorator implements MessageAppender {
   private final SimpleDateFormat dateFormat;
   private final MessageAppender decorated;
   private final TimeSource timeSource;

   public TimeMessageApenderDecorator(final MessageAppender decorated) {
      this(decorated, new CurrentTimeSource());
   }

   public TimeMessageApenderDecorator(final MessageAppender decorated, final TimeSource timeSource) {
      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.UK);
      dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
      this.decorated = decorated;
      this.timeSource = timeSource;
   }

   @Override
   public void close() throws IOException {
      decorated.close();
   }

   @Override
   public void writeline(final String message) {
      final String formattedDate = dateFormat.format(timeSource.nowDate());
      decorated.writeline(formattedDate + " " + message);
   }
}
