package stock.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import stock.repository.QuotesRepository;

@RestController
public class DbServiceResource {
	//QuotesRepository quotesRepository;
	/* public DbServiceResource(QuotesRepository quotesRepository) {
	        this.quotesRepository = quotesRepository;
	    }*/
	
	//GetMapping("/{username}")
	
	 @RequestMapping("/sanjay")
	public String getQuotes(){	
		return "Hello Sanjay";
		/*public List<String> getQuotes(){
		return quotesRepository.findByUserName("sanjay").stream().map(quote->{
			return quote.getQuote();
		}).collect(Collectors.toList());*/
		
		//return null;
	}
	
	//PostMapping("/add")
    /*public List<String> add(@RequestBody final Quotes quotes) {

        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUserName(), quote))
                .forEach(quote -> quotesRepository.save(quote));
        return getQuotesByUserName(quotes.getUserName());
    }*/
	
	/*private List<String> getQuotesByUserName(@PathVariable("username") String username) {
        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }*/

}
