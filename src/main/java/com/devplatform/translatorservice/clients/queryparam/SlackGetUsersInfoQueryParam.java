package com.devplatform.translatorservice.clients.queryparam;

public class SlackGetUsersInfoQueryParam extends SlackGenericQueryParam{
		private String user;
		
		public SlackGetUsersInfoQueryParam(String token, String user){
			this.token = token;
			this.user = user;
		}
}