

/* First created by JCasGen Mon Oct 08 18:56:44 EDT 2012 */
package org.oaqa.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


/** An object that holds a query and results for a search (text search, fact search, KB search, etc.)
 * Updated by JCasGen Fri Jan 18 20:41:49 EST 2013
 * XML source: /Users/elmer/Documents/workspace/oaqa/baseqa/src/main/resources/edu/cmu/lti/oaqa/OAQATypes.xml
 * @generated */
public class Search extends OAQATop {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Search.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Search() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Search(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Search(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: query

  /** getter for query - gets The query in the native syntax of the corresponding search engine.
   * @generated */
  public String getQuery() {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_query == null)
      jcasType.jcas.throwFeatMissing("query", "org.oaqa.model.Search");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Search_Type)jcasType).casFeatCode_query);}
    
  /** setter for query - sets The query in the native syntax of the corresponding search engine. 
   * @generated */
  public void setQuery(String v) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_query == null)
      jcasType.jcas.throwFeatMissing("query", "org.oaqa.model.Search");
    jcasType.ll_cas.ll_setStringValue(addr, ((Search_Type)jcasType).casFeatCode_query, v);}    
   
    
  //*--------------*
  //* Feature: hitList

  /** getter for hitList - gets Hit list of search results, sorted in descreasing order of relevance score.
   * @generated */
  public FSArray getHitList() {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_hitList == null)
      jcasType.jcas.throwFeatMissing("hitList", "org.oaqa.model.Search");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList)));}
    
  /** setter for hitList - sets Hit list of search results, sorted in descreasing order of relevance score. 
   * @generated */
  public void setHitList(FSArray v) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_hitList == null)
      jcasType.jcas.throwFeatMissing("hitList", "org.oaqa.model.Search");
    jcasType.ll_cas.ll_setRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for hitList - gets an indexed value - Hit list of search results, sorted in descreasing order of relevance score.
   * @generated */
  public SearchResult getHitList(int i) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_hitList == null)
      jcasType.jcas.throwFeatMissing("hitList", "org.oaqa.model.Search");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList), i);
    return (SearchResult)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList), i)));}

  /** indexed setter for hitList - sets an indexed value - Hit list of search results, sorted in descreasing order of relevance score.
   * @generated */
  public void setHitList(int i, SearchResult v) { 
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_hitList == null)
      jcasType.jcas.throwFeatMissing("hitList", "org.oaqa.model.Search");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_hitList), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: abstractQuery

  /** getter for abstractQuery - gets The abstract query from which this actual query was generated.
   * @generated */
  public AbstractQuery getAbstractQuery() {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_abstractQuery == null)
      jcasType.jcas.throwFeatMissing("abstractQuery", "org.oaqa.model.Search");
    return (AbstractQuery)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Search_Type)jcasType).casFeatCode_abstractQuery)));}
    
  /** setter for abstractQuery - sets The abstract query from which this actual query was generated. 
   * @generated */
  public void setAbstractQuery(AbstractQuery v) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_abstractQuery == null)
      jcasType.jcas.throwFeatMissing("abstractQuery", "org.oaqa.model.Search");
    jcasType.ll_cas.ll_setRefValue(addr, ((Search_Type)jcasType).casFeatCode_abstractQuery, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: searchId

  /** getter for searchId - gets An identifier for this search result.  Used to collect hit-list objects that belong to this search result after they've been split out for parallel processing then gathered up again.
   * @generated */
  public String getSearchId() {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_searchId == null)
      jcasType.jcas.throwFeatMissing("searchId", "org.oaqa.model.Search");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Search_Type)jcasType).casFeatCode_searchId);}
    
  /** setter for searchId - sets An identifier for this search result.  Used to collect hit-list objects that belong to this search result after they've been split out for parallel processing then gathered up again. 
   * @generated */
  public void setSearchId(String v) {
    if (Search_Type.featOkTst && ((Search_Type)jcasType).casFeat_searchId == null)
      jcasType.jcas.throwFeatMissing("searchId", "org.oaqa.model.Search");
    jcasType.ll_cas.ll_setStringValue(addr, ((Search_Type)jcasType).casFeatCode_searchId, v);}    
  }

    