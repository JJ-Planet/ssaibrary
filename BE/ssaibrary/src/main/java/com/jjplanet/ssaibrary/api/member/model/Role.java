package com.jjplanet.ssaibrary.api.member.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

	ADMIN("ROLE_ADMIN", "관리자 권한"),
	USER("ROLE_USER", "일반 사용자");

	private final String key;
	private final String title;
}