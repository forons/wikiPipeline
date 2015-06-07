package qa.qcri.qf.reversetokenizer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.descriptor.TypeCapability;
import org.apache.uima.jcas.JCas;

import qa.qcri.qf.type.ReverseToken;

@TypeCapability(outputs = {
			"qa.qcri.qf.type.ReverseToken"
		})

public class ReverseTokenizer extends
		org.apache.uima.fit.component.JCasAnnotator_ImplBase {

	public static final String PARAM_TOKENIZER_MODEL = "tokenizerModel";
	@ConfigurationParameter(name = PARAM_TOKENIZER_MODEL)
	private String tokenizerModel;

	private Tokenizer tokenizer;

	@Override
	public void process(JCas cas) throws AnalysisEngineProcessException {

		// Lazy loading
		if (this.tokenizer == null) {
			init();
		}

		String text = cas.getDocumentText();

		Span tokenSpans[] = tokenizer.tokenizePos(text);

		for (Span span : tokenSpans) {
			String token = text.substring(span.getStart(), span.getEnd());
			String reversedToken = new StringBuilder(token).reverse()
					.toString();

			ReverseToken reverseToken = new ReverseToken(cas);
			reverseToken.setReversedToken(reversedToken);
			reverseToken.setBegin(span.getStart());
			reverseToken.setEnd(span.getEnd());
			reverseToken.addToIndexes();
		}
	}

	private void init() {
		try {
			InputStream modelIn = new FileInputStream(this.tokenizerModel);
			TokenizerModel model = new TokenizerModel(modelIn);
			this.tokenizer = new TokenizerME(model);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}