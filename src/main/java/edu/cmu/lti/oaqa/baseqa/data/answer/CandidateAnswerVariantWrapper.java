package edu.cmu.lti.oaqa.baseqa.data.answer;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.answer.CandidateAnswerVariant;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.baseqa.data.nlp.CandidateAnswerOccurrenceWrapper;
import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.gerp.data.GerpTopWrapper;

public class CandidateAnswerVariantWrapper extends GerpTopWrapper<CandidateAnswerVariant> {

  private static final long serialVersionUID = 1L;

  private List<CandidateAnswerOccurrenceWrapper> occurrences;

  private String candidateId;

  private String text;

  private List<String> alternativeNames;

  private String uri;

  private String docId;

  public CandidateAnswerVariantWrapper(List<CandidateAnswerOccurrenceWrapper> occurrences,
          String candidateId, String text, List<String> alternativeNames, String uri, String docId) {
    super();
    this.occurrences = occurrences;
    this.candidateId = candidateId;
    this.text = text;
    this.alternativeNames = alternativeNames;
    this.uri = uri;
    this.docId = docId;
  }

  public CandidateAnswerVariantWrapper() {
    this(Lists.<CandidateAnswerOccurrenceWrapper> newArrayList(), null, null, Lists
            .<String> newArrayList(), null, null);
  }

  public CandidateAnswerVariantWrapper(List<CandidateAnswerOccurrenceWrapper> occurrences,
          String candidateId, String text, List<String> alternativeNames, String uri, String docId,
          String generator) {
    this(occurrences, candidateId, text, alternativeNames, uri, docId);
    addGenerator(generator);
  }

  @Override
  public Class<? extends CandidateAnswerVariant> getTypeClass() {
    return CandidateAnswerVariant.class;
  }

  @Override
  public void wrap(WrapperIndexer indexer, CandidateAnswerVariant top)
          throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    this.occurrences = WrapperHelper.wrapAnnotationList(indexer, top.getOccurrences(),
            CandidateAnswerOccurrenceWrapper.class);
    this.candidateId = top.getCandidateId();
    this.text = top.getText();
    this.alternativeNames = WrapperHelper.wrapStringList(top.getAlternativeNames());
    this.uri = top.getUri();
    this.docId = top.getDocId();
  }

  @Override
  public void unwrap(WrapperIndexer indexer, CandidateAnswerVariant top)
          throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    JCas jcas = WrapperHelper.getJCas(top);
    top.setOccurrences(WrapperHelper.unwrapAnnotationList(indexer, occurrences, jcas));
    top.setCandidateId(candidateId);
    top.setText(text);
    top.setAlternativeNames(WrapperHelper.unwrapStringList(alternativeNames, jcas));
    top.setUri(uri);
    top.setDocId(docId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(text);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CandidateAnswerVariantWrapper other = (CandidateAnswerVariantWrapper) obj;
    return Objects.equal(this.text, other.text);
  }

  public List<CandidateAnswerOccurrenceWrapper> getOccurrences() {
    return occurrences;
  }

  public void setOccurrences(List<CandidateAnswerOccurrenceWrapper> occurrences) {
    this.occurrences = occurrences;
  }

  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<String> getAlternativeNames() {
    return alternativeNames;
  }

  public void setAlternativeNames(List<String> alternativeNames) {
    this.alternativeNames = alternativeNames;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getDocId() {
    return docId;
  }

  public void setDocId(String docId) {
    this.docId = docId;
  }

}