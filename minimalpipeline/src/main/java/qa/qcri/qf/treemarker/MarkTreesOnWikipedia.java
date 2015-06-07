package qa.qcri.qf.treemarker;
import java.io.IOException;
import java.util.List;

import qa.qcri.qf.trees.TokenTree;
import qa.qcri.qf.trees.nodes.RichNode;
import qa.qcri.qf.trees.nodes.RichTokenNode;
import de.tudarmstadt.ukp.dkpro.core.stopwordremover.StopWordSet;

/**
 * 
 * This class establishes matches between RichTokenNodes of trees, comparing
 * their representations. A relational tag is added to matching nodes
 */
public class MarkTreesOnWikipedia {

	private MarkingStrategy markingStrategy;

	/**
	 * Stopword
	 */
	private StopWordSet stopwordSet;
	
	/**
	 * @param markingStrategy
	 */
	public MarkTreesOnWikipedia(MarkingStrategy markingStrategy) {
		this.markingStrategy = markingStrategy;
	}

	/**
	 * Marks the nodes of matching trees
	 * 
	 * @param a
	 *            the first TokenTree root node
	 * @param b
	 *            the second TokenTree root node
	 * @param parameterList
	 *            the list of parameters influencing the output
	 */
	public void markTrees(TokenTree a, TokenTree b, String parameterList) {
		
		List<RichTokenNode> tokenNodesFromA = a.getTokens();
		List<RichTokenNode> tokenNodesFromB = b.getTokens();

		List<RichTokenNode> longestList = tokenNodesFromA;
		List<RichTokenNode> shortestList = tokenNodesFromB;

		if (longestList.size() < shortestList.size()) {
			longestList = tokenNodesFromB;
			shortestList = tokenNodesFromA;
		}

//		Map<String, List<RichTokenNode>> formToNodes = new HashMap<>();
		for (RichTokenNode richToken : longestList) {
			
			if(this.stopwordSet != null
					&& this.stopwordSet.contains(richToken.getValue().toLowerCase())) {
				continue;
			}
			if(richToken.getMetadata().containsKey(RichNode.WIKI_KEY)) {
				Marker.addWikipediaTag(richToken, this.markingStrategy);
				richToken.getMetadata().remove(RichNode.WIKI_KEY);
				//TODO cambia o non cambia markando il nodo
			}
		}

		for (RichTokenNode richToken : shortestList) {
			if(this.stopwordSet != null
					&& this.stopwordSet.contains(richToken.getValue().toLowerCase())) {
				continue;
			}
			if(richToken.getMetadata().containsKey(RichNode.WIKI_KEY)) {
				Marker.addWikipediaTag(richToken, this.markingStrategy);
				richToken.getMetadata().remove(RichNode.WIKI_KEY);
			}
		}
	}

	/**
	 * 
	 * @param stopwordsPath
	 * @return
	 * @throws IOException
	 */
	public MarkTreesOnWikipedia useStopwords(String stopwordsPath) throws IOException {
		this.stopwordSet = new StopWordSet(
				new String[] { stopwordsPath });
		
		return this;
	}
}