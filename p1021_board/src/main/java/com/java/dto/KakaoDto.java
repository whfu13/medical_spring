package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KakaoDto {

	private Long id;
	private String connected_at;
	private Properties properties;
	private Kakao_account kakao_account;
	
	
	//----
	@Data
	public class Properties{
		private String nickname;
		private String profile_image;
		private String thumbnail_image;
	}
		
	
	//----
	@Data
	public class Kakao_account{
		private boolean profile_nickname_needs_agreement;
		private boolean profile_image_needs_agreement;
		private Profile profile;
		
		
		@Data
		public class Profile{
			private String nickname;
			private String thumbnail_image_url;
			private String profile_image_url;
			private String is_default_image;
			private String is_default_nickname;
		}
	}
}
