package edu.com.softserveinc.main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import edu.com.softserveinc.main.dao.CommentDao;
import edu.com.softserveinc.main.models.CommentModel;

public class CommentServiceImpl implements CommentService {
	
	@Autowired
    private CommentDao commentDao;
	
	@Override
	public void addComment(CommentModel comment) {
		commentDao.saveAndFlush(comment);
	}

	@Override
	public void deleteComment(CommentModel comment) {
		commentDao.delete(comment);
	}

	@Override
	public void editComment(CommentModel comment) {
		commentDao.saveAndFlush(comment);
	}

	@Override
	public List<CommentModel> getCommentsByIssueId(int issueId) {
		return commentDao.findByIssueId(issueId);
	}
}
