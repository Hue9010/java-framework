package next.controller.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.mvc.JspView;
import core.mvc.ModelAndView;
import next.controller.Controller;
import next.dao.UserDao;
import next.model.User;

public class LoginController implements Controller {
	private UserDao userDao = UserDao.getInstance();

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		User user = userDao.findByUserId(userId);
		if (user == null) {
			request.setAttribute("loginFailed", true);
			return new ModelAndView(new JspView("/user/login.jsp"));
		}

		if (user.matchPassword(password)) {
			HttpSession session = request.getSession();
			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
			response.sendRedirect("/");
			return new ModelAndView(new JspView("redirect:/"));
		} else {
			request.setAttribute("loginFailed", true);
			return new ModelAndView(new JspView("/user/login.jsp"));
		}
	}

}
