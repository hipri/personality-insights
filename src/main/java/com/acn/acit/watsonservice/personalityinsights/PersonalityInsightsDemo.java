package com.acn.acit.watsonservice.personalityinsights;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.stream.JsonReader;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

public class PersonalityInsightsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonalityInsights service = new PersonalityInsights("2017-10-13");
		service.setUsernameAndPassword("0d4def70-3f97-4704-9591-24f2dbb10242", "H6pD178h6l2q");

		try {
			JsonReader jReader = new JsonReader(new FileReader("./profile.json"));
			Content content = GsonSingleton.getGson().fromJson(jReader, Content.class);
			ProfileOptions options = new ProfileOptions.Builder().contentItems(content.getContentItems())
					.consumptionPreferences(true).rawScores(true).build();
			Profile profile = service.getProfile(options).execute();
			System.out.println(profile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
