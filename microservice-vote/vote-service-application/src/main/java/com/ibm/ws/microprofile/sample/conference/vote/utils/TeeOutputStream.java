/*
 * (C) Copyright IBM Corporation 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.ws.microprofile.sample.conference.vote.utils;

import java.io.IOException;
import java.io.OutputStream;

public final class TeeOutputStream extends OutputStream {

	  private final OutputStream out;
	  private final OutputStream tee;

	  public TeeOutputStream(OutputStream out, OutputStream tee) {
	    if (out == null)
	      throw new NullPointerException();
	    else if (tee == null)
	      throw new NullPointerException();

	    this.out = out;
	    this.tee = tee;
	  }

	  @Override
	  public void write(int b) throws IOException {
	    out.write(b);
	    tee.write(b);
	  }

	  @Override
	  public void write(byte[] b) throws IOException {
	    out.write(b);
	    tee.write(b);
	  }

	  @Override
	  public void write(byte[] b, int off, int len) throws IOException {
	    out.write(b, off, len);
	    tee.write(b, off, len);
	  }

	  @Override
	  public void flush() throws IOException {
	    out.flush();
	    tee.flush();
	  }

	  @Override
	  public void close() throws IOException {
	    out.close();
	    tee.close();
	  }
	}