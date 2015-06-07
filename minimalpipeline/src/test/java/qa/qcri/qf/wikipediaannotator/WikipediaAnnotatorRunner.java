package qa.qcri.qf.wikipediaannotator;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import java.util.HashMap;
import java.util.Map;

import org.apache.uima.UIMAException;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.uimafit.util.JCasUtil;

import qa.qcri.qf.tutorial.TutorialExample;
import qa.qcri.qf.type.WikipediaToken;
import qa.qcri.qf.wikipediaannotator.WikipediaAnnotator;
import qa.qcri.qf.pipeline.Analyzer;
import qa.qcri.qf.pipeline.retrieval.Analyzable;
import qa.qcri.qf.pipeline.retrieval.SimpleContent;
import qa.qcri.qf.pipeline.serialization.UIMANoPersistence;

public class WikipediaAnnotatorRunner {

	public static void main(String[] args) {

		Analyzable test = new SimpleContent(
				"With United, Beckham won the Premier League title 6 times.",
				"With United, Beckham won the Premier League title 6 times.");

		try {
//			Analyzer analyzer = new Analyzer(new UIMANoPersistence());
			Analyzer analyzer = TutorialExample.instantiateTrecAnalyzer(new UIMANoPersistence());

//			analyzer.addAE(AnalysisEngineFactory
//					.createEngine(createEngineDescription(
//							WikipediaAnnotator.class,
//							WikipediaAnnotator.AIDA_URI,
//							"http://sneezy.disi.unitn.eu:8080/ExAidaLighy-1.0-SNAPSHOT/aida/")));

			JCas cas = JCasFactory.createJCas();

			analyzer.analyze(cas, test);

			Map<String, WikipediaToken> wikiTokens = new HashMap<>();
			for (WikipediaToken wikiToken : JCasUtil.select(cas,
					WikipediaToken.class)) {
				wikiTokens.put(wikiToken.getCoveredText(), wikiToken);
			}
			
			WikipediaToken wikiToken;
			for (Map.Entry<String, WikipediaToken> entry : wikiTokens
					.entrySet()) {
				wikiToken = entry.getValue();
				System.out.println(wikiToken.getCoveredText() + " "
						+ wikiToken.getWikipediaTokened() + " "
						+ wikiToken.getWikipediaIsEntity() + " "
						+ wikiToken.getWikipediaLink());
			}

		} catch (UIMAException e) {
			e.printStackTrace();
		}
	}
}
