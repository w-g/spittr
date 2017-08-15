package spittr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FooServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final transient Logger logger = LoggerFactory.getLogger(FooServlet.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		logger.info("## message from foo servlet ##");
		
		PrintWriter writer = null;
		try {
			writer = resp.getWriter();
			writer.write("Hello world.");
		} finally {
			if(writer != null) {
				writer.flush();
				writer.close();
			}
		}

	}
}
