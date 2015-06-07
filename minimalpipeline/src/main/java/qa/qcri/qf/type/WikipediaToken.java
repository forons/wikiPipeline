

/* First created by JCasGen Wed Jun 03 16:24:02 CEST 2015 */
package qa.qcri.qf.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;

/** 
 * Updated by JCasGen Wed Jun 03 18:00:13 CEST 2015
 * XML source: /Users/forons/Desktop/IBM Watson/minimalpipeline/desc/Iyas/WikipediaToken.xml
 * @generated */
public class WikipediaToken extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(WikipediaToken.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected WikipediaToken() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public WikipediaToken(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public WikipediaToken(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public WikipediaToken(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: WikipediaTokened

  /** getter for WikipediaTokened - gets 
   * @generated
   * @return value of the feature 
   */
  public String getWikipediaTokened() {
    if (WikipediaToken_Type.featOkTst && ((WikipediaToken_Type)jcasType).casFeat_WikipediaTokened == null)
      jcasType.jcas.throwFeatMissing("WikipediaTokened", "qa.qcri.qf.type.WikipediaToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((WikipediaToken_Type)jcasType).casFeatCode_WikipediaTokened);}
    
  /** setter for WikipediaTokened - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setWikipediaTokened(String v) {
    if (WikipediaToken_Type.featOkTst && ((WikipediaToken_Type)jcasType).casFeat_WikipediaTokened == null)
      jcasType.jcas.throwFeatMissing("WikipediaTokened", "qa.qcri.qf.type.WikipediaToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((WikipediaToken_Type)jcasType).casFeatCode_WikipediaTokened, v);}    
   
    
  //*--------------*
  //* Feature: WikipediaIsEntity

  /** getter for WikipediaIsEntity - gets 
   * @generated
   * @return value of the feature 
   */
  public boolean getWikipediaIsEntity() {
    if (WikipediaToken_Type.featOkTst && ((WikipediaToken_Type)jcasType).casFeat_WikipediaIsEntity == null)
      jcasType.jcas.throwFeatMissing("WikipediaIsEntity", "qa.qcri.qf.type.WikipediaToken");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((WikipediaToken_Type)jcasType).casFeatCode_WikipediaIsEntity);}
    
  /** setter for WikipediaIsEntity - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setWikipediaIsEntity(boolean v) {
    if (WikipediaToken_Type.featOkTst && ((WikipediaToken_Type)jcasType).casFeat_WikipediaIsEntity == null)
      jcasType.jcas.throwFeatMissing("WikipediaIsEntity", "qa.qcri.qf.type.WikipediaToken");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((WikipediaToken_Type)jcasType).casFeatCode_WikipediaIsEntity, v);}    
   
    
  //*--------------*
  //* Feature: WikipediaLink

  /** getter for WikipediaLink - gets 
   * @generated
   * @return value of the feature 
   */
  public String getWikipediaLink() {
    if (WikipediaToken_Type.featOkTst && ((WikipediaToken_Type)jcasType).casFeat_WikipediaLink == null)
      jcasType.jcas.throwFeatMissing("WikipediaLink", "qa.qcri.qf.type.WikipediaToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((WikipediaToken_Type)jcasType).casFeatCode_WikipediaLink);}
    
  /** setter for WikipediaLink - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setWikipediaLink(String v) {
    if (WikipediaToken_Type.featOkTst && ((WikipediaToken_Type)jcasType).casFeat_WikipediaLink == null)
      jcasType.jcas.throwFeatMissing("WikipediaLink", "qa.qcri.qf.type.WikipediaToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((WikipediaToken_Type)jcasType).casFeatCode_WikipediaLink, v);}    
  }

    