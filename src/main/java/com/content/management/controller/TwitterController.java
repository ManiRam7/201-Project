package com.content.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.content.management.config.TwitterTemplateCreator;

@RestController
@RequestMapping(value = "/twitter")
public class TwitterController {

	@Autowired
	private TwitterTemplateCreator twitterTemplateCreator;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public List<Tweet> home(@RequestParam String title) {
		Twitter twitter = twitterTemplateCreator.getTwitterTemplate();
		List<Tweet> tweets=null;
		try {
			SearchResults searchResults = twitter.searchOperations().search(title);
			 tweets = searchResults.getTweets();
			for (Tweet tweet : tweets) {
				System.out.println(tweet.getFromUser());
				System.out.println(tweet.getText());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tweets;
	}
}
