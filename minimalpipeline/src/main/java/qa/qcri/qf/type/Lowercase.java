

/* First created by JCasGen Wed Mar 18 12:53:51 CET 2015 */
package qa.qcri.qf.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Mar 18 12:53:51 CET 2015
 * XML source: ../desc/Iyas/Lowercase.xml
 * @generated */
public class Lowercase extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Lowercase.class);
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
  protected Lowercase() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Lowercase(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Lowercase(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Lowercase(JCas jcas, int begin, int end) {
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
  //* Feature: uppercaseVersion

  /** getter for uppercaseVersion - gets 
   * @generated
   * @return value of the feature 
   */
  public String getUppercaseVersion() {
    if (Lowercase_Type.featOkTst && ((Lowercase_Type)jcasType).casFeat_uppercaseVersion == null)
      jcasType.jcas.throwFeatMissing("uppercaseVersion", "qa.qcri.qf.type.Lowercase");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Lowercase_Type)jcasType).casFeatCode_uppercaseVersion);}
    
  /** setter for uppercaseVersion - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setUppercaseVersion(String v) {
    if (Lowercase_Type.featOkTst && ((Lowercase_Type)jcasType).casFeat_uppercaseVersion == null)
      jcasType.jcas.throwFeatMissing("uppercaseVersion", "qa.qcri.qf.type.Lowercase");
    jcasType.ll_cas.ll_setStringValue(addr, ((Lowercase_Type)jcasType).casFeatCode_uppercaseVersion, v);}    
   
    
  //*--------------*
  //* Feature: postag

  /** getter for postag - gets 
   * @generated
   * @return value of the feature 
   */
  public String getPostag() {
    if (Lowercase_Type.featOkTst && ((Lowercase_Type)jcasType).casFeat_postag == null)
      jcasType.jcas.throwFeatMissing("postag", "qa.qcri.qf.type.Lowercase");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Lowercase_Type)jcasType).casFeatCode_postag);}
    
  /** setter for postag - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPostag(String v) {
    if (Lowercase_Type.featOkTst && ((Lowercase_Type)jcasType).casFeat_postag == null)
      jcasType.jcas.throwFeatMissing("postag", "qa.qcri.qf.type.Lowercase");
    jcasType.ll_cas.ll_setStringValue(addr, ((Lowercase_Type)jcasType).casFeatCode_postag, v);}    
  }

    