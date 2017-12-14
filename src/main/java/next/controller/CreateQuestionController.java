package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.dao.QuestionDao;
import next.model.Question;

public class CreateQuestionController implements Controller {
	private QuestionDao questionDao = new QuestionDao();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Question question = new Question(
				request.getParameter("writer"), 
				request.getParameter("title"),
				request.getParameter("contents"));
		questionDao.insert(question);
		return "redirect:/";
	}

}