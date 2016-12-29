package com.content.management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

@Component
public class TwitterTemplateCreator {
	@Autowired
	private Environment env;

	public Twitter getTwitterTemplate() {
		String consumerKey = env.getProperty("consumerKey");
		String consumerSecret = env.getProperty("consumerSecret");
		String accessToken = env.getProperty("accessToken");
		String accessTokenSecret = env.getProperty("accessTokenSecret");

		TwitterTemplate twitterTemplate = new TwitterTemplate(consumerKey, consumerSecret, accessToken,
				accessTokenSecret);
		return twitterTemplate;
	}
}
