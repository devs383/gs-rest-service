package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	// TODO Implement the /words/{word} endpoint
	@RequestMapping(value = "/word/{word}",method = RequestMethod.GET, produces = { "application/json"})
	@ResponseBody
	public ResponsePOJO response(@PathVariable String word) 
	{ 
		if(word!=null)
		{
		ResponsePOJO resp = new ResponsePOJO();
		resp.setWord(word);
		resp.setAnagramOfPalindrome(canFormPalindrome(word));
		resp.setPalindrome(checkPalindrom(word));
		return resp;
		}
		return null;
	}

	private boolean checkPalindrom(String word)
	{
		String reverse = "";
		int length = word.length();

		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + word.charAt(i);

		if (word.equals(reverse))
			return true;
		else
			return false;
	}
	
	private boolean canFormPalindrome(String input) 
	{ 
	   int [] count = new int[26];
	        for( int i = 0; i < input.length(); i++ )
	        {
	            char ch = input.charAt(i);
	            count[ch-'a']++;
	        }
	        int oddOccur = 0;
	        for( int cnt:count )
	        {
	            if( oddOccur > 1) // more than 1 char should have odd frequency
	                return false;
	            if( cnt%2 == 1 )
	                oddOccur++;
	        }
	        return true;
	} 
}
