package core.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.controller.Controller;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
	private RequestMapping requestMapping;

	@Override
	public void init() throws ServletException {
		requestMapping = RequestMapping.createRequestMapping();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller controller = requestMapping.findController(req.getRequestURI());
		try {
			String path = controller.execute(req, resp);
			send(req, resp, path);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	private void send(HttpServletRequest req, HttpServletResponse resp, String path)
			throws IOException, ServletException {
		if (path.startsWith("redirect:")) {
			resp.sendRedirect(path.split(":")[1]);
			return;
		}
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
}
