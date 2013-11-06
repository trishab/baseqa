package edu.cmu.lti.oaqa.gerp.core;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

import com.google.common.collect.Lists;

import edu.cmu.lti.oaqa.gerp.data.EvidenceWrapper;
import edu.cmu.lti.oaqa.gerp.data.Gerpable;

public abstract class AbstractIndependentEvidencerProvider<W extends Gerpable> extends
        AbstractEvidencerProvider<W> {

  protected abstract EvidenceWrapper<?, ?> evidence(W gerpable);

  @Override
  public List<EvidenceWrapper<?, ?>> evidence(List<W> gerpables)
          throws AnalysisEngineProcessException {
    List<EvidenceWrapper<?, ?>> evidences = Lists.newArrayList();
    for (W gerpable : gerpables) {
      evidences.add(evidence(gerpable));
    }
    return evidences;
  }
}