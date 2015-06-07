package qa.qcri.qf.reversetokenizer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class OpenNLPTokenizerRunner {

	public static void main(String[] args) {

		InputStream modelIn = null;
		try {
			modelIn = new FileInputStream(
					"src/test/resources/opennlp-tokenizer/en-token.bin");

			TokenizerModel model = new TokenizerModel(modelIn);

			Tokenizer tokenizer = new TokenizerME(model);

			String tokens[] = tokenizer.tokenize("An input sample sentence.");

			Span tokenSpans[] = tokenizer
					.tokenizePos("An input sample sentence.");

			for (String token : tokens) {
				System.out.println(token);
			}

			for (Span span : tokenSpans) {
				System.out.println(span.getStart() + " " + span.getEnd());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
				}
			}
		}
	}
}