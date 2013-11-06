package edu.cmu.lti.oaqa.core.data;

import java.io.Serializable;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.oaqa.model.core.OAQAAnnotation;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public abstract class OAQAAnnotationWrapper<T extends OAQAAnnotation> implements
        AnnotationWrapper<T>, Comparable<OAQAAnnotationWrapper<T>>, Serializable {

  private static final long serialVersionUID = 1L;

  protected final Class<? extends T> typeClass = getTypeClass();

  public abstract Class<? extends T> getTypeClass();

  protected String implementingWrapper = getClass().getCanonicalName();

  protected int begin;

  protected int end;

  public OAQAAnnotationWrapper(int begin, int end) {
    super();
    this.begin = begin;
    this.end = end;
  }

  public OAQAAnnotationWrapper() {
    this(0, Integer.MAX_VALUE);
  }

  @Override
  public void unwrap(WrapperIndexer indexer, T annotation) throws AnalysisEngineProcessException {
    annotation.setImplementingWrapper(implementingWrapper);
    annotation.setBegin(begin);
    annotation.setEnd(end);
  }

  @Override
  public void wrap(WrapperIndexer indexer, T annotation) throws AnalysisEngineProcessException {
    implementingWrapper = annotation.getImplementingWrapper();
    begin = annotation.getBegin();
    end = annotation.getEnd();
  }

  @Override
  public int compareTo(OAQAAnnotationWrapper<T> o) {
    return ComparisonChain.start().compare(begin, o.begin).compare(end, o.end).result();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(begin, end);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    @SuppressWarnings("rawtypes")
    OAQAAnnotationWrapper other = (OAQAAnnotationWrapper) obj;
    return Objects.equal(this.begin, other.begin) && Objects.equal(this.end, other.end);
  }

  @Override
  public String getImplementingWrapper() {
    return implementingWrapper;
  }

  @Override
  public void setImplementingWrapper(String implementingWrapper) {
    this.implementingWrapper = implementingWrapper;
  }

  @Override
  public int getBegin() {
    return begin;
  }

  public void setBegin(int begin) {
    this.begin = begin;
  }

  @Override
  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

}