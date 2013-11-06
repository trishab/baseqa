package edu.cmu.lti.oaqa.baseqa.data.kb;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.kb.Concept;
import org.oaqa.model.kb.Relation;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.core.data.WrapperHelper;
import edu.cmu.lti.oaqa.core.data.WrapperIndexer;

public class RelationWrapper extends ConceptWrapper {

  private static final long serialVersionUID = 1L;

  private List<EntityWrapper> arguments;

  public RelationWrapper(String name, List<String> ids, List<ConceptMentionWrapper> mentions,
          List<EntityWrapper> arguments) {
    super(name, ids, mentions);
    this.arguments = arguments;
  }

  public RelationWrapper(String name, List<String> ids, List<ConceptMentionWrapper> mentions,
          List<EntityWrapper> arguments, String generator) {
    this(name, ids, mentions, arguments);
    addGenerator(generator);
  }

  public RelationWrapper() {
    this(null, Lists.<String> newArrayList(), Lists.<ConceptMentionWrapper> newArrayList(), Lists
            .<EntityWrapper> newArrayList());
  }

  @Override
  public Class<? extends Relation> getTypeClass() {
    return Relation.class;
  }

  @Override
  public void wrap(WrapperIndexer indexer, Concept top) throws AnalysisEngineProcessException {
    super.wrap(indexer, top);
    this.arguments = WrapperHelper.wrapTopList(indexer, ((Relation) top).getArguments(),
            EntityWrapper.class);
  }

  @Override
  public void unwrap(WrapperIndexer indexer, Concept top) throws AnalysisEngineProcessException {
    super.unwrap(indexer, top);
    ((Relation) top).setArguments(WrapperHelper.unwrapTopList(indexer, arguments,
            WrapperHelper.getJCas(top)));
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), arguments);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    RelationWrapper other = (RelationWrapper) obj;
    return Objects.equal(this.arguments, other.arguments);
  }

  public List<EntityWrapper> getArguments() {
    return arguments;
  }

  public void setArguments(List<EntityWrapper> arguments) {
    this.arguments = arguments;
  }

}