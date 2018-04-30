package stock.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.repository.MyRepo;
import stock.repository.Mydirectory;

//1Configuration
//1Component
@RestController
public class DbServiceResource {
	@Autowired
	private MyRepo myRepo;

	public DbServiceResource(MyRepo myRepo) {
		this.myRepo = myRepo;
	}

/*	@RequestMapping("/db")
	public String getQuotes() {
		return "Hello Sanjay";

	}*/

	/*@GetMapping("/sanjay")
	//public List<String> getQuotes(@PathVariable("sanjay") final String username) {
	public List<String> getQuotes1() {

		return getQuotesByUserName("sanjay");
	}*/
	
	@RequestMapping("/add")
	public String addQuotes() {
System.out.println("=============1================");
		return addQuotesByUserName();
	}

	private String addQuotesByUserName() {
		System.out.println("=============2================");
		Mydirectory myd=new  Mydirectory();
		/*myd.setId(1L);
		myd.setName("sanjay1");
		myRepo.save(myd);
		System.out.println("=============3================");
		myd.setId(2L);
		myd.setName("sanjay2");
		myRepo.save(myd);
		System.out.println("=============4================");
		myd.setId((long) 3.0);
		myd.setName("sanjay3");
		myRepo.save(myd);
		System.out.println("=============5================");*/
		return "success";
	}

	/*private List<String> getQuotesByUserName(@PathVariable("username") String username) {
				
		List<String> listS=new ArrayList<String>();
		myRepo.findAll().forEach(i->i.getName());
		System.out.println(listS.get(0));
		return listS;
		
	}*/
}
