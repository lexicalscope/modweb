package com.lexicalscope.modweb.logging;

import java.io.IOException;

import com.lexicalscope.modweb.appender.MessageAppender;

public class SummaryServerLog implements ServerLog {
   private final MessageAppender appender;

   public SummaryServerLog(final MessageAppender appender) {
      this.appender = appender;
   }

   @Override
   public void connectionOpen() {
      appender.writeline("connection opened");
   }

   @Override
   public void connectionClosed() {
      appender.writeline("connection closed");
   }

   @Override
   public void processing() {
      appender.writeline("processubg requests");
   }

   @Override
   public void shutdown() {
      appender.writeline("shutdown processing");
   }

   @Override public void close() throws IOException {
      appender.close();
   }
}
