package com.lexicalscope.modweb.logging;

import com.lexicalscope.modweb.appender.StdoutMessageAppender;

public class StdoutServerLog {
   public static ServerLog stdoutServerLog() {
      return new SummaryServerLog(new StdoutMessageAppender());
   }
}
