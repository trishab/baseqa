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

package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.oaqa.model.Passage;

import edu.cmu.lti.oaqa.framework.data.base.BaseAnnotationWrapper;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class PassageCandidate extends BaseAnnotationWrapper<Passage> implements Serializable {

  private static final long serialVersionUID = 1L;

  private String docID;

  private int start;

  private int end;

  private int rank = -1;

  private String queryString;

  public PassageCandidate() {
    super();
  }

  public PassageCandidate(String docID, int start, int end, float score, String queryString)
          throws AnalysisEngineProcessException {
    super();
    this.docID = docID;
    this.start = start;
    this.end = end;
    this.probability = score;
    this.queryString = queryString;
  }

  @Override
  public String toString() {
    return docID + "[" + start + "," + end + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((docID == null) ? 0 : docID.hashCode());
    result = prime * result + end;
    result = prime * result + start;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PassageCandidate other = (PassageCandidate) obj;
    if (docID == null) {
      if (other.docID != null)
        return false;
    } else if (!docID.equals(other.docID))
      return false;
    if (end != other.end)
      return false;
    if (start != other.start)
      return false;
    return true;
  }

  public String getDocID() {
    return docID;
  }

  public void setDocID(String docID) {
    this.docID = docID;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getQueryString() {
    return queryString;
  }

  public void setQueryString(String queryString) {
    this.queryString = queryString;
  }

  @Override
  public void wrap(Passage passage) {
    super.wrap(passage);
    docID = passage.getUri();
    start = passage.getBegin();
    end = passage.getEnd();
    rank = passage.getRank();
    queryString = passage.getQueryString();
  }

  @Override
  public Passage unwrap(JCas jcas) throws Exception {
    Passage passage = super.unwrap(jcas);
    passage.setUri(docID);
    passage.setBegin(start);
    passage.setEnd(end);
    passage.setRank(rank);
    passage.setQueryString(queryString);
    return passage;
  }

  @Override
  public Class<? extends Passage> getTypeClass() {
    return Passage.class;
  }

}
