package edu.cmu.lti.oaqa.baseqa.data.nlp;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.nlp.CandidateAnswerOccurrence;

import com.google.common.base.Objects;

import edu.cmu.lti.oaqa.baseqa.data.gerp.GerpAnnotationWrapper;

public class CandidateAnswerOccurrenceWrapper extends
        GerpAnnotationWrapper<CandidateAnswerOccurrence> {

  private static final long serialVersionUID = 1L;

  private String text;

  private String mentionType;

  public CandidateAnswerOccurrenceWrapper(int begin, int end, String text, String mentionType) {
    super(begin, end);
    this.text = text;
    this.mentionType = mentionType;
  }

  public CandidateAnswerOccurrenceWrapper(int begin, int end, String label, String mentionType,
          String generator) {
    super(begin, end, generator);
    this.text = label;
    this.mentionType = mentionType;
  }

  @Override
  public Class<? extends CandidateAnswerOccurrence> getTypeClass() {
    return CandidateAnswerOccurrence.class;
  }

  @Override
  public void wrap(CandidateAnswerOccurrence annotation) throws AnalysisEngineProcessException {
    super.wrap(annotation);
    this.text = annotation.getText();
    this.mentionType = annotation.getMentionType();
  }

  @Override
  public CandidateAnswerOccurrence unwrap(JCas jcas) throws AnalysisEngineProcessException {
    CandidateAnswerOccurrence annotation = super.unwrap(jcas);
    annotation.setText(text);
    annotation.setMentionType(mentionType);
    return annotation;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), mentionType);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    CandidateAnswerOccurrenceWrapper other = (CandidateAnswerOccurrenceWrapper) obj;
    return Objects.equal(this.mentionType, other.mentionType);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getMentionType() {
    return mentionType;
  }

  public void setMentionType(String mentionType) {
    this.mentionType = mentionType;
  }

}
