package qa.qcri.qf.wikipediaannotator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import it.unitn.disi.wikipedia.models.EntityList;
import it.unitn.disi.wikipedia.models.EntityMention;
import it.unitn.disi.wikipedia.models.Sentences;
import it.unitn.disi.wikipedia.restexecutor.AidaClient;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.descriptor.TypeCapability;
import org.apache.uima.jcas.JCas;
import org.uimafit.util.JCasUtil;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import qa.qcri.qf.type.Lowercase;
import qa.qcri.qf.type.WikipediaToken;

@TypeCapability(outputs = { "qa.qcri.qf.type.WikipediaToken" })
public class WikipediaAnnotator extends
		org.apache.uima.fit.component.JCasAnnotator_ImplBase {

	public static final String AIDA_URI = "aidaURI";
	@ConfigurationParameter(name = AIDA_URI)
	private String aidaURI;

	@Override
	public void process(JCas cas) throws AnalysisEngineProcessException {
		String sentence = cas.getDocumentText();
//		System.out.println(sentence);
//		System.out.println(AIDA_URI + "\t"
//				+ aidaURI);

		AidaClient client = new AidaClient(aidaURI);
		EntityList ent = null;
		Sentences sent = new Sentences();
		sent.setSentence(new ArrayList<>(Arrays.asList(sentence)));
		ent = client.findExemplar(sent, EntityList.class);

		Map<String, List<EntityMention>> map;
		map = ent.getList();

		for (String s : map.keySet()) {
			List<EntityMention> mentionList;
			mentionList = map.get(s);

//			System.out.println("Sentence: " + s);
			for (EntityMention m : mentionList) {
//				System.out.println("\t " + m.getMention() + "  link: "
//						+ m.getLink());
				for(Token token : JCasUtil.select(cas, Token.class)) {
					
					String tokenText = token.getCoveredText();
//					System.out.println("TOKEN_TEXT: " + tokenText);

					if(m.getMention().contains(tokenText)) {
//						System.out.println(tokenText);
						WikipediaToken wikipediaToken = new WikipediaToken(cas);
						wikipediaToken.setBegin(token.getBegin());
						wikipediaToken.setEnd(token.getEnd());
						wikipediaToken.setWikipediaIsEntity(true);
						wikipediaToken.setWikipediaTokened(m.getMention());
						wikipediaToken.setWikipediaLink(m.getLink());
						wikipediaToken.addToIndexes(cas);
					}
				}
				
				
				
//				WikipediaToken wikipediaToken = new WikipediaToken(cas);
//				wikipediaToken.setWikipediaIsEntity(true);
//				wikipediaToken.setWikipediaTokened(m.getMention());
//				wikipediaToken.setWikipediaLink(m.getLink());
//				wikipediaToken.addToIndexes(cas);
			}
			System.out.println(" ");
		}
	}
}
