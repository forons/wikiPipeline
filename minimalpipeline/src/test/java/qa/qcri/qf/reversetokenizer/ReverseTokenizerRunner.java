package qa.qcri.qf.reversetokenizer;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import org.apache.uima.UIMAException;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.uimafit.util.JCasUtil;

import qa.qcri.qf.type.ReverseToken;
import qa.qcri.qf.pipeline.Analyzer;
import qa.qcri.qf.pipeline.retrieval.Analyzable;
import qa.qcri.qf.pipeline.retrieval.SimpleContent;
import qa.qcri.qf.pipeline.serialization.UIMANoPersistence;

public class ReverseTokenizerRunner {

	public static void main(String[] args) {

		Analyzable test = new SimpleContent("test", "This is an example.");

		try {
			Analyzer analyzer = new Analyzer(new UIMANoPersistence());

			analyzer.addAE(AnalysisEngineFactory
					.createEngine(createEngineDescription(
							ReverseTokenizer.class,
							ReverseTokenizer.PARAM_TOKENIZER_MODEL,
							"src/test/resources/opennlp-tokenizer/en-token.bin")));

			JCas cas = JCasFactory.createJCas();

			analyzer.analyze(cas, test);

			for (ReverseToken token : JCasUtil.select(cas, ReverseToken.class)) {
				System.out.println(token.getCoveredText() + " "
						+ token.getReversedToken());
			}

		} catch (UIMAException e) {
			e.printStackTrace();
		}
	}
}