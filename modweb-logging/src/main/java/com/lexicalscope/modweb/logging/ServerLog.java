package com.lexicalscope.modweb.logging;

import java.io.IOException;

public interface ServerLog extends AutoCloseable {
   @Override void close() throws IOException;

   void connectionOpen();
   void connectionClosed();

   void processing();
   void shutdown();
}
