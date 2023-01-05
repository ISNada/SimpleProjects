import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

//a pipeline takes a text then run annotators on the text
//annotation is giving a full understanding of the text's meaning and context.

public class Pipeline {
	
	//Pipelines are constructed with Properties objects which provide specifications for what annotators to run and how to customize the annotators
	private static Properties properties;
	private static String propertiesName = "tokenize, ssplit, pos, lemma, ner, parse, sentiment";
	private static StanfordCoreNLP stanfordCoreNLP;
	
	private Pipeline() { }
	
	static { 
		// set up pipeline properties
		properties = new Properties();
		// set the list of annotators to run
		properties.setProperty("annotators", propertiesName);
	}
	
	public static StanfordCoreNLP getPipeline() {
		if(stanfordCoreNLP == null) {
			// build pipeline
			stanfordCoreNLP = new StanfordCoreNLP(properties);
		}
		return stanfordCoreNLP;
	}
	
	
	public static void main(String [] args) {
			
		
	}

}
