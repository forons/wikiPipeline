package it.unitn.disi.wikipedia.restexecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import it.unitn.disi.wikipedia.models.EntityList;
import it.unitn.disi.wikipedia.models.EntityMention;
import it.unitn.disi.wikipedia.models.Sentences;

public class AidaTest {
	public static void main(String[] args) {
		AidaClient client = new AidaClient(
				"http://sneezy.disi.unitn.eu:8080/ExAidaLighy-1.0-SNAPSHOT/aida/");
		EntityList ent = null;
//		List<String> ss = new ArrayList();
		String s1 = "With United, Beckham won the Premier League title 6 times.";
		String s2 = "With United, Beckham won the Premier League title 6 times.";
//		ss.add("With United, Beckham won the Premier League title 6 times.");
		Sentences sent = new Sentences();
		sent.setSentence(new ArrayList(Arrays.asList(s1, s2)));
		ent = client.findExemplar(sent, EntityList.class);

		Map<String, List<EntityMention>> map;
		// ent =(EntityList) resp.getEntity();
		map = ent.getList();

		for (String s : map.keySet()) {
			String sentence = s;
			List<EntityMention> mentionList;
			mentionList = map.get(s);

			System.out.println("Sentence: " + sentence);
			for (EntityMention m : mentionList) {
				System.out.println("\t " + m.getMention() + "  link: "
						+ m.getLink());
			}
			System.out.println(" ");

		}
	}
}
