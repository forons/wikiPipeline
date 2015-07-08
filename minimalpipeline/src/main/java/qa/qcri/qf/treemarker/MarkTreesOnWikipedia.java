package qa.qcri.qf.treemarker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Map<String, List<RichTokenNode>> wikiNodes = new HashMap<>();
		String link;
		for (RichTokenNode richToken : longestList) {
			if (richToken.getMetadata().containsKey(RichNode.WIKI_KEY)) {
				//start comment
				link = richToken.getMetadata().get(RichNode.WIKI_LINK);
				if (!wikiNodes.containsKey(RichNode.WIKI_LINK))
					wikiNodes.put(link, new ArrayList<RichTokenNode>());
				wikiNodes.get(link).add(richToken);
				//end comment
				richToken.getMetadata().remove(RichNode.WIKI_KEY);
			}
		}
		for (RichTokenNode richToken : shortestList) {
			if (richToken.getMetadata().containsKey(RichNode.WIKI_KEY)) {
				//start comment
				link = richToken.getMetadata().get(RichNode.WIKI_LINK);
				if (wikiNodes.containsKey(link)) {
					Marker.addWikipediaTag(richToken, this.markingStrategy);
					for(RichTokenNode token : wikiNodes.get(link)) {
						Marker.addWikipediaTag(token, this.markingStrategy);
					}
				}
				//end comment
				richToken.getMetadata().remove(RichNode.WIKI_KEY);
			}
		}
		
		//SECOND APPROACH

		
//		 for (RichTokenNode richToken : longestList) {
//		
//		 if(this.stopwordSet != null
//		 && this.stopwordSet.contains(richToken.getValue().toLowerCase())) {
//		 continue;
//		 }
//		 if(richToken.getMetadata().containsKey(RichNode.WIKI_KEY)) {
//		 Marker.addWikipediaTag(richToken, this.markingStrategy);
//		 richToken.getMetadata().remove(RichNode.WIKI_KEY);
//		 //TODO cambia o non cambia markando il nodo
//		 }
//		 }
//		
//		 for (RichTokenNode richToken : shortestList) {
//		 if(this.stopwordSet != null
//		 && this.stopwordSet.contains(richToken.getValue().toLowerCase())) {
//		 continue;
//		 }
//		 if(richToken.getMetadata().containsKey(RichNode.WIKI_KEY)) {
//		 Marker.addWikipediaTag(richToken, this.markingStrategy);
//		 richToken.getMetadata().remove(RichNode.WIKI_KEY);
//		 }
//		 }
	}

	/**
	 * 
	 * @param stopwordsPath
	 * @return
	 * @throws IOException
	 */
	public MarkTreesOnWikipedia useStopwords(String stopwordsPath)
			throws IOException {
		this.stopwordSet = new StopWordSet(new String[] { stopwordsPath });

		return this;
	}
}