package next.controller.jsp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.jdbc.DataAccessException;
import core.mvc.JspView;
import core.mvc.ModelAndView;
import next.controller.Controller;
import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;

public class ShowQuestionController implements Controller {
	private QuestionDao questionDao = QuestionDao.getInstance();
	private AnswerDao answerDao = AnswerDao.getInstance();
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String questionId = request.getParameter("questionId");
		Question question = questionDao.findByQuestionId(Long.valueOf(questionId));
		if (question == null) {
			throw new DataAccessException("질문을 찾을 수 없습니다.");
		}
		List<Answer> answers = answerDao.findAllByQuestionId(question.getQuestionId());
		request.setAttribute("question", question);
		request.setAttribute("answers", answers);
		return new ModelAndView(new JspView("/qna/show.jsp"));
	}

}
