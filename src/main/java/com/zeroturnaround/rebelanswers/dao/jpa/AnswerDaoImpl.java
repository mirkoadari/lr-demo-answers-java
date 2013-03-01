package com.zeroturnaround.rebelanswers.dao.jpa;

import com.zeroturnaround.rebelanswers.dao.AnswerDao;
import com.zeroturnaround.rebelanswers.domain.Answer;

public class AnswerDaoImpl implements AnswerDao {

  private final DaoTools daoTools;

  public AnswerDaoImpl(final DaoTools daoTools) {
    if (null == daoTools) throw new IllegalArgumentException("daoTools can't be null");
    this.daoTools = daoTools;
  }

  public Answer getAnswerById(Long id) {
    return daoTools.findById(Answer.class, id);
  }

  public Answer persistOrMerge(final Answer answer) {
    if (null == answer) throw new IllegalArgumentException("answer can't be null");

    if (answer.getId() == null) {
      return daoTools.persist(Answer.class, answer);
    }
    else {
      return daoTools.merge(Answer.class, answer);
    }
  }
}
