package edu.cmu.lti.oaqa.baseqa.data.retrieval;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.retrieval.AbstractQuery;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;
import edu.cmu.lti.oaqa.gerp.data.GerpTopWrapper;

public class AbstractQueryWrapper extends GerpTopWrapper<AbstractQuery> {

  private static final long serialVersionUID = 1L;

  private List<QueryConceptWrapper> concepts;

  public AbstractQueryWrapper(List<QueryConceptWrapper> concepts) {
    super();
    this.concepts = concepts;
  }

  public AbstractQueryWrapper(List<QueryConceptWrapper> concepts, String generator) {
    this(concepts);
    addGenerator(generator);
  }

  public AbstractQueryWrapper() {
    this(Lists.<QueryConceptWrapper> newArrayList());
  }

  @Override
  public Class<? extends AbstractQuery> getTypeClass() {
    return AbstractQuery.class;
  }

  @Override
  public void wrap(WrapperIndexer indexer, AbstractQuery top) throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    this.concepts = WrapperHelper
            .wrapTopList(indexer, top.getConcepts(), QueryConceptWrapper.class);
  }

  @Override
  public void unwrap(WrapperIndexer indexer, AbstractQuery top)
          throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    top.setConcepts(WrapperHelper.unwrapTopList(indexer, concepts, WrapperHelper.getJCas(top)));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(concepts);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AbstractQueryWrapper other = (AbstractQueryWrapper) obj;
    return Objects.equal(this.concepts, other.concepts);
  }

  public List<QueryConceptWrapper> getConcepts() {
    return concepts;
  }

  public void setConcepts(List<QueryConceptWrapper> concepts) {
    this.concepts = concepts;
  }

}