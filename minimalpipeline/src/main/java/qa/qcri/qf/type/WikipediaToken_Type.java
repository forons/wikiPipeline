
/* First created by JCasGen Wed Jun 03 16:24:02 CEST 2015 */
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
 * Updated by JCasGen Wed Jun 03 18:00:13 CEST 2015
 * @generated */
public class WikipediaToken_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (WikipediaToken_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = WikipediaToken_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new WikipediaToken(addr, WikipediaToken_Type.this);
  			   WikipediaToken_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new WikipediaToken(addr, WikipediaToken_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = WikipediaToken.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("qa.qcri.qf.type.WikipediaToken");
 
  /** @generated */
  final Feature casFeat_WikipediaTokened;
  /** @generated */
  final int     casFeatCode_WikipediaTokened;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getWikipediaTokened(int addr) {
        if (featOkTst && casFeat_WikipediaTokened == null)
      jcas.throwFeatMissing("WikipediaTokened", "qa.qcri.qf.type.WikipediaToken");
    return ll_cas.ll_getStringValue(addr, casFeatCode_WikipediaTokened);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setWikipediaTokened(int addr, String v) {
        if (featOkTst && casFeat_WikipediaTokened == null)
      jcas.throwFeatMissing("WikipediaTokened", "qa.qcri.qf.type.WikipediaToken");
    ll_cas.ll_setStringValue(addr, casFeatCode_WikipediaTokened, v);}
    
  
 
  /** @generated */
  final Feature casFeat_WikipediaIsEntity;
  /** @generated */
  final int     casFeatCode_WikipediaIsEntity;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public boolean getWikipediaIsEntity(int addr) {
        if (featOkTst && casFeat_WikipediaIsEntity == null)
      jcas.throwFeatMissing("WikipediaIsEntity", "qa.qcri.qf.type.WikipediaToken");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_WikipediaIsEntity);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setWikipediaIsEntity(int addr, boolean v) {
        if (featOkTst && casFeat_WikipediaIsEntity == null)
      jcas.throwFeatMissing("WikipediaIsEntity", "qa.qcri.qf.type.WikipediaToken");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_WikipediaIsEntity, v);}
    
  
 
  /** @generated */
  final Feature casFeat_WikipediaLink;
  /** @generated */
  final int     casFeatCode_WikipediaLink;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getWikipediaLink(int addr) {
        if (featOkTst && casFeat_WikipediaLink == null)
      jcas.throwFeatMissing("WikipediaLink", "qa.qcri.qf.type.WikipediaToken");
    return ll_cas.ll_getStringValue(addr, casFeatCode_WikipediaLink);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setWikipediaLink(int addr, String v) {
        if (featOkTst && casFeat_WikipediaLink == null)
      jcas.throwFeatMissing("WikipediaLink", "qa.qcri.qf.type.WikipediaToken");
    ll_cas.ll_setStringValue(addr, casFeatCode_WikipediaLink, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public WikipediaToken_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_WikipediaTokened = jcas.getRequiredFeatureDE(casType, "WikipediaTokened", "uima.cas.String", featOkTst);
    casFeatCode_WikipediaTokened  = (null == casFeat_WikipediaTokened) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_WikipediaTokened).getCode();

 
    casFeat_WikipediaIsEntity = jcas.getRequiredFeatureDE(casType, "WikipediaIsEntity", "uima.cas.Boolean", featOkTst);
    casFeatCode_WikipediaIsEntity  = (null == casFeat_WikipediaIsEntity) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_WikipediaIsEntity).getCode();

 
    casFeat_WikipediaLink = jcas.getRequiredFeatureDE(casType, "WikipediaLink", "uima.cas.String", featOkTst);
    casFeatCode_WikipediaLink  = (null == casFeat_WikipediaLink) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_WikipediaLink).getCode();

  }
}



    