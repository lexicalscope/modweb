package com.lexicalscope.modweb.appender;



public class StdoutMessageAppender implements MessageAppender {
   @Override public void close() {
      // nothing to do
   }

   @Override
   public void writeline(final String message) {
      System.out.println(message);
   }
}
