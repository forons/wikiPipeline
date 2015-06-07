
/* First created by JCasGen Wed Mar 18 12:53:51 CET 2015 */
package qa.qcri.qf.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Mar 18 12:53:51 CET 2015
 * @generated */
public class Lowercase_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Lowercase_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Lowercase_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Lowercase(addr, Lowercase_Type.this);
  			   Lowercase_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Lowercase(addr, Lowercase_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Lowercase.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("qa.qcri.qf.type.Lowercase");
 
  /** @generated */
  final Feature casFeat_uppercaseVersion;
  /** @generated */
  final int     casFeatCode_uppercaseVersion;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getUppercaseVersion(int addr) {
        if (featOkTst && casFeat_uppercaseVersion == null)
      jcas.throwFeatMissing("uppercaseVersion", "qa.qcri.qf.type.Lowercase");
    return ll_cas.ll_getStringValue(addr, casFeatCode_uppercaseVersion);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setUppercaseVersion(int addr, String v) {
        if (featOkTst && casFeat_uppercaseVersion == null)
      jcas.throwFeatMissing("uppercaseVersion", "qa.qcri.qf.type.Lowercase");
    ll_cas.ll_setStringValue(addr, casFeatCode_uppercaseVersion, v);}
    
  
 
  /** @generated */
  final Feature casFeat_postag;
  /** @generated */
  final int     casFeatCode_postag;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPostag(int addr) {
        if (featOkTst && casFeat_postag == null)
      jcas.throwFeatMissing("postag", "qa.qcri.qf.type.Lowercase");
    return ll_cas.ll_getStringValue(addr, casFeatCode_postag);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPostag(int addr, String v) {
        if (featOkTst && casFeat_postag == null)
      jcas.throwFeatMissing("postag", "qa.qcri.qf.type.Lowercase");
    ll_cas.ll_setStringValue(addr, casFeatCode_postag, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Lowercase_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_uppercaseVersion = jcas.getRequiredFeatureDE(casType, "uppercaseVersion", "uima.cas.String", featOkTst);
    casFeatCode_uppercaseVersion  = (null == casFeat_uppercaseVersion) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_uppercaseVersion).getCode();

 
    casFeat_postag = jcas.getRequiredFeatureDE(casType, "postag", "uima.cas.String", featOkTst);
    casFeatCode_postag  = (null == casFeat_postag) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_postag).getCode();

  }
}



    