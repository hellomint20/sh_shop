package com.example.demo.config;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RequestWrapper extends HttpServletRequestWrapper {
	private byte[] b;
	private final static Logger filterLog = LoggerFactory.getLogger("XSS_filter_log");
	
	public RequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		b = new String(getBody(request)).getBytes();
	}

	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream bis = new ByteArrayInputStream(b);
		return new ServletInputStreamImpl(bis);
	}

	public class ServletInputStreamImpl extends ServletInputStream {
		private InputStream is;

		public ServletInputStreamImpl(InputStream bis) {
			is = bis;
		}

		public int read() throws IOException {
			return is.read();
		}

		public int read(byte[] b) throws IOException {
			return is.read(b);
		}

		@Override
		public boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setReadListener(ReadListener listener) {
			// TODO Auto-generated method stub
			
		}
	}

	public static String getBody(HttpServletRequest request) throws IOException {
		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		
		try{
			InputStream inputStream = request.getInputStream();

			if (inputStream != null) {
				bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
					}
			} else {
				stringBuilder.append("");
			}
		}catch (IOException ex) {
				throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close(); } 
				catch (IOException ex) {throw ex;
				}
			}
		}
		body = stringBuilder.toString();
		//{"itemName":"select","itemPrice":"1000","itemDesc":"delete","itemCategory":"신발","itemState":"중지","itemNo":"0204"}
		filterLog.info("[ ::: /shop/productModiDo - input 값 확인 : "+body+" ::: ]");
		return body;	
		}
}