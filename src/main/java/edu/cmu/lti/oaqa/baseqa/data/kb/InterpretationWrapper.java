package edu.cmu.lti.oaqa.baseqa.data.kb;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.kb.Interpretation;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.gerp.data.GerpTopWrapper;

public class InterpretationWrapper extends GerpTopWrapper<Interpretation> {

  private static final long serialVersionUID = 1L;

  private List<ConceptWrapper> concepts;

  private List<ConceptMentionWrapper> mentions;

  public InterpretationWrapper(List<ConceptWrapper> concepts, List<ConceptMentionWrapper> mentions) {
    super();
    this.concepts = concepts;
    this.mentions = mentions;
  }

  public InterpretationWrapper(List<ConceptWrapper> concepts, List<ConceptMentionWrapper> mentions,
          String generator) {
    this(concepts, mentions);
    addGenerator(generator);
  }

  public InterpretationWrapper() {
    this(Lists.<ConceptWrapper> newArrayList(), Lists.<ConceptMentionWrapper> newArrayList());
  }

  @Override
  public Class<? extends Interpretation> getTypeClass() {
    return Interpretation.class;
  }

  @Override
  public void wrap(WrapperIndexer indexer, Interpretation top)
          throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    this.concepts = WrapperHelper.wrapTopList(indexer, top.getConcepts(), ConceptWrapper.class);
    this.mentions = WrapperHelper.wrapAnnotationList(indexer, top.getMentions(),
            ConceptMentionWrapper.class);
  }

  @Override
  public void unwrap(WrapperIndexer indexer, Interpretation top)
          throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    JCas jcas = WrapperHelper.getJCas(top);
    top.setConcepts(WrapperHelper.unwrapTopList(indexer, concepts, jcas));
    top.setMentions(WrapperHelper.unwrapAnnotationList(indexer, mentions, jcas));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(concepts, mentions);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    InterpretationWrapper other = (InterpretationWrapper) obj;
    return Objects.equal(this.concepts, other.concepts)
            && Objects.equal(this.mentions, other.mentions);
  }

  public List<ConceptWrapper> getConcepts() {
    return concepts;
  }

  public void setConcepts(List<ConceptWrapper> concepts) {
    this.concepts = concepts;
  }

  public List<ConceptMentionWrapper> getMentions() {
    return mentions;
  }

  public void setMentions(List<ConceptMentionWrapper> mentions) {
    this.mentions = mentions;
  }

}