package com.lexicalscope.modweb.appender;

import java.io.IOException;

public interface MessageAppender extends AutoCloseable {
   @Override void close() throws IOException;

   void writeline(String message);
}
