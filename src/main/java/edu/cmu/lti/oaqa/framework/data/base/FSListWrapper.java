/*
 *  Copyright 2013 Carnegie Mellon University
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package edu.cmu.lti.oaqa.framework.data.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.oaqa.model.OAQATop;

import edu.cmu.lti.oaqa.framework.BaseJCasHelper;

public abstract class FSListWrapper<T extends OAQATop> implements ContainerWrapper<T> {

  protected JCas jcas;

  protected FSList list;

  public FSListWrapper(JCas jcas) {
    this.jcas = jcas;
    list = new FSList(jcas);
  }

  @Override
  public void add(AnnotationWrapper<T> annotation) throws Exception {
    list = BaseJCasHelper.addToFSList(jcas, list, annotation.unwrap(jcas));
  }

  @Override
  public abstract void clear();

  @Override
  public abstract void complete();

  protected final <W extends AnnotationWrapper<T>> void setList(Collection<W> wrappers)
          throws Exception {
    clear();
    for (W wrapper : wrappers) {
      add(wrapper);
    }
    complete();
  }

  protected final <W extends AnnotationWrapper<T>> List<W> getList(Class<T> type,
          Class<W> classWrapper) throws AnalysisEngineProcessException {
    List<W> result = new ArrayList<W>();
    for (OAQATop top : BaseJCasHelper.<OAQATop> fsIterator(list)) {
      result.add(BaseAnnotationWrapper.wrap(top, type, classWrapper));
    }
    return result;
  }
}
