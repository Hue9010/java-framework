package next.controller.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.JspView;
import core.mvc.ModelAndView;
import next.controller.Controller;
import next.dao.UserDao;
import next.model.User;

public class CreateUserController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateUserController.class);
	private UserDao userDao = UserDao.getInstance();

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User(request.getParameter("userId"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("email"));
		log.debug("User : {}", user);
		userDao.insert(user);
		
		return new ModelAndView(new JspView("edirect:/"));
	}
}
