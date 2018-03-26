package com.sanjay.search;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.sanjay.index.LuceneConstants;

public class Searcher {
	
   IndexSearcher indexSearcher;
   QueryParser queryParser;
   Query query;
   
   public Searcher(String indexDirectoryPath) 
      throws IOException {
      Directory indexDirectory = 
         FSDirectory.open(new File(indexDirectoryPath));
      indexSearcher = new IndexSearcher(indexDirectory);
      queryParser = new QueryParser(Version.LUCENE_36,
         LuceneConstants.CONTENTS,
         new StandardAnalyzer(Version.LUCENE_36));
   }
   
   public TopDocs search( String searchQuery) 
      throws IOException, ParseException {
      try {
		query = queryParser.parse(searchQuery);
	} catch (org.apache.lucene.queryParser.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return indexSearcher.search(query, LuceneConstants.MAX_SEARCH);
   }

   public Document getDocument(ScoreDoc scoreDoc) 
      throws CorruptIndexException, IOException {
      return indexSearcher.doc(scoreDoc.doc);	
   }

   public void close() throws IOException {
      indexSearcher.close();
   }
}