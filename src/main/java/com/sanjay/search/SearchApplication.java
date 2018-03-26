package com.sanjay.search;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanjay.index.Indexer;
import com.sanjay.index.LuceneConstants;

@SpringBootApplication
@RestController
public class SearchApplication {
	@Value("${indexDir}")
	public String indexDir;
	@Value("${dataDir}")
	public String dataDir;
	Indexer indexer;
	Searcher searcher;
	String fineName;
	String finalResult;

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET /* produces = "application/json" */ )
	public String searching(@RequestParam("search") String search) {
		SearchApplication tester;
		try {
			tester = new SearchApplication();
			tester.createIndex(indexDir, dataDir);
			finalResult = tester.search(search, indexDir, dataDir);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return finalResult;
	}

	private void createIndex(String indexDir, String dataDir) throws IOException {
		indexer = new Indexer(indexDir);
		int numIndexed;
		numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
		//long endTime = System.currentTimeMillis();
		indexer.close();
		//System.out.println(numIndexed + " File indexed, time taken: " + (endTime - startTime) + " ms");
	}

	public String search(String searchQuery, String indexDir, String dataDir) throws IOException, ParseException {
		List<String> fileList = new ArrayList<String>();
		searcher = new Searcher(indexDir);
		//long startTime = System.currentTimeMillis();
		TopDocs hits = searcher.search(searchQuery);
		//long endTime = System.currentTimeMillis();

		//System.out.println(hits.totalHits + " documents found. Time :" + (endTime - startTime));

		for (ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = searcher.getDocument(scoreDoc);
			fineName = doc.get(LuceneConstants.FILE_PATH);
			fileList.add(fineName);

		}
		searcher.close();
		return fileList.toString();
	}	

}
