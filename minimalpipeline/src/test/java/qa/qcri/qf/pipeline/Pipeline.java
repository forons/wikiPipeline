package qa.qcri.qf.pipeline;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import qa.qcri.qf.annotators.IllinoisChunker;
import qa.qcri.qf.pipeline.retrieval.Analyzable;
import qa.qcri.qf.pipeline.retrieval.SimpleContent;
import qa.qcri.qf.pipeline.serialization.UIMANoPersistence;
import qa.qcri.qf.trees.RichTree;
import qa.qcri.qf.trees.TreeSerializer;
import qa.qcri.qf.trees.nodes.RichNode;

import com.google.common.base.Joiner;

import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordNamedEntityRecognizer;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;

public class Pipeline {

	private static JCas cas;

	@BeforeClass
	public static void setUp() throws UIMAException {
		Analyzer ae = new Analyzer(new UIMANoPersistence());
		
		AnalysisEngine breakIteratorSegmenter = AnalysisEngineFactory.createEngine(
				createEngineDescription(BreakIteratorSegmenter.class));
		
		AnalysisEngine stanfordParser = AnalysisEngineFactory.createEngine(
				createEngineDescription(StanfordParser.class));
		
		AnalysisEngine illinoisChunker = AnalysisEngineFactory.createEngine(
				createEngineDescription(IllinoisChunker.class));
		
		AnalysisEngine stanfordNamedEntityRecognizer = AnalysisEngineFactory.createEngine(
				createEngineDescription(StanfordNamedEntityRecognizer.class));

		ae.addAE(breakIteratorSegmenter)
			.addAE(stanfordParser)
			.addAE(illinoisChunker)
			.addAE(stanfordNamedEntityRecognizer);

		Analyzable content = new SimpleContent("sample-content",
				"The apple is on the table and Barack Obama is the president of United States of America.");

		cas = JCasFactory.createJCas();

		ae.analyze(cas, content);
	}

	@Test
	public void testTokenPosChunkTree() throws UIMAException {

		String lowercase = Joiner.on(",").join(
				new String[] { RichNode.OUTPUT_PAR_TOKEN });

		TreeSerializer ts = new TreeSerializer();
		RichNode posChunkTree = RichTree.getPosChunkTree(cas);

		Assert.assertEquals(
				"(ROOT (S (NP (DT (The))(NN (apple)))(VP (VBZ (is)))(PP (IN (on)))(NP (DT (the))(NN (table)))(NP (NNP (Barack))(NNP (Obama)))(VP (VBZ (is)))(NP (DT (the))(NN (president)))(PP (IN (of)))(NP (NNP (United))(NNPS (States)))(PP (IN (of)))(NP (NNP (America)))))",
				ts.serializeTree(posChunkTree, lowercase));
	}

	@Test
	public void testLowercasePosChunkTree() throws UIMAException {

		String lowercase = Joiner.on(",").join(
				new String[] { RichNode.OUTPUT_PAR_TOKEN_LOWERCASE });

		TreeSerializer ts = new TreeSerializer();
		RichNode posChunkTree = RichTree.getPosChunkTree(cas);

		Assert.assertEquals(
				"(ROOT (S (NP (DT (the))(NN (apple)))(VP (VBZ (is)))(PP (IN (on)))(NP (DT (the))(NN (table)))(NP (NNP (barack))(NNP (obama)))(VP (VBZ (is)))(NP (DT (the))(NN (president)))(PP (IN (of)))(NP (NNP (united))(NNPS (states)))(PP (IN (of)))(NP (NNP (america)))))",
				ts.serializeTree(posChunkTree, lowercase));
	}

	@Test
	public void testLemmaPosChunkTree() throws UIMAException {

		String lemma = Joiner.on(",").join(
				new String[] { RichNode.OUTPUT_PAR_LEMMA });

		TreeSerializer ts = new TreeSerializer();
		RichNode posChunkTree = RichTree.getPosChunkTree(cas);

		/**
		 * Lemmas are lowercased by the annotator
		 */

		Assert.assertEquals(
				"(ROOT (S (NP (DT (the))(NN (apple)))(VP (VBZ (be)))(PP (IN (on)))(NP (DT (the))(NN (table)))(NP (NNP (Barack))(NNP (Obama)))(VP (VBZ (be)))(NP (DT (the))(NN (president)))(PP (IN (of)))(NP (NNP (United))(NNPS (States)))(PP (IN (of)))(NP (NNP (America)))))",
				ts.serializeTree(posChunkTree, lemma));
	}

}