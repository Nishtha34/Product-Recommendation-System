package movies.spring.data.neo4j.controller;

import java.util.Collection;
import java.util.Map;

import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.services.MovieService;
import movies.spring.data.neo4j.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Namrata Ajmeri
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}
	
	@GetMapping("/stationary")
	public Map<String, Object> allStationaries(@RequestParam(value = "limit",required = false) Integer limit) {
		return productService.allStationaries(limit == null ? 100 : limit);
	}
	
	@GetMapping("/stationary/{productName}")
	public Map<String, Object> getPeopleAlsoSearchedFor(@PathVariable String productName)
	{
		int limit = 25;
		return productService.getPeopleAlsoSearchedFor(productName, limit);
	}
}
