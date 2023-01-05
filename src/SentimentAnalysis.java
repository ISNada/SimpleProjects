import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class SentimentAnalysis {

	public static void main(String[] args) throws IOException {

	StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
	
	 Path fileName
     = Path.of("Resources/sentimenttest.txt");

	 // Now calling Files.readString() method to
	 // read the file into the string
	 String str = Files.readString(fileName);
	
	 
	 //Pipelines produce CoreDocuments, data objects that contain all of the annotation information
	 //object contains the string from the text file
	 //so this is to create a document object
     CoreDocument coreDocument = new CoreDocument(str);
	
     
     //.ANNOTATE() : Annotate the CoreDocument wrapper
	stanfordCoreNLP.annotate(coreDocument);
	
	//list of sentences in this document
	coreDocument.sentences();
	
	//the list of sentences in the text file
	List<CoreSentence> sentences = coreDocument.sentences();
	
	for(CoreSentence sentence : sentences ) {
		//sentence.sentiment() shows the Positive/Negative/Neutral sentences.
		String sentiment = sentence.sentiment();
		
		System.out.println(sentiment + "\t" + sentence);
	}
		
	}

}
